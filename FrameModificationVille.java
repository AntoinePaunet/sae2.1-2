import javax.swing.*;
import java.awt.*;


public class FrameModificationVille extends JFrame implements ActionListener
{

    private JPanel panelInfo;
    private JPanel panelDonnees;
    private JPanel panelSauvegarde;

    private JLabel lblInfo;
    private JLabel lblNomVille;
    private JLabel lblXVille;
    private JLabel lblYVille;

    private JTextField txtNomVille;
    private JTextField txtXVille;
    private JTextField txtYVille;

    private JButton btnSauvegarder;
    private JButton btnSupprimer;


    public FrameModificationVille()
    {
        this.setTitle   ( "Modification d'une ville");
        this.setSize    ( 500,400                   );
        this.setLocation(  50, 50                   );
        this.setLayout  ( new BorderLayout()  );
        


        //Definition des objets
        this.panelInfo       = new JPanel();
        this.panelDonnees    = new JPanel();
        this.panelSauvegarde = new JPanel();

        //Modification du layout des panels
        this.panelDonnees.setLayout   ( new GridLayout(3,2, 10, 10) );
        this.panelSauvegarde.setLayout( new GridLayout(1,2) );


        //Ajout des objets aux panels
        this.panelInfo.add(this.lblInfo = new JLabel("Modification d'une route"));

        this.panelDonnees.add(this.lblNomVille  = new JLabel("Nom de la ville : "   ));

        this.panelDonnees.add(this.lblXVille = new JLabel("Position X : "   ));

        this.panelDonnees.add(this.lblYVille = new JLabel("Position Y : "));

        this.panelSauvegarde.add(this.btnSauvegarder = new JButton("SAUVEGARDER"));
        this.panelSauvegarde.add(this.btnSupprimer   = new JButton("SUPPRIMER"  ));


        //Ajout des événements aux objets
        this.btnSauvegarder.addActionListener(null);
        this.btnSupprimer.addActionListener(null);


        //Ajout des panels a la frame
        this.add(panelInfo,       BorderLayout.NORTH);
        this.add(panelSauvegarde, BorderLayout.SOUTH);
        this.add(panelDonnees                       );
        

        //Activation des composants
        this.lstNbTroncon.addActionListener  (this);
        this.btnSauvegarder.addActionListener(this);
        this.btnSupprimer.addActionListener  (this);
    

        //Initialisation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if( e.getSource().equals(this.btnSauvegarder) )
        {
            
        }

        if( e.getSource().equals(this.btnSupprimer)  )
        {
            
        }

        if( e.getSource().equals(this.lstNbTroncon)  )
        {
            for (String s : this.lstNbTroncon.getSelectedItems())
            {
                System.out.println(s);
            }
        }



    }


    public static void main(String[]args)
    {
        JFrame frameTest;

        frameTest = new FrameModificationRoute();
    }



}