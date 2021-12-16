package ontology.actions;

import ontology.concepts.Jugador;
import ontology.concepts.Tablero;

public class ingresarDinero implements action {

    private Jugador jug;
    private int dinero;
    private Tablero tab;

    public Tablero getTab() {
        return tab;
    }

    public void setTab(Tablero tab) {
        this.tab = tab;
    }

    public ingresarDinero() {
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


}
