import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameConfirmer extends JFrame implements ActionListener
{
    private JPanel          panelConf;

    private JLabel 	lblConf;
    private JButton btnOui , btnNon;



    public FrameConfirmer()
    {
        this.setTitle   ( "Confirmer");
        this.setSize    ( 300,100 );
        this.setLocation(  600, 500 );

        this.setVisible(true);

        //Definition des objets
        this.panelConf = new JPanel(new FlowLayout());






        this.add(this.panelConf);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if( e.getSource().equals(this.btnOui) )
        {
            
        }

        if( e.getSource().equals(this.btnNon)  )
        {
            
        }
    }




}