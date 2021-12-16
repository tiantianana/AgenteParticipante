package jugador.plans;

import jadex.runtime.Plan;
import java.util.*;
import ontology.concepts.*;
import ontology.predicates.*;
import ontology.actions.*;

public class comienzaPartidaPlan extends Plan{

    public void body()
	{
		System.out.println("Que empiece la partida!!!");
	}
}
