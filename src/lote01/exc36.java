package lote01;

import java.util.Scanner;

public class exc36 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int numero;
        float soma = 1, fatorial = 1;

        System.out.println("Digite o final da série: ");
        numero = leia.nextInt();

        for (int controlador = 1; controlador <= numero; controlador++) {
            for (int j = controlador; j >= 2; j--) {
                fatorial *= j;
            }
            soma += 1/fatorial;
//            System.out.println("Fatorial [" + controlador + "] = " + fatorial);
            fatorial = 1;
        }

        System.out.println("Soma da série = " + soma); //num 2 = 2.5; num 3 = 2.66
    }
}
