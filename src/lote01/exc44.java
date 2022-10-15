package lote01;

import java.util.Scanner;

public class exc44 {
    public static void main(String[] args) { // FALTA ESSE
        Scanner leia = new Scanner(System.in);
        int base, expoente, res = 1;

        System.out.print("Digite a base da potência: ");
        base = leia.nextInt();

        System.out.print("Digite o expoente da potência: ");
        expoente = leia.nextInt();

        for (int control = 1; control <= expoente; control++) {
            res *= base;
        }

        System.out.println(base + "^" + expoente +" = " + res);
    }
}
