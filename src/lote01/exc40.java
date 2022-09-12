package lote01;

import java.util.Scanner;

public class exc40 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int n1, n2, aux, acumulador;

        System.out.println("Digite o 1º número: ");
        n1 = leia.nextInt();

        System.out.println("Digite o 2º número: ");
        n2 = leia.nextInt();

        if (n1 > n2) {
            aux = n1;
            n1 = n2;
            n2 = aux;
        }

        for (int control = n1; control <= n2; control++) {
            acumulador = 0;
            for (int j = control; j >= 1; j--) {
                if (control % 2 == 0) {
                    acumulador++;
                    continue;
                } else if (control % j == 0) {
                    acumulador++;
                }

                if (acumulador > 2) {
                    break;
                }
            }
            if (acumulador == 2) {
                System.out.println(control + " >>> e primo");
            } else {
                System.out.println(control + " >>> nao e primo");
            }
        }
    }
}
