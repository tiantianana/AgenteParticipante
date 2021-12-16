package ontology.actions;

import ontology.concepts.Jugador;
import ontology.concepts.Tablero;

public class sacarDinero implements action {

    private Jugador jug;
    private Tablero tab;
    private int dinero;

    public sacarDinero() {
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public Jugador getJugador() {
        return jug;
    }

    public void setJugador(Jugador jug) {
        this.jug = jug;
    }

    public Tablero getTab() {
        return tab;
    }

    public void setTab(Tablero tab) {
        this.tab = tab;
    }


}
