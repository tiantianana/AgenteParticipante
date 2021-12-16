package ontology.actions;
import ontology.concepts.Jugador;
import ontology.predicates.esPresidente;

public class proponerPresupuestos implements action{
    //Atributos
    private Jugador jug;
    private int presupuesto;
    private esPresidente presidente;
    public proponerPresupuestos(){
    }
    public void setJugador(Jugador jug){
        this.jug = jug;
    }
    public Jugador getJugador(){
        return this.jug;
    }
    public void setPresupuesto(int presupuesto){
        this.presupuesto = presupuesto;
    }
    public int getPresupuesto(){
        return this.presupuesto;
    }
    public void setPresidente(esPresidente presidente){
        this.presidente = presidente;
    }
    public esPresidente getPresidente(){
        return this.presidente;
    }
    
}
