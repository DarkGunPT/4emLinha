package jogo.iu.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import jogo.logica.JogoObser;

import java.awt.*;

import static jogo.logica.Situacao.AguardaMiniJogoB;
import static jogo.logica.Situacao.AguardarMiniJogoA;

public class MiniJogoBPane extends VBox {
    private JogoObser jogoObser;
    Button okButton;
    TextField jtextfield1;
    Label pergunta;
    int [] perguntai;
    public MiniJogoBPane(JogoObser jogoObser){
        this.jogoObser = jogoObser;
        criarvista();
        registarListeners();
        registarObservador();
        atualiza();
    }
    private void criarvista(){
        pergunta = new Label();
        jtextfield1=new TextField();
        okButton = new Button("Ok");
        this.setAlignment(Pos.TOP_CENTER);
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        getChildren().addAll(pergunta,jtextfield1,okButton);
        pergunta.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.ITALIC, 14));
        pergunta.setTextFill(Color.BLACK);
        jogoObser.getString();
    }
    private void registarObservador(){
        jogoObser.addPropertyChangeListener("pecas", evt -> {atualiza();});
    }

    private void registarListeners(){
        okButton.setOnAction((e)->{
            if(jtextfield1.getText()!=null){
                jogoObser.jogoPalavras(jtextfield1.getText(), jogoObser.getPergunta());
                jogoObser.verificaJogada();
            }
            jtextfield1.requestFocus();
        });
    }
    private void atualiza(){
        pergunta.setVisible(false);
        jtextfield1.setVisible(false);
        okButton.setVisible(false);
        this.setVisible(false);
        if(jogoObser.getSituacao()==AguardaMiniJogoB){
            pergunta.setVisible(true);
            jtextfield1.setVisible(true);
            okButton.setVisible(true);
            pergunta.setText(jogoObser.getPergunta());
            this.setVisible(true);
        }
    }
}
