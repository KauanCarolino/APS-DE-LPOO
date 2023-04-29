package TCV;

import java.time.LocalDate;
public class Compra {
    private Produto[] produtos = new Produto[100];
    private LocalDate data;
    private Cliente cliente;
    private TipoCompra tipo;


    public Compra(Produto[] produtos, LocalDate data, Cliente cliente, TipoCompra tipo) {
        this.produtos = produtos;
        this.data = data;
        this.cliente = cliente;
        this.tipo = tipo;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoCompra getTipo() {
        return tipo;
    }

    public void setTipo(TipoCompra tipo) {
        this.tipo = tipo;
    }


}
