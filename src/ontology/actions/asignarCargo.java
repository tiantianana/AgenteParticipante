package ontology.actions;

import ontology.concepts.Jugador;

public class asignarCargo implements action {

    //Atributos
    private Jugador jug;
    private String cargo;

    public asignarCargo() {
    }

    //Getters y setters
    public Jugador getJugador() {
        return jug;
    }

    public void setJugador(Jugador jug) {
        this.jug = jug;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
