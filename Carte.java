import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Cette classe permet de mettre en relation et stocker les villes ainsi que les routes
 * @author Antione Paunet, IUT du Havre
 * @author Mael Vauthier,  IUT du Havre
 * @author Martin Ravenel, IUT du Havre
 * @version 1.0 , 2024-06-03
 */

public class Carte {

    private Ville []    tabVilles;
    private Routes[]    tabRoutes;

    private String urlFichier;
    private File fichierData;

    public Carte()
    {
        this.tabRoutes = new Routes[100];
        this.tabVilles = new Ville[50];
        this.urlFichier = "./data.txt";
        this.init();
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

}
