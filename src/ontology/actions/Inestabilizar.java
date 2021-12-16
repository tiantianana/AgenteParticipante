
package ontology.actions;
// Tipo
// Argumentos (Conceptos)

import ontology.concepts.Tablero;

public class Inestabilizar implements action {

    public Tablero getRepublica() {
        return republica;
    }

    public void setRepublica(Tablero republica) {
        this.republica = republica;
    }

    private Tablero republica;

    public Inestabilizar() {
    }

}