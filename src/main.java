import jogo.iu.texto.textoUI;
import jogo.logica.MaquinaEstados;
import jogo.logica.dados.Jogo;

import java.io.IOException;

public class main {
    public static void main(String[] args){
        MaquinaEstados ME = new MaquinaEstados();
        textoUI textoUI = new textoUI(ME);
        textoUI.comeca();
    }
}
