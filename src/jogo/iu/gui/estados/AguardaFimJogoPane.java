package jogo.iu.gui.estados;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import jogo.logica.JogoObser;
import jogo.logica.estados.AguardaFimJogo;

import java.io.File;

import static jogo.logica.Situacao.FimJogo;


public class AguardaFimJogoPane extends VBox {
    private JogoObser jogoObser;
    Alert alert;
    public AguardaFimJogoPane(JogoObser jogoObser){
        this.jogoObser=jogoObser;
        criarVistaERegistarListeners();
        registarObser();
        atualiza();
    }
    private void registarObser(){
        jogoObser.addPropertyChangeListener("pecas", evt -> {atualiza();});
    }
    private void criarVistaERegistarListeners(){
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
       Button jogarNovamenteButton = new Button("Jogar novamente");
       Button replayButton = new Button("Guardar Replay");
        Button sairButton = new Button("Sair");
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        setAlignment(Pos.CENTER);
        setSpacing(10);
       getChildren().addAll(jogarNovamenteButton, replayButton, sairButton);
       jogarNovamenteButton.setOnAction((e)-> jogoObser.termina());
        replayButton.setOnAction((e)->{
            FileChooser fileChooser = new FileChooser();
            //Set extension filter for text files
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("BIN files (*.bin)", "*.bin");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(null);
            jogoObser.guardareplay(file);
        });
       sairButton.setOnAction((e)->System.exit(0));
    }
    private void atualiza(){
        this.setVisible(jogoObser.getSituacao()== FimJogo);
    }
}
