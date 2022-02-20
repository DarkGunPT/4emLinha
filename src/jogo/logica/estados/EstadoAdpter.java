package jogo.logica.estados;

import jogo.logica.dados.Jogo;

public abstract class EstadoAdpter implements iEstado{

    protected Jogo jogo;

    protected EstadoAdpter(Jogo jogo) {
        this.jogo = jogo;
    }

    @Override
    public iEstado comeca(int op) {
        return this;
    }

    @Override public iEstado escolheModo(int op){return this;}
    @Override
    public iEstado termina() {
        return this;
    }
    @Override public iEstado comecarjogar(String textfield1, String textfield2){return this;}
    @Override public iEstado jogar(int jogador, int col){
        return this;
    }
    @Override public iEstado jogarespecial(int jogador, int col){
        return this;
    }
    @Override public iEstado jogarminiA(int jogador){ return this;}
    @Override public iEstado irMini(int op){return this;}
    @Override public iEstado acabarReplay(){return this;}
    @Override public iEstado decisao(int resposta){return this;}
    @Override public iEstado miniB(String yTexField3, String comparacao){return this;}
    @Override public iEstado jogarautomaticob(int jogador){return this;}
    @Override public iEstado verificaJogada(){return this;}
}
