package school.sptech;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes;

    public Livro(String titulo, String autor, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.avaliacoes = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas) {
        Boolean descricaoValida = descricao != null && !descricao.equals(" ");
        Boolean qtdEstrelasValida = qtdEstrelas != null && qtdEstrelas >= 0 && qtdEstrelas <= 5;

        if(descricaoValida && qtdEstrelasValida){
            Avaliacao avaliacao = new Avaliacao(descricao, qtdEstrelas);
            System.out.println(avaliacao);
            avaliacoes.add(avaliacao);
        }
    }

    public Double calcularMediaAvaliacoes() {
        if(avaliacoes.isEmpty()) {
            return 0.0;
        };
        Double media = 0.0;

        for (Avaliacao avaliacaoAtual : avaliacoes) {
            media += avaliacaoAtual.getQtdEstrelas();
        }
        media = media / avaliacoes.size();
        return media;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                '}';
    }
}
