package ontology.actions;
// Tipo

import ontology.concepts.Jugador;

public class pagar implements action {

    private Jugador emisor;
    private Jugador receptor;
    private int dinero;

    public pagar() {
    }

    public Jugador getEmisor() {
        return emisor;
    }

    public void setEmisor(Jugador emisor) {
        this.emisor = emisor;
    }

    public Jugador getReceptor() {
        return receptor;
    }

    public void setReceptor(Jugador receptor) {
        this.receptor = receptor;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

}