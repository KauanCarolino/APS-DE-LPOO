package TCV;

public class ClienteJuridico extends Cliente{
    private String cnpj;

    public ClienteJuridico(String nome, String cnpj) {
        super(nome, cnpj);
        this.setNome(nome);
        this.setCnpj(cnpj);
    }

    @Override
    public void exibirDados(){
        System.out.println("Nome: "+getNome());
        System.out.println("CNPJ: "+getCnpj());
    }
}
