package ontology.predicates;

import ontology.concepts.Carta;
import ontology.concepts.Jugador;

public class tieneCarta extends Predicate {

    private Jugador jug;
    private Carta car;

    public tieneCarta() {
    }

    public Jugador getJugador() {
        return this.jug;
    }

    public void setJugador(Jugador jug) {
        this.jug = jug;
    }

    public Carta getCard() {
        return this.car;
    }

    public void setCar(Carta car) {
        this.car = car;
    }

}
