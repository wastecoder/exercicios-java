package lote01;

import java.time.LocalDate;

public class exc30 {
    public static void main(String[] args) {
        //TODO: meses contando como 1 a mais na maioria das datas
        tempoVivido(10, 11, 2003); //Meses certo
        tempoVivido(25, 3, 2009); //Meses errado

        /* SITES PARA VALIDAÇÃO:
        http://www.escoladavida.eng.br/Cronometro.htm
        https://howoldagecalculator.com/how-many-days-months-seconds-have-i-been-alive
         */
    }

    static int diasMes(int mesAtual, int anoAtual) {
        return switch (mesAtual) {
            case 2 -> anoBinaro(anoAtual);
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            default -> -999;
        };
    }

    static int anoBinaro(int anoAtual) {
        if ((anoAtual % 4 == 0 && !(anoAtual % 100 == 0)) || anoAtual % 400 == 0) {
            return 29;
        } else {
            return 28;
        }
    }

    static void tempoVivido(int diaNascimento, int mesNascimento, int anoNascimento) {
        int diaAtual, mesAtual, anoAtual, diasAcumulados = 0, anosAcumulados = 0, mesesAcumulados = 0;

        LocalDate dataAtual = LocalDate.now();
        diaAtual = dataAtual.getDayOfMonth();
        mesAtual = dataAtual.getMonthValue();
        anoAtual = dataAtual.getYear();


        for (int ano = anoNascimento; ano <= anoAtual; ano++) { //Todos os anos
            //anosDebugger(ano, anosAcumulados);

            for (int mes = 1; mes <= 12; mes++) { //Meses de cada ano
                if (ano == anoNascimento) { //Mesmo ano de nascimento
                    for (int primeirosMeses = mesNascimento; primeirosMeses <= 12; primeirosMeses++) {
                        mesesAcumulados++;
                        //mesesDebugger(primeirosMeses, mesesAcumulados);

                        if (primeirosMeses == mesNascimento) { //Primeiro mês de vida
                            diasAcumulados = diasMes(primeirosMeses, ano) - diaNascimento;
                            //diasDebugger(diasMes(primeirosMeses, ano), diasAcumulados);
                        } else {
                            diasAcumulados += diasMes(primeirosMeses, ano);
                            //diasDebugger(diasMes(primeirosMeses, ano), diasAcumulados);
                        }
                    }
                    break;


                } else { //Não é o mesmo ano de nascimento
                    if (ano == anoAtual && mes == mesAtual) { //Último mês
                        diasAcumulados += diaAtual;
                        //diasDebugger(diasMes(mes, ano), diasAcumulados);

                        if (mesNascimento == mes && ((diasMes(mes, ano) - diaNascimento) >= diaNascimento)) { //Aniversário por mês e dias
                            //Último mês: totalDiasMês - diaAtual >= diaNascimento
                            anosAcumulados++;
                        }
                        break;

                    }else { //Não é o último mês
                        diasAcumulados += diasMes(mes, ano);
                        //diasDebugger(diasMes(mes, ano), diasAcumulados);
                        mesesAcumulados += 1;
                        //mesesDebugger(mes, mesesAcumulados);

                        if (mesNascimento == mes) { //Aniversários por mês (não dias)
                            anosAcumulados++;
                        }
                    }
                }
            }
        }


        System.out.println("\n+--------------------------+");
        System.out.println("|     ENTRADA DE DADOS     |");
        System.out.println("+--------------------------+");
        System.out.println("| NASCIMENTO >> " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + "  |");
        System.out.println("| ATUAL      >> " + diaAtual + "/" + mesAtual + "/" + anoAtual + " |");
        System.out.println("+--------------------------+");

        System.out.println("+---------------+");
        System.out.println("|   RESULTADO   |");
        System.out.println("+---------------+");
        System.out.println("| ANOS  >> " + anosAcumulados +"   |");
        System.out.println("| MESES >> " + mesesAcumulados + "  |");
        System.out.println("| DIAS  >> " + diasAcumulados + " |");
        System.out.println("+---------------+\n");
    }

    static void anosDebugger(int anoRelativo, int anoAcumulador) {
        System.out.println("\n>>> ANO >> " + anoRelativo + " >> " + anoAcumulador);
    }

    static void mesesDebugger(int mesRelativo, int mesAcumulador) {
        System.out.println(">> MES >> " + mesRelativo + " >> " + mesAcumulador);
    }

    static void diasDebugger(int diasMesRelativo, int disAcumulador) {
        System.out.println("> DIA >> " + diasMesRelativo + " >> " + disAcumulador);
    }
}
