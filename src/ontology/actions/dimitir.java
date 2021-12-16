package ontology.actions;

import ontology.concepts.Jugador;

public class dimitir implements action {

    private Jugador jug;

    public dimitir() {
    }

    public Jugador getJugador() {
        return jug;
    }

    public void setJugador(Jugador jug) {
        this.jug = jug;
    }

}
