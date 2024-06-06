import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class FrameModificationVille extends JFrame implements ActionListener, KeyListener {

    private JPanel panelInfo;
    private JPanel panelPrincipal;
    private JPanel panelDonnees;
    private JPanel panelRoute;
    private JPanel panelSauvegarde;

    private JLabel lblInfo;
    private JLabel lblNomVille;
    private JLabel lblXVille;
    private JLabel lblYVille;
    private JLabel lblErreur;
    private JLabel lblRoute;

    private String tabRoute;

    private JTextField txtNomVille;
    private JTextField txtXVille;
    private JTextField txtYVille;

    private JButton btnSauvegarder;
    private JButton btnSupprimer;

    private Ville villeModif;

    public FrameModificationVille(Ville ville) {
        this.setTitle("Modification d'une ville");
        this.setSize(500, 400);
        this.setLocation(50, 50);
        this.setLayout(new BorderLayout());
        this.villeModif = ville;

        // Definition des objets
        this.panelInfo = new JPanel();
        this.panelPrincipal = new JPanel();
        this.panelDonnees = new JPanel();
        this.panelRoute = new JPanel();
        this.panelSauvegarde = new JPanel();

        // Création de l'affichage des routes
        tabRoute = "Route(s) :";
        for (Route r : villeModif.getTabRoutes())
            tabRoute += " " + r.departToArrivee() + " ;";

        // Modification du layout des panels
        this.panelPrincipal.setLayout(new GridLayout(2, 1));
        this.panelDonnees.setLayout(new GridLayout(3, 2, 30, 30));
        this.panelRoute.setLayout(new BorderLayout());
        this.panelSauvegarde.setLayout(new GridLayout(1, 2));

        // Ajout des objets aux panels
        this.panelInfo.add(this.lblInfo = new JLabel("Modification de " + ville.getNom()));

        this.panelDonnees.add(this.lblNomVille = new JLabel("  Nom de la ville : "));
        this.panelDonnees.add(this.txtNomVille = new JTextField(ville.getNom()));

        this.panelDonnees.add(this.lblXVille = new JLabel("  Position X : "));
        this.panelDonnees.add(this.txtXVille = new JTextField(ville.getX() + ""));

        this.panelDonnees.add(this.lblYVille = new JLabel("  Position Y : "));
        this.panelDonnees.add(this.txtYVille = new JTextField(ville.getY() + ""));

        this.panelRoute.add(this.lblErreur = new JLabel(""), BorderLayout.SOUTH);

        this.panelRoute.add(this.lblRoute = new JLabel(tabRoute));

        // Routes

        this.panelSauvegarde.add(this.btnSauvegarder = new JButton("SAUVEGARDER"));
        this.panelSauvegarde.add(this.btnSupprimer = new JButton("SUPPRIMER"));

        // Changement visuel des labels
        lblInfo.setFont(new Font("Arial", Font.BOLD, 20));
        lblNomVille.setFont(new Font("Arial", Font.BOLD, 20));
        lblXVille.setFont(new Font("Arial", Font.BOLD, 20));
        lblYVille.setFont(new Font("Arial", Font.BOLD, 20));
        lblRoute.setFont(new Font("Arial", Font.BOLD, 20));
        lblErreur.setFont(new Font("Arial", Font.BOLD, 20));
        btnSauvegarder.setFont(new Font("Arial", Font.BOLD, 25));
        btnSupprimer.setFont(new Font("Arial", Font.BOLD, 25));

        // Ajout des événements aux objets
        this.btnSauvegarder.addActionListener(null);
        this.btnSupprimer.addActionListener(null);

        // Ajout des panels au panel principal
        this.panelPrincipal.add(panelDonnees, BorderLayout.NORTH);
        this.panelPrincipal.add(panelRoute, BorderLayout.NORTH);

        // Ajout des panels a la frame
        this.add(panelInfo, BorderLayout.NORTH);
        this.add(panelSauvegarde, BorderLayout.SOUTH);
        this.add(panelPrincipal);

        // Activation des composants
        this.btnSauvegarder.addActionListener(this);
        this.btnSupprimer.addActionListener(this);

        // Raccourcis
        this.btnSauvegarder.addKeyListener(this);

        // Initialisation
        this.setVisible(true);

        // AFFICHER LES ROUTES

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.btnSauvegarder)) {
            if (txtNomVille.getText().isEmpty()
                    || txtXVille.getText().isEmpty()
                    || txtYVille.getText().isEmpty()
                    || txtNomVille.getText() == villeModif.getNom() &&
                            Integer.parseInt(txtXVille.getText()) == villeModif.getX() &&
                            Integer.parseInt(txtYVille.getText()) == villeModif.getY())
                lblErreur.setText("Erreur de saisie.\n");
            else {
                try {
                    // Modification
                    Controleur.getCarte().modifieVille(villeModif, this.txtNomVille.getText(),
                            Integer.parseInt(this.txtXVille.getText()), Integer.parseInt(this.txtYVille.getText()));
                    for (Route r : villeModif.getTabRoutes())
                        Controleur.getCarte().modifieRoute(r, r.getVilleDepart(), r.getVilleArrivee(),
                                r.getNbTroncon());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                this.dispose();
            }
        }

        if (e.getSource().equals(this.btnSupprimer)) {
            // afficher la fenetre de confirmation
            new FrameConfirmer(this);

        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
            this.btnSauvegarder.doClick();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void quitterFrame(boolean confirm) {
        if (confirm) {
            this.dispose();
        }
    }

    public Ville getVilleModif() {
        return this.villeModif;
    }

}