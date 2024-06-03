import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame implements ActionListener
{
    private PanelReseau panelReseau;

	private JMenuItem     menuFichierAjouter;
	private JMenuItem     menuFichierOuvrir;
	private JMenuItem     menuFichierQuitter;

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
		JMenu menuFichier = new JMenu("Ajouter");
		JMenu menuOuvrir = new JMenu("Ouvrir");


		this.menuFichierAjouter  = new JMenuItem("Ajouter une route" );
		this.menuFichierAjouter = new JMenuItem("Ajouter une ville" );
		this.menuFichierQuitter = new JMenuItem("Quitter" );


		menuBar.add(menuFichierAjouter);
		menuBar.add(menuFichierOuvrir);
		menuBar.add(menuFichierQuitter);

		this.setJMenuBar( menuBar );


		// Activation des composants
		this.menuFichierAjouter.addActionListener ( this );
		this.menuFichierOuvrir.addActionListener  ( this );
		this.menuFichierQuitter.addActionListener ( this );

		// Gestion de la fermeture de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

	public void actionPerformed ( ActionEvent e )
	{
		// Syso pour confirmer l'action
		if ( e.getSource() instanceof JMenuItem )
			System.out.println ( ( (JMenuItem) e.getSource() ).getText() );

		// Fermeture de l'application
		if ( e.getSource() == this.menuFichierQuitter )
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

        private JButton btnAjout;

        public PanelReseau ( )
        {

            this.setLayout(new BorderLayout(0,0));

            // création des composants;
            this.btnAjout   = new JButton ( "AJOUTER" );

            this.panelAjout = new JPanel                  ();
            this.panelCarte = new JPanel                  ();



            // positionnement des composants
            this.add(panelAjout, BorderLayout.NORTH );
            this.add(panelCarte, BorderLayout.CENTER);

            //Mise en place du fond
            ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource("/images/backGround.jpg"));
            JLabel backgroundLabel = new JLabel(backgroundImage);
            backgroundLabel.setBounds(0, 0, this.panelCarte.getWidth(), this.panelCarte.getHeight());
            this.panelCarte.add(backgroundLabel);

            //Ajout des composants
            this.panelAjout.add( this.btnAjout );
        }

        public JButton getBtnAjout()
        {
            return this.btnAjout;
        }
    }
}

