package TCV;

public class Cliente {
    private String nome;
    private String enderecos[] = new String[3];
    private String cpf;
    private String cnpj;
    private double limiteDeCredito = 1000;

    public Cliente(String nome, String[] enderecos, String cpf, String cnpj, double limiteDeCredito) {
        this.nome = nome;
        this.enderecos = enderecos;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.limiteDeCredito = limiteDeCredito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getEnderecos() {
        return enderecos;
    }

    public void adicionarEndereco(Endereco endereco) {
        for (int i = 0; i < enderecos.length; i++) {
            if (enderecos[i] == null) {
                enderecos[i] = endereco.toString();
                break;
            }
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public void setLimiteDeCredito(double limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }

    public boolean podeComprar(double valorTotal) {
        return valorTotal <= limiteDeCredito;
    }
}

