import java.io.*;
import java.util.Objects;
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

			int etapeLecture = 0;

			while ( sc.hasNextLine() )
			{
				String ligne = sc.nextLine();

				if( !ligne.isEmpty() )
				{
					if( ligne.equals("[VILLES]") )
					{
						etapeLecture = 1;
						if(sc.hasNextLine())
						{
							ligne = sc.nextLine();
						}
					}
					else if( ligne.equals("[ROUTES]") )
					{
						etapeLecture = 2;
						if(sc.hasNextLine())
						{
							ligne = sc.nextLine();
						}
					}
					if( etapeLecture == 1 && !ligne.equals("[VILLES]"))
					{
						if(!ligne.isEmpty())
						{
							this.lireVille(ligne);
						}
					}
					if( etapeLecture == 2 )
					{
						if(!ligne.isEmpty() && !ligne.equals("[ROUTES]"))
						{
							this.lireRoute(ligne);
						}
					}

				}
			}
			sc.close();
			fr.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}

	public Ville getVille(String nomVille)
	{
		for(Ville i : this.villes)
		{
			System.out.println(i.getNom() + " " + i.getNumVille());
			if (i.getNom().equals(nomVille)) return i;
		}
		return null;
	}


	public void ecrireVille(String nom, int x, int y) throws IOException
	{
		FileReader fr = new FileReader("data.txt");
		Scanner sc = new Scanner(fr);


		String donnesFichier = "";

		while(sc.hasNextLine())
		{
			donnesFichier += sc.nextLine()+"\n";
		}


		String villes = donnesFichier.substring(donnesFichier.indexOf("[VILLES]"), donnesFichier.indexOf("\n["));
		String routes = donnesFichier.substring(donnesFichier.indexOf("[ROUTES]"));

		donnesFichier = villes + (nom + "\t" + x + "\t" + y +"\n\n") + routes;


		BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));

		try {
			writer.write(donnesFichier);
		}catch (Exception e)
		{
			e.printStackTrace();
		}

		writer.close();
	}

	public void ecrireRoute(Ville villeA, Ville villeB, int nbTroncons) throws IOException {
		FileReader fr = new FileReader("data.txt");
		Scanner sc = new Scanner(fr);


		String donnesFichier = "";



		while(sc.hasNextLine())
		{
			String ligne = sc.nextLine();
			donnesFichier += ligne+"\n";
			if(ligne.equals((nbTroncons + "\t" + villeA.getNumVille() + "\t" + villeB.getNumVille() + "\n")))
			{
				return;
			}

		}


		donnesFichier += (nbTroncons + "\t" + villeA.getNumVille() + "\t" + villeB.getNumVille() + "\n");


		BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));

		try {
			writer.write(donnesFichier);
		}catch (Exception e)
		{
			e.printStackTrace();
		}

		writer.close();
	}




	public void lireVille( String ligne )
	{
		String[] routeInfo = ligne.split("\t");


		String nom = routeInfo[0]; 
		int  x = Integer.parseInt(routeInfo[1]);
		int  y = Integer.parseInt(routeInfo[2]);


		this.villes.add( new Ville(nom, x, y) );
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
	}


	public Ville rechercheVille( int numVille )
	{
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