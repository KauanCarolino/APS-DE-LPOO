package TCV;

import java.time.LocalDate;
public class Parcela {
    private LocalDate dataVencto;
    private double valor;
    private float juros;
    private TipoPagamento tipo;
    private LocalDate dataPagto;

    public Parcela() {
        this.dataVencto = dataVencto;
        this.valor = valor;
        this.juros = juros;
        this.tipo = tipo;
        this.dataPagto = dataPagto;
    }

    public LocalDate getDataVencto() {
        return dataVencto;
    }

    public void setDataVencto(LocalDate dataVencto) {
        this.dataVencto = dataVencto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public float getJuros() {
        return juros;
    }

    public void setJuros(float juros) {
        this.juros = juros;
    }

    public TipoPagamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoPagamento tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataPagto() {
        return dataPagto;
    }

    public void setDataPagto(LocalDate dataPagto) {
        this.dataPagto = dataPagto;
    }
}
