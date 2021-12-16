package ontology.actions;

import ontology.concepts.Carta;
import ontology.concepts.Jugador;

public class ofertar implements action {

    private Jugador vendedor;
    private Jugador cliente;
    private Carta cart;
    private int precio;

    public Jugador getVendedor() {
        return vendedor;
    }

    public void setVendedor(Jugador vendedor) {
        this.vendedor = vendedor;
    }

    public Jugador getCliente() {
        return cliente;
    }

    public void setCliente(Jugador cliente) {
        this.cliente = cliente;
    }

    public Carta getCart() {
        return cart;
    }

    public void setCart(Carta cart) {
        this.cart = cart;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
