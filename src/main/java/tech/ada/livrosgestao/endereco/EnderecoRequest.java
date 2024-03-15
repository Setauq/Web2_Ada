package tech.ada.livrosgestao.endereco;



public class EnderecoRequest {

    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public EnderecoRequest() {
    }

    public EnderecoRequest(EnderecoEntity enderecoEntity) {
        this.logradouro = enderecoEntity.getLogradouro();
        this.numero = enderecoEntity.getNumero();
        this.bairro = enderecoEntity.getBairro();
        this.cidade = enderecoEntity.getCidade();;
        this.estado = enderecoEntity.getEstado();
        this.cep = enderecoEntity.getCep();
    }

    // Getters and Setters
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }


}
