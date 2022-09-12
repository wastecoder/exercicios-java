package lote01;

import java.util.Scanner;

public class exc33 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        float soma = 0;

        System.out.print("Digite o final da série: ");
        int n = leia.nextInt();

        for (float contador = 1; contador <= n; contador++) {
            soma += 1/contador;
        }

        System.out.println("Soma da série = " + soma);
    }
}
