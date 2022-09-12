package lote01;

public class exc43 {
    public static void main(String[] args) {
        int contador = 0;
        float maria = 1.5f, ana = 1.1f;

        while (ana < maria) {
            ana += 0.03;
            maria += 0.02;
            contador++;

            System.out.println("Ana = " + ana + "; Maria = " + maria + "\n");
        }

        System.out.println("Crescendo 3cm por ano, Ana levará " + contador + " para ser maior que Maria, que cresce 2cm ao ano");
    }
}
