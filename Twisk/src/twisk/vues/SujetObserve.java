package twisk.vues;

import java.util.ArrayList;

public class SujetObserve {

    private ArrayList<Observateur> ob = new ArrayList<>();

    public SujetObserve(){
    }

    public void addObservateur(Observateur o){
        this.ob.add(o);
    }

    public void notifierObservateurs(){
        for(Observateur o : this.ob){
            o.reagir();
        }
    }
}
