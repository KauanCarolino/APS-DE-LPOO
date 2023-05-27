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
        int quantidadeParcelas = scanner.nextInt();
        fatura.setQuantidadeParcelas(quantidadeParcelas);

        while (parcela == 0) {
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

    public void visualizarEAlterarObjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Visualizar e Alterar Objeto ---");
        System.out.println("1. Visualizar e Alterar Cliente");
        System.out.println("2. Visualizar e Alterar Fatura");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        switch (opcao) {
            case 1:
                visualizarEAlterarCliente();
                break;
            case 2:
                visualizarEAlterarFatura();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private void visualizarEAlterarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione o Cliente a ser visualizado e alterado:");

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }

        System.out.print("Escolha um Cliente (0 para cancelar): ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (escolha > 0 && escolha <= clientes.size()) {
            Cliente cliente = clientes.get(escolha - 1);

            // Exibir os dados atuais do Cliente
            System.out.println("--- Dados Atuais do Cliente ---");
            cliente.exibirDados();
            System.out.println();

            // Solicitar as alterações
            System.out.println("--- Alterar Cliente ---");
            System.out.print("Nome (Deixe em branco para manter o valor atual): ");
            String nome = scanner.nextLine();
            if (!nome.isEmpty()) {
                cliente.setNome(nome);
            }

            // Se for um Cliente Físico, permitir alterar o CPF
            if (cliente instanceof ClienteFisico) {
                ClienteFisico clienteFisico = (ClienteFisico) cliente;
                System.out.print("CPF (Deixe em branco para manter o valor atual): ");
                String cpf = scanner.nextLine();
                if (!cpf.isEmpty()) {
                    clienteFisico.setCpf(cpf);
                }
            }

            System.out.println("Cliente alterado com sucesso.");
        } else if (escolha != 0) {
            System.out.println("Opção inválida.");
        }
    }

    private void visualizarEAlterarFatura() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione a Fatura a ser visualizada e alterada:");

        for (int i = 0; i < faturas.size(); i++) {
            System.out.println((i + 1) + ". Fatura " + (i + 1));
        }

        System.out.print("Escolha uma Fatura (0 para cancelar): ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (escolha > 0 && escolha <= faturas.size()) {
            Fatura fatura = faturas.get(escolha - 1);

            // Exibir os dados atuais da Fatura
            System.out.println("--- Dados Atuais da Fatura ---");
            fatura.exibirDados();
            System.out.println();

            // Solicitar as alterações
            System.out.println("--- Alterar Fatura ---");
            System.out.print("Valor Total (Deixe 0 para manter o valor atual): ");
            double valorTotal = scanner.nextDouble();
            if (valorTotal != 0) {
                fatura.setValorTotal(valorTotal);
            }

            System.out.print("Quantidade de parcelas (Deixe 0 para manter a quantidade atual): ");
            int quantidadeParcelas = scanner.nextInt();
            if (quantidadeParcelas != 0) {
                fatura.setQuantidadeParcelas(quantidadeParcelas);
            }

            System.out.println("Fatura alterada com sucesso.");
        } else if (escolha != 0) {
            System.out.println("Opção inválida.");
        }
    }
    //
    public void excluirObjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Excluir Objeto ---");
        System.out.println("1. Excluir Cliente");
        System.out.println("2. Excluir Fatura");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        switch (opcao) {
            case 1:
                excluirCliente();
                break;
            case 2:
                excluirFatura();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
    private void excluirCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione o Cliente a ser excluído:");

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }

        System.out.print("Escolha um Cliente (0 para cancelar): ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (escolha > 0 && escolha <= clientes.size()) {
            Cliente cliente = clientes.get(escolha - 1);

            if (verificarDependenciasCliente(cliente)) {
                System.out.println("Não é possível excluir o Cliente. Existem dependências com outros objetos.");
                return;
            }

            System.out.print("Tem certeza que deseja excluir o Cliente? (S/N): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("S")) {
                clientes.remove(cliente);
                System.out.println("Cliente excluído com sucesso.");
            } else {
                System.out.println("Operação cancelada.");
            }
        } else if (escolha != 0) {
            System.out.println("Opção inválida.");
        }
    }

    private boolean verificarDependenciasCliente(Cliente cliente) {
        return false;
    }

    private void excluirFatura() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione a Fatura a ser excluída:");

        for (int i = 0; i < faturas.size(); i++) {
            System.out.println((i + 1) + ". Fatura " + (i + 1));
        }

        System.out.print("Escolha uma Fatura (0 para cancelar): ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (escolha > 0 && escolha <= faturas.size()) {
            Fatura fatura = faturas.get(escolha - 1);

            if (verificarDependenciasFatura(fatura)) {
                System.out.println("Não é possível excluir a Fatura. Existem dependências com outros objetos.");
                return;
            }

            System.out.print("Tem certeza que deseja excluir a Fatura? (S/N): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("S")) {
                faturas.remove(fatura);
                System.out.println("Fatura excluída com sucesso.");
            } else {
                System.out.println("Operação cancelada.");
            }
        } else if (escolha != 0) {
            System.out.println("Opção inválida.");
        }
    }

    private boolean verificarDependenciasFatura(Fatura fatura) {
        return false;
    }
    //
    public void exibirMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 8) {
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("1. Cadastrar Cliente Físico");
            System.out.println("2. Cadastrar Cliente Jurídico");
            System.out.println("3. Cadastrar Fatura");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Listar Faturas");
            System.out.println("6. Visualizar e Alterar Objeto");
            System.out.println("7. Excluir Objeto");
            System.out.println("8. Sair");
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
                    visualizarEAlterarObjeto();
                    break;
                case 7:
                    excluirObjeto();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        }
    }
}