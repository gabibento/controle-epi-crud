package gerenciadores;

import entidades.Emprestimo;
import entidades.Epi;
import entidades.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorEmprestimo {
    Scanner scanner = new Scanner(System.in);
    private List<Emprestimo> emprestimos;

    GerenciadorUsuario gerenciadorUsuario;
    GerenciadorEpi gerenciadorEpi;

    public GerenciadorEmprestimo(GerenciadorUsuario gerenciadorUsuario, GerenciadorEpi gerenciadorEpi) {
        emprestimos = new ArrayList<>();
        this.gerenciadorUsuario = gerenciadorUsuario;
        this.gerenciadorEpi = gerenciadorEpi;
    }

    public void criarEmprestimo() {
        try{
            System.out.println("Colaboradores: ");

            Usuario usuario = gerenciadorUsuario.buscarUsuario();

            System.out.println("EPIs");
            Epi epi = gerenciadorEpi.buscarEpi();

            if(usuario != null && epi != null){
                System.out.print("Digite a data de devolução prevista (DD/MM/AAAA): ");
                emprestimos.add(new Emprestimo(epi, usuario, buscarData()));
                System.out.println("Empréstimo criado com sucesso!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listarEmprestimos() {
        if(emprestimos.isEmpty()) System.out.println("Não há empréstimos cadastrados");
        else emprestimos.forEach(emprestimo -> System.out.println((emprestimos.indexOf(emprestimo) + 1) + ": " + emprestimo.toString()));
    }

    public Emprestimo buscarEmprestimo() {
       while (true){
           try {
               listarEmprestimos();
               if(emprestimos.isEmpty()) return null;

               System.out.print("Digite o índice do empréstimo: ");

               Emprestimo emprestimo = emprestimos.get(scanner.nextInt() - 1);
               scanner.nextLine();
               if (emprestimo == null) throw new IllegalArgumentException("Erro ao encontrar empréstimo. Tente novamente!");
               return emprestimo;
           } catch (Exception e) {
               System.out.println(e.getMessage());
           }
       }
    }

    public LocalDate buscarData(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      while(true){
          try{
              String input = scanner.nextLine().trim();

              if (input.isEmpty()) {
                  System.out.println("Entrada vazia. Tente novamente.");
                  continue;
              }
              return LocalDate.parse(input, formatter);
          }catch (Exception e){
              System.out.println("Formato inválido. Use o formato DD/MM/AAAA. Digite novamente: ");
          }
      }
    }

    public void atualizarEmprestimo(){
        try{
            Emprestimo emprestimo = buscarEmprestimo();

            while(true){
                if(emprestimo == null) break;
                System.out.print("1. Atualizar usuário\n" +
                        "2. Atualizar EPI\n" +
                        "3. Atualizar data de empréstimo\n" +
                        "4. Atualizar data de devolução\n" +
                        "5. Voltar\nDigite uma opção: ");
                int opcao = scanner.nextInt();

                if(opcao == 5) break;

                switch (opcao){
                    case 1 -> emprestimo.setUsuario(gerenciadorUsuario.buscarUsuario());
                    case 2 -> emprestimo.setEpi(gerenciadorEpi.buscarEpi());
                    case 3 -> {
                        System.out.print("Digite a data de empréstimo (DD/MM/AAAA): ");
                        emprestimo.setDataEmprestimo(buscarData());
                    }
                    case 4 -> {
                        System.out.print("Digite a data de devolução prevista (DD/MM/AAAA): ");
                        emprestimo.setDataDevolucao(buscarData());
                    }
                }
                System.out.println("Empréstimo atualizado com sucesso!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void removerEmprestimo(){
        try {
            Emprestimo emprestimo = buscarEmprestimo();
           if(emprestimo != null){
               emprestimos.remove(emprestimo);
               System.out.println("Empréstimo removido com sucesso!");
           }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
