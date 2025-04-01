import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorUsuario {
    Scanner scanner = new Scanner(System.in);
    private List<Usuario> usuarios;

    public GerenciadorUsuario() {
        usuarios = new ArrayList<>();
    }

    public void cadastrarUsuario() {
        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("E-mail: ");
        String email = scanner.nextLine();

        Usuario usuario = new Usuario(nome, email);
        usuarios.add(usuario);

        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void listarUsuarios() {
        usuarios.forEach(usuario -> System.out.println((usuarios.indexOf(usuario) + 1) + ": " + usuario.getNome() + " - " + usuario.getEmail()));
    }

    public void listarNomesUsuarios() {
        usuarios.forEach(usuario -> System.out.println((usuarios.indexOf(usuario) + 1) + ": " + usuario.getNome()));
    }

    public Usuario buscarUsuario() {
        try {
            listarUsuarios();
            System.out.println("Digite o índice do usuário: ");

            Usuario usuario = usuarios.get(scanner.nextInt());
            scanner.nextLine();
            if (usuario == null) throw new IllegalArgumentException("Erro ao encontrar usuário. Tente novamente!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            buscarUsuario();
        }
        return null;
    }

    public void atualizarUsuario() {
        try {
            Usuario usuario = buscarUsuario();

            System.out.println("1. Atualizar nome\n2. Atualizar e-mail");
            int opcao = scanner.nextInt();
            if (opcao == 1) {
                System.out.println("Novo nome: ");
                usuario.setNome(scanner.nextLine());
            } else if (opcao == 2) {
                System.out.println("Novo e-mail: ");
                usuario.setEmail(scanner.nextLine());
            } else {
                throw new IllegalArgumentException("Opção inválida. Tente novamente!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            atualizarUsuario();
        }
    }

    public void removerUsuario() {
        try {
            Usuario usuario = buscarUsuario();
            usuarios.remove(usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}