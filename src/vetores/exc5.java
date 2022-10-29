package vetores;

import java.util.Arrays;

public class exc5 {
    public static void main(String[] args) {
        int soma = 0;
        int[] numeros = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50,
                        55, 60, 65, 70, 75, 80, 85, 90, 95, 100};

        System.out.println(Arrays.toString(numeros));

        for (int control = 0; control < numeros.length; control++) {
            System.out.println((control + 1) + "º cálculo: "
                    +  numeros[control] + " - " + numeros[19 - control] + " = "
                    + (numeros[control] - numeros[19 - control]));
            soma += numeros[control] - numeros[19 - control];
        }

        System.out.println("\nSoma = " + soma);
    }
}
