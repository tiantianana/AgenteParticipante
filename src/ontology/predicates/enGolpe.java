package ontology.predicates;

import ontology.concepts.Tablero;

public class enGolpe extends Predicate {

    private Tablero tab;

    public enGolpe() {
    }

    public Tablero getTablero() {
        return this.tab;
    }

    public void setTablero(Tablero tab) {
        this.tab = tab;
    }

}
