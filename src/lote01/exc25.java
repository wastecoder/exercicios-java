package lote01;

public class exc25 {
    public static void main(String[] args) {
        prazo24h(22, 8, 15, 34);
        prazo24h(10, 0, 10, 55);
        prazo24h(10, 23, 15, 46);
    }

    public static void prazo24h(int horaInicio, int minutoInicio, int horaFim, int minutoFim) {
        int minutoTotal, totalInicio, totalFinal, horaTotal;

        totalInicio = (60*horaInicio) + minutoInicio;
        totalFinal = (60*horaFim) + minutoFim;

        System.out.println(">>> Hora de início = " + horaInicio + ":" + minutoInicio);
        System.out.println(">>> Hora do final = " + horaFim + ":" + minutoFim);

        if (horaInicio < horaFim) { //Terminou no mesmo dia
            minutoTotal = (totalFinal - totalInicio);
            horaTotal = minutoTotal/60;
            System.out.println(">>> Tempo total = " + horaTotal + "h" + (minutoTotal%60) +"min");
            System.out.println(">>> Terminou dentro do prazo de 24h!\n");
        } else { //Terminou em outro dia
            minutoTotal = (1440 - totalInicio) + totalFinal;
            horaTotal = minutoTotal/60;
            System.out.println(">>> Tempo total = " + horaTotal + "h" + (minutoTotal%60) +"min");

            if (minutoTotal < 1440) {
                System.out.println(">>> Terminou dentro do prazo de 24h!\n");
            } else {
                System.out.println(">>> Ultrapassou o prazo de 24h!\n");
            }
        }
    }
}
