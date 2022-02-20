package jogo.iu.gui.estados;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import jogo.logica.JogoObser;
import jogo.logica.Situacao;

import static jogo.logica.Situacao.Jogar;

public class AguardaReplayPane extends VBox {
    private JogoObser jogoObser;
    Button  avancarButton, sairButton;
    public AguardaReplayPane(JogoObser jogoObser){
        this.jogoObser = jogoObser;
        criarVista();
        registarObservador();
        atualiza();
    }
    private void criarVista(){
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        setAlignment(Pos.CENTER);
        setSpacing(20);
        avancarButton = new Button("Avancar");
        sairButton = new Button("Sair");
        avancarButton.setOnAction((e)->{
            jogoObser.redo();
            jogoObser.acabarReplay();
        });
        sairButton.setOnAction((e)->System.exit(0));
        getChildren().addAll(avancarButton,sairButton);
    }
    private void registarObservador(){
        jogoObser.addPropertyChangeListener("pecas", evt -> {atualiza();});
    }

    private void atualiza(){
        this.setVisible(jogoObser.getSituacao()==Jogar &&jogoObser.getModo() == 4);
    }
}
