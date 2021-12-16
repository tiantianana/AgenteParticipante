package tablero.plans;

import jadex.runtime.*;
import ontology.concepts.Jugador;
import ontology.predicates.*;
import jadex.adapter.fipa.AgentIdentifier;
import jadex.adapter.fipa.SFipa;
import java.util.ArrayList;
import ontology.concepts.Tablero;

public class comienzaPartidaPlan extends Plan{
    
    public void body()
	{
		System.out.println("Que empiece la partida!!!");
		Tablero tab = (Tablero) getBeliefbase().getBelief("miTablero").getFact();
		tab.setFaseActual("inicioPartida");
		getBeliefbase().getBelief("miTablero").setFact(tab);

	}
}
