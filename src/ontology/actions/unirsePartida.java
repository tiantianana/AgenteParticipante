package ontology.actions;

import ontology.concepts.Jugador;
import ontology.concepts.Tablero;
import java.util.*;
import jadex.adapter.fipa.AgentIdentifier;

public class unirsePartida implements action {

    private Jugador[] players;
    private AgentIdentifier aid;
    private AgentIdentifier tablero;

    public unirsePartida() {
        ;
    }

    public Jugador[] getAllJug() {
        return players;
    }

    public void setAllJug(Jugador[] jugs) {
        this.players = jugs;
    }

    public AgentIdentifier getTableroID() {
        return tablero;
    }

    public void setTableroID(AgentIdentifier t) {
        this.tablero = t;
    }

    public AgentIdentifier getAgentID() {
        return aid;
    }

    public void setAgentID(AgentIdentifier aid) {
        this.aid = aid;
    }
}
