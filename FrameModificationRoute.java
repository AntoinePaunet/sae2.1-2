import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FrameModificationRoute extends JFrame implements ActionListener
{

    private JPanel panelInfo;
    private JPanel panelDonnees;
    private JPanel panelRoute;
    private JPanel panelSauvegarde;

    private JLabel lblInfo;
    private JLabel lblVilleDepart;
    private JLabel lblVilleArrivee;
    private JLabel lblNbTroncons;
	private JLabel lblErreur;

    private JButton btnSauvegarder;
    private JButton btnSupprimer;

    private List lstNbTroncon;
    private List lstVilles;

	private Route routeModif;

    private Carte carteModif;

    public FrameModificationRoute(Carte carte, Route route)
	{
        final String[] TRONCON = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        this.carteModif = carte;
		this.routeModif = route;
        this.setTitle("Modification d'une route");
        this.setSize(500, 400);
        this.setLocation(50, 50);
        this.setLayout(new BorderLayout());

        // Definition des objets
        this.panelInfo = new JPanel();
        this.panelDonnees = new JPanel();
        this.panelRoute = new JPanel();
        this.panelSauvegarde = new JPanel();
        this.lstNbTroncon = new List();
        this.lstVilles = new List();

        // Création de la liste du nombre de tronçons
        for (int i = 0; i < TRONCON.length; i++)
            this.lstNbTroncon.add(TRONCON[i]);

        // Création de la liste des villes existentent
        for (Ville v : this.carteModif.getTabVilles())
            this.lstVilles.add(v.getNom());

        // Modification du layout des panels
        this.panelDonnees.setLayout(new GridLayout(3, 2, 10, 10));
        this.panelRoute.setLayout(new BorderLayout());
        this.panelSauvegarde.setLayout(new GridLayout(1, 2));

        // Ajout des objets aux panels
        this.panelInfo.add(this.lblInfo = new JLabel("Modification de la route "));

        this.panelDonnees.add(this.lblVilleDepart = new JLabel("  Ville de départ"));
        this.panelDonnees.add(this.lstVilles);

        this.panelDonnees.add(this.lblVilleArrivee = new JLabel("  Ville d'arrivée"));
        this.panelDonnees.add(this.lstVilles);

        this.panelDonnees.add(this.lblNbTroncons = new JLabel("  Nombre de tronçons"));
        this.panelDonnees.add(this.lstNbTroncon);

		this.panelRoute.add(this.lblErreur = new JLabel(""), BorderLayout.SOUTH);

        this.panelSauvegarde.add(this.btnSauvegarder = new JButton("SAUVEGARDER"));
        this.panelSauvegarde.add(this.btnSupprimer = new JButton("SUPPRIMER"));

        // Ajout des événements aux objets
        this.btnSauvegarder.addActionListener(null);
        this.btnSupprimer.addActionListener(null);

        // Ajout des panels a la frame
        this.add(panelInfo, BorderLayout.NORTH);
        this.add(panelSauvegarde, BorderLayout.SOUTH);
        this.add(panelDonnees);

        // Activation des composants
        this.lstNbTroncon.addActionListener(this);
        this.btnSauvegarder.addActionListener(this);
        this.btnSupprimer.addActionListener(this);

        // Changement visuel des labels
        lblInfo.setFont(new Font("Arial", Font.BOLD, 20));
        lblVilleDepart.setFont(new Font("Arial", Font.BOLD, 20));
        lblVilleArrivee.setFont(new Font("Arial", Font.BOLD, 20));
        lblNbTroncons.setFont(new Font("Arial", Font.BOLD, 20));
        lblErreur.setFont(new Font("Arial", Font.BOLD, 20));
        btnSauvegarder.setFont(new Font("Arial", Font.BOLD, 25));
        btnSupprimer.setFont(new Font("Arial", Font.BOLD, 25));

        // Initialisation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(this.btnSauvegarder))
		{
            if (lblVilleDepart.getText().isEmpty()
            ||  lblVilleArrivee.getText().isEmpty()
            ||  lblNbTroncons.getText().isEmpty() )
				lblErreur.setText("Erreur de saisie.\n");
            else
			{
                try
				{
                    // Modification
                    Controleur.getCarte().modifieRoute(this.routeModif, this.carteModif.rechercheVille(this.lblVilleDepart.getText()), this.carteModif.rechercheVille(this.lblVilleArrivee.getText()) , Integer.parseInt(this.lblNbTroncons.getText()));
					

					/*
                    Controleur.getCarte().modifieVille(villeModif, this.txtNomVille.getText(),
                            Integer.parseInt(this.txtXVille.getText()), Integer.parseInt(this.txtYVille.getText()));
                    for (Route r : villeModif.getTabRoutes())
                        Controleur.getCarte().modifieRoute(r, r.getVilleDepart(), r.getVilleArrivee(),
                                r.getNbTroncon());
					*/
                }
				catch( IOException ex ) { throw new RuntimeException(ex); }
                this.dispose();
            }
		}
        if (e.getSource().equals(this.btnSupprimer))
			new FrameConfirmer(this);


        if (e.getSource().equals(this.lstNbTroncon))
		{
            for (String s : this.lstNbTroncon.getSelectedItems())
        		System.out.println(s);
		}

    }

    public void quitterFrame(boolean confirm)
	{
        if (confirm)
            this.dispose();
    }

}