package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import twisk.exceptions.DelaiException;
import twisk.exceptions.More1SelecException;
import twisk.exceptions.TwiskException;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

public class EcouteurDelai implements EventHandler<ActionEvent> {

    private MondeIG md;

    public EcouteurDelai(MondeIG monde){
        this.md = monde;
    }

    @Override
    public void handle(ActionEvent event) {
        if(this.md.onlyOneIsActivated()){
            TextInputDialog text = new TextInputDialog();
            text.setTitle("Modifier le délai");
            text.setHeaderText(null);
            text.setContentText("Saisissez un délai pour l'étape : " + this.md.getEtapeSelec().getNom());
            Optional<String> opt = text.showAndWait();
            opt.ifPresent(nom -> {
                int delai = Integer.parseInt(nom);
                if(delai >= 0 && delai <= 99){
                    this.md.getEtapeSelec().setDelai(delai);
                }else{
                    try{
                        throw new DelaiException();
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
