import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameCreation extends JFrame
{
    private JPanel          pnlTop;
    private JPanel          pnlCentral;

    private TextField       txtNom;
    private TextField       txtCooX;
    private TextField       txtCooY;



    public FrameCreation(boolean isIhmVille)
    {
        this.setTitle   ( "Création d'un élément");
        this.setSize    ( 500,400 );
        this.setLocation(  50, 50 );
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        //Definition des objets
        this.pnlTop     = new JPanel(new FlowLayout());
        this.pnlCentral = new JPanel();


        this.pnlCentral.setLayout(new BoxLayout(this.pnlCentral, BoxLayout.Y_AXIS));



        this.add(this.pnlTop, BorderLayout.NORTH);
        this.add(this.pnlCentral);


        Border lineBorder = BorderFactory.createLineBorder(Color.black, 3);
        this.pnlTop.setBorder(lineBorder);

        //Initialisation
        if(isIhmVille)
        {
            this.setIhmVille();
        }else{
            this.setIhmRoute();
        }
    }




    public void setIhmVille()
    {
        JLabel lblTxtPresentation = new JLabel("Création d'une ville");
        lblTxtPresentation.setFont(new Font("Arial", Font.BOLD, 16));
        this.pnlTop.add(lblTxtPresentation, BorderLayout.CENTER);


        //Tests
        JPanel pnlNom = new JPanel(new FlowLayout());
        JPanel pnlCooX = new JPanel(new FlowLayout());
        JPanel pnlCooY = new JPanel(new FlowLayout());


        JLabel lblNom = new JLabel("Nom de la ville : ");
        this.txtNom = new TextField();
        JLabel lblCooX = new JLabel("Coordonnée X de la ville : ");
        this.txtCooX = new TextField();
        JLabel lblCooY = new JLabel("Coordonnée Y de la ville : ");
        this.txtCooY = new TextField();

        pnlNom.add(lblNom);
        pnlNom.add(this.txtNom);

        pnlCooX.add(lblCooX);
        pnlCooX.add(this.txtCooX);

        pnlCooY.add(lblCooY);
        pnlCooY.add(this.txtCooY);

        this.pnlCentral.add(pnlNom);
        this.pnlCentral.add(pnlCooX);
        this.pnlCentral.add(pnlCooY);
    }


    public void setIhmRoute()
    {

    }
}