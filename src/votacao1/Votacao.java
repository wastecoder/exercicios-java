package votacao1;

public class Votacao {
    int numeroSecao;
    int numeroCandidato;

    public Votacao() {
    }

    @Override
    public String toString() {
        return "Votacao{" +
                "Número seção: " + numeroSecao +
                "; Número candidato: " + numeroCandidato +
                '}';
    }
}
