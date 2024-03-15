package tech.ada.livrosgestao.membro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

//@JsonIgnoreProperties({"senha"})
public class MembroRequest {

    private Integer inscricao;
    private String nome;
    private Integer idade;
    private String email;
    private String celular;
    @NotNull(message = "Senha não pode ser null")
    @NotBlank(message = "Senha não pode estar em branco")
    @Pattern(regexp = "[\\w.]{5,20}")
    private String senha;


    public Integer getInscricao() {
        return inscricao;
    }

    public void setInscricao(Integer inscricao) {
        this.inscricao = inscricao;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
