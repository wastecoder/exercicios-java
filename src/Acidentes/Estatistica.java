package Acidentes;

public final class Estatistica {
    private int codigoCidade;
    private String nomeCidade;
    private int quantidadeAcidentes;

    public Estatistica() {
    }

    public Estatistica(int codigoCidade, String nomeCidade, int quantidadeAcidentes) {
        this.codigoCidade = codigoCidade;
        this.nomeCidade = nomeCidade;
        this.quantidadeAcidentes = quantidadeAcidentes;
    }

    public int getCodigoCidade() {
        return codigoCidade;
    }

    public void setCodigoCidade(int codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public int getQuantidadeAcidentes() {
        return quantidadeAcidentes;
    }

    public void setQuantidadeAcidentes(int quantidadeAcidentes) {
        this.quantidadeAcidentes = quantidadeAcidentes;
    }

    @Override
    public String toString() {
        return ">> Código cidade: " + codigoCidade +
                "; Nome cidade: " + nomeCidade +
                "; Quantidade acidentes: " + quantidadeAcidentes;
    }
}
