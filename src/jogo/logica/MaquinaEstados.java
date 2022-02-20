package jogo.logica;

import jogo.logica.dados.GuardaCarrega;
import jogo.logica.dados.Jogo;
import jogo.logica.estados.AguardaJogar;
import jogo.logica.estados.AguardaInicio;
import jogo.logica.estados.iEstado;
import jogo.logica.memento.CareTaker;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class MaquinaEstados
{
    iEstado atual;
    Jogo jogo;
    private CareTaker careTaker;
    public MaquinaEstados() {
        jogo = new Jogo();
        atual = new AguardaInicio(jogo);
        careTaker = new CareTaker(jogo);
    }
    public Situacao getSituacao(){
        return atual.getSituacao();
    }
    public void comeca(int op) {
        atual = atual.comeca(op);
    }
    public void escolheModo(int op){
        atual = atual.escolheModo(op);
    }
    public void comecarjogar(String textField1, String textField2){
        atual = atual.comecarjogar(textField1, textField2);
    }
    public void irMini(int op){
        atual = atual.irMini(op);
    }
    public void jogar(int jogador, int col){
        careTaker.gravaMemento();
        atual = atual.jogar(jogador, col);
    }
    public void decisao(int decisao){
        atual = atual.decisao(decisao);
    }
    public void jogarautomaticob(int jogador){
        atual=atual.jogarautomaticob(jogador);
    }
    public void acabarReplay(){
        atual = atual.acabarReplay();
    }
    public void verificaJogada(){atual = atual.verificaJogada();}
    public void setAux(){
        jogo.setAux();
    }
    public int getMiniA(){
        return jogo.getMiniA();
    }
    public int getMiniB(){
        return jogo.getMiniB();
    }
    public int getJogadaA(){
        return jogo.getJogadaA();
    }
    public int getJogadaB(){
        return jogo.getJogadaB();
    }
    public int getJogada(){
        return jogo.getJogada();
    }
    public void somarJogadas(int jogador){jogo.somarJogadas(jogador);}
    public void jogarespecial(int jogador, int col){
        careTaker.gravaMemento();
        atual=atual.jogarespecial(jogador,col);
    }
    public void jogarMiniA(int jogador){
        atual=atual.jogarminiA(jogador);
    }
    public void jogarMiniB(String ytextField, String comparacao){atual=atual.miniB(ytextField, comparacao); }
    public void termina(){
        atual = atual.termina();
    }
    public char[][] getTabuleiro() {
        return
                jogo.getTabuleiro();
    }

    public void escolherNome(String nome1, String nome2) {
        jogo.escolherNome(nome1,nome2);
    }
    public int getModo(){
        return jogo.getModo();
    }
    public void setJogadaA(){
        jogo.setJogadaA();
    }
    public void setJogadaB(){
        jogo.setJogadaB();
    }
    public void trocarJogador(int jogador){
        jogo.trocarJogador(jogador);
    }
    public void setJogada(){
        jogo.setJogada();
    }
    public void setJogadaAzero(){
        jogo.setJogadaAzero();
    }
    public void setJogadaBzero(){
        jogo.setJogadaBzero();
    }
    public int getPecaespecial(int n){
        return jogo.getPecaespecial(n);
    }
    public String mostrarNome(int n){
        return jogo.mostrarNome(n);
    }
    public void random(){
        jogo.randomJogador();
    }
    public int verificarColuna(){
        return jogo.verificarColuna();
    }
    public int verificarLinhaR(){
        return jogo.verificarLinhaR();
    }
    public int verificaDiag(){
        return jogo.verificaDiag();
    }
    public int getJogador(){
        return jogo.getJogador();
    }
    public int getCreditos(int n){
        return jogo.getCreditos(n);
    }
    public int getFinal(){return jogo.getFinal();}
    public String perguntaMatematica(int [] jogocalculo){
        return jogo.perguntaMatematica(jogocalculo);
    }
    public void acertarMatematica(String yTextfield4, int [] pergunta){
         jogo.acertarMatematica(yTextfield4, pergunta);
    }
    public int respostaMatematica(){
        return jogo.respostaMatematica();
    }
    public String jogopal(){
        return jogo.jogoPalavras();
    }
    public String getString(){
        return jogo.getString();
    }
    public String getPergunta(){
        return jogo.getJogoPal();
    }
    public int[] jogoMatematica(){
        return jogo.jogoMatematica();
    }
    public void tempoM(){
        jogo.tempoM();
    }
    public int getEmpate(){return jogo.getEmpate();}
    public int getTipofinal(){return jogo.getTipofinal();}
    public int jogarautomatico(){return jogo.jogarautomatico();}
    public int verificaColunaCheia(int col){return jogo.verificaColunaCheia(col);}
    public void redo(){careTaker.redo();}
    public void carrega(File file) {
        Object[] jogoold = GuardaCarrega.carrega(file);
        this.jogo= (Jogo) jogoold[0];
        this.careTaker= (CareTaker) jogoold[1];
        this.atual=new AguardaJogar(jogo);
    }
    public void carregaReplay(File file){
        Object[] jogoold = GuardaCarrega.carregaReplay(file);
        this.jogo= (Jogo) jogoold[0];
        this.careTaker= (CareTaker) jogoold[1];
        careTaker.irPrimeiro();
        this.atual=new AguardaJogar(jogo);
    }
    public void setModo(int modo){
        jogo.setModo(modo);
    }
    public void irPrimeiro(){
        careTaker.irPrimeiro();
    }
    public void guarda(File file){
        GuardaCarrega.guardar(jogo, careTaker, file);
    }
    public void guardarReplay(File file){GuardaCarrega.guardarReplay(jogo, careTaker,file);}
    public void recuarJogadas(int recuar) {
        if(jogo.getJogador()==0){
            jogo.setJogadaA();
        }else{
            jogo.setJogadaB();
        }
        for(int i=0; i<recuar; i++){
            if(jogo.getCreditos(jogo.getJogador())>0){
                jogo.setCreditos(jogo.getJogador());
                careTaker.undo();
            }
        }
        jogo.logs("O jogador "+jogo.getJogador()+" recuou "+ recuar +" jogadas!!");
        if(recuar%2!=0){
            jogo.trocarJogador(jogo.getJogador());
        }
    }
    public int verificarPasta(String nomef){
        return jogo.verificarPasta(nomef);
    }
    public void fazerLog(String log){
        jogo.logs(log);
    }
    public String mostrarLog(){
        return jogo.mostraLog();
    }
    public void mostrarPastaSaves(){
        jogo.mostrarPastaSaves();
    }
    public void mostrarPastaReplays(){
        jogo.mostrarPastaReplays();
    }
    public int verificarPastaReplay(String nomef){
        return jogo.verificarPastaReplay(nomef);
    }
    public void setAcabar(){
        jogo.setAcabar();
    }
    public int getAcabar(){
        return jogo.getAcabar();
    }
}
