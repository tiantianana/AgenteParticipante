package ontology.predicates;

import ontology.concepts.Jugador;
import ontology.concepts.Tablero;

public class hayPresi extends Predicate {

    private Tablero tab;
    private Jugador jug;
    private boolean valor;

    public hayPresi() {
    }

    public Tablero getTab() {
        return this.tab;
    }

    public void setTab(Tablero tab) {
        this.tab = tab;
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

    public void setValor(boolean result) {
        this.valor = result;
    }

}
