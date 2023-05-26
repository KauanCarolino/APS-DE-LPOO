package TCV;

public class ClienteFisico extends Cliente{


    public ClienteFisico(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public void exibirDados(){
        System.out.println("Nome: "+getNome());
        System.out.println("CPF: "+getCpf());
    }
}
