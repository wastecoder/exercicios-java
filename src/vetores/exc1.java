package vetores;

import java.util.Scanner;

public class exc1 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int[] valores = new int[10];
        int somaImpares = 0, auxIntervalo = 0;
        float mediaIntervalo = 0;

        for (int control = 0; control < valores.length; control++) {
            System.out.print("Digite o " + (control + 1) + "º valor: ");
            valores[control] = leia.nextInt();

            if (valores[control] >= 10 && valores[control] <= 200) {
                mediaIntervalo += valores[control];
                auxIntervalo++;
            }
            if (valores[control] % 2 != 0) {
                somaImpares += valores[control];
            }
        }
        mediaIntervalo = mediaIntervalo / auxIntervalo;

        System.out.println("\nMédia dos números no intervalo [10-200] = " + mediaIntervalo);
        System.out.println("Soma dos ímpares = " + somaImpares);
    }
}
