package ontology.actions;

import ontology.concepts.Tablero;

public class cerrarBanco implements action {

    private Tablero tab;

    public Tablero getTab() {
        return tab;
    }

    public void setTab(Tablero tab) {
        this.tab = tab;
    }

    public cerrarBanco() {
    }
}
