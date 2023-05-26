package TCV;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Fatura> faturas = new ArrayList<>();

        View usar = new View(clientes, faturas);
        usar.exibirMenuPrincipal();
    }
}
