package tech.ada.livrosgestao.emprestimo;

import java.time.LocalDateTime;

public class EmprestimoRequest {

    private Integer idEmprestimo;
    private LocalDateTime dataRetirada;
    private LocalDateTime dataDevolucao;
    private int diasAtrasados;
    private int multa;

    public EmprestimoRequest() {
    }

    public EmprestimoRequest(Emprestimo emprestimo) {
        this.idEmprestimo = emprestimo.getIdEmprestimo();
        this.dataRetirada = emprestimo.getDataRetirada();
        this.dataDevolucao =  emprestimo.getDataDevolucao();
        this.diasAtrasados = emprestimo.getDiasAtrasados();
        this.multa = emprestimo.getMulta();
    }

    public Integer getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Integer idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public LocalDateTime getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDateTime dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getDiasAtrasados() {
        return diasAtrasados;
    }

    public void setDiasAtrasados(int diasAtrasados) {
        this.diasAtrasados = diasAtrasados;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }
}
