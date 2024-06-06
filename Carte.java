import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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

    public Carte() throws FileNotFoundException
	{
		this.villes = new ArrayList<Ville>();
		this.routes = new ArrayList<Route>();
		this.readAll("data.txt");
	}


	public Runnable readAll( String nomFicher ) throws FileNotFoundException
	{
		Timer timer = new Timer(1000, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					FileReader fr = new FileReader( nomFicher );
					Scanner sc = new Scanner(fr);

					//Vider les tableaux pour ne pas refaire trop de variables
					villes = new ArrayList<Ville>(villes.size());
					routes = new ArrayList<Route>(routes.size());

					int etapeLecture = 0;

					while( sc.hasNextLine() )
					{
						String ligne = sc.nextLine();

						if( !ligne.isEmpty() )
						{
							if( ligne.equals("[VILLES]") )
							{
								etapeLecture = 1;
								if( sc.hasNextLine() )
								{
									ligne = sc.nextLine();
								}
							}
							else if( ligne.equals("[ROUTES]") )
							{
								etapeLecture = 2;
								if( sc.hasNextLine() )
								{
									ligne = sc.nextLine();
								}
							}
							if( etapeLecture == 1 && !ligne.equals("[VILLES]") )
							{
								if( !ligne.isEmpty() )
								{
									lireVille(ligne);
								}
							}
							if( etapeLecture == 2 )
							{
								if( !ligne.isEmpty() && !ligne.equals("[ROUTES]") )
								{
									lireRoute(ligne);
								}
							}

						}
					}
					sc.close();
					fr.close();
				}
				catch( Exception exp ){ exp.printStackTrace(); }
			}
		});
		timer.start();
		return null;
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

		Ville  villeA = this.rechercheVille(routeInfo[1]);
		Ville  villeB = this.rechercheVille(routeInfo[2]);

		if(villeA == null || villeB == null) //Si la ville recherché n'existe plus
		{
			return;
		}


		Route r = new Route( nbTroncon, villeA, villeB );

		this.routes.add(r);
		villeA.ajouterRoute(r);
		villeB.ajouterRoute(r);
	}


	public void ecrireVille( String nom, int x, int y ) throws IOException
	{
		FileReader fr = new FileReader("data.txt");
		Scanner sc = new Scanner(fr);


		String donnesFichier = "";

		while( sc.hasNextLine() )
			donnesFichier += sc.nextLine()+"\n";

		if( !donnesFichier.contains(nom) ) // Vérification de doubles dans le fichier texte
		{
			String donneesVilles = donnesFichier.substring(donnesFichier.indexOf("[VILLES]"), donnesFichier.indexOf("\n["));
			String donneesRoutes = donnesFichier.substring(donnesFichier.indexOf("[ROUTES]"));

			donnesFichier = donneesVilles + (nom + "\t" + x + "\t" + y +"\n\n") + donneesRoutes;


			BufferedWriter writer = new BufferedWriter( new FileWriter("data.txt") );

			try
			{
				this.villes.add(new Ville(nom, x, y)); //creation de la ville
				writer.write(donnesFichier);
			}
			catch( Exception e ) { e.printStackTrace(); }

			writer.close();
		}
		sc.close();
	}

	public void ecrireRoute(Ville villeA, Ville villeB, int nbTroncons) throws IOException
	{
		FileReader fr = new FileReader("data.txt");
		Scanner sc = new Scanner(fr);

		String donnesFichier = "";

		while( sc.hasNextLine() )
			donnesFichier += sc.nextLine()+"\n";

		donnesFichier += (nbTroncons + "\t" + villeA.getNom() + "\t" + villeB.getNom() + "\n");


		BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));

		try
		{
			this.routes.add(new Route(nbTroncons, villeA, villeB));
			writer.write(donnesFichier);
		}
		catch( Exception e ) { e.printStackTrace(); }

		writer.close();
		sc.close();
	}

	public void modifieVille(Ville ville, String nomVille, int xVille, int yVille) throws IOException
	{
		this.supprimerVille(ville);
		this.ecrireVille(nomVille, xVille, yVille);
	}

	public void supprimerVille(Ville ville) throws IOException
	{
		FileReader fr = new FileReader("data.txt");
		Scanner sc = new Scanner(fr);


		String donnesFichier = "";

		while( sc.hasNextLine() )
			donnesFichier += sc.nextLine()+"\n";

		if( donnesFichier.contains(ville.getNom()) ) // Vérification de doubles dans le fichier texte
		{
			String tmp = ville.getX() + "" + ville.getY();
			String donneesVilles = donnesFichier.substring( donnesFichier.indexOf("[VILLES]"), donnesFichier.indexOf(ville.getNom()) );
			String donneesRoutes = donnesFichier.substring( donnesFichier.indexOf(ville.getNom()) + ville.getNom().length() + tmp.length() + 2 );


			donnesFichier = donneesVilles.stripTrailing() + donneesRoutes;


			BufferedWriter writer = new BufferedWriter( new FileWriter("data.txt") );

			try
			{
				writer.write(donnesFichier);
			}
			catch( Exception e ) { e.printStackTrace(); }

			writer.close();
		}
		sc.close();
	}


	public Ville getVille( String nomVille )
	{
		for( Ville i : this.villes )
		{
			if( i.getNom().equals(nomVille) ) return i;
		}
		return null;
	}


	public ArrayList<Ville> getTabVilles() { return this.villes; }


	public Ville rechercheVille( String nom )
	{
		for( Ville v : this.villes )
		{
			if(v.getNom().equals(nom))
			{
				return v;
			}
		}
		return null;
	}
}