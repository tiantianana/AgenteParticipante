package ontology.predicates;
import ontology.concepts.Jugador;
import ontology.concepts.Tablero;

public class comenzarPartida extends Predicate {

    private Jugador jug;

    public comenzarPartida() {
    }

    public Jugador getJugador() {
        return this.jug;
    }

    public void setJugador(Jugador jug) {
        this.jug = jug;
    }
}
