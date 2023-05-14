package contacorrente;

public class ContasCorrentes {
    int codConta;
    String nomeCliente;
    double saldoConta;
    double limiteConta;
    int tipoConta;

    public ContasCorrentes() {
    }

    public ContasCorrentes(int codConta, String nomeCliente, double saldoConta, double limiteConta, int tipoConta) {
        this.codConta = codConta;
        this.nomeCliente = nomeCliente;
        this.saldoConta = saldoConta;
        this.limiteConta = limiteConta;
        this.tipoConta = tipoConta;
    }

    @Override
    public String toString() {
        return "ContasCorrentes{" +
                "codConta=" + codConta +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", saldoConta=" + saldoConta +
                ", limiteConta=" + limiteConta +
                ", tipoConta=" + tipoConta +
                '}';
    }
}
