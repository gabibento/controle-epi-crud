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
        System.out.println("Colaboradores");
        gerenciadorUsuario.listarNomesUsuarios();

        Usuario usuario = gerenciadorUsuario.buscarUsuario();

        System.out.println("EPIs");
        gerenciadorEpi.listarEpis();

        Epi epi = gerenciadorEpi.buscarEpi();

        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataDevolucao;

            System.out.println("Digite a data de devolução (DD/MM/AAAA): ");
            String input = scanner.nextLine();
            dataDevolucao = LocalDate.parse(input, formatter);

            Emprestimo emprestimo = new Emprestimo(epi, usuario, dataDevolucao);
            emprestimos.add(emprestimo);
            System.out.println("Empréstimo criado com sucesso!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listarEmprestimos() {
        emprestimos.forEach(emprestimo -> System.out.println((emprestimos.indexOf(emprestimo) + 1) + ": " + emprestimo.getUsuario() + " - " + emprestimo.getEpi() + " - " + emprestimo.getDataEmprestimo() + " - " + emprestimo.getDataDevolucao()));
    }

    public Emprestimo buscarEmprestimo() {
        try {
            listarEmprestimos();
            System.out.println("Digite o índice do empréstimo: ");

            Emprestimo emprestimo = emprestimos.get(scanner.nextInt() - 1);
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
