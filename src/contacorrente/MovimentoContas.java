package contacorrente;

public class MovimentoContas {
    int codConta;
    double valorMovimentado;
    int tipoMovimento;
    int status;

    public MovimentoContas() {
    }

    public MovimentoContas(int codConta, double valorMovimentado, int tipoMovimento, int status) {
        this.codConta = codConta;
        this.valorMovimentado = valorMovimentado;
        this.tipoMovimento = tipoMovimento;
        this.status = status;
    }

    @Override
    public String toString() {
        return "MovimentoContas{" +
                "codConta=" + codConta +
                ", valorMovimentado=" + valorMovimentado +
                ", tipoMovimento=" + tipoMovimento +
                ", status=" + status +
                '}';
    }
}
