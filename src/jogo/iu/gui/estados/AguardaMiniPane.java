package jogo.iu.gui.estados;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import jogo.logica.JogoObser;

import java.io.File;

import static jogo.logica.Situacao.*;

public class AguardaMiniPane extends VBox {
    private JogoObser jogoObser;
    StackPane opcoes;
    public AguardaMiniPane(JogoObser jogoObser, StackPane opcoes){
        this.jogoObser = jogoObser;
        this.opcoes=opcoes;
        criavista();
        registarObserv();
        atualiza();
    }
    private void criavista(){
        setSpacing(20);
        setAlignment(Pos.CENTER);
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

    }
    private void registarObserv(){
        jogoObser.addPropertyChangeListener("pecas", evt -> {atualiza();});
    }

    private void atualiza(){
        this.setVisible(jogoObser.getSituacao()== AguardarMiniJogoA);
    }
}