package ontology.predicates;
import ontology.concepts.Jugador;
import ontology.concepts.Tablero;

public class ganaPresi extends Predicate {

    private Tablero tab;
    private boolean valor;

    public ganaPresi() {
    }

    public Tablero getTab() {
        return this.tab;
    }
    public void setTab(Tablero tab) {
        this.tab = tab;
    }

    public boolean getValor() {
        return this.valor;
    }
    public void setValor(boolean result) { 
        this.valor = result;
    }
}
