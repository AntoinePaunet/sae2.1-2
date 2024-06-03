import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Cette classe permet de construire et stocker les villes ainsi que les routes
 * @author Antione Paunet, IUT du Havre
 * @author Mael Vauthier,  IUT du Havre
 * @author Martin Ravenel, IUT du Havre
 * @version 1.0 , 2024-06-03
 */

public class Carte {

    private ArrayList<Ville> villes;
    private ArrayList<Route> routes;


/*
Les villes ont un num, nom, x et y
Les routes ont un nombre de troncons, une villeA et une villeB



V	Nom	00	00
R	00	Nom	Nom


*/



    public Carte()
    {
        this.tabRoutes = new Routes[100];
        this.tabVilles = new Ville[50];

		FileReader fr;

		try
		{
			fr = new FileReader ( "data.txt" );
			Scanner sc = new Scanner ( fr );

			while ( sc.hasNextLine() )
				if( sc.hasNext("V") )
				{
					String nom = sc.next();
					int		 x = sc.nextInt(); 
					int		 y = sc.nextInt();

					this.tabVilles[
				}

				else if( sc.hasNext("R")



				else
					sc.nextLine();



			fr.close();
		}
		catch (Exception e){ e.printStackTrace(); }

    }






}
