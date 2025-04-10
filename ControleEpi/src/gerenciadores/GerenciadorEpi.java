package gerenciadores;

import entidades.Epi;

import java.util.*;

public class GerenciadorEpi {
    Scanner scanner = new Scanner(System.in);
    private List<Epi> epis;

    public GerenciadorEpi() {
        epis = new ArrayList<>();
    }

    public void cadastrarEpi(){
       try {
           System.out.print("Nome: ");
           String nome = scanner.nextLine();

           System.out.print("Quantidade: ");
           int quantidade = scanner.nextInt();
           scanner.nextLine();

           Epi epi = new Epi(nome, quantidade);
           epis.add(epi);

           System.out.println("Epi adicionada com sucesso!");
       }catch (Exception e){
           System.out.println("Erro ao cadastrar EPI");
           scanner.nextLine();
       }
    }
    public void listarEpis(){
        if(epis.isEmpty()) System.out.println("Não há EPIs cadastradas");
        else epis.forEach(epi -> System.out.println((epis.indexOf(epi) + 1) + ": " + epi.toString()));
    }
    public Epi buscarEpi(){
      while(true){
          try{
              listarEpis();
              if(epis.isEmpty()) return null;

              System.out.print("Digite o índice do EPI: ");
              int indice = scanner.nextInt();
              scanner.nextLine();

              Epi epi = epis.get(indice - 1);

              if(epi == null) throw new IllegalArgumentException("Erro ao encontrar EPI. Tente novamente!");
              return epi;
          } catch (IndexOutOfBoundsException e) {
              System.out.println("Índice inválido. Tente novamente.");
              scanner.nextLine();
          } catch (InputMismatchException e) {
              System.out.println("Entrada inválida. Digite um número válido.");
              scanner.nextLine();
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }
    }
    public void atualizarEpi(){
        Epi epi = buscarEpi();
        while(true) {
            try {
                if (epi == null) break;

                System.out.print("1. Atualizar nome \n2. Atualizar quantidade\n3. Voltar\nDigite uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 1) {
                    System.out.print("\nNovo nome: ");
                    epi.setNome(scanner.nextLine());
                } else if (opcao == 2) {
                    System.out.print("Nova quantidade: ");
                    epi.setQuantidade(scanner.nextInt());
                    scanner.nextLine();
                } else if (opcao == 3) break;
                else {
                    throw new IllegalArgumentException("Opção inválida. Tente novamente: ");
                }
                System.out.println("EPI atualizada com sucesso!\n");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void removerEpi(){
        try{
            Epi epi = buscarEpi();
            if(epi != null) {
                epis.remove(epi);
                System.out.println("EPI removida com sucesso!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
