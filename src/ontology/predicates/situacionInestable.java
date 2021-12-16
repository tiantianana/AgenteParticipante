package ontology.predicates;
import ontology.concepts.Jugador;
import ontology.concepts.Tablero;

public class situacionInestable extends Predicate {

    private Tablero tab;

    public situacionInestable() {
    }

    public Tablero getTab() {
        return this.tab;
    }

    public void setTab(Tablero tab) {
        this.tab = tab;
    }
    
}
