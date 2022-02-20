package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Jogo;

public class AguardaJogar extends EstadoAdpter{
    public AguardaJogar(Jogo jogo) {
        super(jogo);
    }

    @Override
    public iEstado jogar(int jogador, int col){
        int jogadaf=jogo.jogarpeca(jogador, col);
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
    public iEstado jogarespecial(int jogador, int col){
            int jogadaf=jogo.pecaespecial(col-1);
            if(jogadaf==1){
                jogo.setmenosPecaespecial(jogador);
                jogo.trocarJogador(jogador);
                jogo.somarJogadas(jogador);
                return new AguardaVerifica(jogo);
            }
            return this;
    }
    @Override
    public iEstado acabarReplay(){
        if(jogo.finalJogo()==1 || jogo.empateJogo()==1) {
            return new AguardaFimJogo(jogo);
        }
        return this;
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.Jogar;
    }

}
