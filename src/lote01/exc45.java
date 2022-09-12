package lote01;

public class exc45 {
    public static void main(String[] args) {
        float soma = 0;
        for (float control = 1; control <= 15; control++) {
            soma += control/(control*control);
            System.out.println(control + "/" + (control*control));
        }

        System.out.println("Soma da série: " + soma);
    }
}
