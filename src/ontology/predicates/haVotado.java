package ontology.predicates;
import ontology.concepts.Jugador;
import ontology.concepts.Tablero;

public class haVotado extends Predicate {

    private Jugador jug;

    public haVotado() {
    }

    public Jugador getJugador() {
        return this.jug;
    }

    public void setJugador(Jugador jug) {
        this.jug = jug;
    }
    
}
