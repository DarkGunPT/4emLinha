package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Jogo;

public class AguardaBot extends EstadoAdpter{
    public AguardaBot(Jogo jogo) {
        super(jogo);
    }

    @Override
    public iEstado jogarautomaticob(int jogador){
        int col=jogo.jogarautomatico();
        int jogadaf=jogo.jogarpeca(jogador,col);
        if(jogadaf==0){
            return this;
        }
        jogo.trocarJogador(jogador);
        if(jogo.finalJogo()==1 || jogo.empateJogo()==1){
            if(jogo.finalJogo()==1){
                jogo.setTipofinal(0);
            } else{
                jogo.setTipofinal(1);
            }
            jogo.setJogadaA();
            jogo.setJogadaB();
            jogo.setJogadaf(0);
            return new AguardaFimJogo(jogo);
        }
        return new AguardaVerifica(jogo);
    }
    @Override
    public Situacao getSituacao() {
        return Situacao.JogarBot;
    }
}
