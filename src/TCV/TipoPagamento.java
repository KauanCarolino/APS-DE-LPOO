package TCV;

public enum TipoPagamento {

    DINHEIRO(1), CARTAO_CREDITO(2), CARTAO_DEBITO(3), PIX(4);
    private int tipo;


    TipoPagamento(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo(){
        return tipo;
    }
}
