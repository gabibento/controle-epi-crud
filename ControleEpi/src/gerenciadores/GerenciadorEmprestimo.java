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

    GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario();
    GerenciadorEpi gerenciadorEpi = new GerenciadorEpi();

    public GerenciadorEmprestimo() {
        emprestimos = new ArrayList<>();

    }

    public void criarEmprestimo() {

        try{
            System.out.println("Colaboradores");
            gerenciadorUsuario.listarNomesUsuarios();

            Usuario usuario = gerenciadorUsuario.buscarUsuario();

            System.out.println("EPIs");
            gerenciadorEpi.listarEpis();

            Epi epi = gerenciadorEpi.buscarEpi();

            emprestimos.add(new Emprestimo(epi, usuario, buscarData()));
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

    public LocalDate buscarData(){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String input = scanner.nextLine();
            return LocalDate.parse(input, formatter);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void atualizarEmprestimo(){
        try{
            Emprestimo emprestimo = buscarEmprestimo();

            while(true){
                System.out.print("1. Atualizar usuário\n" +
                        "2. Atualizar EPI\n" +
                        "3. Atualizar data de empréstimo\n" +
                        "4. Atualizar data de devolução\n" +
                        "5. Voltar");
                int opcao = scanner.nextInt();

                if(opcao == 5) break;

                switch (opcao){
                    case 1 -> emprestimo.setUsuario(gerenciadorUsuario.buscarUsuario());
                    case 2 -> emprestimo.setEpi(gerenciadorEpi.buscarEpi());
                    case 3 -> {
                        System.out.println("Digite a data de empréstimo (DD/MM/AAAA): ");
                        emprestimo.setDataEmprestimo(buscarData());
                    }
                    case 4 -> {
                        System.out.println("Digite a data de devolução (DD/MM/AAAA): ");
                        emprestimo.setDataDevolucao(buscarData());
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void removerEmprestimo(){
        try {
            emprestimos.remove(buscarEmprestimo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
