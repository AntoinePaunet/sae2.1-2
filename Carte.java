import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Cette classe permet de construire et stocker les villes ainsi que les routes. Elle représente tout le réseau pour le programme.
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
			{
				String ligne = sc.nextLine();
				System.out.println(ligne);
				int etapeLecture = 0;

				if( !ligne.isEmpty() )
				{
					if( ligne.equals("[VILLES]") )
					{
						ligne = sc.nextLine();
						etapeLecture = 1;
					}
					else if( ligne.equals("[ROUTES]") )
					{
						ligne = sc.nextLine();
						etapeLecture = 2;
					}
					if( etapeLecture == 1 ) this.lireVille(ligne);
					if( etapeLecture == 2 ) this.lireRoute(ligne);

				}
			}
			sc.close();
			fr.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}




	public void lireVille( String ligne )
	{
		String[] routeInfo = ligne.split("\t");

		String nom = routeInfo[0]; 
		int  x = Integer.parseInt(routeInfo[1]);
		int  y = Integer.parseInt(routeInfo[2]);

		this.villes.add( new Ville(nom, x, y) );



		//Ville v = new Ville(nom, x, y);
		for( Ville i : this.villes )
			System.out.println(i);
		//System.out.println("indice de la ville " + villes.get(1));
	}


	public void lireRoute( String ligne )
	{
		String[] routeInfo = ligne.split("\t");

		int nbTroncon = Integer.parseInt(routeInfo[0]); 
		Ville  villeA = this.rechercheVille(Integer.parseInt(routeInfo[1]));
		Ville  villeB = this.rechercheVille(Integer.parseInt(routeInfo[2]));

		Route r = new Route( nbTroncon, villeA, villeB );

		this.routes.add(r);
		villeA.ajouterRoute(r);
		villeB.ajouterRoute(r);

		System.out.println(r);
	}


	public Ville rechercheVille( int numVille )
	{
		System.out.println(this.villes.indexOf(this.villes.get(numVille-1)));
		return this.villes.get(numVille-1);
	}


/*
Les villes ont un num, nom, x et y
Les routes ont un nombre de troncons, une villeA et une villeB

V	Nom	00	00
R	00	00	00
*/

	public static void main( String[] args )
	{
		new Carte();
	}
}