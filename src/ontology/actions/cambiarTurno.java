package ontology.actions;

import ontology.concepts.Jugador;
import ontology.concepts.Tablero;

public class cambiarTurno implements action {

    private Jugador jug;
    private Tablero tab;

    public cambiarTurno() {
    }

    public Jugador getJugador() {
        return jug;
    }

    public void setJugador(Jugador jug) {
        this.jug = jug;
    }

    public ontology.concepts.Tablero getTab() {
        return tab;
    }

    public void setTab(ontology.concepts.Tablero tab) {
        this.tab = tab;
    }

}
