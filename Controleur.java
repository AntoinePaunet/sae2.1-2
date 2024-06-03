import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.temporal.JulianFields;

public class Controleur
{
    private Carte           carte;
    private FrameReseau     ihm;

    private String urlFichier;
    private File fichierData;



    private Controleur()
    {
        this.carte = new Carte();
        this.urlFichier = "./data.txt";
        this.ihm = new FrameReseau();
        this.init();
        this.importFile("./data.txt");
        this.ihm.getPanel().actionPerformed(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource() instanceof JButton)
                {

                }
            }
        });
    }


    private boolean init()
    {
        this.fichierData = new File(this.urlFichier);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichierData)))
        {
            writer.write("Villes :\nRoutes :");
            System.out.println("Fichier de données créer : " + fichierData.getAbsolutePath());
        } catch (IOException e)
        {
            return false;
        }

        return true;
    }

    public boolean importFile(String url)
    {
        File fileImport = new File(url);

        if(fileImport.exists() && fileImport.isFile() && fileImport.canWrite() && fileImport.canRead())
        {
            this.urlFichier = url;
            this.fichierData = fileImport;
            return true;
        }
        System.out.println("Ceci n'est pas un fichier data");
        return false;
    }



    public static void main(String[] args)
    {
        new Controleur();
    }
}
