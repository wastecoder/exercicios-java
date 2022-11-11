package matriz;

public class exc11 {
    public static void main(String[] args) {
        int[][] matriz = new int[8][8];

            //Método mais curto
        for (int z = 1; z <= 4; z++) {
            for (int x = (z - 1); x <= (8 - z); x++) {
                for (int y = (z - 1); y <= (8 - z); y++) {
                    matriz[x][y] = z;
                }
            }
        }

            //Método convencional
//        for (int linhas = 0; linhas < 8; linhas++) {
//            for (int colunas = 0; colunas < 8; colunas++) {
//                if (linhas == 0 || linhas == 7 || colunas == 0 || colunas == 7) {
//                    matriz[linhas][colunas] = 1;
//                } else if (linhas == 1 || linhas == 6 || colunas == 1 || colunas == 6) {
//                    matriz[linhas][colunas] = 2;
//                } else if (linhas == 2 || linhas == 5 || colunas == 2 || colunas == 5) {
//                    matriz[linhas][colunas] = 3;
//                } else {
//                    matriz[linhas][colunas] = 4;
//                }
//            }
//        }

        for (int linhas = 0; linhas < matriz.length; linhas++) {
            System.out.println();
            for (int colunas = 0; colunas < matriz[0].length; colunas++) {
                System.out.print(matriz[linhas][colunas] + "  ");
            }
        }
    }
}
