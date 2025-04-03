import gerenciadores.GerenciadorDevolucao;
import gerenciadores.GerenciadorEmprestimo;
import gerenciadores.GerenciadorEpi;
import gerenciadores.GerenciadorUsuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorEpi gerenciadorEpi = new GerenciadorEpi();
        GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario();
        GerenciadorEmprestimo gerenciadorEmprestimo = new GerenciadorEmprestimo();
        GerenciadorDevolucao gerenciadorDevolucao = new GerenciadorDevolucao();
        int opcao;
        int opcao2 = 0;

        do{
            System.out.println("1. CRUD de Usuários\n" +
                    "2. CRUD de EPIs\n" +
                    "3. CRUD de Empréstimos\n" +
                    "4. CRUD de Devoluções\n" +
                    "0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if(opcao == 0) break;

            do{
                System.out.println("1. Cadastrar\n" +
                        "2. Listar\n" +
                        "3. Atualizar\n" +
                        "4. Remover\n" +
                        "5. Voltar");
                System.out.print("Escolha uma opção: ");
                opcao2 = scanner.nextInt();

                switch (opcao){
                    case 1 -> {
                        switch (opcao2){
                            case 1 -> gerenciadorUsuario.cadastrarUsuario();
                            case 2 -> gerenciadorUsuario.listarUsuarios();
                            case 3 -> gerenciadorUsuario.atualizarUsuario();
                            case 4 -> gerenciadorUsuario.removerUsuario();
                        }
                    }
                    case 2 -> {
                        switch (opcao2){
                            case 1 -> gerenciadorEpi.cadastrarEpi();
                            case 2 -> gerenciadorEpi.listarEpis();
                            case 3 -> gerenciadorEpi.atualizarEpi();
                            case 4 -> gerenciadorEpi.removerEpi();
                        }
                    }
                    case 3 -> {
                        switch (opcao2){
                            case 1 -> gerenciadorEmprestimo.criarEmprestimo();
                            case 2 -> gerenciadorEmprestimo.listarEmprestimos();
                            case 3 -> gerenciadorEmprestimo.atualizarEmprestimo();
                            case 4 -> gerenciadorEmprestimo.removerEmprestimo();
                        }
                    }
                    case 4 -> {
                        switch (opcao2){
                            case 1 -> gerenciadorDevolucao.criarDevolucao();
                            case 2 -> gerenciadorDevolucao.listarDevolucoes();
                            case 3 -> gerenciadorDevolucao.atualizarDevolucao();
                            case 4 -> gerenciadorDevolucao.removerDevolucao();
                        }
                    }
                }
            }while(opcao2 != 5);
        }while (opcao != 0);
    }
}
