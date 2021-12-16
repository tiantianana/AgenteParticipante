package ontology.predicates;
import ontology.concepts.Jugador;
import ontology.concepts.Tablero;

public class imposibilidadProponerPresupuesto extends Predicate {
    
    private Tablero tab;

    public imposibilidadProponerPresupuesto(){
    }

    public Tablero getTab(){
        return this.tab;
    }

    public void setTab(Tablero tab){
        this.tab = tab;
    }
}
