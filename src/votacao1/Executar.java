package votacao1;

import java.io.IOException;
import java.util.Scanner;

public class Executar {
    public static void main(String[] args) throws IOException {
        Votacao2023[] votacao2023 = new Votacao2023[200];
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
                    votacao2023 = votacao.cadastrarVotos(votacao2023);
                    break;
                case 2:
                    votacao2023 = votacao.ordenarPorSecao(votacao2023);
                    break;
                case 3:
                    votacao.gravarVotacao(votacao2023);
                    break;
                case 4:
                    votacao.mostrarIndicadores(votacao2023);
                    break;
                case 9:
                    System.out.println("\n>>>> PROGRAMA FINALIZADO!\n");
                    break;
            }

        } while (escolha != 9);
    }
}
