/**
 * Cet classe recense les Routes correspondantes aux Villes.
 * @author Antione Paunet, IUT du Havre
 * @author Mael Vauthier,  IUT du Havre
 * @author Martin Ravenel, IUT du Havre
 * @version 1.0 , 2024-05-23
 */


public class Routes
{

	private int   nbTroncon   ;
	private Ville villeDepart ;
	private Ville villeArrivee;


	/**
	 * Constructeur de la classe Route. Chaque route possede un nombre de tronçon, ainsi qu'une ville de départ et une ville d'arrivée pour définir sa position.
	 *
	 * @param nbTroncon le nombre de tronçon de la Route
	 * @param villeD la ville de départ de la Route
	 * @param villeA la ville d'arrivée de la Route
	 */
	public Routes(int nbTroncon, Ville villeD, Ville villeA)
	{
		if (nbTroncon >= 0 && nbTroncon <= 10)
			this.nbTroncon    = nbTroncon;
		this.villeDepart  = villeD   ;
		this.villeArrivee = villeA   ;
	}

	/**
	 * Donne le nombre de tronçon de la Route.
	 *
	 * @return le nombre detronçon de la route.
	 */
	public int getNbTroncon   () { return this.nbTroncon   ; }

	/**
	 * Donne la ville de départ de la Route.
	 *
	 * @return la ville de départ de la route.
	 */
	public Ville getVilleDepart () { return this.villeDepart ; }

	/**
	 * Donne la ville d'arrivée de la Route.
	 *
	 * @return la ville d'arrivée de la route.
	 */
	public Ville getVilleArrivee() { return this.villeArrivee; }

	/**
	 * Donne sous forme texte toutes les données de la Route.
	 *
	 * @return le mot "Route" puis le nombre de tronçon , la ville de départ et la ville d'arrivée de la Route.
	 */
	public String toString()
	{
		return "Route de " + this.getNbTroncon() + " tronçon, qui part de" + this.getVilleDepart()
				+     " jusqu'a " + this.getVilleArrivee();
	}


}