import javax.swing.*;
import java.awt.*;

public class FrameCreation extends JFrame
{
    private JPanel panelDonnees;
    private JRadioButton radioButtonVille;
    private JRadioButton radioButtonRoute;



    public FrameCreation()
    {
        this.setTitle   ( "Réseau routier");
        this.setSize    ( 500,400 );
        this.setLocation(  50, 50 );
        this.setVisible(true);

        //Definition des objets
        this.panelDonnees = new JPanel();
        this.radioButtonVille = new JRadioButton("Ville");
        this.radioButtonRoute = new JRadioButton("Route");


        this.panelDonnees.add(this.radioButtonVille, BorderLayout.CENTER);
        this.panelDonnees.add(this.radioButtonRoute, BorderLayout.CENTER);







    }
}