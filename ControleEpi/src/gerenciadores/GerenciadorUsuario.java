package gerenciadores;

import entidades.Usuario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GerenciadorUsuario {
    Scanner scanner = new Scanner(System.in);
    private List<Usuario> usuarios;

    public GerenciadorUsuario() {
        usuarios = new ArrayList<>();
    }

    public void cadastrarUsuario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        Usuario usuario = new Usuario(nome, email);
        usuarios.add(usuario);

        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void listarUsuarios() {
        if(usuarios.isEmpty()) System.out.println("Não há usuários cadastrados");
        else usuarios.forEach(usuario -> System.out.println((usuarios.indexOf(usuario) + 1) + ": " + usuario.toString()));
    }

    public Usuario buscarUsuario() {
        while (true){
         try {
             listarUsuarios();
             if(usuarios.isEmpty()) return null;

             System.out.print("Digite o índice do usuário: ");
             int indice = scanner.nextInt();

             Usuario usuario = usuarios.get(indice - 1);
             scanner.nextLine();

             if (usuario == null) throw new IllegalArgumentException("Erro ao encontrar usuário. Tente novamente!");
             return usuario;
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

    public void atualizarUsuario() {
        Usuario usuario = buscarUsuario();

        while(true) {
            try {
                if (usuario == null) break;

                System.out.print("1. Atualizar nome\n2. Atualizar e-mail\n3. Voltar\nDigite uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 1) {
                    System.out.print("Novo nome: ");
                    usuario.setNome(scanner.nextLine());
                } else if (opcao == 2) {
                    System.out.print("Novo e-mail: ");
                    usuario.setEmail(scanner.nextLine());
                } else if (opcao == 3) break;
                else {
                    throw new IllegalArgumentException("Opção inválida. Tente novamente!");
                }
                System.out.println("Usuário atualizado com sucesso!\n");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void removerUsuario() {
        try {
            Usuario usuario = buscarUsuario();
           if(usuario != null){
               usuarios.remove(usuario);
               System.out.println("Usuário removido com sucesso!");
           }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}