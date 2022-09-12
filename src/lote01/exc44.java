package lote01;

import java.util.Scanner;

public class exc44 {
    public static void main(String[] args) { // FALTA ESSE
        Scanner leia = new Scanner(System.in);
        int base, expoente, aux;

        System.out.print("Digite a base da potência: ");
        base = leia.nextInt();

        System.out.print("Digite o expoente da potência: ");
        expoente = leia.nextInt();

        aux = base;
        for (int control = 1; control < expoente; control++) {
            base *= aux;
        }

        System.out.println("Resultado: " + base);
    }
}
