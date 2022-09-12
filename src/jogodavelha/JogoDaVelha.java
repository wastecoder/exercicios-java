package jogodavelha;

import java.util.Scanner;

public class JogoDaVelha {

    static void tabela(byte[][] jogada) {
        System.out.println("\n+---+---+---+");
        System.out.println("| " + casas(jogada[0][0]) + " | " + casas(jogada[0][1]) + " | " + casas(jogada[0][2]) + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + casas(jogada[1][0]) + " | " + casas(jogada[1][1]) + " | " + casas(jogada[1][2]) + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + casas(jogada[2][0]) + " | " + casas(jogada[2][1]) + " | " + casas(jogada[2][2]) + " |");
        System.out.println("+---+---+---+\n");
    }

    static char casas(byte jogado) {
        //-2 = X = player 1
        //-3 = O = player 2

        if (jogado == -2) {
            return 'X';
        } else if (jogado == -3) {
            return 'O';
        } else {
            return (char) (jogado + '0');
        }
    }

    static void jogar(byte[][] jogadas, int jogador, byte casa) {
        for (byte linha = 0; linha < 3; linha++) {
            for (byte coluna = 0; coluna < 3; coluna++) {
                if (casa == jogadas[linha][coluna]) {
                    jogadas[linha][coluna] = (byte) jogador;
                    break;
                }
            }
        }
    }

    static boolean verificarVitoria(byte[][] tabela, byte contador) {
        int w1 = tabela[0][0] + tabela[0][1] + tabela[0][2];
        int w2 = tabela[1][0] + tabela[1][1] + tabela[1][2];
        int w3 = tabela[2][0] + tabela[2][1] + tabela[2][2];

        int w4 = tabela[0][0] + tabela[1][0] + tabela[2][0];
        int w5 = tabela[0][1] + tabela[1][1] + tabela[2][1];
        int w6 = tabela[0][2] + tabela[1][2] + tabela[2][2];

        int w7 = tabela[0][0] + tabela[1][1] + tabela[2][2];
        int w8 = tabela[0][2] + tabela[1][1] + tabela[2][0];

        tabela(tabela);

        if (w1 == -6 || w2 == -6 || w3 == -6 || w4 == -6 || w5 == -6 || w6 == -6 || w7 == -6 || w8 == -6) {
            System.out.println("\n1º JOGADOR GANHOU!");
            return false;
        } else if (w1 == -9 || w2 == -9 || w3 == -9 || w4 == -9 || w5 == -9 || w6 == -9 || w7 == -9 || w8 == -9) {
            System.out.println("\n2º JOGADOR GANHOU!");
            return false;
        } else if (contador == 9) {
            System.out.println("EMPATOU!");
            return false;
        }

        return true;
    }

    static boolean verificarErro(byte[][] tabela, byte jogadaAtual) {
        if (jogadaAtual < 1 || jogadaAtual > 9) {
            System.out.println("Jogue entre 1 e 9, tente novamente!");
            return true;
        }

        byte contador = 0;
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                contador++;
                if (tabela[linha][coluna] == jogadaAtual) {
                    System.out.println("Jogada válida -- " + contador);
                    return false;
                } else{
                    System.out.println("Jogada inválida -- " + contador);
                }
            }
        }

                /*if (tabela[linha][coluna] == jogadaAtual &&
                        (tabela[linha][coluna] == -2 || tabela[linha][coluna] == -3)) {
                    tabela(tabela);
                    System.out.println(tabela[linha][coluna]);
                    System.out.println(--contador);
                    System.out.println(jogadaAtual);
                    System.out.println("1 - Casa ocupada, tente novamente!");
                    return true;
                }*/

                    /*else if (tabela[linha][coluna] == -2 || tabela[linha][coluna] == -3){
                    System.out.println("Jogada inválida");
                    System.out.println("Casa atual: " + tabela[linha][coluna]);
                    System.out.println("Jogada: " + jogadaAtual);
                    return true;
                }*/
        return false;
    }


    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        byte[][] jogadas = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        byte novaJogada, contador = 1;
        boolean terminar = true;
        boolean erro;


        tabela(jogadas);
        do {
            System.out.println("1º jogador: [X] em qual posição?");
            novaJogada = leia.nextByte();
            erro = verificarErro(jogadas, novaJogada);
            if (erro) {
                continue;
            } else {
                jogar(jogadas, -2, novaJogada);
                terminar = verificarVitoria(jogadas, contador);
                if (!terminar) {
                    break;
                }
            }


            System.out.println("2º jogador: [O] em qual posição?");
            novaJogada = leia.nextByte();
            erro = verificarErro(jogadas, novaJogada);
            if (erro) {
                continue;
            } else {
                jogar(jogadas, -3, novaJogada);
                terminar = verificarVitoria(jogadas, contador);
                if (!terminar) {
                    break;
                }
            }
        } while (terminar);

        leia.close();
    }

}

	/*
	Se jogou em lugar ocupado
	Try catch ao digitar letras
	Empatar corretamente
	 */
