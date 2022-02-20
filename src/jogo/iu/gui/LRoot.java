package jogo.iu.gui;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import jogo.logica.JogoObser;

public class LRoot extends BorderPane {
    private JogoObser jogoObser;
    private PrincipalPane principalPane;
    public LRoot(JogoObser jogoObser) {
        this.jogoObser = jogoObser;
        criarVistaCentral();
    }
    private void criarVistaCentral(){
        principalPane = new PrincipalPane(jogoObser);
        setCenter(principalPane);
    }
}
