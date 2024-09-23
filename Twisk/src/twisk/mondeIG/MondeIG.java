package twisk.mondeIG;

import twisk.exceptions.ArcException;
import twisk.exceptions.TwiskException;
import twisk.outils.TailleComposants;
import twisk.vues.*;
import twisk.outils.FabriqueIdentifiant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MondeIG implements Iterable<EtapeIG>{

    private SujetObserve so = new SujetObserve();
    private ArrayList<Observateur> ob = new ArrayList<>();
    private HashMap<String, EtapeIG> ep = new HashMap<>();
    private PointDeControleIG ptSelec;
    private EtapeIG etapeSelec;
    private ArrayList<ArcIG> arc = new ArrayList<>();

    public MondeIG() {
        this.ajouter("Activité");
    }

    public void ajouter(String type){
        if(type.equals("Activité")){
            String identEtape = FabriqueIdentifiant.getInstance().getIdentifiantEtape();
            ActiviteIG ac = new ActiviteIG("Activité", identEtape, TailleComposants.getInstance().getLargeur(), TailleComposants.getInstance().getHauteur());
            ac.setNom(ac.getNom() + ac.getIdentifiant());
            ep.put(ac.getIdentifiant(), ac);
            System.out.println("Activité ajoutée");
        }
    }

    public SujetObserve getSo() {
        return so;
    }

    public boolean onlyOneIsActivated(){
        int temp = 0;
        for(EtapeIG e : this){
            if(e.getEtapeSelec()){
                temp++;
            }
        }
        if(temp > 1){
            return false;
        }else{
            return true;
        }
    }

    public void removeEtape(EtapeIG e){
        this.ep.remove(e.getIdentifiant(), e);
    }

    public void remove(){ // pas sur
        for(EtapeIG e : this.ep.values()){
            if(e.getEtapeSelec() == true){
                System.out.println("coucou");
                this.ep.remove(e.getIdentifiant(), e);
                for(Iterator<ArcIG> iter = this.iterArc(); iter.hasNext();){
                    ArcIG next = iter.next();
                    if(next.getPt1().getE().getNom().equals(e.getNom())){
                        this.arc.remove(next);
                    }
                }
            }
            this.so.notifierObservateurs();
        }
    }

    public void removeArc(){
        for(Iterator<ArcIG> iter = this.iterArc(); iter.hasNext();){
            ArcIG next = iter.next();
            if(next.getIsSelect() == true){
                this.arc.remove(next);
                next.getPt1().setIsSelected(false);
                next.getPt2().setIsSelected(false);
            }
        }
    }

    public void dragNDrop(String idE, int posX, int posY){
        for(EtapeIG e : this){
            if(idE.equals(e.getIdentifiant())){
                e.modifPos(posX, posY);
            }
        }
    }

    public void ajouterArc(PointDeControleIG pt1, PointDeControleIG pt2){
        ArcIG arc1 = new ArcIG(pt1, pt2);
        if(!isVerify(arc1)){
            try {
                throw new ArcException();
            } catch (TwiskException e) {
                e.printStackTrace();
            }
        }else{
            this.arc.add(arc1);
        }
        pt1.setIsSelected(true);
        pt2.setIsSelected(true);
    }

    public Iterator<ArcIG> iterArc(){
        return this.arc.iterator();
    }

    public Iterator<EtapeIG> iterator() {
        return this.ep.values().iterator();
    }

    public PointDeControleIG getPtSelec() {
        return ptSelec;
    }

    public void setPtSelec(PointDeControleIG ptSelec) {
        this.ptSelec = ptSelec;
    }

    public EtapeIG getEtapeSelec(){
        return this.etapeSelec;
    }

    public boolean isVerify(ArcIG arc){
        if(arc.getPt1().getIsSelected() == true ||arc.getPt2().getIsSelected() == true){
            return false;
        }else{
            return true;
        }
    }

    public void setEtapeSelec(EtapeIG e){
        this.etapeSelec = e;
    }
}
