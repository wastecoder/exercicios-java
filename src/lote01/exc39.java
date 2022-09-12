package lote01;

public class exc39 {
    public static void main(String[] args) {
        float quantidade = 1;
        for (int casa = 1; casa <= 64; casa++) {
            quantidade *= 2;
        }

        System.out.println("Quantidade de grãos = " + quantidade);
    }
}
