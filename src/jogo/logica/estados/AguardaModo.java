package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Jogo;

import java.util.Scanner;

public class AguardaModo extends EstadoAdpter{

    public AguardaModo(Jogo jogo) {
        super(jogo);
    }
    @Override
    public iEstado escolheModo(int op){
        jogo.randomJogador();
        jogo.iniciaJogo();
        jogo.setModo(op);
        return new AguardarEscolha(jogo);
    }
    @Override
    public Situacao getSituacao() {
        return Situacao.EsperaModo;
    }
}
