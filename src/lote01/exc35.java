package lote01;

import java.util.Scanner;

public class exc35 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int n1, n2, aux, soma = 0;

        System.out.println("Digite o 1º número: ");
        n1 = leia.nextInt();

        System.out.println("Digite o 2º número: ");
        n2 = leia.nextInt();

        if (n1 > n2) {
            aux = n1;
            n1 = n2;
            n2 = aux;
        }

        for (int controlador = n1; controlador <= n2; controlador++) {
            if (controlador % 2 != 0) {
                System.out.println("Controlador = " + controlador);
                soma += controlador;
            }
        }

        System.out.println("Soma dos ímpares = " + soma);
    }
}
