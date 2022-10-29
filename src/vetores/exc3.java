package vetores;

import java.util.Arrays;

public class exc3 {
    public static void main(String[] args) {
        int[] vetor1 = {1, 2, 3};
        int[] vetor2 = {4, 5, 6};
        int[] vetor3 = new int[6];

        for (int control = 0; control < vetor3.length; control++) {
            if (control <= 2) {
                vetor3[control] = vetor1[control];
            } else {
                vetor3[control] = vetor2[control - 3];
            }
        }

        System.out.println("1º vetor = " + Arrays.toString(vetor1));
        System.out.println("2º vetor = " + Arrays.toString(vetor2));
        System.out.println("3º vetor = " + Arrays.toString(vetor3));
    }
}
