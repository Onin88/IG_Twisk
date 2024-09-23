package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import twisk.exceptions.More1SelecException;
import twisk.exceptions.TwiskException;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

public class EcouteurRenommer implements EventHandler<ActionEvent> {

    private MondeIG md;

    public EcouteurRenommer(MondeIG md){
        this.md = md;
    }

    @Override
    public void handle(ActionEvent event) {
        if(this.md.onlyOneIsActivated()){
            TextInputDialog tp = new TextInputDialog();
            tp.setTitle("Renommer l'activité");
            tp.setHeaderText(null);
            tp.setContentText("Saisi un nouveu nom pour l'étape : " + this.md.getEtapeSelec().getNom());
            Optional<String> opt = tp.showAndWait();
            opt.ifPresent(nom -> {
                this.md.getEtapeSelec().setNom(nom);
            });
        }else{
            try {
                throw new More1SelecException();
            }catch(TwiskException e){
                e.printStackTrace();
            }
        }

        this.md.getSo().notifierObservateurs();
    }
}