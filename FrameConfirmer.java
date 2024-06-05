import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameConfirmer extends JFrame implements ActionListener
{
    private JPanel panelConf;

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

		this.lblConf = new JLabel("Êtes-vous sûr ?");

		this.btnOui = new JButton("Oui");
		this.btnNon = new JButton("Non");


		// Ajout des éléments
		panelConf.add(this.lblConf);
		panelConf.add(this.btnOui);
		panelConf.add(this.btnNon);

        this.add(this.panelConf);
    }

    public void actionPerformed(ActionEvent e)
    {
        if( e.getSource().equals(this.btnOui) )
        {
            this.getConfirmation(true);
			this.dispose();
        }

        if( e.getSource().equals(this.btnNon)  )
        {
            this.getConfirmation(false);
			this.dispose();
        }
    }

	public boolean getConfirmation( boolean conf )
	{
		return conf;
	}

}