package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Jogo;

public class AguardaInicio extends EstadoAdpter{

    public AguardaInicio(Jogo jogo){
        super(jogo);
    }

    @Override
    public iEstado comeca(int op)  {
        if(op==2){
            return new AguardaJogar(jogo);
        }
        return new AguardaModo(jogo);
    }
    @Override
    public Situacao getSituacao() {
        return Situacao.Inicio;
    }
}
