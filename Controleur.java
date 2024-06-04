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
    private static Carte    carte;
    private FramePrincipale ihm;
    private FrameCreation   ihmCreation;

    private String urlFichier;
    private File fichierData;



    private Controleur() {
        this.urlFichier = "data.txt";
        this.ihm = new FramePrincipale();
        this.init();
        this.importFile("data.txt");
        Controleur.carte = new Carte();
    }

    private Controleur getCrtl()
    {
        return this;
    }

	public static void setNouvelleVille( Ville ville ) throws IOException
    {
        Controleur.carte.ecrireVille(ville.getNom(), ville.getX(), ville.getY());
	}


    private boolean init()
    {
        this.fichierData = new File(this.urlFichier);

        if(fichierData.exists())
        {
            return true;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichierData)))
        {
            writer.write("[VILLES]\n\n[ROUTES]");
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
