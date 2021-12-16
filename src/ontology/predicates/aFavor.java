package ontology.predicates;

import ontology.concepts.Jugador;

public class aFavor extends Predicate{

    private int presupuesto;
    
    public aFavor() {
    }

    public int getPresupuesto() {
        return presupuesto;
    }
    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }
    
}
