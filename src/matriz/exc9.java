package matriz;

public class exc9 {
    public static void main(String[] args) {
        int[][] matriz = new int[4][4]; //Deixe x = y
        int min = 10, max = 90;         //Gera números aleatórios de 10 a 100

        for (int linhas = 0; linhas < matriz.length; linhas++) {
            for (int colunas = 0; colunas < matriz[0].length; colunas++) {
                if (linhas == colunas) {
                    matriz[linhas][colunas] = (int) Math.pow(4, linhas);
                } else {
                    matriz[linhas][colunas] = (int) (Math.random() * max + min);
                }
            }
        }

        for (int linhas = 0; linhas < matriz.length; linhas++) {
            System.out.println();
            for (int colunas = 0; colunas < matriz[0].length; colunas++) {
                if (linhas == colunas) {
                    System.out.print(matriz[linhas][colunas] + " ");
                } else {
                    System.out.print("   ");
                }
            }
        }
    }
}
