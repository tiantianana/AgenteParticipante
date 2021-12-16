package ontology.actions;
import java.util.*;
import ontology.concepts.Jugador;

public class elegirLocalizacion implements action {

    private Jugador jug;
    private List<Integer> localizacion;

    public elegirLocalizacion() {
    }

    public Jugador getJugador() {
        return jug;
    }

    public void setJugador(Jugador jug) {
        this.jug = jug;
    }

    public List<Integer> getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(List<Integer> localizacion) {
        this.localizacion = localizacion;
    }

}
