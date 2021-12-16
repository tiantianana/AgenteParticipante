package jugador.plans;

import jadex.runtime.*;
import jadex.adapter.fipa.SFipa;
import jadex.runtime.IMessageEvent;
import jadex.adapter.fipa.AgentIdentifier;
import jugador.beliefs.AgentLocation;
import jugador.beliefs.AgentEnemigo;
import java.util.*;
import ontology.concepts.*;
import ontology.predicates.*;
import ontology.actions.*;

public class golpeEstadoPlan extends Plan {

    // Comprobar que estamos en la fase de golpe de estado
    // Compruebo que el jugador no es presidente
    // Compruebo que el presidente es el que más dinero tiene (va ganando)
    public void body() {

        // Request(dar_golpe) al tablero
        IMessageEvent msgsend;
        Jugador[] players = (Jugador[]) getBeliefbase().getBeliefSet("jugadores").getFacts();;
        Jugador me = (Jugador) getBeliefbase().getBelief("myself").getFact();
        Tablero tab = (Tablero) getBeliefbase().getBelief("miTablero").getFact();

        // Solo si esta en la fase de golpe de estado y si el jugador no es presidente
        // puede hacer el golpe de estado
        if (tab.getFaseActual() == "IntentarGolpe" && me.getCargo() != "Presidente") {

            // Decision del experto: dar golpe si el presidente actual va ganando
            Jugador presidente = players[0];
            for (Jugador ap : players) {
                if (ap.getCargo() == "Presidente") {
                    presidente = ap;
                    break;
                }
            }

            if (presidente != null) {
                // Utilizo la estrategia para ganar el juego
                // Si el presidente va ganando y el presidente es enemigo mio
                AgentEnemigo enemigo = (AgentEnemigo) getBeliefbase().getBelief("enemigo").getFact();

                if (getWinner() == presidente && enemigo.isEnemigo(me.getFamilia(), presidente.getFamilia())) {
                    System.out.println("Decido hacer un golpe de estado");
                    msgsend = createMessageEvent("RequestGolpeEstadoMsg");
                    darGolpe action = new darGolpe(); // creo un golpe de estado
                    action.setJugador(me);
                    msgsend.setContent(action);
                    msgsend.getParameterSet(SFipa.RECEIVERS).addValue(tab.getAgentID());
                    sendMessage(msgsend);
                }

            } else {
                System.out.println("No hay presidente para dar golpe de estado");
            }
        }
    }

    public Jugador getWinner() {

        Jugador[] players = (Jugador[]) getBeliefbase().getBeliefSet("jugadores").getFacts();
        Jugador winner = (Jugador) getBeliefbase().getBelief("playerWinning").getFact(); // obtiene el jugador que va gannado

        // Compara quien va ganando
        for (Jugador ahp : players) {
            // Si el resto de jugadores tienen menos
            if (ahp.getEfectivo() > winner.getEfectivo()) {
                winner = ahp;
            }
        }

        // Devuelve el jugador que va ganando
        getBeliefbase().getBelief("playerWinning").setFact(winner);
        return winner;
    }
}
