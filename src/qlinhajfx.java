import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jogo.iu.gui.LRoot;
import jogo.logica.JogoObser;
import jogo.logica.MaquinaEstados;

public class qlinhajfx extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MaquinaEstados jogoMaqEstados = new MaquinaEstados();
        JogoObser observableModel = new JogoObser(jogoMaqEstados);
        LRoot lRoot = new LRoot(observableModel);
        Scene scene = new Scene(lRoot,600, 800);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("\"4 em Linha\"");
        stage.setOnCloseRequest(windowEvent -> Platform.exit());
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
