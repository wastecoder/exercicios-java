package caixaeletronico;

import java.util.*;

public class Caixa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<Integer> notasCaixa = new PriorityQueue<>(6);

        menu(input, notasCaixa);
    }

    public static void menu(Scanner input, Queue<Integer> notasCaixa) {
        int[][] bancos = new int[4][5];
        int escolha;

        do {
            System.out.println("\n+--------------------+");
            System.out.println("|        MENU        |");
            System.out.println("+--------------------+");
            System.out.println("| 0 - Fim            |");
            System.out.println("| 1 - Carregar notas |");
            System.out.println("| 2 - Sacar (valor)  |");
            System.out.println("| 3 - Op. 2 + notas  |");
            System.out.println("| 4 - Estatísticas   |");
            System.out.println("+--------------------+");
            System.out.print("> Escolha: ");
            escolha = input.nextInt();

            switch (escolha) {
                case 0 -> System.out.println("\n>> Programa finalizado.");
                case 1 -> carregarNotas(input, notasCaixa);
                case 2 -> sacarPorValor(input, notasCaixa, bancos);
                case 3 -> sacarPorValorENotas(input, notasCaixa, bancos);
                case 4 -> exibirEstatisticas(bancos);
                default -> System.out.println(">> Escolha inválida, tente novamente.");
            }
        } while (escolha != 0);
    }



    public static void carregarNotas(Scanner input, Queue<Integer> notasCaixa) {
        if (!notasCaixa.isEmpty()) {
            System.out.println(">> Caixa já possui dinheiro.");
            System.out.print("> Deseja sobrescrever o saldo atual? [S/N]: ");
            String resposta = input.next().toUpperCase(Locale.ROOT);

            if (!resposta.equals("S")) menu(input, notasCaixa);
        }

        notasCaixa.clear();
        List<Integer> notasValidas = new ArrayList<>(List.of(2, 5, 10, 20, 50, 100, 200));
        int QUANTIDADE_POR_NOTA = 6;

        for (int notasValida : notasValidas) {
            for (int quantidade = 0; quantidade < QUANTIDADE_POR_NOTA; quantidade++) {
                notasCaixa.add(notasValida);
            }
        }

        System.out.println(">> Novo saldo: R$" + saldoCaixa(notasCaixa));
    }

    public static int saldoCaixa(Queue<Integer> notasCaixa) {
        int saldo = 0;
        for (int nota : notasCaixa) {
            saldo += nota;
        }
        return saldo;
    }



    public static void sacarPorValor(Scanner input, Queue<Integer> notasCaixa, int[][] bancos) {
        if (notasCaixa.isEmpty()) { //TRANSFORMAR EM MÉTODO
            System.out.println(">> Caixa vazio. Carregue notas antes.");
            menu(input, notasCaixa);
        }

        int saldoCaixa = saldoCaixa(notasCaixa);
        System.out.println(">> Saldo do caixa: R$" + saldoCaixa);
        System.out.print("> Digite o quanto deseja sacar: R$");
        int valorDesejado = input.nextInt();

        if (valorDesejado <= 1 || valorDesejado == 3) {
            System.out.println(">> ERRO: VALOR [" + valorDesejado + "] INVÁLIDO");
        } else if (valorDesejado > saldoCaixa) {
            System.out.println(">> ERRO: EXCEDEU O LIMITE DO CAIXA - R$" + saldoCaixa);
        } else {
            coletarEstatisticas(input, bancos, valorDesejado);

            while (valorDesejado % 5 != 0 && notasCaixa.contains(2)) { //Retira números não múltiplos de 5 até virar múltiplo dele.
                System.out.println("RETIRANDO >>>> 2");
                valorDesejado -= 2;
                notasCaixa.remove(2);
            }

            List<Integer> notasValidas = new ArrayList<>(List.of(200, 100, 50, 20, 10, 5, 2));
            for (int notaAtual : notasValidas) {
                valorDesejado = sacarRepeticao(notasCaixa, valorDesejado, notaAtual);
            }
            System.out.println(notasCaixa);
        }
    }

    public static void sacarPorValorENotas(Scanner input, Queue<Integer> notasCaixa, int[][] bancos) {
        if (notasCaixa.isEmpty()) {
            System.out.println(">> Caixa vazio. Carregue notas antes.");
            menu(input, notasCaixa);
        }

        ArrayList<Integer> notasValidas = new ArrayList<>(List.of(200, 100, 50, 20, 10, 5, 2));
        int saldoCaixa = saldoCaixa(notasCaixa);

        System.out.println(">> Saldo do caixa: R$" + saldoCaixa);
        System.out.println(">> Notas válidas: " + notasValidas);

        System.out.print("> Digite a nota que deseja sacar: R$");
        int notaDesejada = input.nextInt();

        System.out.print("> Digite quantas notas dela deseja: ");
        int quantidadeDesejada = input.nextInt();

        if (!notasValidas.contains(notaDesejada)) {
            System.out.println(">> ERRO: NOTA [" + notaDesejada + "] INVÁLIDA");
        } else {
            int valorDesejado = notaDesejada * quantidadeDesejada;
            coletarEstatisticas(input, bancos, valorDesejado); // Pode bugar se acabar notas pequenas, aumentando o valor o do banco mesmo sem o cliente receber as notas

            while (valorDesejado % 5 != 0 && notasCaixa.contains(2)) { //TRANSFORMAR EM MÉTODO
                System.out.println("RETIRANDO >>>> 2");
                valorDesejado -= 2;
                notasCaixa.remove(2);
            }

            for (int i = notasValidas.size() - 1; i >= 0; i--) { //Remove as notas maiores que a desejada. Auxilia a repetição abaixo
                if (notasValidas.get(i) <= notaDesejada) continue;
                notasValidas.remove(i);
            }

            for (int notaAtual : notasValidas) {
                valorDesejado = sacarRepeticao(notasCaixa, valorDesejado, notaAtual);
            }
        }
    }

    public static int sacarRepeticao(Queue<Integer> notasCaixa, int valorDesejado, int notaAtual) {
        while (valorDesejado >= notaAtual && notasCaixa.contains(notaAtual)) {
            System.out.println("RETIRANDO >>>> " + notaAtual);
            valorDesejado -= notaAtual;
            notasCaixa.remove(notaAtual);
        }

        return valorDesejado;
    }



    public static void coletarEstatisticas(Scanner input, int[][] bancos, int valorSacado) {
        System.out.println(">> [1] Banco do Brasil");
        System.out.println(">> [2] Santander");
        System.out.println(">> [3] Itaú");
        System.out.println(">> [4] Caixa");
        System.out.print("> Digite o código do seu banco: ");
        int codigoBanco = input.nextInt();

        if (codigoBanco < 1 || codigoBanco > 4) {
            System.out.println(">> ERRO: CÓDIGO DE BANCO [" + codigoBanco + "] INVÁLIDO!");
            coletarEstatisticas(input, bancos, valorSacado);
        }

        //bancos[id][0] = menor valor sacado
        //bancos[id][1] = maior valor sacado
        //bancos[id][2] = total sacado
        //bancos[id][3] = média de saque
        //bancos[id][4] = quantidade de saque
        codigoBanco--;
        if (bancos[codigoBanco][0] == 0 && bancos[codigoBanco][1] == 0) {
            bancos[codigoBanco][0] = valorSacado;
            bancos[codigoBanco][1] = valorSacado;
        } else {
            if (valorSacado < bancos[codigoBanco][0]) {
                bancos[codigoBanco][0] = valorSacado;
            } else if (valorSacado > bancos[codigoBanco][1]) {
                bancos[codigoBanco][1] = valorSacado;
            }
        }

        bancos[codigoBanco][2] += valorSacado;
        bancos[codigoBanco][4]++;
        bancos[codigoBanco][3] = bancos[codigoBanco][2]/bancos[codigoBanco][4];
    }

    public static void exibirEstatisticas(int[][] bancos) {
        System.out.println("\n+-------------------------+");
        for (int x = 0; x < 4; x++) {
            System.out.print(">>> BANCO: ");
            switch (x) {
                case 0 -> System.out.println("Banco do Brasil");
                case 1 -> System.out.println("Santander");
                case 2 -> System.out.println("Itaú");
                case 3 -> System.out.println("Caixa");
            }

            for (int y = 0; y < 4; y++) { //Até 4 para não exibir a quantidade de saque
                switch (y) {
                    case 0 -> System.out.print("> Maior valor sacado: R$");
                    case 1 -> System.out.print("> Menor valor sacado: R$");
                    case 2 -> System.out.print("> Total sacado: R$");
                    case 3 -> System.out.print("> Média de saque: R$");
                }
                System.out.println(bancos[x][y]);
            }
            System.out.println("+-------------------------+");
        }
    }
}
