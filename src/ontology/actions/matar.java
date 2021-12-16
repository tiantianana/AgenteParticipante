package ontology.actions;

import ontology.concepts.Jugador;

public class matar implements action {


    private Jugador asesino;
    private Jugador objetivo;

    public matar() {
    }

    public Jugador getAsesino() {
        return asesino;
    }

    public void setAsesino(Jugador asesino) {
        this.asesino = asesino;
    }

    public Jugador getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Jugador objetivo) {
        this.objetivo = objetivo;
    }

}
