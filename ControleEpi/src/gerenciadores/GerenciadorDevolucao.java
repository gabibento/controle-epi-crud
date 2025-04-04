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

    GerenciadorEmprestimo gerenciadorEmprestimo;

    public GerenciadorDevolucao(GerenciadorEmprestimo gerenciadorEmprestimo) {
       devolucoes = new ArrayList<>();
       this.gerenciadorEmprestimo = gerenciadorEmprestimo;
    }

    public void criarDevolucao(){
        System.out.println("Empréstimo: ");
        Emprestimo emprestimo = gerenciadorEmprestimo.buscarEmprestimo();

        try{
            System.out.print("Digite a data de devolução (DD/MM/AAAA): ");
            LocalDate data = gerenciadorEmprestimo.buscarData();

            devolucoes.add(new Devolucao(emprestimo, data));
            System.out.println("Devolução criada com sucesso!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarDevolucoes() {
        if(devolucoes.isEmpty()) System.out.println("Não há devoluções cadastradas");
        else devolucoes.forEach(devolucao -> System.out.println((devolucoes.indexOf(devolucao) + 1) + ": " + devolucao.toString()));
    }
    public Devolucao buscarDevolucao(){
        try {
            listarDevolucoes();
            if(devolucoes.isEmpty()) return null;

            System.out.print("Digite o índice da devolução: ");

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
               if(devolucao == null) break;
               System.out.print("1. Atualizar empréstimo\n2. Atualizar data de devolução\n3. Voltar\nDigite uma opção: ");
               int opcao = scanner.nextInt();
               scanner.nextLine();

               if (opcao == 1) {
                   gerenciadorEmprestimo.listarEmprestimos();
                   devolucao.setEmprestimo(gerenciadorEmprestimo.buscarEmprestimo());
               } else if (opcao == 2) {
                   System.out.print("Digite a data de devolução (DD/MM/AAAA): ");
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
            Devolucao devolucao = buscarDevolucao();
           if(devolucao != null){
               devolucoes.remove(devolucao);
               System.out.println("Devolução removida com sucesso!");
           }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
