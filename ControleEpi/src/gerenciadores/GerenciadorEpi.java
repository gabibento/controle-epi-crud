package gerenciadores;

import entidades.Epi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GerenciadorEpi {
    Scanner scanner = new Scanner(System.in);
    private List<Epi> epis;

    public GerenciadorEpi() {
        epis = new ArrayList<>();
    }

    public void cadastrarEpi(){
        System.out.print("Nome: ");
        String nome = scanner.next();

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();

        Epi epi = new Epi(nome, quantidade);
        epis.add(epi);

        System.out.println("Epi adicionada com sucesso!");
    }
    public void listarEpis(){
        if(epis.isEmpty()) System.out.println("Não há EPIs cadastradas");
        else epis.forEach(epi -> System.out.println((epis.indexOf(epi) + 1) + ": " + epi.toString()));
    }
    public Epi buscarEpi(){
      while(true){
          try{
              listarEpis();
              System.out.print("Digite o índice do EPI: ");

              Epi epi = epis.get(scanner.nextInt() - 1);
              scanner.nextLine();
              if(epi == null) throw new IllegalArgumentException("Erro ao encontrar EPI. Tente novamente!");
              return epi;
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }
    }
    public void atualizarEpi(){
       try{
           Epi epi = buscarEpi();

           while(true){
               System.out.print("1. Atualizar nome \n2. Atualizar quantidade\n3. Voltar\nDigite uma opção: ");
               int opcao = scanner.nextInt();
               scanner.nextLine();

               if(opcao == 1){
                   System.out.print("Novo nome: ");
                   epi.setNome(scanner.nextLine());
               }else if(opcao == 2){
                   System.out.print("Nova quantidade: ");
                   epi.setQuantidade(scanner.nextInt());
               }
               else if(opcao == 3) break;
               else{
                   throw new IllegalArgumentException("Opção inválida. Tente novamente");
               }
           }
       }catch (Exception e){
           System.out.println(e.getMessage());
           atualizarEpi();
       }
    }
    public void removerEpi(){
        try{
            Epi epi = buscarEpi();
            epis.remove(epi);
            System.out.println("EPI removida com sucesso!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
