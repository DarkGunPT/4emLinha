package jogo.iu.gui;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import jogo.iu.gui.estados.*;
import jogo.logica.JogoObser;

public class PrincipalPane extends BorderPane {
    private JogoObser jogoObser;
    public PrincipalPane(JogoObser jogoObser) {
        this.jogoObser = jogoObser;
        criarVista();

    }
    private void criarVista(){

        // TOP DADOS
        DadosPane dadosPane = new DadosPane(jogoObser);
        HBox topBox = new HBox(50);
        topBox.setPadding(new Insets(0,0,0,0));
        topBox.getChildren().add(dadosPane);
        setTop(topBox);

        // ESQUERDA
        TabuleiroPane tabuleiroPane = new TabuleiroPane(jogoObser);
        HBox colunasPane = new ColunasPane(jogoObser);
        HBox recuarPane = new RecuarPane(jogoObser);
        HBox colunaEspPane = new ColunasEspPane(jogoObser);
        VBox minijogoA = new MiniJogoAPane(jogoObser);
        VBox minijogoB = new MiniJogoBPane(jogoObser);
        StackPane opcoes = new StackPane(colunasPane, colunaEspPane, recuarPane, minijogoA, minijogoB);
        VBox leftBox = new VBox(50);
        leftBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                null, new BorderWidths(1))));
        leftBox.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        leftBox.getChildren().addAll(tabuleiroPane, opcoes);
        leftBox.setPadding(new Insets(10));
        //ESTADOS
        AguardaInicioPane aguardaInicioPane = new AguardaInicioPane(jogoObser);
        AguardaModoPane aguardaModoPane = new AguardaModoPane(jogoObser);
        AguardaNomePane aguardaNomePane = new AguardaNomePane(jogoObser);
        AguardaNomePane2 aguardaNomePane2 = new AguardaNomePane2(jogoObser);
        AguardaNomePane3 aguardaNomePane3 = new AguardaNomePane3(jogoObser);
        AguardaDecisaoPane aguardaDecisaoPane = new AguardaDecisaoPane(jogoObser);
        AguardaJogarPane aguardaJogarPane = new AguardaJogarPane(jogoObser, opcoes);
        AguardaMiniPane aguardaMiniPane = new AguardaMiniPane(jogoObser, opcoes);
        AguardaReplayPane aguardaReplayPane = new AguardaReplayPane(jogoObser);
        AguardaBotPane aguardaBotPane = new AguardaBotPane(jogoObser, recuarPane);
        AguardaFimJogoPane aguardaFimJogoPane = new AguardaFimJogoPane(jogoObser);
        // DIREITA
        StackPane rightBox = new StackPane(aguardaInicioPane, aguardaModoPane,aguardaNomePane,aguardaNomePane2,aguardaNomePane3,aguardaDecisaoPane,aguardaJogarPane, aguardaMiniPane,aguardaBotPane, aguardaFimJogoPane, aguardaReplayPane);
        rightBox.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID,
                null, new BorderWidths(1))));
        rightBox.setPadding(new Insets(20));
        rightBox.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));

        // BOX CENTRAL ENVOLVENTE CONTENDO A ESQUERDA E A DIREITA
        HBox center = new HBox(10);
        center.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID,
                null, new BorderWidths(2))));
        center.setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGREY, null, null)));
        center.setAlignment(Pos.CENTER);
        center.getChildren().addAll(leftBox, rightBox);
        setCenter(center);

    }
}
