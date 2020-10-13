package donotforget.layout;

import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.beans.binding.Bindings;

public class Navigation extends BorderPane {
    public Navigation() {
        super();
        Button t = new Button("derechaa");
        this.setMinHeight(200);
        this.setMinWidth(200);
        t.setMaxWidth(Double.MAX_VALUE);

        t.getStyleClass().add("boton");

        t.setStyle("-fx-background-color: blue; -fx-text-fill: white");

        this.setBottom(t);
        BorderPane.setAlignment(t, Pos.CENTER);
        this.setMinWidth(0);


        this.setStyle("-fx-background-color: blue;");
    }

}