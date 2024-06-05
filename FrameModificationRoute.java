import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrameModificationRoute extends JFrame implements ActionListener
{

    private JPanel panelInfo;
    private JPanel panelDonnees;
    private JPanel panelSauvegarde;

    private JLabel lblInfo;
    private JLabel lblVilleDepart;
    private JLabel lblVilleArrivee;
    private JLabel lblNbTroncons;

    private JButton btnSauvegarder;
    private JButton btnSupprimer;

    
    private List lstNbTroncon;


    public FrameModificationRoute()
    {
        final String[] TRONCON = new String[] {"0","1","2","3","4","5","6","7","8","9","10"};
        this.setTitle   ( "Modification d'une route");
        this.setSize    ( 500,400            );
        this.setLocation(  50, 50                     );
        this.setLayout  ( new BorderLayout()              );
        
        //Definition des objets
        this.panelInfo       = new JPanel();
        this.panelDonnees    = new JPanel();
        this.panelSauvegarde = new JPanel();
        this.lstNbTroncon    = new List();


        //Création de la liste du nombre de tronçons
        for (int i=0; i < TRONCON.length; i++)
        	this.lstNbTroncon.add(TRONCON[i]);

        //Modification du layout des panels
        this.panelDonnees.setLayout   ( new GridLayout(3,2, 10, 10) );
        this.panelSauvegarde.setLayout( new GridLayout(1,2) );


        //Ajout des objets aux panels
        this.panelInfo.add(this.lblInfo = new JLabel("Modification d'une route"));

        this.panelDonnees.add(this.lblVilleDepart  = new JLabel("  Ville de départ"   ));
        //this.panelDonnees.add(this.lstVilleDepart  = new JList<>());

        this.panelDonnees.add(this.lblVilleArrivee = new JLabel("  Ville d'arrivée"   ));
        //this.panelDonnees.add(this.lstVilleArrivee = new JList<>());

        this.panelDonnees.add(this.lblNbTroncons   = new JLabel("  Nombre de tronçons"));
        this.panelDonnees.add(this.lstNbTroncon);

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

        //Changement visuel des labels
		lblInfo.setFont(new Font("Arial", Font.BOLD, 20));
		lblVilleDepart.setFont(new Font("Arial", Font.BOLD, 20));
		lblVilleArrivee.setFont(new Font("Arial", Font.BOLD, 20));
		lblNbTroncons.setFont(new Font("Arial", Font.BOLD, 20));

		btnSauvegarder.setFont(new Font("Arial", Font.BOLD, 25));
		btnSupprimer.setFont(new Font("Arial", Font.BOLD, 25));
    

        //Initialisation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if( e.getSource().equals(this.btnSauvegarder) )
        {
            // Ecrire les modifications
        }

        if( e.getSource().equals(this.btnSupprimer)  )
        {
			//afficher la fenetre de confirmation
			FrameConfirmer confirmer;
			boolean bOk;
			confirmer = new FrameConfirmer();
			//si getConfirm renvoie false alors ferme confirm
			//si true supprime dans le fichier
			confirmer.dispose();
			this.dispose();

        }

        if( e.getSource().equals(this.lstNbTroncon)  )
        {
            for (String s : this.lstNbTroncon.getSelectedItems())
            	System.out.println(s);
        }

    }


    public static void main(String[]args)
    {
       	new FrameModificationRoute();
    }
}