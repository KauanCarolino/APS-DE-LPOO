package TCV;

public enum Tipo {
    PRAZO(1), VISTA(2);
    private final int valor;
    Tipo(int valorTipo){
        valor = valorTipo;
    }

    public int getValor(){
        return valor;
    }

}
