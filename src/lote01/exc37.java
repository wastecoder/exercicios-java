package lote01;

import java.util.Scanner;

public class exc37 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int numero, res = 1, primeiro = 0, segundo = 1;

        System.out.println("Digite a quantidade de séries: ");
        numero = leia.nextInt();

        //      = 1
        //0 + 1 = 1
        //1 + 1 = 2
        //1 + 2 = 3
        for (int controlador = 1; controlador <= numero; controlador++) {
            System.out.println("a" + controlador + " = " + res);
            res = primeiro + segundo;
            primeiro = segundo;
            segundo = res;
        }
    }
}
