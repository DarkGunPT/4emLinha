package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Jogo;

public class AguardarMiniJogoA extends EstadoAdpter{

    public AguardarMiniJogoA(Jogo jogo) {
        super(jogo);
    }
    @Override
    public iEstado jogarminiA(int jogador){

        if(jogo.getComecou()==0){
            jogo.setComecou(1);
            jogo.tempoM();
            jogo.setCerto();
        }
        if(!jogo.tempoMat()){
            System.out.println("\nPerdeu especial!!");
            if(jogo.getJogador()==0) {
                jogo.setMiniA(1);
            }else{
                jogo.setMiniB(1);
            }
            jogo.setComecou(0);
            jogo.setCerto();
            jogo.trocarJogador(jogo.getJogador());
            return new AguardaJogar(jogo);
        }
        else if(jogo.getCerto()>=5 && jogo.tempoMat()){
            System.out.println("\nGanhou especial!!");
            jogo.setPecaespecial(jogador);
            jogo.setComecou(0);
            jogo.setCerto();
            if(jogo.getJogador()==0) {
                jogo.setMiniA(1);
            }else{
                jogo.setMiniB(1);
            }
            return new AguardaJogar(jogo);
        }
        return this;
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.AguardarMiniJogoA;
    }
}
