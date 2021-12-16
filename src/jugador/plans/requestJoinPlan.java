package jugador.plans;

import jadex.runtime.*;
import jadex.adapter.fipa.AgentDescription;
import jadex.adapter.fipa.AgentIdentifier;
import jadex.adapter.fipa.SFipa;
import jadex.runtime.IMessageEvent;
import java.util.ArrayList;
import java.util.*;
import ontology.concepts.*;
import ontology.predicates.*;
import ontology.actions.*;
import jadex.adapter.fipa.SearchConstraints;
import jadex.adapter.fipa.ServiceDescription;
import jadex.runtime.IGoal;

public class requestJoinPlan extends Plan{
    
    public void body() {

        // Buscamos si existe un tablero al que se pueda unir
        ServiceDescription sd = new ServiceDescription();
		sd.setType("tablero");
		AgentDescription dfadesc = new AgentDescription();
		dfadesc.addService(sd);
		IGoal ft = createGoal("df_search");
		ft.getParameter("description").setValue(dfadesc);
		dispatchSubgoalAndWait(ft);
		AgentDescription[]	result	= (AgentDescription[])ft.getParameterSet("result").getValues();
		AgentIdentifier tableroID = result[0].getName();
    
        // El jugador envia un request para unirse a la partida
        unirsePartida action = new unirsePartida();
        // Creo el mensaje de unirse a la partida y espero a que el tablero me diga si puedo entrar o no

        System.out.println("Jugador pregunta si puede unirse a la partida");
        IMessageEvent msgsend = createMessageEvent("RequestUnirsePartida");
        action.setAgentID(tableroID);
        msgsend.setContent(action);
        msgsend.getParameterSet(SFipa.RECEIVERS).addValue(tableroID);
        sendMessage(msgsend);
    }
}