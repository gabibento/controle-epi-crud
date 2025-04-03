package gerenciadores;

import entidades.Devolucao;
import entidades.Emprestimo;
import entidades.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDevolucao {
    Scanner scanner = new Scanner(System.in);
    private List<Devolucao> devolucoes;

    GerenciadorEmprestimo gerenciadorEmprestimo = new GerenciadorEmprestimo();

    public void criarDevolucao(){
        System.out.println("Empréstimo: ");
        Emprestimo emprestimo = gerenciadorEmprestimo.buscarEmprestimo();

        try{
            devolucoes.add(new Devolucao(emprestimo, gerenciadorEmprestimo.buscarDataDevolucao()));
            System.out.println("Devolução criada com sucesso!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarDevolucoes() {
        devolucoes.forEach(devolucao -> System.out.println((devolucoes.indexOf(devolucao) + 1) + ": " + devolucao.getEmprestimo().toString() + " - "  + devolucao.getDataDevolucao()));
    }
    public Devolucao buscarDevolucao(){
        try {
            listarDevolucoes();
            System.out.println("Digite o índice da devolução: ");

            Devolucao devolucao = devolucoes.get(scanner.nextInt() - 1);
            scanner.nextLine();
            if (devolucao == null)
                throw new IllegalArgumentException("Erro ao encontrar a devolução. Tente novamente!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            buscarDevolucao();
        }
        return null;
    }
    public void atualizarDevolucao(){
        try {
            Devolucao devolucao = buscarDevolucao();

            System.out.println("1. Atualizar empréstimo\n2. Atualizar data de devolução");
            int opcao = scanner.nextInt();
            if (opcao == 1) {
                gerenciadorEmprestimo.listarEmprestimos();
                devolucao.setEmprestimo(gerenciadorEmprestimo.buscarEmprestimo());
            } else if (opcao == 2) {
                devolucao.setDataDevolucao(gerenciadorEmprestimo.buscarDataDevolucao());
            } else {
                throw new IllegalArgumentException("Opção inválida. Tente novamente!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            atualizarDevolucao();
        }
    }
    public void removerDevolucao(){
        try {
            devolucoes.remove(buscarDevolucao());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
