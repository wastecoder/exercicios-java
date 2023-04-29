package Acidentes;

import java.util.Scanner;

public class Executar {
    public static void main(String[] args) {
        ClasseMetodos classeMetodos = new ClasseMetodos();
        Scanner leia = new Scanner(System.in);
        Estatistica[] estatisticas = new Estatistica[3];
        int escolha;

        do {
            System.out.println("""

                    +-----------------------------------------------+
                    |               MENU ESTATÍSTICA                |
                    | Estatísticas de acidentes em 2023             |
                    +-----------------------------------------------+
                    | 1 - Cadastro de estatística                   |
                    | 2 - Consulta por quantidade de acidentes      |
                    | 3 - Consulta por estatísticas de acidentes    |
                    | 4 - Acidentes acima da média das cidades      |
                    | 9 - Finaliza                                  |
                    +-----------------------------------------------+""");

            System.out.print(">> Escolha: ");
            escolha = leia.nextInt();

            switch (escolha) {
                case 1:
                    estatisticas = classeMetodos.cadastrarEstatistica(estatisticas);
                    break;

                case 2:
                    classeMetodos.quantidadeAcidentes(estatisticas);
                    break;

                case 3:
                    classeMetodos.maiorMenor(estatisticas);
                    break;

                case 4:
                    classeMetodos.acimaMedia(estatisticas);
                    break;

                case 9:
                    System.out.println("\n>>>> PROGRAMA FINALIZADO");
                    break;

            }
        } while (escolha != 9);
    }
}
