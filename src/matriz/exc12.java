package matriz;

public class exc12 {
    public static void main(String[] args) {
        int[][] tabuleiro = new int[8][8];
        int[] contagemPecas = new int[7];

        int vazio = 0;
        int peao = 1;
        int torre = 2;
        int cavalo = 3;
        int bispo = 4;
        int rainha = 5;
        int rei = 6;

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (x == 0 || x == 7) {
                    if (y == 0 || y == 7) {
                        tabuleiro[x][y] = torre;
                    } else if (y == 1 || y == 6) {
                        tabuleiro[x][y] = cavalo;
                    } else if (y == 2 || y == 5) {
                        tabuleiro[x][y] = bispo;
                    } else if (y == 3) {
                        tabuleiro[x][y] = rei;
                    } else {
                        tabuleiro[x][y] = rainha;
                    }
                } else if (x == 1 || x == 6) {
                    tabuleiro[x][y] = peao;
                } else {
                    tabuleiro[x][y] = vazio;
                }

                //O índice do contagemPecas[] é o valor em tabuleiro[x][y]
                contagemPecas[tabuleiro[x][y]] += 1;
            }
        }

        System.out.println(">>> Tabuleiro");
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                System.out.print(tabuleiro[x][y] + "  ");
            }
            System.out.println();
        }

        System.out.println("\n>>> Soma das peças");
        for (int x = 0; x < contagemPecas.length; x++) {
            if (x == vazio) {
                System.out.println("Vazio = " + contagemPecas[x]);
            } else if (x == peao) {
                System.out.println("Peão = " + contagemPecas[x]);
            } else if (x == torre) {
                System.out.println("Torre = " + contagemPecas[x]);
            } else if (x == cavalo) {
                System.out.println("Cavalo = " + contagemPecas[x]);
            } else if (x == bispo) {
                System.out.println("Bispo = " + contagemPecas[x]);
            } else if (x == rainha) {
                System.out.println("Rainha = " + contagemPecas[x]);
            } else {
                System.out.println("Rei = " + contagemPecas[x]);
            }
        }
    }
}
