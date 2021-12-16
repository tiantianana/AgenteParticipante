package ontology.actions;
import ontology.concepts.Tablero;

public class cambiarFase implements action {

    private Tablero tab;
    private String nueva_fase;
    private String old_fase;

    public String getNuevaFase() {
        return nueva_fase;
    }

    public void setNuevaFase(String nueva_fase) {
        this.nueva_fase = nueva_fase;
    }

    public Tablero getTab() {
        return tab;
    }

    public void setTab(Tablero tab) {
        this.tab = tab;
    }

    public String geOldtFase() {
        return old_fase;
    }

    public void setOldFase(String fase) {
        this.old_fase= fase;
    }

    public cambiarFase() {
    }
}
