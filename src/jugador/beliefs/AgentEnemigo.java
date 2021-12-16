package jugador.beliefs;

import jadex.runtime.*;
import java.util.*;


public class AgentEnemigo {

    public boolean isEnemigo(int familia1, int familia2) {

        boolean enemigo = false;
        Map<Integer, Integer> enemistad = new HashMap();
        enemistad.put(1, 2);
        enemistad.put(3, 4);
        enemistad.put(5, 7);
        enemistad.put(6, 5);

        Set set = enemistad.entrySet();// Converting to Set so that we can traverse
        Iterator itr = set.iterator();

        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            if (entry.getKey() == entry.getValue()) {
                enemigo = true;
                System.out.println("El presidente es enemigo mio!!");
                break;
            }
        }
        return enemigo;
    }
}
