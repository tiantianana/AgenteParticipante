package tablero.plans;

import jadex.runtime.*;
import ontology.predicates.*;
import jadex.adapter.fipa.AgentIdentifier;
import jadex.adapter.fipa.SFipa;
import java.util.*;
import jadex.adapter.fipa.*;
import ontology.concepts.*;
import ontology.predicates.*;
import ontology.actions.unirsePartida;

public class completarJugadoresPlan extends Plan {

    public void body() {

        ServiceDescription sd = new ServiceDescription();
        sd.setType("jugadores");
        sd.setName("jugador");
        AgentDescription adesc = new AgentDescription();
        adesc.addService(sd);
        SearchConstraints sc = new SearchConstraints();
        sc.setMaxResults(-1);
        IGoal busqueda = createGoal("df_search");
        busqueda.getParameter("description").setValue(adesc);
        busqueda.getParameter("constraints").setValue(sc);
        dispatchSubgoalAndWait(busqueda);
        AgentDescription[] result = (AgentDescription[]) busqueda.getParameterSet("result").getValues();
        int numjug = result.length;
        System.out.println(numjug + " jugadores encontrados");

        // Request(unirsePartida, jugador)
        IMessageEvent msgsend;
        IMessageEvent	msgrec	= (IMessageEvent) getInitialEvent();
        unirsePartida action = (unirsePartida) msgrec.getContent(); // accedo al contenido del mensaje
        AgentIdentifier sender = (AgentIdentifier) msgrec.getParameter("sender").getValue(); // mensaje
        Tablero tab = (Tablero) getBeliefbase().getBelief("miTablero").getFact();

        // Agree(unirsePartida, jugador)
        int contador = 0;
        for (AgentDescription ad : result) {
            // Creo un nuevo jugador y le asigno la familia del contador
            Jugador jug = new Jugador(contador, 0, false);
            if (!getBeliefbase().getBeliefSet("jugadores").containsFact(jug)) {
                AgentIdentifier aid = result[contador].getName();
                jug.setAgentID(aid);
                getBeliefbase().getBeliefSet("jugadores").addFact(jug);
                contador++;
            }
        }
        
        getBeliefbase().getBelief("numJugs").setFact(numjug); // Actualizo el número de jugadores
        // obtengo todos los jugadores para enviar los datos al resto de jugadores
        Jugador[] players = (Jugador[]) getBeliefbase().getBeliefSet("jugadores").getFacts();
        action.setAllJug(players);
    
        for (AgentDescription des : result) {
            // Envio un agree a cada uno de los jugadores
            msgsend = createMessageEvent("AgreeUnirsePartida");
            msgsend.getParameterSet(SFipa.RECEIVERS).addValue(des.getName());
            msgsend.setContent(action);
        }
        
    }

}