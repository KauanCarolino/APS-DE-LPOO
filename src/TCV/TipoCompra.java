package TCV;

public enum TipoCompra {
    PRAZO(1), VISTA(2);
    private final int tipo;
    TipoCompra(int valorTipo){
        tipo = valorTipo;
    }

    public int getTipo() {
        return tipo;
    }
}
