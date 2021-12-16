package ontology.predicates;
import ontology.concepts.Jugador;
import ontology.concepts.Tablero;

public class tieneCargo extends Predicate {

    private Jugador jug;
    private String cargo;

    public tieneCargo() {
    }

    public Jugador getJugador() {
        return this.jug;
    }

    public void setJugador(Jugador jug) {
        this.jug = jug;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
