package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Jogo;
import jogo.utils.UtilUi;

import java.util.Scanner;

public class AguardarEscolha extends EstadoAdpter {
    public AguardarEscolha(Jogo jogo) {
        super(jogo);
    }

    @Override
    public iEstado comecarjogar(String textfield1, String textfield2){
        String nome;
        String nome2;
            if(textfield2.equals(textfield1)){
                return this;
            }else{
                nome=textfield1;
                nome2=textfield2;
            }
        jogo.escolherNome(nome, nome2);
        return new AguardaVerifica(jogo);
    }

    @Override
    public Situacao getSituacao() {
        return Situacao.EsperarEscolha;
    }
}

