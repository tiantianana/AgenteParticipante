package jugador.plans;

import jadex.runtime.*;
import jadex.adapter.fipa.SFipa;
import jadex.runtime.IMessageEvent;
import ontology.concepts.*;
import ontology.predicates.*;
import ontology.actions.*;

public class waitIntentarAsesinarPlan extends Plan {

    public void body() {

        IMessageEvent msgrec = (IMessageEvent) getInitialEvent(); // recivo el mensaje del tablero
        intentarAsesinar action = (intentarAsesinar) msgrec.getContent(); // accedo al contenido del mensaje
        imposibilidadAsesinato imp = (imposibilidadAsesinato) msgrec.getContent(); 

        if (action != null) {

            System.out.println("El asesinato se ha completado excitosamente");
            // Si se acepta el request: elimino la carta del jugador que usa
            Carta[] cards = (Carta[]) getBeliefbase().getBeliefSet("cartas").getFacts();;
            // Busco mi carta de asesinato y la elimino, pues ya la he utilizado
            for (Carta ad : cards) {
                if (ad.getTipoCarta() == 5) {
                    getBeliefbase().getBeliefSet("cartas").removeFact(ad);
                }
            }

            Jugador[] players = (Jugador[]) getBeliefbase().getBeliefSet("jugadores").getFacts();;
            Jugador me = (Jugador) getBeliefbase().getBelief("myself").getFact();
            Jugador target = players[0];

            // Actualizo los datos del mi jugador(myself) y el jugador objetivo
            for (Jugador ap : players) {
                if (ap == action.getObjetivo()) {
                    target = ap;
                }
            }

            // Eliminamos los antiguos valores del asesino y el asesinado
            getBeliefbase().getBeliefSet("jugadores").removeFact(target);
            getBeliefbase().getBeliefSet("jugadores").addFact(action.getAsesino());
            getBeliefbase().getBelief("mysef").setFact(me);


        } else if (imp != null) {

            System.out.println("No se ha podido completar el asesinato");
            
        }

    }

}
