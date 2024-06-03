import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Cette classe lie la pertie métier et vue du projet
 * @author Antione Paunet, IUT du Havre
 * @author Mael Vauthier,  IUT du Havre
 * @author Martin Ravenel, IUT du Havre
 * @version 1.0 , 2024-06-03
 */

public class Controleur
{
    private Carte           carte;
    private Interface       ihm;
    private FrameCreation   ihmCreation;

    private String urlFichier;
    private File fichierData;



    private Controleur()
    {
        this.carte = new Carte();
        this.urlFichier = "data.txt";
        this.ihm = new Interface();
        this.init();
        this.importFile("data.txt");

        //Ajout des actions listener pour les bouttons
        this.ihm.getMenuFichierAjouter().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                getCrtl().ihmCreation = new FrameCreation();
            }
        });
    }

    private Controleur getCrtl()
    {
        return this;
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
