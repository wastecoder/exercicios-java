package recursiva;

public class recursiva1 {
    //Serie1 = (1 + 2 + 3 + ... + 100) = 5050
    public static void main(String[] args) {
        System.out.println("\nSoma da série (1 >>> 100) = " + somaSerie(100));
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
