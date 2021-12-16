package ontology.predicates;
import ontology.concepts.Jugador;
import ontology.concepts.Tablero;

public class esRebelde extends Predicate{

    private Jugador jug;
    private boolean valor;
    
    public esRebelde() {
    }

    public Jugador getJugador() {
        return this.jug;
    }
    public void setJugador(Jugador jug) {
        this.jug = jug;
    }
    public boolean getValor() {
        return this.valor;
    }
    public void setValor(boolean valor) {
        this.valor = valor;
    }
}
