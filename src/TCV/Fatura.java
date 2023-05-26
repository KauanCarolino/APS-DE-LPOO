package TCV;
import TCV.TipoPagamento;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.time.LocalDate;
public class Fatura {
    private Conta conta;
    private LocalDate dataQuitacao, dataVencimento;
    private double juros;
    private int quantidadeParcelas;
    private ArrayList<Integer> parcelas;
    private double valorTotal, valorParcela;
    private boolean isFaturaQuitada;

    public Fatura(Conta conta, LocalDate dataQuitacao, double juros, int quantidadeParcelas, int[] parcelas, double valorTotal) {
        super();
        this.conta = conta;
        this.dataQuitacao = dataQuitacao;
        this.juros = juros;
        this.quantidadeParcelas = quantidadeParcelas;
        this.parcelas = new ArrayList<Integer>();

        // Adicionar cada parcela do array à lista
        for (int parcela : parcelas) {
            this.parcelas.add(parcela);
        }

        this.valorTotal = valorTotal;
        this.isFaturaQuitada = false;
    }

    public Fatura(double valorTotal) {
    }

    public void quitarFatura(LocalDate dataQuitacao){
        if (parcelas.size() == quantidadeParcelas) {
            this.dataQuitacao = dataQuitacao;
            isFaturaQuitada = true;
        } else {
            System.out.println("A fatura ainda possui parcelas em aberto.");
        }
    }

    public void adicionarParcela(int parcela) {
        if (parcelas.size() < 3) {
            parcelas.add(parcela);
        } else {
            System.out.println("Limite máximo de parcelas atingido (3 parcelas).");
        }
    }

    private double calculateValorTotal() {
        return 0;
    }

    public double calcularJurosPorParcelamento(TipoPagamento tipo){
        double juros = 0;
        int maxParcelas = 3; // Máximo de parcelas permitidas

        if (quantidadeParcelas > maxParcelas) {
            System.out.println("Parcelamento não permitido. Máximo de parcelas: " + maxParcelas);
        } else {
            juros = JurosPorParcelamento(tipo, quantidadeParcelas);
        }
        return juros;
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

    public double jurosPorAtraso(){
        int diasAtraso = (int) ChronoUnit.DAYS.between(dataVencimento, dataQuitacao);
        if (diasAtraso > 0) {
            if (diasAtraso <= 15) {
                juros = valorParcela * 0.03;
            } else if (diasAtraso <= 30) {
                juros = valorParcela * 0.09;
            } else {
                juros = valorParcela * (0.0033 * diasAtraso);
            }
        }
        return juros;
    }

    public void exibirDados(){
        System.out.println("Valor Total: "+valorTotal);
        System.out.println("Parcelas: "+quantidadeParcelas);
    }

    public void setQuantidadeParcelas(int quantidadeParcelas){
        this.quantidadeParcelas = quantidadeParcelas;
    }
    public int getQuantidadeParcelas(){
        return quantidadeParcelas;
    }
}

