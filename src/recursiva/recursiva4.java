package recursiva;

import java.util.Scanner;

public class recursiva4 {
    //Serie4 = (N/1) + (N-1/2) + (N-2/3) + ... + (1/N)
    //n(5) = (5/1) + (4/2) + (3/3) + (2/4) + (1/5) = 8.7
    //n(4) = 6.41; n(3) = 4.33; n(2) = 2.5
    //n(1) = (1/1) ou (1/1) + (1/1) = ???
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        float ultimo, retorno;

        System.out.print("Digite o final da série: ");
        ultimo = leia.nextFloat();

        retorno = somaSerie(ultimo, 1);
        System.out.printf("\nSoma da série = %.2f", retorno);
    }

    static float somaSerie(float numerador, float denominador) {
        if (numerador > 1) {
//            System.out.print("(" + numerador + "/" + denominador + ") + ");
            return (numerador / denominador) + somaSerie(--numerador, ++denominador);
        } else {
//            System.out.println("(" + numerador + "/" + denominador + ")");
            return numerador/denominador;
        }
    }
}
