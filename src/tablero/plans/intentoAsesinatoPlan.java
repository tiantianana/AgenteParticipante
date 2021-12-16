// ANA
package tablero.plans;

import jadex.runtime.*;
import jadex.adapter.fipa.AgentIdentifier;
import jadex.adapter.fipa.SFipa;
import jadex.runtime.IMessageEvent;
import ontology.concepts.*;
import ontology.predicates.*;
import ontology.actions.*;

public class intentoAsesinatoPlan extends Plan{

    public void body() {

        // Request(intentar_asesinar, localizacion, jugador)
        IMessageEvent msgrec = (IMessageEvent) getInitialEvent();
        IMessageEvent msgsend;
        intentarAsesinar action = (intentarAsesinar) msgrec.getContent(); // accedo al contenido del mensaje
        AgentIdentifier sender = (AgentIdentifier) msgrec.getParameter("sender").getValue(); // accedo al emisor del mensaje

        // Obtenemos jugador y tablero de la base Belief
        Tablero tab = (Tablero) getBeliefbase().getBelief("miTablero").getFact();
        Jugador[] players = (Jugador[]) getBeliefbase().getBeliefSet("jugadores").getFacts();;
        Jugador target = new Jugador();
        Jugador asesino = new Jugador();
        for(Jugador ahp : players){
            if(ahp == action.getAsesino()) asesino = ahp;
            else if (ahp == action.getObjetivo()) target = ahp;
        }
        
        //Comprobamos que el agente que realiza tiene la carta necesaria
        msgsend = createMessageEvent("QueryIfTieneCartaMsg");
        msgsend.getParameterSet(SFipa.RECEIVERS).addValue(sender);
        msgsend.setContent(new tieneCarta()); // Relleno el contenido.
        msgrec = sendMessageAndWait(msgsend, 10000);
        tieneCarta tiene = (tieneCarta) msgrec.getContent();

        // Compruebo que el jugador y el asesino son distintos. No puede intentar
        // asesinarse a si mismo!
        if (target == null && asesino == null) {
            System.out.println("No se puede asesinar si no hay asesino o asesinado");
            msgsend = createMessageEvent("RefuseAsesinatoMsg"); // Creo un mensaje
            msgsend.getParameterSet(SFipa.RECEIVERS).addValue(sender); // Asigno un destinatario
            imposibilidadAsesinato imp = new imposibilidadAsesinato();
            imp.setValor(true);
            msgsend.setContent(imp); // Relleno el contenido.
            sendMessage(msgsend);
            // Comprobamos si la fase actual es intentar asesinar
        } else if (tab.getFaseActual() != "IntentarAsesinar") {
            System.out.println("Solo se puede asesinar en la fase de asesinatos");
            msgsend = createMessageEvent("RefuseAsesinatoMsg"); // Creo un mensaje
            msgsend.getParameterSet(SFipa.RECEIVERS).addValue(sender); // Asigno un destinatario
            msgsend.setContent(new imposibilidadAsesinato()); // Relleno el contenido.
            sendMessage(msgsend);
            // Comprobamos si tiene la carta de asesinato
        } else if (tiene == null || tiene.getCard().getTipoCarta() != 5) {
            System.out.println("No puedes asesinar sin la carta de asesinato");
            msgsend = createMessageEvent("RefuseAsesinatoMsg"); // Creo un mensaje
            msgsend.getParameterSet(SFipa.RECEIVERS).addValue(sender); // Asigno un destinatario
            msgsend.setContent(new imposibilidadAsesinato()); // Relleno el contenido.
            sendMessage(msgsend);
        }
        // Comprobamos la localizacion del jugador y si adivina la localizacion
        else if (target.getLocalizacion() != action.getAdivinaLoc()) {
            System.out.println("No has adivinado la localizacion del jugador");
            msgsend = createMessageEvent("RefuseAsesinatoMsg"); // Creo un mensaje
            msgsend.getParameterSet(SFipa.RECEIVERS).addValue(sender); // Asigno un destinatario
            msgsend.setContent(new imposibilidadAsesinato());
            sendMessage(msgsend);
            // Comprobamos si el jugador esta muerto
        } else if (target.isMuerto()) {
            System.out.println("No se puede intentar asesinar a un jugador muerto.");
            msgsend = createMessageEvent("RefuseAsesinatoMsg"); // Creo un mensaje
            msgsend.getParameterSet(SFipa.RECEIVERS).addValue(sender); // Asigno un destinatario
            msgsend.setContent(new imposibilidadAsesinato()); // Relleno el contenido.
            sendMessage(msgsend);
        } else {
            // Agree(intentar_asesinar, localizacion, jugador)
            msgsend = createMessageEvent("AgreeAsesinatoMsg");
            msgsend.getParameterSet(SFipa.RECEIVERS).addValue(sender);
            msgsend.setContent(action);
            sendMessage(msgsend);
            getBeliefbase().getBeliefSet("jugadores").removeFact(target);
            getBeliefbase().getBeliefSet("jugadores").removeFact(asesino);

            // El jugador da el efectivo al asesino
            if (target.getEfectivo() > 0) {
                asesino.setEfectivo(asesino.getEfectivo() + target.getEfectivo());
            }
            if (target.getNCartas() > 0) {
                asesino.setNCartas(asesino.getEfectivo() + target.getNCartas());
            }

            // update jugador a muerto y quitar las cartas y dinero.
            target.setMuerto(true);
            target.setEfectivo(0); // Pongo a cero el efectivo del jugador pq esta muerto
            target.setNCartas(0);

            getBeliefbase().getBeliefSet("jugadores").addFact(target);
            getBeliefbase().getBeliefSet("jugadores").addFact(asesino);

            // Añado una carta a la pila de cartas del tablero
            Carta[] cards = (Carta[]) getBeliefbase().getBeliefSet("cartas").getFacts();
            for (Carta ad : cards) {
                if (ad == tiene.getCard()) {
                    getBeliefbase().getBeliefSet("cartas").addFact(ad);
                }
            }
        }
    }
}
