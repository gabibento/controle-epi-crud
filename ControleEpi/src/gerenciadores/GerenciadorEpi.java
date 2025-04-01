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
        System.out.println("Nome: ");
        String nome = scanner.next();

        System.out.println("Quantidade: ");
        int quantidade = scanner.nextInt();

        Epi epi = new Epi(nome, quantidade);
        epis.add(epi);

        System.out.println("Epi adicionada com sucesso!");
    }
    public void listarEpis(){
        epis.forEach(epi -> System.out.println((epis.indexOf(epi) + 1) + ": " + epi.getNome() + " - " + epi.getQuantidade()));
    }
    public Epi buscarEpi(){
      try{
           listarEpis();
           System.out.println("Digite o índice do EPI: ");

           Epi epi = epis.get(scanner.nextInt() - 1);
           scanner.nextLine();
           if(epi == null) throw new IllegalArgumentException("Erro ao encontrar EPI. Tente novamente!");
           return epi;
       } catch (Exception e) {
           System.out.println(e.getMessage());
           buscarEpi();
       }
       return null;
    }
    public void atualizarEpi(){
       try{
           Epi epi = buscarEpi();
           System.out.println("1. Atualizar nome \n2. Atualizar quantidade");
           int opcao = scanner.nextInt();
           if(opcao == 1){
               System.out.println("Novo nome: ");
               epi.setNome(scanner.nextLine());
           }else if(opcao == 2){
               System.out.println("Nova quantidade: ");
               epi.setQuantidade(scanner.nextInt());
           }else{
               throw new IllegalArgumentException("Opção inválida. Tente novamente");
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
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
