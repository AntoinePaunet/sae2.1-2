import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame
{
    private PanelReseau panelReseau;

    public Interface ()
    {
        this.setTitle   ( "Réseau routier");
        this.setSize    ( 1040,950 );
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

