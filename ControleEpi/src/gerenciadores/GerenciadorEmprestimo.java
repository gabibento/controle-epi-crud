package gerenciadores;

import entidades.Emprestimo;
import entidades.Epi;
import entidades.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorEmprestimo {
    Scanner scanner = new Scanner(System.in);
    private List<Emprestimo> emprestimos;

    GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario();
    GerenciadorEpi gerenciadorEpi = new GerenciadorEpi();

    public GerenciadorEmprestimo() {
        emprestimos = new ArrayList<>();

    }

    public void criarEmprestimo() {
        //adicionar try catch??
        System.out.println("Colaboradores");
        gerenciadorUsuario.listarNomesUsuarios();
        System.out.println("Digite o índice do colaborador: ");

        Usuario usuario = gerenciadorUsuario.buscarUsuario();//Colocar -1

        System.out.println("EPIs");
        gerenciadorEpi.listarEpis();
        System.out.println("Digite o índice da epi: ");

        Epi epi = gerenciadorEpi.buscarEpi();//Colocar -1

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataDevolucao;

        System.out.println("Digite a data de devolução (DD/MM/AAAA): ");
        String input = scanner.nextLine();
        dataDevolucao = LocalDate.parse(input, formatter);
        System.out.println("Data de devolução: " + dataDevolucao);

        Emprestimo emprestimo = new Emprestimo(epi, usuario, dataDevolucao);//verificar se a dataDevolucao está correta
        emprestimos.add(emprestimo);
        System.out.println("Empréstimo criado com sucesso!");
        System.out.println("Colaborador: " + usuario.getNome());
        System.out.println("EPI: " + epi.getNome());
        System.out.println("Data de Empréstimo: " + emprestimo.getDataEmprestimo());
        System.out.println("Data de Devolução: " + emprestimo.getDataDevolucao());
    }

    public void listarEmprestimos() {
        emprestimos.forEach(emprestimo -> System.out.println((emprestimos.indexOf(emprestimo) + 1) + ": " + emprestimo.getUsuario() + " - " + emprestimo.getEpi() + " - " + emprestimo.getDataEmprestimo() + " - " + emprestimo.getDataDevolucao()));
    }

    public Emprestimo buscarEmprestimo() {
        try {
            listarEmprestimos();
            System.out.println("Digite o índice do empréstimo: ");

            Emprestimo emprestimo = emprestimos.get(scanner.nextInt());
            scanner.nextLine();
            if (emprestimo == null)
                throw new IllegalArgumentException("Erro ao encontrar empréstimo. Tente novamente!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            buscarEmprestimo();
        }
        return null;
    }
}
