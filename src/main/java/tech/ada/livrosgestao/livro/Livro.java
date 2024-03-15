package tech.ada.livrosgestao.livro;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tech.ada.livrosgestao.membro.Membro;

import java.time.LocalDateTime;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private Long isbn;
    @NotNull(message = "Titulo não pode estar nulo")
    @NotBlank(message = "Titulo não pode estar em branco")
    private String titulo;
    private String autor;
    private String genero;
    private LocalDateTime anoPublicacao;
    private boolean emprestado;


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
