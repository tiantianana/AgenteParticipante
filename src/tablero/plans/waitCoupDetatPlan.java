package tablero.plans;

import jadex.runtime.*;
import ontology.predicates.*;
import ontology.actions.*;
import jadex.adapter.fipa.AgentIdentifier;
import jadex.adapter.fipa.SFipa;
import java.util.ArrayList;
import ontology.concepts.Tablero;

import ontology.concepts.*;
import ontology.predicates.*;
import ontology.actions.*;
public class waitCoupDetatPlan extends Plan {
	// -------- methods --------

	/**
	 * Plan body.
	 */

	public void body() {
		IMessageEvent msgrec = (IMessageEvent) getInitialEvent();
		darGolpe action = (darGolpe) msgrec.getContent();
		AgentIdentifier sender = (AgentIdentifier) msgrec.getParameter("sender").getValue();
		Tablero tab = (Tablero) getBeliefbase().getBelief("miTablero").getFact();
		System.out.println("Consultando si se puede realizar el golpe...");
		IMessageEvent msgsend;
		Jugador[] players = (Jugador[]) getBeliefbase().getBeliefSet("jugadores").getFacts();
		boolean isPlayer = false;
		for (Jugador ahp : players) {
			if ((ahp.getFamilia() == action.getJugador().getFamilia()) && (ahp.getAgentID() == sender)) {
				isPlayer = true;
				break;
			}
		}

		if ((!isPlayer) ||
				(tab.getFaseActual() != "IntentarGolpe") ||
				(!tab.getSituacionInestable()) ||
				(tab.getGolpeDeEstado())) {
			// comunicamos que no se puede realizar la petición
			msgsend = createMessageEvent("RefuseGolpeEstadoMsg");
			imposibilidadGolpe imp = new imposibilidadGolpe();
			imp.setJugador(action.getJugador());
			msgsend.setContent(imp);
			msgsend.getParameterSet(SFipa.RECEIVERS).addValue(sender);
			sendMessage(msgsend);
		} else {
			// Actualiza estado del tablero
			tab.setGolpeDeEstado(true);
			getBeliefbase().getBelief("miTablero").setFact(tab);
			// Confirmamos que la acción será realizada
			msgsend = createMessageEvent("AgreeGolpeEstadoMsg");
			msgsend.setContent(action);
			msgsend.getParameterSet(SFipa.RECEIVERS).addValue(sender);
			sendMessage(msgsend);
		}
	}
}
