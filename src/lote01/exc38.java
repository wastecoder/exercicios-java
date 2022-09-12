package lote01;

import java.util.Scanner;

public class exc38 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int atual, maior = 0, menor = 0;

        for (int controlador = 1; controlador <= 5; controlador++) {
            System.out.print("Digite o número " + controlador + ": ");
            atual = leia.nextInt();

            if (atual < 0) {
                controlador--;
                System.out.println("Digite apenas números positivos!");
            } else if ((maior == 0) && (menor == 0)) {
                maior = atual;
                menor = atual;
            } else {
                if (atual > maior) {
                    maior = atual;
                } else if (atual < menor) {
                    menor = atual;
                }
            }
        }

        System.out.println("Maior = " + maior);
        System.out.println("Menor = " + menor);
    }
}
