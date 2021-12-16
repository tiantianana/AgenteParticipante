package ontology.predicates;
import ontology.concepts.Jugador;
import ontology.concepts.Tablero;

public class esTurnoDe extends Predicate {

    private Jugador jug;

    public esTurnoDe() {
    }

    public Jugador getJugador() {
        return this.jug;
    }

    public void setJugador(Jugador jug) {
        this.jug = jug;
    }

}
