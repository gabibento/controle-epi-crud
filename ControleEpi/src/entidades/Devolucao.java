package entidades;

import java.time.LocalDate;

public class Devolucao {
    private Emprestimo emprestimo;
    private LocalDate dataDevolucao;

    public Devolucao(Emprestimo emprestimo, LocalDate dataDevolucao) {
        this.emprestimo = emprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
