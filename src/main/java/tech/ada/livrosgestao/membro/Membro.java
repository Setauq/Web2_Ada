package tech.ada.livrosgestao.membro;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tech.ada.livrosgestao.endereco.EnderecoEntity;


@Entity
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inscricao;
    @NotNull(message = "Nome não pode estar nulo")
    @NotBlank(message = "Nome não pode estar em branco")
    private String nome;
    private Integer idade;
    @NotNull(message = "Email não pode estar nulo")
    @NotBlank(message = "Email não pode estar em branco")
    private String email;
    private String celular;
    @NotNull(message = "Senha não pode estar nula")
    @NotBlank(message = "Senha não pode estar em branco")
    private String senha;
    @OneToOne
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity endereco;

    public Membro() {
    }

    public Membro(Membro item) {
        this.inscricao = inscricao;
    }

    public Membro(MembroRequest request) {
        this.inscricao = request.getInscricao();
        this.nome = request.getNome();
        this.idade = request.getIdade();
        this.email = request.getEmail();
        this.celular = request.getCelular();
        this.senha = request.getSenha();
    }

    public Integer getInscricao() {
        return inscricao;
    }

    public void setInscricao(Integer inscricao) {
        this.inscricao = inscricao;
    }

    public void setInscriacao(Integer inscriacao) {
        this.inscricao = inscriacao;
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

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }
}
