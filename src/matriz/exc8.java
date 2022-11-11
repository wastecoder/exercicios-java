package matriz;

import java.util.Scanner;

public class exc8 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int[][] matriz = new int[4][3];
        int[] vendaCadaProduto = new int[3];
        int[] vendaCadaSemana = new int[4];
        int vendaMes = 0;

        for (int semana = 0; semana < 4; semana++) {
            for (int produto = 0; produto < 3; produto++) {
                System.out.print((semana + 1) + "� semana >> digite a quantidade vendida do " + (produto + 1) + "� produto: " );
                matriz[semana][produto] = leia.nextInt();

                vendaMes += matriz[semana][produto];
                vendaCadaSemana[semana] += matriz[semana][produto];
                vendaCadaProduto[produto] += matriz[semana][produto];
            }
            System.out.println();
        }

        System.out.println(">>> C�lculo das vendas");
        for (int control = 0; control < 7; control++) {
            if (control < 3) {
                System.out.println("A) " + (control + 1) + "� produto >> " + vendaCadaProduto[control]);
            } else {
                System.out.println("B) " + (control - 2) + "� semana >>> " + vendaCadaSemana[control - 3]);
            }
        }
        System.out.println("C) Produtos no m�s >> " + vendaMes);
    }
}
