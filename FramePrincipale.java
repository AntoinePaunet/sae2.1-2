import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FramePrincipale extends JFrame implements ActionListener
{
    private PanelReseau panelReseau;

	private JMenuItem     menuiAjouterVille, menuiAjouterRoute;
	private JMenuItem     menuiOuvrir;
	private JMenuItem     menuiQuitter;

    public FramePrincipale ()
    {
        this.setTitle   ( "Réseau routier");
        this.setSize    ( 1040,950 );
        this.setLocation(  50, 50 );
		this.setVisible (true);


		// Création et ajout du Panel
        this.panelReseau = new PanelReseau();
        this.add ( this.panelReseau );


		// Création et ajout de la barre de menu
		JMenuBar  menuBar = new JMenuBar();
		JMenu menuAjouter = new JMenu("Ajouter");
		JMenu menuOuvrir  = new JMenu("Ouvrir");
		JMenu menuQuitter = new JMenu("Quitter");


		this.menuiAjouterVille  = new JMenuItem("Ajouter une ville" );
		this.menuiAjouterRoute  = new JMenuItem("Ajouter une route" );
		this.menuiOuvrir = new JMenuItem("Importer un réseau" );
		this.menuiQuitter = new JMenuItem("Quitter" );

		menuAjouter.add(this.menuiAjouterVille);
		menuAjouter.add(this.menuiAjouterRoute);
		menuOuvrir .add(this.menuiOuvrir);
		menuQuitter.add(this.menuiQuitter);

		menuBar.add(menuAjouter);
		menuBar.add(menuOuvrir);
		menuBar.add(menuQuitter);

		this.setJMenuBar( menuBar );


		// Activation des composants
		this.menuiAjouterVille.addActionListener ( this );
		this.menuiAjouterRoute.addActionListener ( this );
		this.menuiOuvrir .addActionListener ( this );
		this.menuiQuitter.addActionListener ( this );

		// Gestion de la fermeture de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public JMenuItem getMenuiAjouterVille()
    {
        return this.menuiAjouterVille;
    }

    public JMenuItem getMenuFichierAjouter()
    {
        //return this.menuAjouter;
		return null;
    }

	public void actionPerformed ( ActionEvent e )
	{
		// Syso pour confirmer l'action
		if ( e.getSource() instanceof JMenuItem )
			System.out.println ( ( (JMenuItem) e.getSource() ).getText() );

		if( e.getSource() == this.menuiAjouterVille )
			new FrameCreation(true);

		if( e.getSource() == this.menuiAjouterRoute )
			new FrameCreation(false);

		/*
		// Importation des fichiers
		if( e.getSource() == this.menuiOuvrir )
		{
			JFileChooser fc = new JFileChooser();

			int returnVal = fc.showOpenDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION)
				this.ctrl.setFichierImage(fc.getSelectedFile().getAbsolutePath());
			else
				System.out.println("Annuler");
		}
		*/

		// Fermeture de l'application
		if ( e.getSource() == this.menuiQuitter )
			System.exit(0);
	}

    public PanelReseau getPanel()
    {
        return this.panelReseau;
    }


    public class PanelReseau extends JPanel
    {

        private JPanel panelAjout;
        private JPanel panelCarte;

        public PanelReseau ( )
        {

            this.setLayout(new BorderLayout(0,0));

            // création des composants;
            this.panelAjout = new JPanel ();
            this.panelCarte = new JPanel ();



            // positionnement des composants
            this.add(panelAjout, BorderLayout.NORTH );
            this.add(panelCarte, BorderLayout.CENTER);

            //Mise en place du fond
            ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource("/images/backGround.jpg"));

            JLabel backgroundLabel = new JLabel(backgroundImage);

            backgroundLabel.setBounds(0, 0, this.panelCarte.getWidth(), this.panelCarte.getHeight());

            this.panelCarte.add(backgroundLabel);
        }
    }
}

