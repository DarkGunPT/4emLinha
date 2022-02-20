package jogo.iu.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import jogo.logica.JogoObser;
import jogo.logica.Situacao;

import java.io.File;

public class MenuJogoPane extends VBox{
    private JogoObser jogoObser;
    Button pecaButton, especialButton, voltarButton,gravarButton, avancarButton, sairButton;
    StackPane opcoes;
    public MenuJogoPane (JogoObser jogoObser, StackPane opcoes){
        this.jogoObser = jogoObser;
        this.opcoes=opcoes;
        criarVista();
        registarObservador();
        registarListeners();
        atualiza();
    }
    private void criarVista(){
        pecaButton = new Button("Jogar peça");
        especialButton = new Button("Jogar peça especial");
        voltarButton = new Button("Voltar atrás");
        gravarButton = new Button("Gravar");
        avancarButton = new Button("Avancar");
        sairButton = new Button("Sair");

    }
    private void registarObservador(){
        jogoObser.addPropertyChangeListener("pecas", evt -> {atualiza();});
    }
    private void registarListeners(){
        pecaButton.setOnAction((e)-> {
            opcoes.getChildren().get(0).setVisible(true);
            opcoes.getChildren().get(1).setVisible(false);
            opcoes.getChildren().get(2).setVisible(false);
        });
        especialButton.setOnAction((e)->{
            opcoes.getChildren().get(0).setVisible(false);
            opcoes.getChildren().get(1).setVisible(true);
            opcoes.getChildren().get(2).setVisible(false);
        });
        voltarButton.setOnAction((e)->{
            opcoes.getChildren().get(0).setVisible(false);
            opcoes.getChildren().get(1).setVisible(false);
            opcoes.getChildren().get(2).setVisible(true);
        });
        gravarButton.setOnAction((e)->{
            FileChooser fileChooser = new FileChooser();
            //Set extension filter for text files
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("BIN files (*.bin)", "*.bin");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(null);
            jogoObser.guarda(file);
        });
        sairButton.setOnAction((e)->System.exit(0));
    }
    private void atualiza(){
        this.setVisible(jogoObser.getModo() != 4);
    }
}
