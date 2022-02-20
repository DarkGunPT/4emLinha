package jogo.iu.gui.estados;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import jogo.logica.JogoObser;
import jogo.logica.estados.AguardaModo;
import jogo.logica.estados.AguardarEscolha;

import static jogo.logica.Situacao.*;

public class AguardaModoPane extends BorderPane {
    private JogoObser jogoObser;
    public AguardaModoPane(JogoObser jogoObser) {
        this.jogoObser=jogoObser;
        criarVistaERegistarListeneres();
        registarObserv();
        atualiza();
    }
    private void criarVistaERegistarListeneres(){
        VBox botoes = new VBox(20);
        Button pvpButton = new Button("Pessoa v Pessoa");
        Button pvcButton = new Button("Pessoa v Pc");
        Button cvcButton = new Button("Pc v Pc");
        Button sairButton = new Button("Sair");
        botoes.setAlignment(Pos.CENTER);
        //setPadding(new Insets(10));
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        botoes.getChildren().addAll(pvpButton, pvcButton, cvcButton, sairButton);
        setCenter(botoes);
        pvpButton.setOnAction((e)->{
            jogoObser.escolherModo(1);

        });
        pvcButton.setOnAction((e)->{
            jogoObser.escolherModo(2);

        });
        cvcButton.setOnAction((e)->{
            jogoObser.escolherModo(3);
            //jogoObser.comecarjogar("Computador1", "Computador2");
        });
        sairButton.setOnAction((e)->System.exit(0));
    }
    private void registarObserv(){
        jogoObser.addPropertyChangeListener("pecas", evt -> {atualiza();});
    }
    private void atualiza(){
        this.setVisible(jogoObser.getSituacao()== EsperaModo);
    }
}
