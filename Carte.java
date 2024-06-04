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

public class Carte
{
    private ArrayList<Ville> villes;
    private ArrayList<Route> routes;

    public Carte()
    {
		FileReader fr;

		this.villes = new ArrayList<Ville>();
		this.routes = new ArrayList<Route>();


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

					this.villes.add( new Ville(nom, x, y) );
				}
				else if( sc.hasNext("R") )
				{
					int nbTroncon  = sc.nextInt();
					String	villeA = sc.next(); 
					String	villeB = sc.next();

					this.routes.add( new Route(nbTroncon, new Ville("g",0,0), new Ville("t",0,0)));
				}
				else
					sc.nextLine();



			fr.close();
		}
		catch (Exception e){ e.printStackTrace(); }
    }


/*
Les villes ont un num, nom, x et y
Les routes ont un nombre de troncons, une villeA et une villeB

V	Nom	00	00
R	00	Nom	Nom
*/




}
