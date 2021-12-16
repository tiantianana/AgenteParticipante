package jugador.beliefs;
import java.util.*;
import ontology.concepts.Jugador;

public class AgentLocation {

    protected List<Integer> loc;
    protected Jugador objetivo;

    public Jugador getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Jugador obj) {
        this.objetivo = obj;
    }

    public List<Integer> getLocation() {
        return loc;
    }

    public void setLocation(List<Integer> loc) {
        this.loc = loc;
    }
}
