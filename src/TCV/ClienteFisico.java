package TCV;

public class ClienteFisico extends Cliente{
    private String dataNasc;


    public ClienteFisico(String nome, String cpf, String dataNasc) {
        super(nome, cpf);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setDataNasc(dataNasc);
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public void exibirDados(){
        System.out.println("Nome: "+getNome());
        System.out.println("CPF: "+getCpf());
        System.out.println("CPF: "+getDataNasc());
    }
}
