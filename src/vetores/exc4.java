package vetores;

import java.util.Scanner;

public class exc4 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int[] numeros = new int[10];
        int acimaMedia = 0, abaixoMedia = 0;
        float media = 0;

        for (int control = 0; control < numeros.length; control++) {
            System.out.print("Digite o " + (control + 1) + "º valor: ");
            numeros[control] = leia.nextInt();
            media += numeros[control];
        }
        media /= numeros.length;

        for (int numero : numeros) {
            if (numero > media) {
                acimaMedia++;
            } else if (numero < media) { //Com else ficaria <=
                abaixoMedia++;
            }
        }

        System.out.println("\nMédia = " + media);
        System.out.println("Abaixo da média = " + abaixoMedia);
        System.out.println("Acima da média = " + acimaMedia);
    }
}
