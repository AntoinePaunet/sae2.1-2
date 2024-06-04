import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrameModificationVille extends JFrame implements ActionListener
{

    private JPanel panelInfo      ;
	private JPanel panelPrincipal ;
    private JPanel panelDonnees   ;
	private JPanel panelRoute     ;
    private JPanel panelSauvegarde;

    private JLabel lblInfo    ;
    private JLabel lblNomVille;
    private JLabel lblXVille  ;
    private JLabel lblYVille  ;
	private JLabel lblErreur  ;
	private JLabel lblRoute   ;

    private JTextField txtNomVille;
    private JTextField txtXVille;
    private JTextField txtYVille;

    private JButton btnSauvegarder;
    private JButton btnSupprimer;


    public FrameModificationVille()
    {
        this.setTitle   ( "Modification d'une ville");
        this.setSize    ( 500,400            );
        this.setLocation(  50, 50                     );
        this.setLayout  ( new BorderLayout()              );
        


        //Definition des objets
        this.panelInfo       = new JPanel();
		this.panelPrincipal  = new JPanel();
        this.panelDonnees    = new JPanel();
		this.panelRoute      = new JPanel();
        this.panelSauvegarde = new JPanel();

        //Modification du layout des panels
		this.panelPrincipal.setLayout ( new GridLayout(2, 1));
        this.panelDonnees.setLayout   ( new GridLayout(3,2, 30, 30) );
		this.panelRoute.setLayout     ( new BorderLayout());
        this.panelSauvegarde.setLayout( new GridLayout(1, 2) );


        //Ajout des objets aux panels
        this.panelInfo.add(this.lblInfo = new JLabel("Modification d'une ville"));

        this.panelDonnees.add(this.lblNomVille = new JLabel("  Nom de la ville : "));
		this.panelDonnees.add(this.txtNomVille = new JTextField() );

        this.panelDonnees.add(this.lblXVille = new JLabel("  Position X : "));
		this.panelDonnees.add(this.txtXVille = new JTextField(10) );

        this.panelDonnees.add(this.lblYVille = new JLabel("  Position Y : "));
		this.panelDonnees.add(this.txtYVille = new JTextField() );

		this.panelRoute.add(this.lblErreur = new JLabel(""), BorderLayout.SOUTH);
		lblErreur.setFont(new Font("Arial", Font.BOLD, 20));
		this.panelRoute.add(this.lblRoute = new JLabel("  Route(s) : "), BorderLayout.NORTH);
		lblRoute.setFont(new Font("Arial", Font.BOLD, 13));

        this.panelSauvegarde.add(this.btnSauvegarder = new JButton("SAUVEGARDER"));
        this.panelSauvegarde.add(this.btnSupprimer   = new JButton("SUPPRIMER"  ));


        //Ajout des événements aux objets
        this.btnSauvegarder.addActionListener(null);
        this.btnSupprimer.addActionListener(null);


		//Ajout des panels au panel principal
		this.panelPrincipal.add(panelDonnees, BorderLayout.NORTH);
		this.panelPrincipal.add(panelRoute  , BorderLayout.NORTH);

        //Ajout des panels a la frame
        this.add(panelInfo,       BorderLayout.NORTH);
        this.add(panelSauvegarde, BorderLayout.SOUTH);
		this.add(panelPrincipal                     );
        

        //Activation des composants
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
            if (txtNomVille.getText().isEmpty() ||
			    txtXVille.getText().isEmpty()   ||
				txtYVille.getText().isEmpty()     )
			{
				lblErreur.setText("Erreur de saisie.\n");
				System.out.println("test");
			}
        }

        if( e.getSource().equals(this.btnSupprimer)  )
        {
			FrameConfirmer confirmer;
			confirmer = new FrameConfirmer();
        }


    }


    public static void main(String[]args)
    {
        JFrame frameTest;

        frameTest = new FrameModificationVille();
    }



}