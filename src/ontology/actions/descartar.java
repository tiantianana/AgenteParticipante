package ontology.actions;

import ontology.concepts.Carta;
import ontology.concepts.Jugador;

public class descartar implements action {

    private Jugador jug;
    private Carta cart;

    public Jugador getJugador() {
        return jug;
    }

    public void setJugador(Jugador jug) {
        this.jug = jug;
    }

    public Carta getCart() {
        return cart;
    }

    public void setCart(Carta cart) {
        this.cart = cart;
    }

}
