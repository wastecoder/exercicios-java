package matriz;

public class exc10 {
    public static void main(String[] args) {
        long[][] matriz = new long[8][8];
        long aux = 1;

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                matriz[x][y] = aux;
                aux *= 2;
//                soma += matriz[x][y]; //Não somei, porque estouraria a memória
            }
        }

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                System.out.print(matriz[x][y] + " ");
            }
            System.out.println();
        }
    }
}
