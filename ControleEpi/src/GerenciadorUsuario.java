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
}