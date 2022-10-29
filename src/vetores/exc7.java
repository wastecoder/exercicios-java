package vetores;

import java.util.Arrays;
import java.util.Scanner;

public class exc7 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int indexRetornado, valorProcurado;
        int[] ordenado = {0, 1, 2, 4, 5, 6, 7, 8, 9};
        int[] par = {2, 0, 6, 4}; //Apenas números pares e o total é par
        int[] impar = {3, 1, 5, 9, 7}; //Apenas números impares e o total é impar

            //Busca o índice por busca binária recursiva com return
//        valorProcurado = 4;
//        indexRetornado = buscaBinariaRecursiva(bubbleSort(ordenado), valorProcurado, 0, ordenado.length - 1);
//        System.out.println("Valor [" + valorProcurado + "] encontrado no índice [" + indexRetornado + "]!");

            //Busca o índice por busca binária normal sem return
//        buscaBinariaNormal(bubbleSort(ordenado), 5);
//        buscaBinariaNormal(bubbleSort(ordenado), 3);
//        buscaBinariaNormal(bubbleSort(par), 4);
//        buscaBinariaNormal(bubbleSort(impar), 7);

        System.out.println("Vetor impar: " + Arrays.toString(impar));
        System.out.println("Digite o valor que deseja procurar: ");
        valorProcurado = leia.nextInt();
        buscaBinariaNormal(bubbleSort(impar), valorProcurado);
    }

    static int[] bubbleSort(int[] vetor) {
        int aux;
        for (int control1 = 0; control1 < vetor.length; control1++) {
            for (int control2 = 0; control2 < vetor.length - 1; control2++) {
                if (vetor[control2] > vetor[control2 + 1]) {
                    aux = vetor[control2];
                    vetor[control2] = vetor[control2 + 1];
                    vetor[control2 + 1] = aux;
                }
            }
        }
        return vetor;
    }

    static int buscaBinariaRecursiva(int[] vetorOrdenado, int valorDesejado, int inicio, int fim) {
//        System.out.println(">> Procurando: " + valorDesejado);
        int meio;

        if (inicio <= fim) { //Para quando não tiver mais como dividir
            meio = (inicio + fim) / 2;
//            System.out.println("> Meio: (" + inicio + "+" + fim + ")/2 = " + meio);

            if (vetorOrdenado[meio] == valorDesejado) { //Valor encontrado
                return meio;
            } else if (valorDesejado < vetorOrdenado[meio]) { //Valor à esquerda do meio
                return buscaBinariaRecursiva(vetorOrdenado, valorDesejado, inicio, meio - 1);
            } else { //Valor à direita do meio
                return buscaBinariaRecursiva(vetorOrdenado, valorDesejado, meio + 1, fim);
            }
        }

        return -1; //Não encontrou
    }

    static void buscaBinariaNormal(int[] vetor, int valorDesejado) {
        int inicio = 0, fim = vetor.length - 1, meio;
        int index = -1; //Padrão para valor não encontrado

//        System.out.println(">> Vetor : " + Arrays.toString(vetor));
        while (inicio <= fim) {
//            System.out.println("> Procurando: " + valorDesejado);
            meio = (fim + inicio) / 2;
//            System.out.println("> meio: (" + inicio + "+" + fim + ")/2 = " + meio);

            if (valorDesejado == vetor[meio]) {
                index = meio;
                break;
            } else if (valorDesejado < vetor[meio]) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        if (index != -1) {
            System.out.println(">> Valor [" + valorDesejado + "] encontrado no índice [" + index + "]!\n");
        } else {
            System.out.println(">> Valor [" + valorDesejado + "] não encontrado!\n");
        }
    }
}
