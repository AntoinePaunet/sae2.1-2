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



    public Carte()
    {
        this.tabRoutes = new Routes[100];
        this.tabVilles = new Ville[50];

    }






}
