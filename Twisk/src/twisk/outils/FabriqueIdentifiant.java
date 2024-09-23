package twisk.outils;

public class FabriqueIdentifiant {

    private static FabriqueIdentifiant fb;
    private int noEtape;

    public static FabriqueIdentifiant getInstance(){
        if(fb == null)
            fb = new FabriqueIdentifiant();
        return fb;
    }

    public String getIdentifiantEtape(){
        this.noEtape++;
        return Integer.toString(noEtape);
    }
}
