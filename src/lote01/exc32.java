package lote01;

import java.util.Scanner;

public class exc32 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int numero, resultado = 1;

        System.out.print("Digite um número: ");
        numero = leia.nextInt();

        for (int controlador = numero; controlador >= 2; controlador--) {
            resultado *= controlador;
        }

        System.out.println("Fatorial [" + numero + "] = " + resultado);
    }
}
