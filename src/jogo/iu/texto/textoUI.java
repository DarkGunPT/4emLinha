package jogo.iu.texto;
import jogo.logica.MaquinaEstados;
import jogo.utils.UtilUi;

import java.io.IOException;
import java.util.Scanner;
public class textoUI {
    MaquinaEstados ME;
    boolean sair;
    int a=0;
    public textoUI(MaquinaEstados ME) {
        this.ME = ME;
    }

    public void comeca() {
        sair = false;
        while (!sair) {
            // System.out.println(ME.getSituacaoJogo());
            switch (ME.getSituacao()) {
                case Inicio:
                    inicioUI();
                    break;
                case EsperarEscolha:
                    escolherUI();
                    break;
                case Jogar:
                    jogarUI();
                    break;
                case AguardarMiniJogoA:
                    minijogoUI();
                    break;
                case FimJogo:
                    fimUI();
                    break;
            }
        }
    }

    void mostrarTabuleiro() {
        System.out.print("[ ");
        for (int a = 1; a <= 7; a++) {
            System.out.print("[" + a + "]");
        }
        System.out.println(" ]");
        for (int i = 0; i < 6; i++) {
            System.out.print("[ ");
            for (int j = 0; j < 7; j++) {
                System.out.print("|" + ME.getTabuleiro()[i][j] + "|");
            }
            System.out.print(" ]");
            System.out.print("\n");
        }

        System.out.print("\n");
    }

    void escolherNome() {
        String nome = ""; // usado na função pedirNome
        String nome2 = ""; // usado na função pedirNome
        Scanner sc = new Scanner(System.in);
        if (ME.getModo() == 1) {
            System.out.print("Insira o seu nome jogador 1: ");
            nome = sc.nextLine();
            do {
                System.out.print("Insira o seu nome jogador 2: ");
                nome2 = sc.nextLine();
            } while (nome2.equals(nome));
        } else if (ME.getModo() == 2) {
            System.out.print("Insira o seu nome jogador 1: ");
            nome = sc.nextLine();
            nome2 = "Computador1";
        } else if (ME.getModo() == 3) {
            nome = "Computador1";
            nome2 = "Computador2";
        }
        ME.fazerLog("O primeiro jogador chama-se " + nome + " !!\n");
        ME.fazerLog("O segundo jogador chama-se " + nome2 + " !!\n");
        ME.escolherNome(nome, nome2);
    }

    private void inicioUI() {
        int op = UtilUi.escolheOpcao("Comecar", "Regras", "Carregar", "Replay", "Sair");

        switch (op) {
            case 1:

                break;
            case 2:
                System.out.println();
                inicioUI();
                break;
            case 3:
                String carreg;
                ME.mostrarPastaSaves();
                do {
                    carreg = UtilUi.pedeString("Insira o nome do save que pretende carregar: ");
                } while (ME.verificarPasta(carreg) != 1);

                break;
            case 4:
                String replay;
                ME.mostrarPastaReplays();
                do {
                    replay = UtilUi.pedeString("Insira o nome do Replay que pretende carregar: ");
                } while (ME.verificarPastaReplay(replay) != 1);
                ME.setAux();

                replaysUI();
                break;
            default:
                sair = true;
                break;
        }
    }

    private void escolherUI() {
        int op = UtilUi.escolheOpcao("Jogador x jogador", "Jogador x Computador", "Computador x Computador", "Sair");
        ME.random();
        switch (op) {
            case 1:
                System.out.println("O modo de jogo selecionado foi Jogador x Jogador");
                ME.fazerLog("\nO modo de jogo selecionado foi Jogador x Jogador !!\n");

                escolherNome();
                break;
            case 2:
                System.out.println("O modo de jogo selecionado foi Jogador x Computador");
                ME.fazerLog("\nO modo de jogo selecionado foi Jogador x Computador !!\n");

                escolherNome();

                break;
            case 3:
                System.out.println("O modo de jogo selecionado foi Computador x Computador");
                ME.fazerLog("\nO modo de jogo selecionado foi Computador x Computador !!\n");

                escolherNome();
                break;
            default:
                sair = true;
                break;
        }
    }

    private int jogarpeca() {
        int col;
        Scanner sc = new Scanner(System.in);
        do {
            do {
                System.out.println("Insira a coluna em que pretende jogar: ");
                col = sc.nextInt();
            } while (col > 7 || col < 1);
        } while (ME.verificaColunaCheia(col) != 0);
        return col;
    }

    private void minijogoUI() {
        if (ME.getMiniA() == 0 || ME.getMiniB() == 0) {
            System.out.println("=== Mini Jogo - Calculos Matematicos ===");
            System.out.println("Neste jogo irao aparecer varios calculos simples. Ao acertar 5 ganha 1 peca especial!!");

        } else {
            System.out.println("=== Mini Jogo - Escreva rapido ===");
            System.out.println("Neste jogo irao ser apresentadas 5 palavras. Ao escreves as 5 palavras em um tempo limitado ganha 1 peca especial!!");

        }
    }

    private void usarEspecial() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira a coluna que pretende apagar: ");
        int col = sc.nextInt();
        if (ME.getPecaespecial(ME.getJogador()) >= 1) {
            ME.jogarespecial(ME.getJogador(), col);
        } else {
            System.out.println("Nao apresenta peca especial para jogar!!");
        }
    }

    private void recuarJogada() {
        Scanner sc = new Scanner(System.in);
        int recuar;
        if (ME.getCreditos(ME.getJogador()) > 0) {
            do {
                System.out.println("Insira o numero de jogadas que pretende recuar");
                recuar = sc.nextInt();
            } while (recuar > ME.getJogada());
            ME.recuarJogadas(recuar);
        }
        System.out.println("Creditos restantes: " + ME.getCreditos(ME.getJogador()));
    }

    private void jogarUI() {
        int passar = 0;
        ME.somarJogadas(ME.getJogador());
        System.out.println();
        System.out.println("=== Pecas especiais " + ME.getPecaespecial(ME.getJogador()) + " ===");
        System.out.println("=== Creditos " + ME.getCreditos(ME.getJogador()) + " ===");
        System.out.println("=== E a vez do jogador " + ME.mostrarNome(ME.getJogador()) + " jogar - Jogada " + ME.getJogada() + " - Jogada A " + ME.getJogadaA() + " - Jogada B " + ME.getJogadaB() + " ===");
        mostrarTabuleiro();
        if (ME.getModo() == 1 || ME.getModo() == 2 && ME.getJogador() == 0) {
            if (ME.getJogadaA() > 4) {
                ME.setJogadaA();
                System.out.println("=== E a vez do jogador " + ME.mostrarNome(ME.getJogador()) + " jogar o minijogo ===");
                int op = UtilUi.escolheOpcao("Sim", "Nao");
                if (op == 1) {
                    ME.irMini(op);
                    return;
                }
            } else if (ME.getJogadaB() > 4) {
                ME.setJogadaB();
                System.out.println("=== E a vez do jogador " + ME.mostrarNome(ME.getJogador()) + " jogar o minijogo ===");
                int op = UtilUi.escolheOpcao("Sim", "Nao");
                if (op == 1) {
                    ME.irMini(op);
                    return;
                }
            }
        }
        if (ME.getModo() == 1 || ME.getModo() == 2 && ME.getJogador() == 0) {
            do {
                int op = UtilUi.escolheOpcao("Joga peca", "Jogar peca especial", "Mostrar log", "Voltar atrás", "Gravar", "Sair");
                switch (op) {
                    case 1:
                        ME.jogar(ME.getJogador(), jogarpeca());

                        if (ME.verificarColuna() != 1 || ME.verificarLinhaR() != 1 || ME.verificaDiag() != 1) {
                            ME.trocarJogador(ME.getJogador());
                        }
                        passar = 1;
                        break;
                    case 2:
                        if (ME.getPecaespecial(ME.getJogador()) >= 1) {
                            usarEspecial();
                            ME.trocarJogador(ME.getJogador());
                            mostrarTabuleiro();
                            passar = 1;
                        } else {
                            System.out.println("Nao possui peca especial!!");
                        }
                        break;
                    case 3:
                        System.out.println(ME.mostrarLog());
                        break;
                    case 4:
                        recuarJogada();
                        System.out.println("Creditos restantes do jogador " + ME.mostrarNome(ME.getJogador()) + " : " + ME.getCreditos(ME.getJogador()));
                        passar = 1;
                        break;
                    case 5:
                        String nome = UtilUi.pedeString("Insira um nome para salvar o seu jogo: ");

                        break;
                    default:
                        passar = 1;
                        sair = true;
                        break;
                }
            } while (passar != 1);
        } else if (ME.getModo() == 3 || ME.getModo() == 2 && ME.getJogador() == 1) {
            passar = 0;
            do {
                int op = UtilUi.escolheOpcao("Joga peca", "Mostrar log", "Voltar atrás", "Gravar", "Sair");
                switch (op) {
                    case 1:
                        ME.jogar(ME.getJogador(), ME.jogarautomatico());
                        if (ME.verificarColuna() != 1 || ME.verificarLinhaR() != 1 || ME.verificaDiag() != 1) {
                            ME.trocarJogador(ME.getJogador());
                        }
                        passar = 1;
                        break;
                    case 2:
                        System.out.println(ME.mostrarLog());
                        break;
                    case 3:
                        recuarJogada();
                        System.out.println("Creditos restantes do jogador " + ME.mostrarNome(ME.getJogador()) + " : " + ME.getCreditos(ME.getJogador()));
                        passar = 1;
                        break;
                    case 4:
                        String nome = UtilUi.pedeString("Insira um nome para salvar o seu jogo: ");
                        break;
                    default:
                        passar = 1;
                        sair = true;
                        break;
                }

            } while (passar != 1);
        }
    }

    private void fimUI() {
        mostrarTabuleiro();
        if(a==0){
            ME.trocarJogador(ME.getJogador());
            if (ME.getTipofinal() == 0) {
                System.out.println("O vencedor foi o jogador " + ME.mostrarNome(ME.getJogador()) + ". Parabens!!");
                ME.fazerLog("O jogador " + ME.getJogador() + " ganhou o jogo!!\n");
            } else {
                System.out.println("Ocorreu um empate!!");
                ME.fazerLog("O jogo acabou empatado!!\n");
            }
            ME.setJogada();
            ME.setJogadaAzero();
            ME.setJogadaBzero();
            a=1;
        }
        int op = UtilUi.escolheOpcao("Guardar para replay","Voltar AguardaInicio", "Sair");
        switch (op) {
            case 1:
                String nome = UtilUi.pedeString("Insira um nome para salvar o seu replay: ");
                break;
            case 2:
                break;
            default:
                sair = true;
                break;
        }
    }
    private void replaysUI() {
        ME.irPrimeiro();
        do {
            System.out.println("=== E a vez do jogador " + ME.mostrarNome(ME.getJogador()) + " jogar - Jogada " + ME.getJogada() + " - Jogada A " + ME.getJogadaA() + " - Jogada B " + ME.getJogadaB() + " ===");
            mostrarTabuleiro();
            int op = UtilUi.escolheOpcao("Proxima jogada", "Sair");
            switch (op) {
                case 1:
                    ME.redo();
                    a=0;
                    ME.acabarReplay();
                    break;
                default:
                    ME.setAcabar();
                    sair = true;
                    break;
            }
        }while(ME.getAcabar()!=1);
    }
}