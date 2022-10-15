package recursiva;

import java.util.Scanner;

public class recursiva5 {
    //Serie3 = (N)! + (N-1)! + (N-2)! + ... + (1)!
    //n(5) = 153; n(3) = 9
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int ultimo, retorno;

        System.out.print("Digite o final da série: ");
        ultimo = leia.nextInt();

        retorno = somaSerie(ultimo);
        System.out.println("\nSoma da série (1! >>> " + ultimo + "!) = " + retorno);
    }

    static int somaSerie(int numero) {
        if (numero > 1) {
//            System.out.print(fatorial(numero) + " + ");
//            System.out.print(numero + "! + ");
            return fatorial(numero) + somaSerie(--numero);
        } else {
//            System.out.println(1);
            return 1;
        }
    }

    static int fatorial(int numero) {
        if (numero != 1) {
            return numero * fatorial(--numero);
        } else {
            return 1;
        }
    }
}
