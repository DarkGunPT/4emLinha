package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Jogo;
import jogo.utils.UtilUi;

public class AguardaMinijogoB extends EstadoAdpter{
    public AguardaMinijogoB(Jogo jogo){
        super(jogo);
    }
    @Override
    public iEstado miniB(String yTextfield3, String palavras){
        jogo.tempoP(palavras);
        if(jogo.getComecouP()==0){
            jogo.setComecouP(1);
            jogo.tempoP(jogo.getJogoPal());
        }
        if(!jogo.tempoPal() || !yTextfield3.equals(palavras)){
            if(jogo.getJogador()==0) {
                jogo.setMiniA(1);
            }else{
                jogo.setMiniB(1);
            }
            jogo.setComecouP(0);
            jogo.trocarJogador(jogo.getJogador());
            return new AguardaJogar(jogo);
        }
        else if(jogo.tempoPal()){
            jogo.setPecaespecial(jogo.getJogador());
            jogo.setComecouP(0);
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
        return Situacao.AguardaMiniJogoB;
    }
}
