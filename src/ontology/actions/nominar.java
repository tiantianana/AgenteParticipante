package ontology.actions;
// Tipo

import ontology.concepts.Jugador;

public class nominar implements action {

    // Cada jugador escoge un presidente
    private Jugador votante;
    private Jugador nominado;

    public nominar() {
        ;
    }

    public Jugador getVotante() {
        return votante;
    }

    public void setVotante(Jugador votante) {
        this.votante = votante;
    }

    public Jugador getNominado() {
        return nominado;
    }

    public void setNominado(Jugador nominado) {
        this.nominado = nominado;
    }

}