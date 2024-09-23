package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.exceptions.ArcException;
import twisk.exceptions.TwiskException;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class EcouteurPointDeControle implements EventHandler<MouseEvent> {

    private MondeIG md;
    private PointDeControleIG pt;

    public EcouteurPointDeControle(MondeIG md, PointDeControleIG pd){
        this.md = md;
        this.pt = pd;
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println("Point : " + pt.getIdentifiant() + " séléctionné de l'étape " + pt.getE().getNom());

        if(this.md.getPtSelec() == null){
            this.md.setPtSelec(this.pt);
            System.out.println("pt : " + this.pt.getIdentifiant());
        }else{
            if(this.md.getPtSelec().getE().getIdentifiant().equals(pt.getE().getIdentifiant())){
                this.md.setPtSelec(null);
                try{
                    throw new ArcException();
                }catch(TwiskException e){
                    e.printStackTrace();
                }
            }else{
                System.out.println("pt2 : " + this.pt.getIdentifiant());
                this.md.ajouterArc(this.md.getPtSelec(), this.pt);
                this.md.setPtSelec(null);
            }
        }
        this.md.getSo().notifierObservateurs();
    }
}
