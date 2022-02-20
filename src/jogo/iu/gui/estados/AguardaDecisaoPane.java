package jogo.iu.gui.estados;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import jogo.logica.JogoObser;

import static jogo.logica.Situacao.AguardaMiniDecisao;
import static jogo.logica.Situacao.EsperaModo;

public class AguardaDecisaoPane extends BorderPane{
    private JogoObser jogoObser;
    public AguardaDecisaoPane(JogoObser jogoObser) {
        this.jogoObser=jogoObser;
        criarVistaERegistarListeneres();
        registarObserv();
        atualiza();
    }
    private void criarVistaERegistarListeneres(){
        VBox botoes = new VBox(20);
        Button simButton = new Button("Sim");
        Button naoButton = new Button("Não");
        Button sairButton = new Button("Sair");
        botoes.setAlignment(Pos.CENTER);
        //setPadding(new Insets(10));
        setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID,
                null, new BorderWidths(1))));
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        botoes.getChildren().addAll(simButton, naoButton, sairButton);
        setCenter(botoes);
        simButton.setOnAction((e)->{
            jogoObser.decisaomini(1);

        });
        naoButton.setOnAction((e)->{
            jogoObser.decisaomini(2);
        });

        sairButton.setOnAction((e)->System.exit(0));
    }
    private void registarObserv(){
        jogoObser.addPropertyChangeListener("pecas", evt -> {atualiza();});
    }
    private void atualiza(){
        this.setVisible(jogoObser.getSituacao()== AguardaMiniDecisao);
    }
}
