package ristinolla.kayttoliittyma;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ristinolla.logiikka.Sovelluslogiikka;

public class GraafinenKayttoliittyma {

    private Sovelluslogiikka logiikka;

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(600, 600);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile(this.logiikka);
                tile.setX(i);
                tile.setY(j);
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);

                root.getChildren().add(tile);
            }
        }
        return root;
    }

    public void kaynnista(Stage primaryStage) {
        this.logiikka = new Sovelluslogiikka();
        this.logiikka.alustaRuudut();
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }
}
