package TCV;

public class ClienteJuridico extends Cliente{
    private String cnpj;
    private String inscricaoEstadual;
    public ClienteJuridico(String nome, String cnpj, String inscricaoEstadual) {
        super(nome, cnpj);
        this.setNome(nome);
        this.setCnpj(cnpj);
        this.setInscricaoEstadual(inscricaoEstadual);
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public void exibirDados(){
        System.out.println("Nome: "+getNome());
        System.out.println("CNPJ: "+getCnpj());
        System.out.println("Inscricao Estadual: "+getInscricaoEstadual());
    }
}
