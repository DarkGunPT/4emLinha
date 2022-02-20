package jogo.iu.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import jogo.logica.JogoObser;
import jogo.logica.Situacao;

import static jogo.logica.Situacao.AguardarMiniJogoA;

public class MiniJogoAPane extends VBox {
    private JogoObser jogoObser;
    Button okButton;
    TextField jtextfield1;
    Label pergunta;
    int [] perguntai;
    public MiniJogoAPane(JogoObser jogoObser){
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

    }
    private void registarObservador(){
        jogoObser.addPropertyChangeListener("pecas", evt -> {atualiza();});
    }

    private void registarListeners(){
        okButton.setOnAction((e)->{
            if(jtextfield1.getText()!=null){
                jogoObser.acertarMatematica(jtextfield1.getText(), perguntai);
                jogoObser.jogarMiniA();
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
        if(jogoObser.getSituacao()==AguardarMiniJogoA){
            pergunta.setVisible(true);
            jtextfield1.setVisible(true);
            okButton.setVisible(true);
            this.setVisible(true);
            perguntai=jogoObser.jogoMatematica();
            pergunta.setText(jogoObser.perguntaMatematica(perguntai));
        }
    }
}
