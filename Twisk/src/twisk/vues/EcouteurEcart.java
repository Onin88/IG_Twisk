package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import twisk.exceptions.DelaiException;
import twisk.exceptions.EcartException;
import twisk.exceptions.More1SelecException;
import twisk.exceptions.TwiskException;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

public class EcouteurEcart implements EventHandler<ActionEvent> {

    private MondeIG md;

    public EcouteurEcart(MondeIG md) {
        this.md = md;
    }

    @Override
    public void handle(ActionEvent event) {
        if(this.md.onlyOneIsActivated()){
            TextInputDialog t = new TextInputDialog();
            t.setTitle("Modifier l'écart");
            t.setHeaderText(null);
            t.setContentText("Saisissez un écart pour l'étape : " + this.md.getEtapeSelec().getNom());
            Optional<String> op = t.showAndWait();
            op.ifPresent(nom -> {
                int delai = this.md.getEtapeSelec().getDelai();
                int ecart = Integer.parseInt(nom);
                if(ecart >= 0 && ecart <= delai){
                    this.md.getEtapeSelec().setEcart(ecart);
                }else{
                    try{
                        throw new EcartException();
                    }catch(TwiskException e){
                        e.printStackTrace();
                    }
                }
            });
        }else{
            try{
                throw new More1SelecException();
            }catch(TwiskException e){
                e.printStackTrace();
            }
        }
        this.md.getSo().notifierObservateurs();
    }
}
