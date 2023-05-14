package contacorrente;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ClasseMetodos {
    public boolean cadastrarContasCorrentes(ContasCorrentes[] contasCorrentes) throws IOException {
//        contasCorrentes[0] = new ContasCorrentes(13, "Maria Souza", 1200, 300, 4);
//        contasCorrentes[1] = new ContasCorrentes(14, "Mauro Souza", 900, 0, 2);
//        contasCorrentes[2] = new ContasCorrentes(10, "José Silva", 800, 100, 1);
//        contasCorrentes[3] = new ContasCorrentes(20, "Carlos Lima", 3000, 2000, 3);

        Scanner leia = new Scanner(System.in);
        for (int i = 0; i < contasCorrentes.length; i++) {
            contasCorrentes[i] = new ContasCorrentes();

            System.out.print((i + 1) + "º cliente >> digite o código: ");
            contasCorrentes[i].codConta = leia.nextInt();

            leia.nextLine();
            System.out.print((i + 1) + "º cliente >> digite o nome: ");
            contasCorrentes[i].nomeCliente = leia.nextLine();

            System.out.print((i + 1) + "º cliente >> digite o saldo da conta: ");
            contasCorrentes[i].saldoConta = leia.nextDouble();

            System.out.print((i + 1) + "º cliente >> digite o limite da conta: ");
            contasCorrentes[i].limiteConta = leia.nextDouble();

            System.out.print((i + 1) + "º cliente >> digite o tipo da conta: ");
            contasCorrentes[i].tipoConta = leia.nextInt();

            System.out.println();
        }

        //Ordena, em ordem crescente, o contasCorrentes[] pelo atributo codConta
        //Aqui usa expressão lambda para ordenar. Se inverter "(c1, c2)" vira decrescente
        Arrays.sort(contasCorrentes, (c1, c2) -> c1.codConta - c2.codConta);

        BufferedWriter gravar = new BufferedWriter(new FileWriter("contasCorrentesCadastradas.txt"));
        for (ContasCorrentes conta : contasCorrentes) {
            gravar.write(String.valueOf(conta.codConta));
            gravar.newLine();
            gravar.write(conta.nomeCliente);
            gravar.newLine();
            gravar.write(String.valueOf(conta.saldoConta));
            gravar.newLine();
            gravar.write(String.valueOf(conta.limiteConta));
            gravar.newLine();
            gravar.write(String.valueOf(conta.tipoConta));
            gravar.newLine();
        }
        gravar.close();
        System.out.println(">>>> ARQUIVO 'contasCorrentesCadastradas.txt' GERADO!");

        return true;
    }

    public boolean cadastrarMovimentos(MovimentoContas[] movimentoContas) throws IOException {
//        movimentoContas[0] = new MovimentoContas(13, 300, 1, 1);
//        movimentoContas[1] = new MovimentoContas(20, 2000, 2, 2);
//        movimentoContas[2] = new MovimentoContas(13, 50, 2, 1);
//        movimentoContas[3] = new MovimentoContas(20, 4000, 2, 2);
//        movimentoContas[4] = new MovimentoContas(13, 100, 1, 1);

        Scanner leia = new Scanner(System.in);
        for (int i = 0; i < movimentoContas.length; i++) {
            movimentoContas[i] = new MovimentoContas();

            System.out.print((i + 1) + "º movimento >> digite o código: ");
            movimentoContas[i].codConta = leia.nextInt();

            System.out.print((i + 1) + "º movimento >> digite o valor movimentado: ");
            movimentoContas[i].valorMovimentado = leia.nextDouble();

            System.out.print((i + 1) + "º movimento >> digite o tipo de movimento: ");
            movimentoContas[i].tipoMovimento = leia.nextInt();

            System.out.print((i + 1) + "º movimento >> digite o status de movimento: ");
            movimentoContas[i].status = leia.nextInt();

            System.out.println();
        }

        //Ordena movimentoContas[] crescentemente pelo atributo codConta
        //Usa a classe Comparator. Inverter m1 e m2 vira decrescente
        Arrays.sort(movimentoContas, new Comparator<MovimentoContas>() {
            public int compare(MovimentoContas m1, MovimentoContas m2) {
                return m1.codConta - m2.codConta;
            }
        });

        BufferedWriter gravar = new BufferedWriter(new FileWriter("movimentoContasCadastrados.txt"));
        for (MovimentoContas movimento : movimentoContas) {
            gravar.write(String.valueOf(movimento.codConta));
            gravar.newLine();
            gravar.write(String.valueOf(movimento.valorMovimentado));
            gravar.newLine();
            gravar.write(String.valueOf(movimento.tipoMovimento));
            gravar.newLine();
            gravar.write(String.valueOf(movimento.status));
            gravar.newLine();
        }
        gravar.close();
        System.out.println(">>>> ARQUIVO 'movimentoContasCadastrados.txt' GERADO!");

        return true;
    }

    public boolean gerarContasAtualizadas(ContasCorrentes[] contasCorrentes, MovimentoContas[] movimentoContas) throws IOException {
        ContasCorrentes[] contasAtualizadas = new ContasCorrentes[contasCorrentes.length];
        BufferedWriter gravar = new BufferedWriter(new FileWriter("contasAtualizadas.txt"));

        for (int i = 0; i < contasCorrentes.length; i++) {
            contasAtualizadas[i] = new ContasCorrentes();
            contasAtualizadas[i].codConta = contasCorrentes[i].codConta;
            contasAtualizadas[i].nomeCliente = contasCorrentes[i].nomeCliente;
            contasAtualizadas[i].saldoConta = contasCorrentes[i].saldoConta;
            contasAtualizadas[i].limiteConta = contasCorrentes[i].limiteConta;
            contasAtualizadas[i].tipoConta = contasCorrentes[i].tipoConta;

            for (int x = 0; x < movimentoContas.length; x++) {
                if (contasAtualizadas[i].codConta == movimentoContas[x].codConta) {
                    if (movimentoContas[x].tipoMovimento == 1) {
                        contasAtualizadas[i].saldoConta += movimentoContas[x].valorMovimentado;
                    } else {
                        contasAtualizadas[i].saldoConta -= movimentoContas[x].valorMovimentado;
                    }
                }
            }

            gravar.write(String.valueOf(contasAtualizadas[i].codConta));
            gravar.newLine();
            gravar.write(contasAtualizadas[i].nomeCliente);
            gravar.newLine();
            gravar.write(String.valueOf(contasAtualizadas[i].saldoConta));
            gravar.newLine();
            gravar.write(String.valueOf(contasAtualizadas[i].limiteConta));
            gravar.newLine();
            gravar.write(String.valueOf(contasAtualizadas[i].tipoConta));
            gravar.newLine();
        }
        gravar.close();
        System.out.println(">>>> ARQUIVO 'contasAtualizadas.txt' GERADO!");

        return true;
    }

    public void consultarCadastros() throws IOException {
        Scanner leia = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\n+------------------------------+\n" +
                    "|       CONSULTA CADASTRO      |\n" +
                    "+------------------------------+\n" +
                    "| 1 - Contas correntes         |\n" +
                    "| 2 - Movimento das contas     |\n" +
                    "| 3 - Contas atualizadas       |\n" +
                    "| 9 - VOLTAR                   |\n" +
                    "+------------------------------+");

            System.out.print(">> Escolha: ");
            escolha = leia.nextInt();

            System.out.println();

            switch (escolha) {
                case 1:
                    this.consultarContasCorrentes();
                    break;
                case 2:
                    this.consultarMovimentoContas();
                    break;
                case 3:
                    this.consultarContasAtualizadas();
                    break;
            }
        } while (escolha != 9);
    }

    public void consultarContasCorrentes() throws IOException {
        BufferedReader ler = new BufferedReader(new FileReader("contasCorrentesCadastradas.txt"));
        ContasCorrentes[] contasCorrentes = new ContasCorrentes[4];

        for (int i = 0; i < 4; i++) {
            contasCorrentes[i] = new ContasCorrentes();

            //Daria pra printar sem guardar no objeto
            contasCorrentes[i].codConta = Integer.parseInt(ler.readLine());
            contasCorrentes[i].nomeCliente = ler.readLine();
            contasCorrentes[i].saldoConta = Double.parseDouble(ler.readLine());
            contasCorrentes[i].limiteConta = Double.parseDouble(ler.readLine());
            contasCorrentes[i].tipoConta = Integer.parseInt(ler.readLine());

            System.out.println(contasCorrentes[i]);
        }
        ler.close();
    }

    public void consultarMovimentoContas() throws IOException {
        BufferedReader ler = new BufferedReader(new FileReader("movimentoContasCadastrados.txt"));

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            stringBuilder.append("MovimentoContas{");
            stringBuilder.append("codConta=").append(ler.readLine());
            stringBuilder.append(", valorMovimentado=").append(ler.readLine());
            stringBuilder.append(", tipoMovimento=").append(ler.readLine());
            stringBuilder.append(", status=").append(ler.readLine());
            stringBuilder.append("}\n");
        }
        System.out.println(stringBuilder);
    }

    public void consultarContasAtualizadas() throws IOException {
        BufferedReader ler = new BufferedReader(new FileReader("contasAtualizadas.txt"));

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append("ContasAtualizadas{");
            stringBuilder.append("codConta=").append(ler.readLine());
            stringBuilder.append(", nomeCliente=").append(ler.readLine());
            stringBuilder.append(", saldoConta=").append(ler.readLine());
            stringBuilder.append(", limiteConta=").append(ler.readLine());
            stringBuilder.append(", tipoConta=").append(ler.readLine());
            stringBuilder.append("}\n");
        }
        System.out.println(stringBuilder);
    }
}
