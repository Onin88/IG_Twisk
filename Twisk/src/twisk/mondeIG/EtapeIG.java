package twisk.mondeIG;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public abstract class EtapeIG implements Iterable<PointDeControleIG>{

    private String nom;
    private String identifiant;
    private int posX;
    private int posY;
    private int largeur;
    private int hauteur;
    private ArrayList<PointDeControleIG> pd = new ArrayList<>();
    private boolean EtapeSelec = false;
    private boolean Entree = false;
    private boolean Sortie = false;
    private int delai = 0;
    private int ecart = 0;

    public EtapeIG(String nom, String idf, int larg, int haut){
        Random r = new Random();
        this.nom = nom;
        this.identifiant = idf;
        this.largeur = larg;
        this.hauteur = haut;
        this.posX = r.nextInt(1280);
        this.posY = r.nextInt(720);
        this.pd.add(new PointDeControleIG(this.posX + (this.largeur/2), this.posY, "1", this));
        this.pd.add(new PointDeControleIG(this.posX + (this.largeur/2), this.posY + this.hauteur, "2", this));
        this.pd.add(new PointDeControleIG(this.posX, this.posY + (this.hauteur/2), "3", this));
        this.pd.add(new PointDeControleIG(this.posX + this.largeur, this.posY + (this.hauteur/2), "4", this));
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public void setEcart(int ecart) {
        this.ecart = ecart;
    }

    public int getDelai() {
        return delai;
    }

    public int getEcart() {
        return ecart;
    }

    public boolean isEntree(){
        return this.Entree;
    }

    public void setEntree(boolean bool){
        this.Entree = bool;
    }

    public boolean isSortie(){
        return this.Sortie;
    }

    public void setSortie(boolean bool){
        this.Sortie = bool;
    }

    public String getIdentifiant(){
        return this.identifiant;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setPosX(int posX){
        this.posX = posX;
    }

    public void setPosY(int posY){
        this.posY = posY;
    }

    public int getPosX(){
        return this.posX;
    }

    public int getPosY(){
        return this.posY;
    }

    public String getNom() {
        return this.nom;
    }

    public Iterator<PointDeControleIG> iterator(){
        return this.pd.iterator();
    }

    public boolean getEtapeSelec(){
        return this.EtapeSelec;
    }

    public void setEtapeSelec(boolean bool){
        this.EtapeSelec = bool;
    }

    public void modifPos(int posX, int posY) {
        this.posX = posX;
        this.posY = posY-hauteur/2-5;
        pd.get(0).setPos(this.posX+this.largeur/2,this.posY);
        pd.get(1).setPos(this.posX+this.largeur/2,this.posY+this.hauteur);
        pd.get(2).setPos(this.posX,this.posY+this.hauteur/2);
        pd.get(3).setPos(this.posX+this.largeur,this.posY+this.hauteur/2);
    }
}
