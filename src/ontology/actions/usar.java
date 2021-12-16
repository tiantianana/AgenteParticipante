package ontology.actions;
// Tipo

import ontology.concepts.Carta;
import ontology.concepts.Jugador;

public class usar implements action {

    private Jugador jug;
    private Carta cart;

    public usar() {
        ;
    }

    public Jugador getJugador() {
        return jug;
    }

    public void setJugador(Jugador jug) {
        this.jug = jug;
    }

    public Carta getCard() {
        return cart;
    }

    public void setCar(Carta car) {
        this.cart = cart;
    }


}