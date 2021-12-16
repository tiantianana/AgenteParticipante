package ontology.actions;

import ontology.concepts.Jugador;
import ontology.concepts.Tablero;

public class censurar implements action {

    private Jugador golpista;
    private Tablero republica;

    public censurar() {
    }

    public Jugador getJugador() {
        return golpista;
    }

    public void setJugador(Jugador golpista) {
        this.golpista = golpista;
    }

    public Tablero getRepublica() {
        return republica;
    }

    public void setRepublica(Tablero republica) {
        this.republica = republica;
    }
}
