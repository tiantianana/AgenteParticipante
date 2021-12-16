package ontology.predicates;

import ontology.concepts.Jugador;
import ontology.concepts.Tablero;

public class imposibilidadAsesinato extends Predicate {

    private Jugador jug;

    public imposibilidadAsesinato() {
    }

    public Jugador getJugador() {
        return this.jug;
    }

    public void setJugador(Jugador jug) {
        this.jug = jug;
    }
}