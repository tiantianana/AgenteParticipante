package jugador.plans;

import jadex.runtime.*;
import jadex.adapter.fipa.AgentIdentifier;
import jadex.adapter.fipa.SFipa;
import jadex.runtime.IMessageEvent;
import ontology.concepts.*;
import ontology.predicates.*;
import ontology.actions.*;
import java.util.ArrayList;
import java.util.*;

public class waitUnirsePartidaPlan extends Plan{

    public void body() {
        // Recibo la información de la familia al que pertenece el jugador que se
        // acabade unir
        IMessageEvent msgrec = (IMessageEvent) getInitialEvent();
        unirsePartida action = (unirsePartida) msgrec.getContent(); // accedo al contenido del mensaje

        // Comprobamos si existe el mensaje
        if (action != null) {

            System.out.println("El tablero informa al jugador de que se ha unido a la partida");
            // Creo el tablero en la base de creencias del jugador.
            Tablero tab = new Tablero();
            tab.setAgentID(action.getTableroID());
            tab.setFaseActual("inicioJuego");
            getBeliefbase().getBelief("miTablero").setFact(tab); // Actualizo el tablero en mi base de creencias

            // Actualizo mi lista de jugadores con el array que obtengo de unirsePartida
            Jugador[] jugsList = action.getAllJug();
            for (Jugador jug : jugsList) {
                if (jug.getAgentID() == action.getAgentID()) {
                    getBeliefbase().getBelief("myself").setFact(jug); // me actualizo a mi mismo
                } else {
                    getBeliefbase().getBeliefSet("jugadores").addFact(jug); // actualizo al resto de jugadores
                }
            }
            System.out.println("Se han actualizado los datos de todos los jugadores en mi base de creencias");

        } else {
            // El tablero envia refuse al jugador
            System.out.println("El tablero informa al jugador de no puede unirse a la partida");
        }
    }

}
