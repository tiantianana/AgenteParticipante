package jugador.plans;

import jadex.runtime.*;
import jadex.adapter.fipa.AgentIdentifier;
import jadex.adapter.fipa.SFipa;
import jadex.runtime.IMessageEvent;
import java.util.ArrayList;
import java.util.*;
import ontology.concepts.*;
import ontology.predicates.*;
import ontology.actions.*;


public class waitGolpeEstadoPlan extends Plan{

    public void body() {
        IMessageEvent msgrec = (IMessageEvent) getInitialEvent(); // recivo el mensaje del tablero
        darGolpe action = (darGolpe) msgrec.getContent(); // accedo al contenido del mensaje
        imposibilidadGolpe refuse = (imposibilidadGolpe) msgrec.getContent(); // accedo al contenido del mensaje

        if (action != null) {
            System.out.println("Se ha aceptado el golpe de estado");
            Tablero tab = (Tablero) getBeliefbase().getBelief("miTablero").getFact();
            tab.setGolpeDeEstado(true);
            // Actualizamos el tablero para el golpe de estado
            getBeliefbase().getBelief("miTablero").setFact(tab);

            Jugador me = (Jugador) getBeliefbase().getBelief("myself").getFact();
            me.setEsLeal(false); // No soy leal al presidente porque he dado un golpe de estado
            getBeliefbase().getBelief("myself").setFact(me);

        } else if (refuse != null) {

            System.out.println("No se ha podido completar el golpe de estado");
            Tablero tab = (Tablero) getBeliefbase().getBelief("miTablero").getFact();
            tab.setGolpeDeEstado(false);
            // Actualizamos el tablero para el golpe de estado
            getBeliefbase().getBelief("miTablero").setFact(tab);

        } else {
            
        }
    }
}
