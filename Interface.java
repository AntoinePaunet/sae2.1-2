import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame implements ActionListener
{
    private PanelReseau panelReseau;

	private JMenuItem     menuiAjouter;
	private JMenuItem     menuiOuvrir;
	private JMenuItem     menuiQuitter;

    public Interface ()
    {
        this.setTitle   ( "Réseau routier");
        this.setSize    ( 1040,950 );
        this.setLocation(  50, 50 );

		// Création et ajout du Panel
        this.panelReseau = new PanelReseau();
        this.add ( this.panelReseau );


		// Création et ajout de la barre de menu
		JMenuBar  menuBar = new JMenuBar();
		JMenu menuAjouter = new JMenu("Ajouter");
		JMenu menuOuvrir  = new JMenu("Ouvrir");
		JMenu menuQuitter = new JMenu("Quitter");


		this.menuiAjouter  = new JMenuItem("Ajouter une ville" );
		this.menuiOuvrir = new JMenuItem("Ajouter une route" );
		this.menuiQuitter = new JMenuItem("Quitter" );

		menuAjouter.add(this.menuiAjouter);
		menuOuvrir .add(this.menuiOuvrir);
		menuQuitter.add(this.menuiQuitter);



		menuBar.add(menuAjouter);
		menuBar.add(menuOuvrir);
		menuBar.add(menuQuitter);

		this.setJMenuBar( menuBar );


		// Activation des composants
		this.menuiAjouter.addActionListener ( this );
		this.menuiOuvrir .addActionListener ( this );
		this.menuiQuitter.addActionListener ( this );

		// Gestion de la fermeture de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
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

