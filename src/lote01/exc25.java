package lote01;

public class exc25 {
    public static void main(String[] args) {
        prazo24h(22, 8, 15, 34);
        prazo24h(10, 0, 10, 55);
        prazo24h(10, 23, 15, 46);
        prazo24h(12, 20, 10, 10);
    }

    public static void prazo24h(int horaInicio, int minutoInicio, int horaFim, int minutoFim) {
        int horaTotal = horaFim - horaInicio;
        int minutoTotal = minutoFim - minutoInicio;

        if (horaTotal < 0) { //Dia diferente
            horaTotal += 24;
        }
        if (minutoTotal < 0) {
            horaTotal--;
            minutoTotal += 60;
        }

        System.out.println(">>> Tempo total = " + horaTotal + "h" + minutoTotal +"min");
    }
}
