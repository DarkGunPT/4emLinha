package jogo.iu.gui.estados;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import jogo.logica.JogoObser;

import static jogo.logica.Situacao.EsperaModo;
import static jogo.logica.Situacao.EsperarEscolha;

public class AguardaNomePane extends BorderPane {
    private JogoObser jogoObser;
    VBox botoes;
    Button okButton1, sairButton;
    TextField jtextfield1, jtextfield2;
    public AguardaNomePane(JogoObser jogoObser) {
        this.jogoObser=jogoObser;
        criarVista();
        registarObserv();
        atualiza();
    }
    private void criarVista(){
        botoes = new VBox(30);
        okButton1 = new Button("Ok");
        sairButton = new Button("Sair");
        jtextfield1 = new TextField();
        jtextfield2 = new TextField();
        botoes.setAlignment(Pos.CENTER);
        setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID,
                null, new BorderWidths(1))));
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        setCenter(botoes);
        botoes.getChildren().addAll(jtextfield1, jtextfield2, okButton1, sairButton);

    }
    private void registarObserv(){
        jogoObser.addPropertyChangeListener("pecas", evt -> {atualiza();});
    }

    private void atualiza(){
        okButton1.setOnAction((e)->{
            jogoObser.comecarjogar(jtextfield1.getText(),jtextfield2.getText());
            jogoObser.verificaJogada();
        });
        sairButton.setOnAction((e)->System.exit(0));
        this.setVisible(jogoObser.getSituacao()== EsperarEscolha && jogoObser.getModo()==1);
    }
}
