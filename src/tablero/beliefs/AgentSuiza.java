package tablero.plans;

import jadex.runtime.*;
import ontology.concepts.Jugador;


public class AgentSuiza {
    // relaciona a cada jugador con una cantidad de dinero en suiza que solo sabe el jugador
    protected int suiza;
    protected Jugador jug;

    public int getSuiza() {
        return suiza;
    }

    public void setSuiza(int suiza) {
        this.suiza = suiza;
    }

    public Jugador getJugador() {
        return jug;
    }

    public void setJugador(Jugador jug) {
        this.jug = jug;
    }
}
