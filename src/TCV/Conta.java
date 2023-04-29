package TCV;

import java.time.LocalDate;
public class Conta {
    private Compra[] compras = new Compra[100];
    private LocalDate dataVencimento;
    private double total;
    private Cliente cliente;

    public boolean adicionarCompra(Compra compra) {
        if (compra.getTipo() == TipoCompra.PRAZO && dataVencimento != null && LocalDate.now().isAfter(dataVencimento)) {
            return false;
        }

        int i = 0;
        while (compras[i] != null && i < compras.length) {
            i++;
        }
        if (i == compras.length) {
            return false; // já foram feitas compras até o limite do cliente
        }

        compras[i] = compra;

        if (compra.getTipo() == TipoCompra.PRAZO && dataVencimento == null) {
            dataVencimento = compra.getData().plusDays(5);
        }

        total += getValorTotal();

        return true;
    }

    public double getValorTotal() {
        double valorTotal = 0.0;
        for (Compra compra : compras) {
            if (compra != null) {
                for (Produto produto : compra.getProdutos()) {
                    if (produto != null) {
                        valorTotal += produto.getPreco();
                    }
                }
            }
        }
        return valorTotal;
    }

    public Compra[] getCompras() {
        return compras;
    }

    public void setCompras(Compra[] compras) {
        this.compras = compras;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
