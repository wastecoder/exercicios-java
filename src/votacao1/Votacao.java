package votacao1;

public class Votacao {
    int numeroSecao;
    int numeroCandidato;

    public Votacao() {
    }

    @Override
    public String toString() {
        return "Votacao{" +
                "N�mero se��o: " + numeroSecao +
                "; N�mero candidato: " + numeroCandidato +
                '}';
    }
}
