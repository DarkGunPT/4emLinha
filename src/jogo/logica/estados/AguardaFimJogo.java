package jogo.logica.estados;

import jogo.logica.MaquinaEstados;
import jogo.logica.Situacao;
import jogo.logica.dados.Jogo;



public class AguardaFimJogo extends EstadoAdpter{
    public AguardaFimJogo(Jogo jogo){
        super(jogo);
    }

    @Override
    public iEstado termina()  {
        jogo.iniciaJogo();
        return new AguardaInicio(jogo);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.FimJogo;
    }

}
