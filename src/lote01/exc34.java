package lote01;

import java.util.Scanner;

public class exc34 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int numero;

        System.out.print("Digite o número: ");
        numero = leia.nextInt();

        System.out.println(">>> TABUADA DO " + numero);
        for (int controlador = 1; controlador <= 10; controlador++) {
            System.out.println(numero + "x" + controlador + " = " + numero*controlador);
        }
    }
}
