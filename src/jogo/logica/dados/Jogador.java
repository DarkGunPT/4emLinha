package jogo.logica.dados;

import java.io.Serializable;
import java.util.Scanner;

public class Jogador implements Serializable {
    int n=0;
    String nome;
    int creditos, pecaespecial;
    public Jogador(String nome){
        n=n+1;
        creditos=5;
        pecaespecial=1;
        this.nome=nome;
    }

    public void setPecaespecial() {
        this.pecaespecial = pecaespecial+1;
    }
    public void setmenosPecaespecial() {
        this.pecaespecial = pecaespecial-1;
    }
    public int getPecaespecial() {
        return this.pecaespecial;
    }
    public String getNome() {
        return nome;
    }
    public int getCreditos(){
        return creditos;
    }
    public void setCreditos(){
        this.creditos = creditos-1;
    }
    @Override
    public String toString() {
        return "Jogador{" + " nome='" + nome + '\'' +
                ", creditos=" + creditos +
                '}';
    }
}
