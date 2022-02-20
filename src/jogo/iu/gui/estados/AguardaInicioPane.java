package jogo.iu.gui.estados;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import jogo.logica.JogoObser;
import jogo.logica.estados.AguardaInicio;

import java.io.File;

import static jogo.logica.Situacao.Inicio;

public class AguardaInicioPane extends BorderPane {
    private JogoObser jogoObser;
    public AguardaInicioPane(JogoObser jogoObser){
        this.jogoObser=jogoObser;
        criarVistaERegistarListeneres();
        registarObserv();
        atualiza();
    }

    private void criarVistaERegistarListeneres(){
        VBox botoes = new VBox(20);
        Button iniciarButton = new Button("Iniciar");
        Button carregarButton = new Button("Carregar");
        Button replayButton = new Button("Replay");
        Button sairButton = new Button("Sair");
        botoes.setAlignment(Pos.CENTER);
        //setPadding(new Insets(10));
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        botoes.getChildren().addAll(iniciarButton, carregarButton, replayButton, sairButton);
        setCenter(botoes);
        iniciarButton.setOnAction((e)->jogoObser.comecar(1));
        carregarButton.setOnAction((e)->{
            FileChooser fileChooser = new FileChooser();

            //Set extension filter for text files
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("BIN files (*.bin)", "*.bin");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(null);
            jogoObser.carrega(file);
        });
        replayButton.setOnAction((e)->{
            FileChooser fileChooser = new FileChooser();

            //Set extension filter for text files
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("BIN files (*.bin)", "*.bin");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(null);
            jogoObser.setAux();
            jogoObser.replay(file);
            jogoObser.setModo(4);
            jogoObser.comecar(2);
        });
        sairButton.setOnAction((e)->System.exit(0));
    }

    private void registarObserv(){
        jogoObser.addPropertyChangeListener("pecas", evt -> {atualiza();});
    }

    private void atualiza(){
        this.setVisible(jogoObser.getSituacao()== Inicio);
    }
}
