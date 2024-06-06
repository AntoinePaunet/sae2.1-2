import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FrameCreation extends JFrame {
    private JPanel panelTop;
    private JPanel panelCentral;

    private TextField txtNom;
    private TextField txtCooX;
    private TextField txtCooY;

    private TextField txtVilleDep;
    private TextField txtVilleArr;
    private List lstTroncons;

    public FrameCreation(boolean isIhmVille) {
        this.setTitle("Création d'un élément");
        this.setSize(500, 300);
        this.setLocation(50, 50);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        // Definition des objets
        this.panelTop = new JPanel(new FlowLayout());
        this.panelCentral = new JPanel();
        this.panelCentral.setLayout(new BoxLayout(this.panelCentral, BoxLayout.Y_AXIS));

        this.add(this.panelTop, BorderLayout.NORTH);
        this.add(this.panelCentral);

        Border lineBorder = BorderFactory.createLineBorder(Color.black, 3);
        this.panelTop.setBorder(lineBorder);

        // Initialisation
        if (isIhmVille)
            this.setIhmVille();
        else
            this.setIhmRoute();

    }

    public void setIhmVille() {
        JLabel lblTxtPresentation = new JLabel("Création d'une ville");
        lblTxtPresentation.setFont(new Font("Arial", Font.BOLD, 30));
        this.panelTop.add(lblTxtPresentation, BorderLayout.CENTER);

        // Panels
        JPanel pnlNom = new JPanel(new FlowLayout());
        JPanel pnlCooX = new JPanel(new FlowLayout());
        JPanel pnlCooY = new JPanel(new FlowLayout());
        JPanel pnlErreur = new JPanel(new FlowLayout());
        JPanel pnlSave = new JPanel(new BorderLayout());

        // Labels
        JLabel lblNom = new JLabel("Nom de la ville :                ");
        lblNom.setFont(new Font("Arial", Font.PLAIN, 25));
        this.txtNom = new TextField();
        this.txtNom.setPreferredSize(new Dimension(100, 20));

        JLabel lblCooX = new JLabel("Coordonnée X de la ville : ");
        lblCooX.setFont(new Font("Arial", Font.PLAIN, 25));
        this.txtCooX = new TextField();
        this.txtCooX.setPreferredSize(new Dimension(100, 20));

        JLabel lblCooY = new JLabel("Coordonnée Y de la ville : ");
        lblCooY.setFont(new Font("Arial", Font.PLAIN, 25));
        this.txtCooY = new TextField();
        this.txtCooY.setPreferredSize(new Dimension(100, 20));

        JLabel lblErreur = new JLabel("");

        JButton btnSave = new JButton("Sauvegarder");
        btnSave.setFont(new Font("Arial", Font.BOLD, 30));
        btnSave.setPreferredSize(new Dimension(460, 60));
        btnSave.setBorder(BorderFactory.createLineBorder(Color.black, 3));

        pnlNom.add(lblNom);
        pnlNom.add(this.txtNom);

        pnlCooX.add(lblCooX);
        pnlCooX.add(this.txtCooX);

        pnlCooY.add(lblCooY);
        pnlCooY.add(this.txtCooY);

        pnlSave.add(btnSave, BorderLayout.SOUTH);

        // Ajout des composants
        this.panelCentral.add(pnlNom);
        this.panelCentral.add(pnlCooX);
        this.panelCentral.add(pnlCooY);
        this.panelCentral.add(pnlErreur);
        this.panelCentral.add(pnlSave);

        // On vérifie que le bouton à été cliqué et que les données entrées sont valides
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lblErreur.setFont(new Font("Arial", Font.BOLD, 20));
                lblErreur.setBackground(Color.RED);
                pnlErreur.add(lblErreur);

                if (!txtNom.getText().isEmpty()) {
                    try {
                        if (Integer.parseInt(txtCooX.getText()) <= 900 && Integer.parseInt(txtCooX.getText()) >= 20
                                && Integer.parseInt(txtCooY.getText()) <= 730
                                && Integer.parseInt(txtCooY.getText()) >= 50) {
                            lblErreur.setText("Création d'une ville");
                            if (Controleur.setNouvelleVille(new Ville(txtNom.getText(),
                                    Integer.parseInt(txtCooX.getText()), Integer.parseInt(txtCooY.getText()))))

                                FrameCreation.super.dispose();
                        }
                        lblErreur.setText("Champ de saisie incorrecte");
                    } catch (NumberFormatException e) {
                        lblErreur.setText("Erreur de saisie.");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else
                    lblErreur.setText("Erreur de saisie.");
            }
        });
    }

    public void setIhmRoute() {
        final String[] TRONCON = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

        JLabel lblTxtPresentation = new JLabel("Création d'une route");
        lblTxtPresentation.setFont(new Font("Arial", Font.BOLD, 30));
        this.panelTop.add(lblTxtPresentation, BorderLayout.CENTER);

        // Panels
        JPanel pnlVilleDep = new JPanel(new FlowLayout());
        JPanel pnlVilleArr = new JPanel(new FlowLayout());
        JPanel pnlTroncons = new JPanel(new FlowLayout());
        JPanel pnlErreur = new JPanel(new FlowLayout());
        JPanel pnlSave = new JPanel(new BorderLayout());

        // Labels
        JLabel lblVilleDep = new JLabel("Ville de départ :");
        lblVilleDep.setFont(new Font("Arial", Font.PLAIN, 25));
        this.txtVilleDep = new TextField();
        this.txtVilleDep.setPreferredSize(new Dimension(100, 20));

        JLabel lblVilleArr = new JLabel("Ville d'arrivée : ");
        lblVilleArr.setFont(new Font("Arial", Font.PLAIN, 25));
        this.txtVilleArr = new TextField();
        this.txtVilleArr.setPreferredSize(new Dimension(100, 20));

        JLabel lblTroncons = new JLabel("Nombre de tronçons : ");
        lblTroncons.setFont(new Font("Arial", Font.PLAIN, 25));
        this.lstTroncons = new List();

        // Création de la liste du nombre de tronçons
        for (int i = 0; i < TRONCON.length; i++)
            this.lstTroncons.add(TRONCON[i]);

        this.lstTroncons.setPreferredSize(new Dimension(60, 10));

        JLabel lblErreur = new JLabel("");

        JButton btnSave = new JButton("Sauvegarder");
        btnSave.setFont(new Font("Arial", Font.BOLD, 30));
        btnSave.setPreferredSize(new Dimension(460, 60));
        btnSave.setBorder(BorderFactory.createLineBorder(Color.black, 3));

        // Ajout des éléments
        pnlVilleDep.add(lblVilleDep);
        pnlVilleDep.add(this.txtVilleDep);

        pnlVilleArr.add(lblVilleArr);
        pnlVilleArr.add(this.txtVilleArr);

        pnlTroncons.add(lblTroncons);
        pnlTroncons.add(this.lstTroncons);

        pnlSave.add(btnSave, BorderLayout.SOUTH);

        this.panelCentral.add(pnlVilleDep);
        this.panelCentral.add(pnlVilleArr);
        this.panelCentral.add(pnlTroncons);
        this.panelCentral.add(pnlErreur);
        this.panelCentral.add(pnlSave);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lblErreur.setFont(new Font("Arial", Font.BOLD, 20));
                lblErreur.setBackground(Color.RED);
                pnlErreur.add(lblErreur);

                if (!txtVilleDep.getText().isEmpty() && !txtVilleArr.getText().isEmpty()
                        && lstTroncons.getSelectedIndex() != -1) {
                    // Création d'un élément
                    lblErreur.setText("Création d'un élément");
                    try {
                        if (!Controleur.setNouvelleRoute(txtVilleDep.getText(), txtVilleArr.getText(),
                                lstTroncons.getSelectedIndex()))
                            lblErreur.setText("Une des villes n'existe pas");
                        else
                            FrameCreation.super.dispose();

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else
                    lblErreur.setText("Veuillez saisir tous les champs de texte");
            }
        });
    }
}