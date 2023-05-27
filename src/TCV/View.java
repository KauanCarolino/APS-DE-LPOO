package TCV;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private ArrayList<Cliente> clientes;
    private ArrayList<Fatura> faturas;

    public View(ArrayList<Cliente> clientes, ArrayList<Fatura> faturas) {
        this.clientes = clientes;
        this.faturas = faturas;
    }

    public void cadastrarClienteFisico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastro de Cliente Físico");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        Cliente cliente = new ClienteFisico(nome,cpf);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    public void cadastrarClienteJuridico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastro de Cliente Jurídico");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        Cliente cliente = new ClienteJuridico(nome, cnpj);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    public void cadastrarFatura() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastro de Fatura");
        System.out.print("Valor Total: ");
        double valorTotal = scanner.nextDouble();
        Fatura fatura = new Fatura(valorTotal);
        System.out.println("Digite as parcelas (0 para finalizar):");
        int parcela = scanner.nextInt();
        while (parcela != 0) {
            fatura.adicionarParcela(parcela);
            parcela = scanner.nextInt();
        }
        faturas.add(fatura);
        System.out.println("Fatura cadastrada com sucesso.");
    }

    public void listarClientes() {
        System.out.println("Clientes cadastrados:");
        for (Cliente cliente : clientes) {
            cliente.exibirDados();
            System.out.println("---------------------");
        }
    }

    public void listarFaturas() {
        System.out.println("Faturas cadastradas:");
        for (Fatura fatura : faturas) {
            fatura.exibirDados();
            System.out.println("---------------------");
        }
    }

    public void exibirMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("1. Cadastrar Cliente Físico");
            System.out.println("2. Cadastrar Cliente Jurídico");
            System.out.println("3. Cadastrar Fatura");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Listar Faturas");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrarClienteFisico();
                    break;
                case 2:
                    cadastrarClienteJuridico();
                    break;
                case 3:
                    cadastrarFatura();
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    listarFaturas();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        }
    }
}