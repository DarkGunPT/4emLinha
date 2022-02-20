package jogo.iu.gui;

import com.sun.javafx.geom.Rectangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import jogo.iu.gui.resources.images.ImageLoader;
import jogo.logica.JogoObser;

import java.util.List;

import static jogo.logica.Situacao.EsperarEscolha;

public class TabuleiroPane extends GridPane {
    private JogoObser jogoObser;
    public TabuleiroPane(JogoObser jogoObser){
        this.jogoObser=jogoObser;
        criarVista();
        registarObservador();
        atualiza();
    }


    private void criarVista(){
        //tabuleiroLabel =new Label("Tabuleiro de Jogo");
        //tabuleiroLabel.setFont(Font.font("verdana",FontWeight.NORMAL, FontPosture.ITALIC, 14));
        setPadding(new Insets(25));
        setBorder(new Border(new BorderStroke(Color.PURPLE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        this.setAlignment(Pos.CENTER);
        this.setHgap(20);
        this.setVgap(20);
    }
    private void registarObservador(){
        jogoObser.addPropertyChangeListener("pecas", evt -> {atualiza();});
    }

    private void atualiza(){
        char[][] tab = jogoObser.getTab();
        this.getChildren().clear();
        Circle circle;
        if(tab==null){
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    circle = new Circle(16, Color.WHITE);
                    add(circle, j, i);
                }}
        }else{
            System.out.print("[ ");
            for (int a = 1; a <= 7; a++) {
                System.out.print("[" + a + "]");
            }
            System.out.println(" ]");
            for (int i = 0; i < 6; i++) {
                System.out.print("[ ");
                for (int j = 0; j < 7; j++) {
                    System.out.print("|" + tab[i][j] + "|");
                }
                System.out.print(" ]");
                System.out.print("\n");
            }
            System.out.print("\n");
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {

                    circle = new Circle(16);
                    if(tab[i][j]=='R'){
                       circle.setFill(Color.RED);
                    }else if(tab[i][j]=='Y'){
                        circle.setFill(Color.YELLOW);
                    }else{
                        circle.setFill(Color.WHITE);
                    }
                    add(circle, j, i);
                }
            }
        }

    }
}

