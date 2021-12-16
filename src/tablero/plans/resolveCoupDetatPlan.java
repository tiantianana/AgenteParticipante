package tablero.plans;

import jadex.runtime.*;
import jadex.adapter.fipa.SFipa;
import java.util.ArrayList;
import ontology.concepts.Tablero;
import jadex.adapter.fipa.*;

import ontology.concepts.*;
import ontology.predicates.*;
import ontology.actions.*;
public class resolveCoupDetatPlan extends Plan
{
	//-------- methods --------
	
	/**
	 *  Plan body.
	 */

	public void body()
	{
        IMessageEvent msgsend, msgrec;
        // Encuentro a todos los jugadores para resolver el golpe
        ServiceDescription sd = new ServiceDescription();
        sd.setType("voto");
        sd.setName("jugador");
        AgentDescription dfadesc = new AgentDescription();
        dfadesc.addService(sd);
        SearchConstraints	sc	= new SearchConstraints();
        sc.setMaxResults(-1);
        IGoal ft = createGoal("df_search");
        ft.getParameter("description").setValue(dfadesc);
        ft.getParameter("constraints").setValue(sc);
        dispatchSubgoalAndWait(ft);
        System.out.println ("Buscando jugadores...");
        AgentDescription[] result	= (AgentDescription[])ft.getParameterSet("result").getValues();
        Tablero tab = (Tablero) getBeliefbase().getBelief("miTablero").getFact();
        if (result.length>0)
        {
            // Les informo del golpe de estado
            msgsend = createMessageEvent("InformGolpeEstadoMsg");
            enGolpe eg = new enGolpe();
            eg.setTablero(tab);
            msgsend.setContent(eg);
            for(AgentDescription des : result) {
                msgsend.getParameterSet(SFipa.RECEIVERS).addValue(des.getName());
            }
            sendMessage(msgsend);
            int votes = 0; // 0 votos es victoria para el presidente 
            //Pregunta a cada jugador por su voto
            for(AgentDescription des : result){
                msgsend = createMessageEvent("QueryIfRebeldeMsg");
                msgsend.getParameterSet(SFipa.RECEIVERS).addValue(des.getName());
                msgsend.setContent(new esRebelde());
                msgrec = sendMessageAndWait(msgsend, 10000);
                esRebelde voto = (esRebelde) msgrec.getContent();
                if(voto.getValor()){
                    votes ++;
                } else {
                    votes --;
                }
            }
            // Informa del resultado del golpe
            msgsend = createMessageEvent("InformResultadoGolpe");
            for(AgentDescription des : result) {
                msgsend.getParameterSet(SFipa.RECEIVERS).addValue(des.getName());
            }
            ganaPresi gp = new ganaPresi();
            if(votes<=0) {
                gp.setValor(true);
            } else {
                gp.setValor(false);
            }
            msgsend.setContent(gp);
            
            tab.setFaseActual("DiaDespues");
            tab.setSituacionInestable(false);
            tab.setGolpeDeEstado(false);
            getBeliefbase().getBelief("miTablero").setFact(tab);
            sendMessage(msgsend);   
        }
        else{
            System.out.println("Los jugadores se marcharon...");

        }       
        
	}
}
