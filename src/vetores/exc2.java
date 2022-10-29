package vetores;

import java.util.Scanner;

public class exc2 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int[] numeros = new int[10];
        int menor = 0, maior = 0;
        float media = 0;

        for (int control = 0; control < numeros.length; control++) {
            System.out.print("Digite o " + (control + 1) + "º valor: ");
            numeros[control] = leia.nextInt();

            media += numeros[control];
            if (menor == 0 && maior == 0) {
                menor = numeros[control];
                maior = numeros[control];
            } else if (numeros[control] < menor) {
                menor = numeros[control];
            } else if (numeros[control] > maior) {
                maior = numeros[control];
            }
        }
        media /= numeros.length;

        System.out.println("\nMédia dos valores = " + media);
        System.out.println("Menor valor = " + menor);
        System.out.println("Maior valor = " + maior);
    }
}
