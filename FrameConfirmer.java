import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FrameConfirmer extends JFrame implements ActionListener
{
    private JPanel panelConf;

    private JLabel lblConf;
    private JButton btnOui, btnNon;

    private FrameModificationVille frameModificationVille;
    private FrameModificationRoute frameModificationRoute;

    public FrameConfirmer(FrameModificationRoute frameModificationRoute)
	{
        this.frameModificationRoute = frameModificationRoute;
        creerFrameConfirmer();
    }

    public FrameConfirmer(FrameModificationVille frameModificationVille)
	{
        this.frameModificationVille = frameModificationVille;
        creerFrameConfirmer();
    }

    private void creerFrameConfirmer()
	{
        this.setTitle("Confirmer");
        this.setSize(300, 100);
        this.setLocation(600, 500);

        this.setVisible(true);

        // Definition des objets
        this.panelConf = new JPanel(new FlowLayout());

        this.lblConf = new JLabel("Êtes-vous sûr ?");

        this.btnOui = new JButton("Oui");
        this.btnNon = new JButton("Non");

        // Ajout des éléments
        panelConf.add(this.lblConf);
        panelConf.add(this.btnOui);
        panelConf.add(this.btnNon);

        // Activation des composants
        this.btnOui.addActionListener(this);
        this.btnNon.addActionListener(this);

        this.add(this.panelConf);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.btnOui))
        {
            if (this.frameModificationVille != null)
            {
                this.frameModificationVille.quitterFrame(true);
                try {
                    for (Route r : this.frameModificationVille.getVilleModif().getTabRoutes())
                        Controleur.getCarte().supprimerRoute(r);
                    Controleur.getCarte().supprimerVille(this.frameModificationVille.getVilleModif());
                }
				catch( IOException ex ) { throw new RuntimeException(ex); }
            }
            if (this.frameModificationRoute != null)
                this.frameModificationRoute.quitterFrame(true);
            this.dispose();
        }

        if (e.getSource().equals(this.btnNon)) {
            this.dispose();
        }
    }

}