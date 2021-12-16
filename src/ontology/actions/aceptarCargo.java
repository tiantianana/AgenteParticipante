package ontology.actions;

import ontology.concepts.Jugador;

public class aceptarCargo {

    //Atributos
    private Jugador jug;
    private String cargo;
    private boolean aceptaCargo;

    public aceptarCargo() {
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

    public boolean getAceptaCargo(){ return this.aceptaCargo; }
    public void setAceptaCargo(boolean acepta){ this.aceptaCargo = acepta; }
}
