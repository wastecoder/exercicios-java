package vetores;

import java.util.Arrays;

public class exc6 {
    public static void main(String[] args) {
        int[] aleatorio = {14, 23, 32, 21};
        int[] invertido = {89, 55, 34, 21, 13};
        int[] repetido = {3, 3, 3, 2, 2, 1};

        bubbleSort(aleatorio);
        bubbleSort(invertido);
        bubbleSort(repetido);
    }

    static void bubbleSort(int[] vetor) {
        int aux;
        System.out.println("\n>> Vetor desordenado: " + Arrays.toString(vetor));

        for (int control1 = 0; control1 < vetor.length; control1++) {

            for (int control2 = 0; control2 < vetor.length - 1; control2++) {
                if (vetor[control2] > vetor[control2 + 1]) {
//                    System.out.println(vetor[control2] + " > " + vetor[control2+1]);
                    aux = vetor[control2];
                    vetor[control2] = vetor[control2 + 1];
                    vetor[control2 + 1] = aux;
//                    System.out.println("Vetor agora: " + Arrays.toString(vetor));
                }
            }
        }

        System.out.println(">> Vetor ordenado: " + Arrays.toString(vetor));
    }
}
