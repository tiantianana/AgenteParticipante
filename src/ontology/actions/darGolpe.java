package ontology.actions;
// Tipo

import ontology.concepts.Jugador;
import ontology.concepts.Tablero;

public class darGolpe implements action {

    private Jugador golpista;

    public darGolpe() {
    }

    public Jugador getJugador() {
        return golpista;
    }

    public void setJugador(Jugador golpista) {
        this.golpista = golpista;
    }

}