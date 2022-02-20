package jogo.iu.gui;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import jogo.logica.JogoObser;
import jogo.logica.Situacao;

public class DadosPane extends HBox {
    private JogoObser jogoObser;
    private Label dadosLabel, jogadoratual, jogada;
    public DadosPane (JogoObser jogoObser){
        this.jogoObser = jogoObser;
        criarVista();
        registarObserv();
        atualiza();
    }
    private void criarVista(){
        VBox dados = new VBox();
        dadosLabel = new Label("Dados do jogador");
        dadosLabel.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.ITALIC, 14));
        dadosLabel.setTextFill(Color.WHITE);
        setPadding(new Insets(50,0,50,0));
        jogadoratual = new Label();
        jogada = new Label();
        setMinWidth(600);
        setAlignment(Pos.TOP_CENTER);
        //setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGREY, null, null)));
        dados.getChildren().addAll(dadosLabel, jogada,jogadoratual);
        getChildren().add(dados);
    }
    private void registarObserv(){
        jogoObser.addPropertyChangeListener("pecas", evt -> {atualiza();});
    }
    private void atualiza(){
        if(jogoObser.getSituacao()== Situacao.Jogar || jogoObser.getSituacao()== Situacao.JogarBot){
            jogada.setText("Jogada: "+ jogoObser.getJogada()+" Jogada A: "+ jogoObser.getJogadaA()+" Jogador B: "+jogoObser.getJogadaB());
            jogada.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.ITALIC, 14));
            jogada.setTextFill(Color.WHITE);
            jogadoratual.setText("É a vez do jogador "+ jogoObser.getNome() +" jogar\nPecas especiais: "+jogoObser.getEspecial(jogoObser.getJogador())+" Creditos: "+jogoObser.getCreditos(jogoObser.getJogador()));
            jogadoratual.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.ITALIC, 14));
            jogadoratual.setTextFill(Color.WHITE);

        }

    }
}
