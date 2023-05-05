package votacao1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Votacao2023 {
    public Votacao[] cadastrarVotos(Votacao[] votos) {
        System.out.println("\n>>>> CADASTRAR " + votos.length + " VOTOS:");

        //Fórmula do aleatório: (min, max + 1)
        for (int i = 0; i < votos.length; i++) {
            votos[i] = new Votacao();
            votos[i].numeroSecao = ThreadLocalRandom.current().nextInt(0, 10 + 1);
            votos[i].numeroCandidato = ThreadLocalRandom.current().nextInt(0, 300 + 1);

            System.out.println("> " + i + " ==> " + votos[i]);
        }

        System.out.println("\n>>>> " + votos.length + " VOTOS CADASTRADOS!");
        return votos;
    }

    public Votacao[] ordenarPorSecao(Votacao[] votos) {
        if (votosVazios(votos)) return votos;

        // Ordena votos[] crescentemente pelo numeroSecao
        Arrays.sort(votos, new Comparator<Votacao>() {
            public int compare(Votacao vot1, Votacao vot2) {
                return Integer.compare(vot1.numeroSecao, vot2.numeroSecao);
            }
        });

        System.out.println("\n>>>> VOTOS ORDENADOS!");
        return votos;
    }

    public void gravarVotacao(Votacao[] votos) throws IOException {
        if (votosVazios(votos)) return;

        String nomeArquivo = "Votacao2023.txt";
        BufferedWriter gravar = new BufferedWriter(new FileWriter(nomeArquivo));

        for (Votacao voto : votos) {
            gravar.write("NumeroSecao: " + voto.numeroSecao + "; NumeroCandidato: " + voto.numeroCandidato);
            gravar.newLine();
        }

        gravar.close();
        System.out.println("\n>>>> ARQUIVO 'Votação2023.txt' GERADO!");
    }

    public void mostrarIndicadores(Votacao[] votos) {
        if (votosVazios(votos)) return;

        Scanner input = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("""
                                        
                    +---------------------------------------------------+
                    |              INDICADORES DA VOTAÇÃO               |
                    +---------------------------------------------------+
                    | 1 - Quantidade eleitores por seção                |
                    | 2 - Seção com maior e menor número de eleitores   |
                    | 3 - Quantidade de votos por candidato             |
                    | 4 - 10 primeiros colocadas (nro cand e qtd votos) |
                    | 9 - Finalizar consulta                            |
                    +---------------------------------------------------+
                    """);

            System.out.print(">> Escolha: ");
            escolha = input.nextInt();

            switch (escolha) {
                case 1:
                    this.eleitoresPorSecao(votos);
                    break;
                case 2:
                    this.maiorEMenorSecao(votos);
                    break;
                case 3:
                    this.votosPorCandidato(votos);
                    break;
                case 4:
                    this.primeiros10Candidatos(votos);
                    break;
            }
        } while (escolha != 9);
    }

    public void eleitoresPorSecao(Votacao[] votos) {
        System.out.println("\n>>>> QUANTIDADE DE ELEITORES POR SEÇÃO");

        int[] secoes = new int[11]; //Seções vão de 0 a 10
        for (Votacao voto : votos) {
            secoes[voto.numeroSecao]++;
        }

        for (int i = 0; i < secoes.length; i++) {
            System.out.println("> seção " + i + ": " + secoes[i]);
        }
    }

    public void maiorEMenorSecao(Votacao[] votos) {
        System.out.println("\n>>>> SEÇÃO COM MAIOR E MENOR NÚMERO DE ELEITORES");

        int[] secoes = new int[11]; //Seções vão de 0 a 10
        for (Votacao voto : votos) {
            secoes[voto.numeroSecao]++;
        }

        int maior = 0, menor = 0;
        for (int i = 1; i < secoes.length; i++) {
            if (secoes[i] > secoes[maior]) {
                maior = i;
            }
            if (secoes[i] < secoes[menor]) {
                menor = i;
            }
        }

        System.out.println("> Seção com mais eleitores: " + maior + "; Quantidade: " + secoes[maior]);
        System.out.println("> Seção com menos eleitores: " + menor + "; Quantidade: " + secoes[menor]);
    }

    public void votosPorCandidato(Votacao[] votos) {
        System.out.println("\n>>>> QUANTIDADE DE VOTOS POR CANDIDATO");

        int[] candidatos = new int[301]; //Candidatos vão de 0 a 300
        for (Votacao voto : votos) {
            candidatos[voto.numeroCandidato]++;
        }

        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("> candidato " + i + ": " + candidatos[i]);
        }
    }

    public void primeiros10Candidatos(Votacao[] votos) {
        System.out.println("\n>>>> OS 10 CANDIDATOS COM MAIS VOTOS");

        //Coluna 0: número do candidato
        //Coluna 1: soma dos votos no candidato
        int[][] candidatos = new int[301][2];
        for (int x = 0; x < 301; x++) {
            candidatos[x][0] = x;

            if (x < votos.length) { //Para não estourar o limite do index
                candidatos[votos[x].numeroCandidato][1]++;
            }
        }

        //Ordena a matriz "candidatos" em ordem decrescente a partir da segunda coluna
        Arrays.sort(candidatos, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);   //Para ordem crescente, basta inverter o2 com o1
            }
        });

        for (int x = 0; x < 10; x++) {
            System.out.println("> " + (x + 1) + "º candidato (" + candidatos[x][0] + ") = " + candidatos[x][1] + " votos");
        }
    }


    public boolean votosVazios(Votacao[] votos) {
        if (votos[0] == null) {
            System.out.println("\n>>>> ERRO: Votos vazios, cadastre primeiro!");
            return true;
        }
        return false;
    }
}
