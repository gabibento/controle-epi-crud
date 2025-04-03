package gerenciadores;

import entidades.Devolucao;
import entidades.Emprestimo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDevolucao {
    Scanner scanner = new Scanner(System.in);
    private List<Devolucao> devolucoes;

    GerenciadorEmprestimo gerenciadorEmprestimo = new GerenciadorEmprestimo();

    public GerenciadorDevolucao() {
       devolucoes = new ArrayList<>();
    }

    public void criarDevolucao(){
        System.out.println("Empréstimo: ");
        Emprestimo emprestimo = gerenciadorEmprestimo.buscarEmprestimo();

        try{
            System.out.println("Digite a data de devolução (DD/MM/AAAA): ");
            LocalDate data = gerenciadorEmprestimo.buscarData();

            devolucoes.add(new Devolucao(emprestimo, data));
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

           while(true){
               System.out.println("1. Atualizar empréstimo\n2. Atualizar data de devolução\n3. Voltar");
               int opcao = scanner.nextInt();
               scanner.nextLine();

               if (opcao == 1) {
                   gerenciadorEmprestimo.listarEmprestimos();
                   devolucao.setEmprestimo(gerenciadorEmprestimo.buscarEmprestimo());
               } else if (opcao == 2) {
                   System.out.println("Digite a data de devolução (DD/MM/AAAA): ");
                   devolucao.setDataDevolucao(gerenciadorEmprestimo.buscarData());
               } else if(opcao == 3) break;
               else {
                   throw new IllegalArgumentException("Opção inválida. Tente novamente!");
               }
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
