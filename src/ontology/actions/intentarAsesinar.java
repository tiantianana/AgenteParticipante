package ontology.actions;
import java.util.*;
import ontology.concepts.Carta;
import ontology.concepts.Jugador;

public class intentarAsesinar implements action {


    private Jugador asesino;
    private Jugador objetivo;
    private int adivina_loc;
    
    public intentarAsesinar() {
    }

    public int getAdivinaLoc() {
        return adivina_loc;
    }

    public void setAdivinaLoc(int adivina_loc) {
        this.adivina_loc = adivina_loc;
    }

    public Jugador getAsesino() {
        return asesino;
    }

    public void setAsesino(Jugador asesino) {
        this.asesino = asesino;
    }

    public Jugador getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Jugador objetivo) {
        this.objetivo = objetivo;
    }

}
