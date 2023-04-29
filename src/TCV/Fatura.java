package TCV;

import java.time.LocalDate;
public class Fatura extends Conta{
    private Conta conta;
    private LocalDate dataQuitacao;
    private float juros;
    private int quantidadeParcelas;
    private int parcelas[] = new int[12];
    public void jurosPorAtraso(){}
    public void jurosPorParcelamento(){}
}
