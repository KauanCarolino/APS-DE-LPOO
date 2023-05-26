package TCV;

public class ClienteJuridico extends Cliente{


    public ClienteJuridico(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public void exibirDados(){
        System.out.println("Nome: "+getNome());
        System.out.println("CNPJ: "+getCnpj());
    }
}
