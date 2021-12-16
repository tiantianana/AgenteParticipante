package ontology.concepts;
// Tipo

public class Carta implements Concept {

    /*
    public enum TipoCarta{
        evento, soborno, donacion, voto, asesino;
    }*/

    private int valor;
    //private TipoCarta tipocarta;
   
    // Asingo un int a cada tipo de carta
    private int tipoCarta;
    // tipo 1: evento
    // tipo 2: soborno
    // tipo 3: donacion
    // tipo 4: voto
    // tipo 5: asesinato

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
	
	public int getTipoCarta() {
		return tipoCarta;
	}

    public void setTipoCarta(int tipocarta) {
        this.tipoCarta = tipocarta;
    }
    
	public Carta()
	{ ; }

    public Carta(int valor, int tipo){ 
        this.valor = valor;
        this.tipoCarta = tipo;
    }

}
