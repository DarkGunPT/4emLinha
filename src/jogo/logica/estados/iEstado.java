package jogo.logica.estados;

import jogo.logica.Situacao;

public interface iEstado {

    Situacao getSituacao();
    iEstado comeca(int op);
    iEstado comecarjogar(String textfield1, String textfield2);
    iEstado jogarespecial(int jogador, int col);
    iEstado jogar(int jogador, int col);
    iEstado termina();
    iEstado jogarminiA(int jogador);
    iEstado irMini(int op);
    iEstado acabarReplay();
    iEstado escolheModo(int op);
    iEstado decisao(int resposta);
    iEstado miniB(String yTextfield3, String comparacao);
    iEstado jogarautomaticob(int jogador);
    iEstado verificaJogada();
}
