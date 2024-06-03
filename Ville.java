import java.util.List;

/**
 * Cet classe enum recense les Epices contenues dans le jeu. Les Epices sont un type de Jeton, et ont une Couleur coeespondante, définie dans la classe enum Couleur.
 * @author Antione Paunet, IUT du Havre
 * @author Mael Vauthier,  IUT du Havre
 * @author Martin Ravenel, IUT du Havre
 * @version 1.0 , 2024-06-03
*/

public class Ville
{
	private static int nbVille = 1;

	private int numVille , x , y;
	private String nom;

	private List lstRoute;

	/**
	 * Constructeur de la classe Ville. Chaque villle possede un numéro séquentiel, un nom, ainsi qu'une abcisse et une ordonnée pour définnir sa position.
	 *
	 * @param nom le nom de la Ville
	 * @param x l'abcisse de la Ville
	 * @param y l'ordonnée de la Ville
	 */
	private Ville( String nom, int x, int y)
	{
		this.numVille = Ville.nbVille++;
		this.nom = nom;
		this.x = x;
		this.y = y;
	}

	/**
	 * Donne le numèro de la Ville.
	 *
	 * @return le numéro de la ville.
	 */

	public int getNumVille()
	{
		return this.numVille;
	}

	/**
	 * Donne le nom de la Ville.
	 *
	 * @return le nom de la Ville.
	 */

	public String getNom()
	{
		return this.nom;
	}

	/**
	 * Donne l'abcisse de la Ville.
	 *
	 * @return l'abcisse de la Ville.
	 */

	public int getX()
	{
		return this.x;
	}

	/**
	 * Donne l'ordonnée de la Ville.
	 *
	 * @return l'ordonnée de la Ville.
	 */

	public int getY()
	{
		return this.y;
	}


	/**
	 * Donne sous forme texte toutes les données de la Ville.
	 *
	 * @return le mot "Ville" puis le nom , numéro et position de la Ville.
	 */

	public String toString()
	{
		return "Ville " + this.numVille + " " + this.nom
		 +     "\tx:" + this.x + " y:" + this.y;
	}

}