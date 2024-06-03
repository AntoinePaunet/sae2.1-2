public class Controleur
{
    private Carte           carte;
    //private FrameReseau     ihm;

    private Controleur()
    {
        this.carte = new Carte();
        this.carte.importFile("./data.txt");
    }

    public static void main(String[] args)
    {
        new Controleur();
    }
}
