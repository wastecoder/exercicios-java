package jogodavelha;

import java.util.Scanner;

public class JogoDaVelha {
	
	static void tabela(short jogada[][]) {
		System.out.println("+---+---+---+");
		System.out.println("| " + casas(jogada[0][0]) + " | " + casas(jogada[0][1]) + " | " + casas(jogada[0][2]) + " |");
		System.out.println("+---+---+---+");
		System.out.println("| " + casas(jogada[1][0]) + " | " + casas(jogada[1][1]) + " | " + casas(jogada[1][2]) + " |");
		System.out.println("+---+---+---+");
		System.out.println("| " + casas(jogada[2][0]) + " | " + casas(jogada[2][1]) + " | " + casas(jogada[2][2]) + " |");
		System.out.println("+---+---+---+");
	}
	
	static short[][] iniciar(short jogadas[][]) {
		short linha, coluna;
		short contador = 1;
		
		for(linha = 0; linha < 3; linha++) {
			for(coluna = 0; coluna < 3; coluna++) {
				jogadas[linha][coluna] = contador++;
			}
		}
		
		return jogadas;
	}
	
	static char casas(short jogado) {
		//-2 = X = player 1
		//-3 = O = player 2
		
		if (jogado == -2) {
			return 'X';
		}else if (jogado == -3) {
			return 'O';
		}else {
			//jogado = (char)jogado;
			return (char)(jogado + '0');
		}
	}
	
	static short[][] jogar(short jogadas[][], int jogador, short casa) {
		short linha = 0;
		short coluna = 0;
		
		for(linha = 0; linha < 3; linha++) {
			for(coluna = 0; coluna < 3; coluna++) {
				if(casa == jogadas[linha][coluna]) {
					jogadas[linha][coluna] = (short)jogador;
					break;
				}
			}
		}
		
		return jogadas;
	}
	
	static boolean verificar(short tabela[][], short jogadas) {
		int w1 = tabela[0][0] + tabela[0][1] + tabela[0][2];
		int w2 = tabela[1][0] + tabela[1][1] + tabela[1][2];
		int w3 = tabela[2][0] + tabela[2][1] + tabela[2][2];
		
		int w4 = tabela[0][0] + tabela[1][0] + tabela[2][0];
		int w5 = tabela[0][1] + tabela[1][1] + tabela[2][1];
		int w6 = tabela[0][2] + tabela[1][2] + tabela[2][2];
		
		int w7 = tabela[0][0] + tabela[1][1] + tabela[2][2];
		int w8 = tabela[0][2] + tabela[1][1] + tabela[2][0];
		
		if(w1 == -6 || w2 == -6 || w3 == -6 || w4 == -6 || w5 == -6 || w6 == -6 || w7 == -6 || w8 == -6) {
			System.out.println("\n1º JOGADOR GANHOU!");
			return false;
		}else if(w1 == -9 || w2 == -9 || w3 == -9 || w4 == -9 || w5 == -9 || w6 == -9 || w7 == -9 || w8 == -9) {
			System.out.println("\n2º JOGADOR GANHOU!");
			return false;
		}else if(jogadas == 9) {
			
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		short jogadas[][] = new short[3][3];
		short novaJogada = 0;
		short contador = 1;
		boolean terminar = false;
				
		
		jogadas = iniciar(jogadas);
		tabela(jogadas);
		do {
			System.out.println("\n1º jogador: [X] em qual posição?");
			jogadas = jogar(jogadas, -2, leia.nextShort());
			terminar = verificar(jogadas, contador++);
			
			tabela(jogadas);
			
			System.out.println("\n2º jogador: [O] em qual posição?");
			jogadas = jogar(jogadas, -3, leia.nextShort());
			
			terminar = verificar(jogadas, contador++);
		}while(terminar);
		
		tabela(jogadas);
		leia.close();
	}

}
