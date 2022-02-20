package jogo.logica;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;

public class JogoObser {
    private MaquinaEstados jogoMaqEstados;
    private final PropertyChangeSupport propertyChangeSupport;

    public JogoObser(MaquinaEstados jogoMaqEstados) {
        this.jogoMaqEstados = jogoMaqEstados;
        propertyChangeSupport = new PropertyChangeSupport(jogoMaqEstados);
    }

    // o argumento recebido por listener vai passar a fazer parte da colecao de observadores
    // geridos pelo objeto propertyCangeSupport, desta classe,
    // IDENTIFICADOS com propertyName,

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }
    public void comecar(int op){
        jogoMaqEstados.comeca(op);
        propertyChangeSupport.firePropertyChange("pecas", null, null);
    }
    public void termina(){
        jogoMaqEstados.termina();
        propertyChangeSupport.firePropertyChange("pecas", null, null);
    }
    public void comecarjogar(String jogador1, String jogador2){
        jogoMaqEstados.comecarjogar(jogador1, jogador2);
        propertyChangeSupport.firePropertyChange("pecas", null,null);
    }
    public void escolherModo(int op){
        jogoMaqEstados.escolheModo(op);
        propertyChangeSupport.firePropertyChange("pecas", null,null);
    }
    public void jogar(int jogador, int col){
        jogoMaqEstados.jogar(jogador, col);
        propertyChangeSupport.firePropertyChange("pecas", null,null);
    }
    public void jogarMiniA(){
        jogoMaqEstados.jogarMiniA(jogoMaqEstados.getJogador());
        propertyChangeSupport.firePropertyChange("pecas", null,null);
    }
    public void decisaomini(int decisao){
        jogoMaqEstados.decisao(decisao);
        propertyChangeSupport.firePropertyChange("pecas", null,null);
    }
    public void verificaJogada(){
        jogoMaqEstados.verificaJogada();
        propertyChangeSupport.firePropertyChange("pecas", null,null);
    }
    public void setAux(){
        jogoMaqEstados.setAux();
    }
    public void jogarespecial(int jogador, int col){
        jogoMaqEstados.jogarespecial(jogador, col);
        propertyChangeSupport.firePropertyChange("pecas", null,null);
    }
    public void jogarautomatico(){
        jogoMaqEstados.jogarautomaticob(jogoMaqEstados.getJogador());
        propertyChangeSupport.firePropertyChange("pecas", null, null);
    }
    public void recuarJogadas(int recuar){
        jogoMaqEstados.recuarJogadas(recuar);
        propertyChangeSupport.firePropertyChange("pecas", null,null);
    }
    public void guarda(File file){
        jogoMaqEstados.guarda(file);
    }
    public void carrega(File file){
        jogoMaqEstados.carrega(file);
        propertyChangeSupport.firePropertyChange("pecas", null,null);
    }
    public void guardareplay(File file){
        jogoMaqEstados.guardarReplay(file);
        propertyChangeSupport.firePropertyChange("pecas", null,null);
    }
    public void replay(File file){
        jogoMaqEstados.carregaReplay(file);
        propertyChangeSupport.firePropertyChange("pecas", null,null);
    }
    public void redo(){
        jogoMaqEstados.redo();
        propertyChangeSupport.firePropertyChange("pecas", null,null);
    }
    public char[][] getTab(){
        return jogoMaqEstados.getTabuleiro();
    }
    public Situacao getSituacao(){
        return jogoMaqEstados.getSituacao();
    }
    public int getModo(){return jogoMaqEstados.getModo();}
    public int getJogador(){return jogoMaqEstados.getJogador();}
    public String getNome(){return jogoMaqEstados.mostrarNome(jogoMaqEstados.getJogador());}
    public int getJogada(){return jogoMaqEstados.getJogada();}
    public int getCreditos(int jogador){return jogoMaqEstados.getCreditos(jogador);}
    public int getEspecial(int jogador){return jogoMaqEstados.getPecaespecial(jogador);}
    public int getJogadaA(){return jogoMaqEstados.getJogadaA();}
    public int getJogadaB(){return jogoMaqEstados.getJogadaB();}
    public void setModo(int modo){jogoMaqEstados.setModo(modo);}
    public int getFinal(){return jogoMaqEstados.getFinal();}
    public int getEmpate(){return jogoMaqEstados.getEmpate();}
    public void acabarReplay(){ jogoMaqEstados.acabarReplay();
        propertyChangeSupport.firePropertyChange("pecas", null,null);
    }
    public String perguntaMatematica(int [] jogocalculo){
        return jogoMaqEstados.perguntaMatematica(jogocalculo);
    }
    public void acertarMatematica(String yTextfield4, int [] pergunta){
        jogoMaqEstados.acertarMatematica(yTextfield4, pergunta);
        propertyChangeSupport.firePropertyChange("pecas", null,null);
    }
    public int[] jogoMatematica(){
        return jogoMaqEstados.jogoMatematica();
    }
    public void jogoPalavras(String ytextField, String comparacao){ jogoMaqEstados.jogarMiniB(ytextField, comparacao);
        propertyChangeSupport.firePropertyChange("pecas", null,null);}

    public String getString(){
        return jogoMaqEstados.getString();
    }
    public String getPergunta(){
        return jogoMaqEstados.getPergunta();
    }
}
