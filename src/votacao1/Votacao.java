package votacao1;

public abstract class Votacao implements Comparable<Votacao> {
    private int numeroSecao;
    private int numeroCandidato;

    public Votacao() {
    }

    public Votacao(int numeroSecao, int numeroCandidato) {
        this.numeroSecao = numeroSecao;
        this.numeroCandidato = numeroCandidato;
    }

    public int getNumeroSecao() {
        return numeroSecao;
    }

    public void setNumeroSecao(int numeroSecao) {
        this.numeroSecao = numeroSecao;
    }

    public int getNumeroCandidato() {
        return numeroCandidato;
    }

    public void setNumeroCandidato(int numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }

    @Override
    public String toString() {
        return "Votacao{" +
                "N�mero se��o: " + numeroSecao +
                "; N�mero candidato: " + numeroCandidato +
                '}';
    }

    //Ordena��o a partir da se��o
    @Override
    public int compareTo(Votacao outraVotacao) {
        return Integer.compare(numeroSecao, outraVotacao.getNumeroSecao());
    }
}
