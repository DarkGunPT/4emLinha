package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Jogo;

    public class AguardaMiniDecisao extends EstadoAdpter{

        public AguardaMiniDecisao(Jogo jogo){
            super(jogo);
        }
        @Override
        public iEstado decisao(int resposta){

            if(resposta==1){
                if(jogo.getMiniA()==0 && jogo.getJogador()==0 || jogo.getMiniA()==0 && jogo.getJogador()==1){
                    return new AguardarMiniJogoA(jogo);
                }else if(jogo.getMiniA()==1 && jogo.getJogador()==0 || jogo.getMiniB()==1 && jogo.getJogador()==1){
                    return new AguardaMinijogoB(jogo);
                }
            }else{
                System.out.println(jogo.getJogador());
                if(jogo.getJogador()==0)
                    jogo.setJogadaA();
                else
                    jogo.setJogadaB();
            }
            return new AguardaJogar(jogo);
        }

        @Override
        public Situacao getSituacao() {
            return Situacao.AguardaMiniDecisao;
        }
    }




