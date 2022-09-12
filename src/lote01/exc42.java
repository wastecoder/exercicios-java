package lote01;

public class exc42 {
    public static void main(String[] args) {
        float soma = 0;

        for (float control = 1; control <= 50; control++) {
            soma += control/((control*2)-1);
            //System.out.println(control + "/" + ((control*2)-1));
        }

        System.out.println("Soma da série: " + soma);
    }
}
