package tech.ada.livrosgestao.emprestimo;

import jakarta.persistence.*;
import tech.ada.livrosgestao.livro.Livro;
import tech.ada.livrosgestao.membro.Membro;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmprestimo;
    private LocalDateTime dataRetirada;
    private LocalDateTime dataDevolucao;
    private int diasAtrasados;
    private int multa;

    @OneToOne
    @JoinColumn(name = "membro_id")
    private Membro membro;

    @OneToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

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
        return dataRetirada.plusDays(10);
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
        long diasDeAtraso = ChronoUnit.DAYS.between(dataDevolucao, LocalDateTime.now());
        if (diasDeAtraso > 0) {
            diasAtrasados = (int) diasDeAtraso;
            multa = diasAtrasados * 10; // 10 reais por dia de atraso
            return multa;
        } else {
            diasAtrasados = 0;
            multa = 0;
            return multa;
        }
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void calcularMulta() {
        long diasDeAtraso = ChronoUnit.DAYS.between(dataDevolucao, LocalDateTime.now());
        if (diasDeAtraso > 10) {
            diasAtrasados = (int) diasDeAtraso;
            multa = diasAtrasados * 10; // 10 reais por dia de atraso
        } else {
            diasAtrasados = 0;
            multa = 0;
        }
    }
}
