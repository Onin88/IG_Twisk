package twisk.outils;

public class TailleComposants {

    private static TailleComposants tc;
    private int hauteur;
    private int largeur;

    public static TailleComposants getInstance(){
        if(tc == null)
            tc = new TailleComposants();
        return tc;
    }

    public int getHauteur() {
        this.hauteur = 50;
        return hauteur;
    }

    public int getLargeur() {
        this.largeur = 100;
        return largeur;
    }
}
