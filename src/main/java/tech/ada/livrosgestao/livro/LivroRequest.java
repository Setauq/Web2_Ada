package tech.ada.livrosgestao.livro;

import java.time.LocalDateTime;

public class LivroRequest {

    private Integer codigo;
    private Long isbn;
    private String titulo;
    private String autor;
    private String genero;
    private LocalDateTime anoPublicacao;
    private boolean emprestado;

    public LivroRequest() {
    }

    public LivroRequest(Livro entityLivro) {
        this.codigo = entityLivro.getCodigo();
        this.isbn = entityLivro.getIsbn() ;
        this.titulo = entityLivro.getTitulo();
        this.autor = entityLivro.getAutor();
        this.genero = entityLivro.getGenero();
        this.anoPublicacao = entityLivro.getAnoPublicacao();
        this.emprestado = entityLivro.isEmprestado();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDateTime getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(LocalDateTime anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
}
