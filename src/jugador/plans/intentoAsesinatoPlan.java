package jugador.plans;

import jadex.runtime.*;
import jadex.adapter.fipa.AgentIdentifier;
import jadex.adapter.fipa.SFipa;
import jadex.runtime.IMessageEvent;
import jugador.beliefs.AgentLocation;
import java.util.ArrayList;
import java.util.*;
import ontology.concepts.*;
import ontology.predicates.*;
import ontology.actions.*;

public class intentoAsesinatoPlan extends Plan {

    public void body() {

        // Request(intentar_asesinar, localizacion, jugador) al tablero
        IMessageEvent msgsend;
        Jugador[] players = (Jugador[]) getBeliefbase().getBeliefSet("jugadores").getFacts();
        Jugador me = (Jugador) getBeliefbase().getBelief("myself").getFact();
        Tablero tab = (Tablero) getBeliefbase().getBelief("miTablero").getFact();
        Jugador target;

        // Buscamos las cartas que tiene en la base de creencias
        Carta[] cards = (Carta[]) getBeliefbase().getBeliefSet("cartas").getFacts();
        boolean tiene = false;
        for (Carta ac : cards) {
            // Tipo carta 5 equivale a carta asesinato
            if (ac.getTipoCarta() == 5) {
                tiene = true;
                break;
            }
        }

        // Estrategia del jugador, solo intentar asesinar cuando tiene la carta de
        // asesinato
        // en caso contrario, el tablero rechazá la petición
        // Además tb comprobamos que estamos en la fase de asesinato
        if (tab.getFaseActual() == "IntentarAsesinar" && tiene) {

            // Creamos una lista con todos los jugadores que se puede asesinar
            List<Jugador> chooseTarget = new ArrayList<Jugador>();
            for (Jugador ahp : players) {
                // Si el jugador esta muerto, no esta en ninguna localizacion o esta en la
                // embajada, no se le puede matar y por tanto el jugador decide no asesinar
                if (ahp.isMuerto() == false && ahp.getLocalizacion() != 0
                        && ahp.getLocalizacion() != 6 && ahp != me) {
                    chooseTarget.add(ahp);
                }
            }

            if (chooseTarget.size() == 0) {
                System.out.println("No puedo asesinar a ningun jugador, por tanto no utilizo la carta de asesinar");
            } else {
                // Decision del experto: busca de entre estos jugadores que se puede matar, a
                // aquel que tenga
                // más dinero y ese va a ser el jugador que decida intentar asesinar

                target = chooseTarget.get(0);
                for (Jugador ap : chooseTarget) {
                    if (ap.getEfectivo() > target.getEfectivo()) {
                        target = ap; // Actualizamos nuestra target con el nuevo jugador que tiene mas efectivo
                    }
                }

                System.out.println("El jugador manda request al tablero para intentar asesinar a la familia "
                        + target.getFamilia());
                msgsend = createMessageEvent("RequestAsesinatoMsg");

                intentarAsesinar action = new intentarAsesinar();

                // Buscamos en la base de belief las localizaciones que ya ha probado para ese
                // jugador
                AgentLocation[] AgentLoc = (AgentLocation[]) getBeliefbase().getBeliefSet("localizaciones").getFacts();
                // Lista de localizaciones
                // localizacion 0: Ninguna
                // localizacion 1: Banco
                // localizacion 2: Cuartel_General
                // localizacion 3: Casa
                // localizacion 4: Querida
                // localizacion 5: Nightclub
                // localizacion 6: Embajada
                int i = 0;
                for (AgentLocation al : AgentLoc) {
                    if (al.getObjetivo() == target) {
                        List<Integer> locations =  al.getLocation();
                        for (int loc : locations) {
                            if (i < loc) {
                                i++;
                            } else {
                                // Establecemos la localizacion siguiente a la que habia en la base de creencias
                                locations.add(i);
                                break;
                            }
                        }
                    }
                }

                // actualizamos el mensaje para enviarselo al tablero
                action.setAsesino(me);
                action.setObjetivo(target);
                action.setAdivinaLoc(i);

                msgsend.setContent(action); // Envio la accion intentar asesinar
                msgsend.getParameterSet(SFipa.RECEIVERS).addValue(tab.getAgentID());
                sendMessage(msgsend);

            }
        }

    }

}
