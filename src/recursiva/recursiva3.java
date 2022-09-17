package recursiva;

import java.util.Scanner;

public class recursiva3 {
    //Serie3 = (1/1) + (1/2) + (1/3) + ... + (1/N)
    //n(3) = (1/3) + (1/2) + (1/1) = 1.83; n(4) = 2.08
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        float numero, retorno;

        System.out.print("Digite o final da série: ");
        numero = leia.nextFloat();

        retorno = somaSerie(numero);
        System.out.format("\nSoma da série = %.2f", retorno);
    }

    static float somaSerie(float denominador) {
        if (denominador != 1) {
//            System.out.print("(" + 1 + "/" + denominador + ") + ");
            return (1 / denominador) + somaSerie(--denominador);
        } else {
//            System.out.println("(1/1)");
            return 1;
        }
    }
}
