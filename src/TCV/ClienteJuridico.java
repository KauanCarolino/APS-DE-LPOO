package TCV;

public class ClienteJuridico extends Cliente{
    private String cnpj;

    public ClienteJuridico(String nome, String cpf) {
        super(nome, cpf);
        this.cnpj = cnpj;
    }

    @Override
    public void exibirDados(){
        System.out.println("Nome: "+getNome());
        System.out.println("CNPJ: "+getCnpj());
    }
}
