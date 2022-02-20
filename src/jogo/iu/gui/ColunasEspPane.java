package jogo.iu.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import jogo.logica.JogoObser;

import java.awt.*;

public class ColunasEspPane extends HBox {
    private JogoObser jogoObser;
    Button col1Button, col2Button, col3Button, col4Button, col5Button, col6Button, col7Button;
    public ColunasEspPane(JogoObser jogoObser){
        this.jogoObser = jogoObser;
        criarvista();
        registarListeners();
        registarObservador();
        atualiza();
    }
    private void criarvista(){
        col1Button = new Button("1");
        col2Button = new Button("2");
        col3Button = new Button("3");
        col4Button = new Button("4");
        col5Button = new Button("5");
        col6Button = new Button("6");
        col7Button = new Button("7");
        this.setSpacing(31);
        this.setAlignment(Pos.CENTER);
        getChildren().addAll(col1Button, col2Button, col3Button, col4Button, col5Button, col6Button, col7Button);
    }
    private void registarObservador(){
        jogoObser.addPropertyChangeListener("pecas", evt -> {atualiza();});
    }

    private void registarListeners(){
        col1Button.setOnAction((e)->{
            jogoObser.jogarespecial(jogoObser.getJogador(), 1);
            jogoObser.verificaJogada();
        });
        col2Button.setOnAction((e)->{
            jogoObser.jogarespecial(jogoObser.getJogador(), 2);
            jogoObser.verificaJogada();
        });
        col3Button.setOnAction((e)->{
            jogoObser.jogarespecial(jogoObser.getJogador(), 3);
            jogoObser.verificaJogada();
        });
        col4Button.setOnAction((e)->{
            jogoObser.jogarespecial(jogoObser.getJogador(), 4);
            jogoObser.verificaJogada();
        });
        col5Button.setOnAction((e)->{
            jogoObser.jogarespecial(jogoObser.getJogador(), 5);
            jogoObser.verificaJogada();
        });
        col6Button.setOnAction((e)->{
            jogoObser.jogarespecial(jogoObser.getJogador(), 6);
            jogoObser.verificaJogada();
        });
        col7Button.setOnAction((e)->{
            jogoObser.jogarespecial(jogoObser.getJogador(), 7);
            jogoObser.verificaJogada();
        });
    }
    private void atualiza(){
        this.setVisible(false);
    }
}
