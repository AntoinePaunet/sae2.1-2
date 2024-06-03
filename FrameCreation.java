import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameCreation extends JFrame implements ActionListener
{
    private JPanel panelDonnees;
    private JRadioButton radioButtonVille;
    private JRadioButton radioButtonRoute;



    public FrameCreation()
    {
        this.setTitle   ( "Création d'un élément");
        this.setSize    ( 500,400 );
        this.setLocation(  50, 50 );
        this.setVisible(true);

        //Definition des objets
        this.panelDonnees = new JPanel();

        this.radioButtonVille = new JRadioButton("Ville");
        this.radioButtonRoute = new JRadioButton("Route");


        this.panelDonnees.add(this.radioButtonVille, BorderLayout.CENTER);
        this.panelDonnees.add(this.radioButtonRoute, BorderLayout.CENTER);
        this.add(panelDonnees);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if( e.getSource().equals(this.radioButtonVille) )
        {
            this.radioButtonRoute.setSelected(false);
            this.setIhmVille();
            return;
        }

        if( e.getSource().equals(this.radioButtonRoute) )
        {
            this.radioButtonVille.setSelected(false);
            this.setIhmRoute();
        }


    }

    public void setIhmVille()
    {

    }


    public void setIhmRoute()
    {

    }


}