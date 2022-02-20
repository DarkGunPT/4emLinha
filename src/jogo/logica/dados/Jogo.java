package jogo.logica.dados;
import jogo.logica.memento.IMementoOriginator;
import jogo.logica.memento.Memento;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jogo implements Serializable, IMementoOriginator {
    private char[][] tabuleiro;
    ArrayList<String> historico;
    ArrayList<Jogador> jogadors;
    int larg = 7, alt = 6;
    static int miniA=0, miniB=0, modo=0, jogador, tipofinal, jogada=0, jogadaB=0, jogadaA=0, acabar=0;
    static int aux;
    static int finaljogo, empatejogo, perdeminijogo, certo, comecou, comecouP;
    static long finaltemp, tempoP;
    String jogoPalavrasS;
    public Jogo() {

    }
    public void iniciaJogo() {
        jogadors = new ArrayList<>();
        historico = new ArrayList<>();
        tabuleiro = new char[alt][larg];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }
public void setAux(){
        aux=1;
}
public void setAcabar(){
        acabar=1;
}
public int getAcabar(){
        return acabar;
}
    public void setTipofinal(int tipof){
        if(tipof==0){
            tipofinal=0;
        }else{
            tipofinal=1;
        }
    }
    public int getTipofinal(){
        return tipofinal;
    }
    public void adicionarJogador(String nome) {
        jogadors.add(new Jogador(nome));
    }
    public Jogador dados(int n) {
        return jogadors.get(n);
    }
    public void trocarJogador(int jogadr){
        if(jogadr==0){
            jogador=1;
        }else{
            jogador=0;
        }
    }
    public int getJogador(){
        return jogador;
    }
    public void setJogada(){
        jogada=1;
    }
    public void setJogadaf(int a){jogada=a;
    }
    public void setJogadaAzero(){
        jogadaA=0;
    }
    public void setJogadaBzero(){
        jogadaB=0;
    }
    public String mostrarNome(int n) {
        return jogadors.get(n).getNome();
    }
    public void setPecaespecial(int n) {
        jogadors.get(n).setPecaespecial();
    }
    public void setmenosPecaespecial(int n) {
        jogadors.get(n).setmenosPecaespecial();
    }
    public int getCreditos(int n){
        return jogadors.get(n).getCreditos();
    }
    public void setCreditos(int n){
        jogadors.get(n).setCreditos();
    }
    public int getPecaespecial(int n) {
        return jogadors.get(n).getPecaespecial();
    }
    public char[][] getTabuleiro() {
        return tabuleiro;
    }
    public void randomJogador() {
        Random random = new Random();
        jogador = random.nextInt(2);
    }
    public int jogarpeca(int jogador, int col) {
        for(int i=5; i>=0; i--){
            if (tabuleiro[i][col - 1] == '-' && verificaColunaCheia(col)==0) {
                if (jogador == 0) {
                    tabuleiro[i][col - 1] = 'R';
                } else if (jogador == 1) {
                    tabuleiro[i][col - 1] = 'Y';
                }
                return 1;

            } else if (verificaColunaCheia(col)!=0) {
                return 0;
            }
        }
        return 1;
    }
    public int verificarColuna() {
        for (int i = 0; i < larg; i++) {
            int cont = 0;
            for (int j = 0; j < alt; j++) {
                if (tabuleiro[j][i] == 'R') {
                    cont++;
                } else {
                    cont = 0;
                }
                if (cont == 4) {
                    return 1;
                }
            }
        }
        for (int i = 0; i < larg; i++) {
            int cont = 0;
            for (int j = 0; j < alt; j++) {
                if (tabuleiro[j][i] == 'Y') {
                    cont++;
                } else {
                    cont = 0;
                }
                if (cont == 4) {
                    return 1;
                }
            }
        }
        return 0;
    }
    public int verificarLinhaR() {
        for (int i = 0; i < alt; i++) {
            int cont = 0;
            for (int j = 0; j < larg; j++) {
                if (tabuleiro[i][j] == 'R') {
                    cont++;
                } else {
                    cont = 0;
                }
                if (cont == 4) {
                    return 1;
                }
            }
        }
        for (int i = 0; i < alt; i++) {
            int cont = 0;
            for (int j = 0; j < larg; j++) {
                if (tabuleiro[i][j] == 'Y') {
                    cont++;
                } else {
                    cont = 0;
                }
                if (cont == 4) {
                    return 1;
                }
            }
        }
        return 0;
    }
    public void escolherNome(String nome1, String nome2) {
        adicionarJogador(nome1);
        adicionarJogador(nome2);
    }
    public int getModo(){
        return modo;
    }


    public int pecaespecial(int col) {
        int jogadaf=0;
        if(getPecaespecial(getJogador())!=0){
            for (int i = 0; i < 6; i++) {
                tabuleiro[i][col] = '-';
            }
            jogadaf=1;
        }
        return jogadaf;
    }
    // REALIZAR A PERGUNTA MATEMATICA
    public int[] jogoMatematica() {
        Random random = new Random();
        int[] jogocalculo = new int[4];
        jogocalculo[1] = random.nextInt(4) + 1;
        jogocalculo[0] = random.nextInt(25) + 1;
        jogocalculo[2] = random.nextInt(25) + 1;
        if (jogocalculo[1] == 1) {
            jogocalculo[3] = jogocalculo[0] + jogocalculo[2];
        } else if (jogocalculo[1] == 2) {
            jogocalculo[3] = jogocalculo[0] - jogocalculo[2];
        } else if (jogocalculo[1] == 3) {
            jogocalculo[3] = jogocalculo[0] / jogocalculo[2];
        } else {
            jogocalculo[3] = jogocalculo[0] * jogocalculo[2];
        }
        return jogocalculo;
    }
    // APRESENTAR A PERGUNTA MATEMATICA
    public String perguntaMatematica(int [] jogocalculo){
        StringBuilder pergunta = new StringBuilder();
        if (jogocalculo[1] == 1) {
            pergunta.append(jogocalculo[0]).append('+').append(jogocalculo[2]);
        } else if (jogocalculo[1] == 2) {
            pergunta.append(jogocalculo[0]).append('-').append(jogocalculo[2]);
        } else if (jogocalculo[1] == 3) {
            pergunta.append(jogocalculo[0]).append('/').append(jogocalculo[2]);
        } else {
            pergunta.append(jogocalculo[0]).append('*').append(jogocalculo[2]);
        }
        return pergunta.toString();
    }
    // RESULTADO PARA COMPARAÇÃO
    public int respostaMatematica(){
        int[] jogoresultado;
        jogoresultado = jogoMatematica();
        return jogoresultado[3];
    }
    // SOMAR ACERTOU PARA GANHAR PEÇA
    public void acertarMatematica(String yTextfield4, int [] pergunta){
        int resposta = Integer.parseInt(yTextfield4);
        if (resposta == pergunta[3]){
                certo++;
        }
    }
    public void setComecou(int n){
        comecou=n;
    }
    public int getComecou(){
        return comecou;
    }
    public void setComecouP(int n){comecouP=n;}
    public int getComecouP(){
        return comecouP;
    }
    public int getCerto(){
        return certo;
    }
    public void setCerto(){
        certo=0;
    }
    // Inicializa tempo
    public void tempoM(){
        finaltemp=System.currentTimeMillis()+30000;
    }
    /// Tempo Matemática
    public boolean tempoMat(){
        return System.currentTimeMillis()<finaltemp;
    }
    public int finalJogo() {
        if (verificarColuna() == 1 || verificarLinhaR() == 1 || verificaDiag() == 1) {
            finaljogo=1;
            return 1;
        } else {
            return 0;
        }
    }
    //Realizar a pergunta palavras
    public String jogoPalavras() {
        String[] palavras = new String[100];
        StringBuilder jogoPalavras = new StringBuilder();
        try {
            // open file to read
            Scanner scanner = new Scanner(new File("palavras.txt"));

            // read until end of file (EOF)
            while (scanner.hasNextLine()) {
                for (int i = 0; i < 100; i++)
                    palavras[i] = scanner.nextLine();
            }
            // close the scanner
            scanner.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Random rd = new Random();
        int a = rd.nextInt(99) + 1;
        jogoPalavras.append(palavras[a]);
        for (int f = 1; f < 5; f++) {
            int b = rd.nextInt(99) + 1;
            jogoPalavras.append(" ").append(palavras[b]);
        }
        return jogoPalavras.toString();
    }
    //Get jogo pal
    public String getString(){
        jogoPalavrasS=jogoPalavras();
        return jogoPalavrasS;
    }
    public String getJogoPal(){
        return jogoPalavrasS;
    }
    //inicializa tempo
    public void tempoP(String jogoPalavras){
        tempoP=System.currentTimeMillis()+((jogoPalavras.length()/2)* 1000);
    }
    //Tempo palavras
    public boolean tempoPal(){
        return System.currentTimeMillis()<tempoP;
    }
    public int empateJogo(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (tabuleiro[i][j]=='-'){
                    return 0;
                }
            }
        }
        empatejogo=1;
        return 1;
    }
    public int getFinal(){
        return finaljogo;
    }
    public int getEmpate(){
        return empatejogo;
    }
    public int verificaDiag() {
        for (int i = 3; i < alt; i++) {
            for (int j = 0; j < larg - 3; j++) {
                if (tabuleiro[i][j] == 'R' && tabuleiro[i - 1][j + 1] == 'R'
                        && tabuleiro[i - 2][j + 2] == 'R' && tabuleiro[i - 3][j + 3] == 'R')
                    return 1;
            }
        }

        for (int i = 3; i < alt; i++) {
            for (int j = 3; j < larg; j++) {
                if (tabuleiro[i][j] == 'R' && tabuleiro[i - 1][j - 1] == 'R'
                        && tabuleiro[i - 2][j - 2] == 'R' && tabuleiro[i - 3][j - 3] == 'R')
                    return 1;
            }

        }
        for (int i = 3; i < alt; i++) {
            for (int j = 0; j < larg - 3; j++) {
                if (tabuleiro[i][j] == 'Y' && tabuleiro[i - 1][j + 1] == 'Y'
                        && tabuleiro[i - 2][j + 2] == 'Y' && tabuleiro[i - 3][j + 3] == 'Y')
                    return 1;
            }
        }

        for (int i = 3; i < alt; i++) {
            for (int j = 3; j < larg; j++) {
                if (tabuleiro[i][j] == 'Y' && tabuleiro[i - 1][j - 1] == 'Y'
                        && tabuleiro[i - 2][j - 2] == 'Y' && tabuleiro[i - 3][j - 3] == 'Y')
                    return 1;
            }

        }
        return 0;
    }

    public int verificaColunaCheia(int col) {
        int peca = 0;
        for (int j = 0; j < alt; j++) {
            if (tabuleiro[j][col - 1] != '-')
                peca++;
        }
        if (peca == alt) {
            return 1;
        }
        return 0;
    }
    public void setModo(int op){
        modo=op;
    }
    public int jogarautomatico(){
        int col;
        Random random = new Random();
        col = random.nextInt(7) + 1;
        return col;
    }
    public void somarJogadas(int jogador){
        if (jogador == 0) {
            jogadaA++;
        } else if(jogador==1){
            jogadaB++;
        }
        jogada++;
    }
    public int getJogadaA(){
        return jogadaA;
    }
    public int getJogadaB(){
        return jogadaB;
    }
    public int getJogada(){
        return jogada;
    }
    public int getMiniA(){
        return miniA;
    }
    public int getMiniB(){
        return miniB;
    }
    public void setMiniA(int minij){
        miniA=minij;
    }
    public void setMiniB(int minij){
        miniB=minij;
    }
    public void setJogadaA(){
        jogadaA=0;
    }
    public void setJogadaB(){
        jogadaB=0;
    }
    @Override
    public Memento getMemento() throws IOException {
        Memento m = new Memento(this);
        return m;
    }
    @Override
    public void setMemento(Memento m) throws IOException, ClassNotFoundException {
        Jogo jogo = (Jogo) m.getSnapshot();
        tabuleiro = jogo.tabuleiro;
        if(aux==1){
            jogador = jogo.jogador;
            jogada = jogo.jogada;
            jogadaA = jogo.jogadaA;
            jogadaB = jogo.jogadaB;
        }
    }
    public int verificarPasta(String nomef){
        File folder = new File("saves");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
                if(listOfFiles[i].getName().equals(nomef)){
                    return 1;
            }
        }
        return 0;
    }
    public void logs(String log){
        historico.add(log);
    }
    public String mostraLog(){
        return historico.toString();
    }

 public void mostrarPastaSaves(){
     File folder = new File("saves");
     File[] listOfFiles = folder.listFiles();
     if(listOfFiles.length >= 5){
         for (int i = listOfFiles.length-5; i < listOfFiles.length; i++) {
             if (listOfFiles[i].isFile()) {
                 System.out.println(listOfFiles[i].getName());
             }
         }
     }else{
         for (int i = 0; i < listOfFiles.length; i++) {
             if (listOfFiles[i].isFile()) {
                 System.out.println(listOfFiles[i].getName());
             }
         }
     }
 }
    public void mostrarPastaReplays(){
        File folder = new File("replays");
        File[] listOfFiles = folder.listFiles();
        if(listOfFiles.length >= 5){
            for (int i = listOfFiles.length-5; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println(listOfFiles[i].getName());
                }
            }
        }else{
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println(listOfFiles[i].getName());
                }
            }
        }
    }
    public int verificarPastaReplay(String nomef){
        File folder = new File("replays");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if(listOfFiles[i].getName().equals(nomef)){
                return 1;
            }
        }
        return 0;
    }
}