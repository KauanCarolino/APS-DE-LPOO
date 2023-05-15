package TCV;

import java.time.LocalDate;
public class Fatura {
    private Conta conta;
    private LocalDate dataQuitacao;
    private float juros;
    private int quantidadeParcelas;
    private int[] parcelas = new int[12];
    private double valorTotal;

    public void jurosPorAtraso(){}

    public Fatura(Conta conta, LocalDate dataQuitacao, float juros, int quantidadeParcelas, int[] parcelas) {
        super();
        this.conta = conta;
        this.dataQuitacao = dataQuitacao;
        this.juros = juros;
        this.quantidadeParcelas = quantidadeParcelas;
        this.parcelas = parcelas;
    }

    public double calcularJurosPorParcelamento(TipoPagamento tipo){
        double juros = 0;
        int maxParcelas = 3; //Máximo de parcelas permitidas

        if(quantidadeParcelas > maxParcelas){
            System.out.println("Parcelamento não permitido. Máximo de parcelas: "+maxParcelas);
        }
        return 0;
    }

    public double JurosPorParcelamento(TipoPagamento tipo, int quantidadeParcelas) {
        double juros = 0;
        switch (tipo) {
            case DINHEIRO:
            case PIX:
                juros = Math.pow(1 + 0.02, quantidadeParcelas);
                break;
            case CARTAO_DEBITO:
                juros = Math.pow(1 + 0.04, quantidadeParcelas) * 1.013;
                break;
            case CARTAO_CREDITO:
                juros = Math.pow(1 + 0.06, quantidadeParcelas) * 1.018;
                break;
            default:
                System.out.println("Tipo de pagamento inválido!");
                break;
        }
        return (valorTotal * juros) / quantidadeParcelas;
    }
}

