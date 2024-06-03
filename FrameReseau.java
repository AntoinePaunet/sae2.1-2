import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;

public class FrameReseau extends JFrame
{
    private PanelReseau panelReseau;

    public FrameReseau ()
    {
        this.setTitle   ( "Réseau routier");
        this.setSize    ( 1040,910 );
        this.setLocation(  50, 50 );
        this.panelReseau = new PanelReseau();

// Création et ajout du Panel
        this.add ( this.panelReseau );

// Gestion de la fermeture de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }

    public PanelReseau getPanel()
    {
        return this.panelReseau;
    }


    public class PanelReseau extends JPanel implements ActionListener
    {

        private JPanel panelAjout;
        private JPanel panelCarte;

        private JButton btnAjout;

        public PanelReseau ( )
        {

            this.setLayout(new BorderLayout(10,10));

            // création des composants;
            this.btnAjout   = new JButton ( "AJOUTER" );

            this.panelAjout = new JPanel                  ();
            this.panelCarte = new JPanel                  ();



            // positionnement des composants
            this.add(panelAjout, BorderLayout.NORTH );
            this.add(panelCarte);

            this.panelAjout.add( this.btnAjout );

            // activation des composants
            this.btnAjout.addActionListener(this);
        }

        public void actionPerformed ( ActionEvent evt )
        {
            if(evt.getSource().equals(btnAjout))
                new FrameCreation();
        }

        public void actionPerformed(ActionListener actionListener) {
        }
    }

    public class FrameCreation
    {
        public FrameCreation()
        {

        }
    }


}

