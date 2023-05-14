package contacorrente;

import java.io.IOException;
import java.util.Scanner;

public class Executar {
    public static void main(String[] args) throws IOException {
        Scanner leia = new Scanner(System.in);
        int escolha;
        boolean contaPreenchida = false, movimentoPreenchido = false, contaAtualizada = false;

        ContasCorrentes[] clientes = new ContasCorrentes[4];
        MovimentoContas[] movimentoContas = new MovimentoContas[5];
        ClasseMetodos classeMetodos = new ClasseMetodos();

        do {
            System.out.println("\n+----------------------------------+\n" +
                    "|          MENU PRINCIPAL          |\n" +
                    "+----------------------------------+\n" +
                    "| 1 - Cadastra Contas Correntes    |\n" +
                    "| 2 - Cadastra movimento           |\n" +
                    "| 3 - Gera Contas Atualizadas      |\n" +
                    "| 4 - Consulta cadastros           |\n" +
                    "| 9 - FIM                          |\n" +
                    "+----------------------------------+");

            System.out.print(">> Escolha: ");
            escolha = leia.nextInt();

            System.out.println();

            switch (escolha) {
                case 1:
                    contaPreenchida = classeMetodos.cadastrarContasCorrentes(clientes);
                    break;
                case 2:
                    movimentoPreenchido = classeMetodos.cadastrarMovimentos(movimentoContas);
                    break;
                case 3:
                    if (objetosVazios(contaPreenchida, movimentoPreenchido)) continue;
                    contaAtualizada = classeMetodos.gerarContasAtualizadas(clientes, movimentoContas);
                    break;
                case 4:
                    if (objetosVazios(contaPreenchida, movimentoPreenchido && contaAtualizada)) continue;
                    classeMetodos.consultarCadastros();
                    break;
                case 9:
                    System.out.println(">> PROGRAMA FINALIZADO");
            }

        } while (escolha != 9);
    }

    public static boolean objetosVazios(boolean conta, boolean movimento) {
        if (conta && movimento) return false;

        System.out.println("ERRO: contas correntes, movimentos e/ou contas atualizadas vazias! Preencha elas primeiro.");
        return true;
    }
}
