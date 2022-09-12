package lote01;

public class exc25 {
public static void main(String[] args) {
    int minutoTotal, totalInicio, totalFinal, horaTotal;

        //ENTRADA DE DADOS DO USUÁRIO
    int horaInicio = 22, minutoInicio = 8, horaFim = 15, minutoFim = 34; //17h26min
//    int horaInicio = 10, minutoInicio = 0, horaFim = 10, minutoFim = 55; //24h55min
//    int horaInicio = 10, minutoInicio = 23, horaFim = 15, minutoFim = 46; //5h23min

    totalInicio = (60*horaInicio) + minutoInicio;
    totalFinal = (60*horaFim) + minutoFim;

    if (horaInicio < horaFim) { //Terminou no mesmo dia
        minutoTotal = (totalFinal - totalInicio);
        horaTotal = minutoTotal/60;
//        System.out.println("Comecou = " + horaInicio + ":" + minutoInicio + "; Terminou = " + horaFim + ":" + minutoFim);
//        System.out.println("Minutos = " + minutoTotal + "; Horas = " + (float)minutoTotal/60);
        System.out.println(">>> Tempo total = " + horaTotal + "h" + (minutoTotal%60) +"min");
        System.out.println(">>> Terminou dentro do prazo de 24h!");
    } else { //Terminou em outro dia
        minutoTotal = (1440 - totalInicio) + totalFinal;
        horaTotal = minutoTotal/60;
//        System.out.println("Comecou = " + horaFim + ":" + minutoFim + "; Terminou = " + horaInicio + ":" + minutoInicio);
//        System.out.println("Minutos = " + minutoTotal + "; Horas = " + minutoTotal/60);
        System.out.println(">>> Tempo total = " + horaTotal + "h" + (minutoTotal%60) +"min");

        if (minutoTotal < 1440) {
            System.out.println(">>> Terminou dentro do prazo de 24h!");
        } else {
            System.out.println(">>> Ultrapassou o prazo de 24h!");
        }
    }
}
}
