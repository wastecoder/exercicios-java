package recursiva;

import java.util.Scanner;

public class recursiva2 {
    //Serie2 = (N) + (N-1) + (N-2) + ... + (1)
    //n(100) = 5050; n(50) = 1275; n(5) = 15
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int numero, retorno;

        System.out.print("Digite o final da série: ");
        numero = leia.nextInt();

        retorno = somaSerie(numero);
        System.out.println("\nSoma da série (1 >>> " + numero + ") = " + retorno);
    }

    static int somaSerie(int numero) {
        if (numero != 1) {
//            System.out.print(numero + " + ");
            return numero + somaSerie(--numero);
        } else {
//            System.out.println(1);
            return 1;
        }
    }
}
