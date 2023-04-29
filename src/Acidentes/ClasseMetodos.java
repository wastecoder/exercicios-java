package Acidentes;

import java.util.Scanner;

public class ClasseMetodos {
    public Estatistica[] cadastrarEstatistica(Estatistica[] estatisticas) {
        Scanner leia = new Scanner(System.in);
        int quantidadeAcidentes;
        System.out.println("\n>>>> CADASTRAR " + estatisticas.length + " ESTATÍSTICAS:");

        for (int i = 0; i < estatisticas.length; i++) {
            System.out.println("\n>>>> " + (i + 1) + "ª ESTATÍSTICA: ");
            estatisticas[i] = new Estatistica();

            System.out.print(">> Código cidade: ");
            estatisticas[i].setCodigoCidade(leia.nextInt());
            leia.nextLine(); //BUG: https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo

            System.out.print(">> Nome cidade: ");
            estatisticas[i].setNomeCidade(leia.nextLine());

            System.out.print(">> Quantidade de acidentes: ");
            quantidadeAcidentes = leia.nextInt();
            estatisticas[i].setQuantidadeAcidentes(quantidadeAcidentes);
        }

        System.out.println("\n>>>> " + estatisticas.length + " ESTATÍSTICAS CADASTRADAS!\n");
        return estatisticas;
    }

    public void quantidadeAcidentes(Estatistica[] estatisticas) {
        if (estatiscaVazia(estatisticas)) return;

        System.out.println("\n>>>> QUANTIDADE DE ACIDENTES: 100 < acidentes < 500");
        int quantidadeAcidentes;

        for (int i = 0; i < estatisticas.length; i++) {
            quantidadeAcidentes = estatisticas[i].getQuantidadeAcidentes();
            if (quantidadeAcidentes > 100 && quantidadeAcidentes < 500) {
                System.out.println(estatisticas[i]);
            }
        }
    }

    public void maiorMenor(Estatistica[] estatisticas) {
        if (estatiscaVazia(estatisticas)) return;

        Estatistica maiorAcidentes = new Estatistica();
        Estatistica menorAcidentes = new Estatistica();

        for (int i = 0; i < estatisticas.length; i++) {
            if (maiorAcidentes.getNomeCidade() != null && menorAcidentes.getNomeCidade() != null) {
                if (estatisticas[i].getQuantidadeAcidentes() > maiorAcidentes.getQuantidadeAcidentes()) {
                    maiorAcidentes = estatisticas[i];
                }
                if (estatisticas[i].getQuantidadeAcidentes() < menorAcidentes.getQuantidadeAcidentes()) {
                    menorAcidentes = estatisticas[i];
                }
            } else {
                maiorAcidentes = estatisticas[i];
                menorAcidentes = estatisticas[i];
            }
        }

        System.out.println("\n>>>> MAIOR E MENOR NÚMEROS DE ACIDENTES:");

        System.out.println("\n>> MAIOR NÚMERO DE ACIDENTES: " + maiorAcidentes);
        System.out.println(">> MENOR NÚMERO DE ACIDENTES: " + menorAcidentes);
    }

    public void acimaMedia(Estatistica[] estatisticas) {
        if (estatiscaVazia(estatisticas)) return;

        float media = 0;
        for (Estatistica estatistica : estatisticas) {
            media += estatistica.getQuantidadeAcidentes();
        }
        media /= estatisticas.length;

        System.out.println("\n>>>> ACIDENTES ACIMA DA MÉDIA (" + media + "):");
        for (Estatistica estatistica : estatisticas) {
            if (estatistica.getQuantidadeAcidentes() > media) {
                System.out.println(estatistica);
            }
        }
    }

    public boolean estatiscaVazia(Estatistica[] estatisticas) {
        if (estatisticas[0] == null) {
            System.out.println("\n>>>> ERRO: Estatísticas vazias, cadastre primeiro!");
            return true;
        }
        return false;
    }
}
