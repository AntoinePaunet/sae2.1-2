import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameCreation extends JFrame
{
    private JPanel          pnlRadio;
    private JPanel          pnlCentral;

    private JRadioButton    radioButtonVille;
    private JRadioButton    radioButtonRoute;
    private ButtonGroup     btnGrp;

    private TextField       txtNom;
    private TextField       txtCooX;
    private TextField       txtCooY;



    public FrameCreation()
    {
        this.setTitle   ( "Création d'un élément");
        this.setSize    ( 500,400 );
        this.setLocation(  50, 50 );
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        //Definition des objets
        this.pnlRadio   = new JPanel(new FlowLayout());
        this.pnlCentral = new JPanel(new GridLayout(3,2,10,10));

        this.pnlCentral.add(Box.createRigidArea(new Dimension(0, 100)));

        this.radioButtonVille = new JRadioButton("Ville");
        this.radioButtonRoute = new JRadioButton("Route");
        this.btnGrp = new ButtonGroup();

        this.btnGrp.add(this.radioButtonRoute);
        this.btnGrp.add(this.radioButtonVille);


        this.pnlRadio.add(this.radioButtonVille, BorderLayout.CENTER);
        this.pnlRadio.add(this.radioButtonRoute, BorderLayout.CENTER);

        this.add(this.pnlRadio, BorderLayout.NORTH);
        this.add(this.pnlCentral);

        this.radioButtonVille.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setIhmVille();
            }
        });

        this.radioButtonRoute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setIhmRoute();
            }
        });


        Border lineBorder = BorderFactory.createLineBorder(Color.black, 3);
        this.pnlRadio.setBorder(lineBorder);


        //Initialisation
        this.radioButtonVille.setSelected(true);
        this.setIhmVille();
    }




    public void setIhmVille()
    {
        JLabel lblNom = new JLabel("Nom de la ville : ");
        this.txtNom = new TextField();
        JLabel lblCooX = new JLabel("Coordonnée X de la ville : ");
        this.txtCooX = new TextField();
        JLabel lblCooY = new JLabel("Coordonnée Y de la ville : ");
        this.txtCooY = new TextField();

        this.txtNom.setPreferredSize(new Dimension(20, 30));
        this.txtCooY.setPreferredSize(new Dimension(20, 30));
        this.txtCooX.setPreferredSize(new Dimension(20, 30));

        this.pnlCentral.add(lblNom);
        this.pnlCentral.add(this.txtNom);
        this.pnlCentral.add(lblCooX);
        this.pnlCentral.add(this.txtCooX);
        this.pnlCentral.add(lblCooY);
        this.pnlCentral.add(this.txtCooY);

    }


    public void setIhmRoute()
    {

    }
}