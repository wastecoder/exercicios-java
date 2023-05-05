package votacao1;

import java.io.IOException;
import java.util.Scanner;

public class Executar {
    public static void main(String[] args) throws IOException {
        Votacao[] votos = new Votacao[200];
        Votacao2023 votacao = new Votacao2023();
        Scanner input = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("""
                    
                    +---------------------------------------+
                    |          SISTEMA DE VOTAÇÃO           |
                    +---------------------------------------+
                    | 1 - Carregar seção/número Eleitor     |
                    | 2 - Classificar por seção             |
                    | 3 - Gravar registros                  |
                    | 4 - Mostrar indicadores               |
                    | 9 - Finalizar                         |
                    +---------------------------------------+
                    """);

            System.out.print(">> Escolha: ");
            escolha = input.nextInt();

            switch (escolha) {
                case 1:
                    votos = votacao.cadastrarVotos(votos);
                    break;
                case 2:
                    votos = votacao.ordenarPorSecao(votos);
                    break;
                case 3:
                    votacao.gravarVotacao(votos);
                    break;
                case 4:
                    votacao.mostrarIndicadores(votos);
                    break;
                case 9:
                    System.out.println("\n>>>> PROGRAMA FINALIZADO!");
                    break;
            }

        } while (escolha != 9);
    }
}
