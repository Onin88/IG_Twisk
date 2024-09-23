package twisk.mondeIG;

public class PointDeControleIG{

    private int posX;
    private int posY;
    private String identifiant;
    private EtapeIG e;
    private boolean isSelected = false;


    public PointDeControleIG(int posX, int posY, String identifiant, EtapeIG etape){
        this.posX = posX;
        this.posY = posY;
        this.identifiant = identifiant;
        this.e = etape;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public EtapeIG getE() {
        return e;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setPos(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public boolean getIsSelected(){
        return this.isSelected;
    }

    public void setIsSelected(boolean bool){
        this.isSelected = bool;
    }
}
