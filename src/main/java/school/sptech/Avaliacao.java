package school.sptech;

public class Avaliacao {
    private String descricao;
    private Double qtdEstrelas;

    public Avaliacao(String descricao, Double qtdEstrelas) {
        this.descricao = descricao;
        this.qtdEstrelas = qtdEstrelas;
    }

    public Double getQtdEstrelas() {
        return qtdEstrelas;
    }

    public void setQtdEstrelas(Double qtdEstrelas) {
        this.qtdEstrelas = qtdEstrelas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "descricao='" + descricao + '\'' +
                ", qtdEstrelas=" + qtdEstrelas +
                '}';
    }
}
