package ontology.actions;

import ontology.concepts.Jugador;

public class robarCartas implements action {

    //Atributos
    private Jugador jug;
    private int n_cart;

    public robarCartas() {
        ;
    }

    //Getters y setters
    public int getN_cart() {
        return n_cart;
    }

    public void setN_cart(int n_cart) {
        this.n_cart = n_cart;
    }

    public Jugador getJugador() {
        return jug;
    }

    public void setJugador(Jugador jug) {
        this.jug = jug;
    }
}
