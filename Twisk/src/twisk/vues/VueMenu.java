package twisk.vues;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import twisk.mondeIG.MondeIG;

public class VueMenu extends MenuBar implements Observateur{

    private MondeIG md;
    private Menu Fichier = new Menu("Fichier");
    private Menu Edition = new Menu("Edition");
    private Menu Monde = new Menu("Monde");
    private Menu Parametres = new Menu("Paramètres");
    private MenuItem Supprimer = new Menu("Supprimer (cliquez autant de fois qu'il y'a d'objets séléctionnés)");
    private MenuItem Quitter = new MenuItem("Quitter");
    private MenuItem Renommer = new MenuItem("Renommer");
    private MenuItem Effacer = new MenuItem("Effacer");
    private MenuItem Entree = new MenuItem("Entrée");
    private MenuItem Sortie = new MenuItem("Sortie");
    private MenuItem Delai = new MenuItem("Délai");
    private MenuItem Ecart = new MenuItem("Ecart");

    public VueMenu(MondeIG md){
        this.md = md;

        Quitter.setOnAction(new EcouteurQuitter(this.md));
        Supprimer.setOnAction(new EcouteurSupprimer(this.md));
        Renommer.setOnAction(new EcouteurRenommer(this.md));
        Effacer.setOnAction(new EcouteurEffacer(this.md));
        Entree.setOnAction(new EcouteurEntree(this.md));
        Sortie.setOnAction(new EcouteurSortie(this.md));
        Delai.setOnAction(new EcouteurDelai(this.md));
        Ecart.setOnAction(new EcouteurEcart(this.md));

        Fichier.getItems().add(Quitter);
        Edition.getItems().add(Supprimer);
        Edition.getItems().add(Renommer);
        Edition.getItems().add(Effacer);
        Monde.getItems().add(Entree);
        Monde.getItems().add(Sortie);
        Parametres.getItems().add(Delai);
        Parametres.getItems().add(Ecart);

        this.getMenus().addAll(Fichier, Edition, Monde, Parametres);
    }

    @Override
    public void reagir() {

    }
}
