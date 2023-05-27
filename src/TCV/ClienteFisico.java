package TCV;

public class ClienteFisico extends Cliente{
    private String cpf;


    public ClienteFisico(String nome, String cpf) {
        super(nome, cpf);
        this.setNome(nome);
        this.setCpf(cpf);
    }

    @Override
    public void exibirDados(){
        System.out.println("Nome: "+getNome());
        System.out.println("CPF: "+getCpf());
    }
}
