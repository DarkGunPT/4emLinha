package jogo.iu.gui.estados;


import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import jogo.logica.JogoObser;
import jogo.logica.Situacao;

import java.io.File;
import java.io.PrintWriter;

import static jogo.logica.Situacao.EsperarEscolha;
import static jogo.logica.Situacao.Jogar;

public class AguardaJogarPane extends VBox {
    private JogoObser jogoObser;
    StackPane opcoes;
    Button pecaButton, especialButton, voltarButton,gravarButton, sairButton;
    public AguardaJogarPane(JogoObser jogoObser, StackPane opcoes){
        this.jogoObser = jogoObser;
        this.opcoes=opcoes;
        criavista();
        registarObserv();
        atualiza();
    }
    private void criavista(){
        setSpacing(20);
        pecaButton = new Button("Jogar peça");
        especialButton = new Button("Jogar peça especial");
        voltarButton = new Button("Voltar atrás");
        gravarButton = new Button("Gravar");
        sairButton = new Button("Sair");
        setAlignment(Pos.CENTER);
        pecaButton.setOnAction((e)-> {
            opcoes.getChildren().get(0).setVisible(true);
            opcoes.getChildren().get(1).setVisible(false);
            opcoes.getChildren().get(2).setVisible(false);
            opcoes.getChildren().get(3).setVisible(false);
        });
        especialButton.setOnAction((e)->{
            opcoes.getChildren().get(0).setVisible(false);
            opcoes.getChildren().get(1).setVisible(true);
            opcoes.getChildren().get(2).setVisible(false);
            opcoes.getChildren().get(3).setVisible(false);
        });
        voltarButton.setOnAction((e)->{
            opcoes.getChildren().get(0).setVisible(false);
            opcoes.getChildren().get(1).setVisible(false);
            opcoes.getChildren().get(2).setVisible(true);
            opcoes.getChildren().get(3).setVisible(false);
        });
            gravarButton.setOnAction((e)->{
                FileChooser fileChooser = new FileChooser();
                //Set extension filter for text files
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("BIN files (*.bin)", "*.bin");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(null);
                jogoObser.guarda(file);
            });
            setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
            sairButton.setOnAction((e)->System.exit(0));
        getChildren().addAll(pecaButton, especialButton, voltarButton, gravarButton,sairButton);

    }
    private void registarObserv(){
        jogoObser.addPropertyChangeListener("pecas", evt -> {atualiza();});
    }

    private void atualiza(){
        this.setVisible(jogoObser.getSituacao()== Jogar && jogoObser.getModo()!=4);
    }
}