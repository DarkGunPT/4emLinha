package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Jogo;

public class AguardaVerifica extends EstadoAdpter{
    public AguardaVerifica(Jogo jogo){
        super(jogo);
    }

    @Override
    public iEstado verificaJogada()  {
        jogo.somarJogadas(jogo.getJogador());
        if(jogo.getModo() == 1 || jogo.getModo() == 2 && jogo.getJogador() == 0){
            if(jogo.getJogadaA()>4 || jogo.getJogadaB()>4) {
                if (jogo.getJogadaA() > 4){
                    jogo.setJogadaA();
                }
                else if (jogo.getJogadaB() > 4){
                    jogo.setJogadaB();
                }
                return new AguardaMiniDecisao(jogo);
            }else
                return new AguardaJogar(jogo);
        }
        return new AguardaBot(jogo);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.VerificaJogada;
    }

}
