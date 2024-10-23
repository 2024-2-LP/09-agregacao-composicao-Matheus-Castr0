package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarLivro(Livro livro) {
        Boolean livroValido = livro != null;
        if(livroValido) {
            Boolean tituloValido = livro.getTitulo() != null && !livro.getTitulo().isBlank();
            Boolean autorValido = livro.getAutor() != null && !livro.getAutor().isBlank();
            Boolean dataValido = livro.getDataPublicacao() != null;

            if(tituloValido && autorValido && dataValido) {
                this.livros.add(livro);
            }
        }

    }

    public void removerLivroPorTitulo(String titulo) {
        for (int i = 0; i < livros.size(); i++) {
            String tituloAtual = livros.get(i).getTitulo();
            if(tituloAtual.equalsIgnoreCase(titulo)){
                livros.remove(livros.get(i));
            }
        }
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        Boolean tituloValido = titulo != null && !titulo.equals(" ");

        if(tituloValido) {
            for (int i = 0; i < livros.size(); i++) {
                String tituloAtual = livros.get(i).getTitulo();
                if(tituloAtual.equalsIgnoreCase(titulo)){
                    return livros.get(i);
                }
            }
        }
        return null;
    }

    public Integer contarLivros(){
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano) {
        List<Livro> livrosFiltrados = new ArrayList<>();
        for (Livro livroAtual : livros) {
            Integer dataLivro = livroAtual.getDataPublicacao().getYear();
            if(dataLivro <= ano) {
                livrosFiltrados.add(livroAtual);
            }
        }
        return livrosFiltrados;
    }

    public List<Livro> retornarTopCincoLivros() {
        List<Livro> livrosFiltrados = new ArrayList<>();

        Double maiorMedia = 0.0;

        for(Livro livroAtual : livros) {
            Double mediaAvaliacaoLivro = 0.0;
            List<Avaliacao> avaliacoes = livroAtual.getAvaliacoes();

            for(Avaliacao avaliacaoAtual : avaliacoes) {
                mediaAvaliacaoLivro += avaliacaoAtual.getQtdEstrelas();
            };

            if(mediaAvaliacaoLivro > maiorMedia) {
                maiorMedia = mediaAvaliacaoLivro;
                livrosFiltrados.addLast(livroAtual);
            } else {
                livrosFiltrados.addFirst(livroAtual);
            }

        }
        return livrosFiltrados;
    }
}
