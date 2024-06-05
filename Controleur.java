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



    private Controleur()
    {
        this.urlFichier = "data.txt";
        this.init();
        this.importFile(this.urlFichier);
        Controleur.carte = new Carte();
        this.ihm = new FramePrincipale();
    }

    public static Carte getCarte() { return carte; }

    public static boolean setNouvelleVille( Ville ville ) throws IOException
    {
        Ville vDep = Controleur.carte.getVille( ville.getNom() );

        if( vDep != null )
        	return false;

        Controleur.carte.ecrireVille( ville.getNom(), ville.getX(), ville.getY() );
        return true;
	}

    public static boolean setNouvelleRoute( String villeA, String villeB, int nbTroncons ) throws IOException
    {
        Ville vDep = Controleur.carte.getVille(villeA);
        Ville vArr = Controleur.carte.getVille(villeB);

        if( vDep == null || vArr == null )
        	return false;

        Controleur.carte.ecrireRoute( vDep, vArr, nbTroncons );
        return true;
    }


    private boolean init()
    {
        this.fichierData = new File( this.urlFichier );

        if( fichierData.exists() )
        	return true;

        try( BufferedWriter writer = new BufferedWriter( new FileWriter(fichierData) ) )
        {
            writer.write("[VILLES]\n\n[ROUTES]");
            System.out.println("Fichier de données créé : " + fichierData.getAbsolutePath());
        }
		catch( IOException e ) { return false; }

        return true;
    }

    public boolean importFile( String url )
    {
        File fileImport = new File(url);

        if( fileImport.exists() && fileImport.isFile() && fileImport.canWrite() && fileImport.canRead() )
        {
            this.urlFichier = url;
            this.fichierData = fileImport;
            return true;
        }
        System.out.println("Ce fichier n'est pas lisible");
        return false;
    }

    public static void main(String[] args)
    {
        new Controleur();
    }
}
