package jogo.iu.gui.estados;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import jogo.logica.JogoObser;

import static jogo.logica.Situacao.Jogar;
import static jogo.logica.Situacao.JogarBot;

public class AguardaBotPane extends VBox {
    private JogoObser jogoObser;
    HBox recuarPane;
    public AguardaBotPane(JogoObser jogoObser, HBox recuarPane){
        this.jogoObser = jogoObser;
        this.recuarPane=recuarPane;

        criavista();
        registarObserv();
        atualiza();
    }
    private void criavista(){
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        setSpacing(20);
        Button pecaButton = new Button("Jogar peça");
        Button gravarButton = new Button("Gravar");
        Button sairButton = new Button("Sair");
        setAlignment(Pos.CENTER);
        System.out.println(jogoObser.getModo());
        this.getChildren().addAll(pecaButton, gravarButton,sairButton);
        pecaButton.setOnAction((e)-> {
            jogoObser.jogarautomatico();
            jogoObser.verificaJogada();
        });
        sairButton.setOnAction((e)->System.exit(0));
    }
    private void registarObserv(){
        jogoObser.addPropertyChangeListener("pecas", evt -> {atualiza();});
    }

    private void atualiza(){

        this.setVisible(jogoObser.getSituacao()== JogarBot);
    }
}
