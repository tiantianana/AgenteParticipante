package ontology.concepts;

import jadex.adapter.fipa.AgentIdentifier;
public class Tablero implements Concept {

    //Atributos
    private boolean golpe_estado;
    private boolean situacion_inestable;
    private String estado_banco;
    private String fase_actual;
    private int dinero_restante;
    private Jugador presidente;
    private AgentIdentifier aid;

    public Tablero() {
        ;
    }

    public AgentIdentifier getAgentID() {
		return aid;
	}

	public void	setAgentID(AgentIdentifier aid) {
		this.aid = aid;
	}

    public int getDineroRestante() {
        return dinero_restante;
    }

    public void setDineroRestante(int dinero_restante) {
        this.dinero_restante = dinero_restante;
    }

    //Getters y setters
    public String getEstadoBanco() {
        return estado_banco;
    }

    public void setEstadoBanco(String estado_banco) {
        this.estado_banco = estado_banco;
    }

    public String getFaseActual() {
        return fase_actual;
    }

    public void setFaseActual(String fase_actual) {
        this.fase_actual = fase_actual;
    }

    public boolean getGolpeDeEstado() {
        return golpe_estado;
    }

    public void setGolpeDeEstado(boolean golpe_estado) {
        this.golpe_estado = golpe_estado;
    }

    public boolean getSituacionInestable() {
        return situacion_inestable;
    }

    public void setSituacionInestable(boolean situacion_inestable) {
        this.situacion_inestable = situacion_inestable;
    }

    public void setPresident(Jugador newPresident) {
        this.presidente = newPresident;
    }
    public Jugador getPresident() {
        return this.presidente;
    }

    // Definicion atributos
    //String de fase: opciones
    /*
        inicioJuego, VotacionParte1, VotacionParte2, TomarCartas, AsignarCargos, RecibirAyudaExtranjera, ProponerPresupuesto,
        elegirLocalizaciones, IntentarAsesinar, OperacionesBancarias, IntentarGolpe, DiaDespues, FinJuego
    */
    // String de Banco
    /*
        CerradoVacaciones, CerradoComer, Abierto;
    }*/

}
