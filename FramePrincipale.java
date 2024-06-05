import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FramePrincipale extends JFrame implements ActionListener
{
    private JLayeredPane panelReseau;

	private JMenuItem     menuiAjouterVille, menuiAjouterRoute;
	private JMenuItem     menuiOuvrir;
	private JMenuItem     menuiQuitter;

    public FramePrincipale ()
    {
        this.setTitle   ( "Réseau routier" );
        this.setSize    ( 1040,950 );
        this.setLocation(  50, 50 );
		this.setVisible (true);


		// Création et ajout du Panel
        this.panelReseau = new JLayeredPane();
        this.add ( this.panelReseau );
        this.panelReseau.setPreferredSize(new Dimension(1000, 800));
        this.panelReseau.setBorder(BorderFactory.createLineBorder(Color.black, 3));


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

		this.setJMenuBar(menuBar);


		// Activation des composants
		this.menuiAjouterVille.addActionListener ( this );
		this.menuiAjouterRoute.addActionListener ( this );
		this.menuiOuvrir .addActionListener ( this );
		this.menuiQuitter.addActionListener ( this );

		// Gestion de la fermeture de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Recharger l'ihm
        rechargerIhm();
    }

    public Runnable rechargerIhm() //Met 60 fps
    {

        Timer fps = new Timer(500, new ActionListener()
		{
            @Override
            public void actionPerformed(ActionEvent e)
            {

                ArrayList<Ville> villes = Controleur.getCarte().getTabVilles();



                ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource("/images/backGround.jpg"));
                JLabel backgroundLabel = new JLabel(backgroundImage);
                backgroundLabel.setBounds(0, 0, panelReseau.getWidth(), panelReseau.getHeight());
                panelReseau.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

                for(Ville v : villes)
                {
                    ImageIcon imageVille = new ImageIcon(getClass().getResource("/images/ville.png"));
                    JLabel imgLabel = new JLabel(imageVille);
                    imgLabel.setBounds(v.getX(), v.getY(), imageVille.getIconWidth(), imageVille.getIconHeight());
                    panelReseau.add(imgLabel, JLayeredPane.DRAG_LAYER);
                }
            }
        });
        fps.start();
        return null;
    }



    public JMenuItem getMenuiAjouterVille()
    {
        return this.menuiAjouterVille;
    }

    public JMenuItem getMenuiAjouterRoute()
    {
        return this.menuiAjouterRoute;
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

    public JLayeredPane getPanel() { return this.panelReseau; }
}