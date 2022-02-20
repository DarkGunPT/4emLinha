package jogo.iu.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import jogo.logica.JogoObser;

public class RecuarPane extends HBox {
    private JogoObser jogoObser;
    Button okButton;
    TextField jtextfield1;
    public RecuarPane (JogoObser jogoObser){
        this.jogoObser = jogoObser;
        criarvista();
        registarListeners();
        registarObservador();
        atualiza();
    }
    private void criarvista(){
        jtextfield1=new TextField();
        okButton = new Button("Ok");
        this.setAlignment(Pos.TOP_CENTER);
        getChildren().addAll(jtextfield1,okButton);
    }
    private void registarObservador(){
        jogoObser.addPropertyChangeListener("pecas", evt -> {atualiza();});
    }

    private void registarListeners(){
        okButton.setOnAction((e)->{
            String recuos = jtextfield1.getText();
            int recuar = Integer.parseInt(recuos);
            jogoObser.recuarJogadas(recuar);
            jogoObser.verificaJogada();
        });
    }
    private void atualiza(){
        this.setVisible(false);

    }
}
