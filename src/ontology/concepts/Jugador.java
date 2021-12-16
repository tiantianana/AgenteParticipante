package ontology.concepts;

import jadex.adapter.fipa.AgentIdentifier;
// Tipo


public class Jugador implements Concept {

    //Atributos enumerados
    /*
    public enum Location{
        Ninguna, Banco, Cuartel_General, Casa, Querida, Nightclub, Embajada
    }
    public enum TipoCargo{
        Ninguno, Presidente, Ministro_interior, General, Almirante, Comandante
    }
    public enum Familia{
        f1,f2,f3,f4,f5,f6,f7
    }*/

    private AgentIdentifier aid;

    //Atributos
    private int efectivo;
    private boolean muerto;
    private boolean exhiliado;
    private int n_cartas;
    //private Location localizacion;
    private boolean es_leal;
    //private TipoCargo cargo;
    //private Familia familia;
    private int votos;
    private int influencia;
    private int familia;
    private int localizacion;
    // localizacion 0: Ninguna
    // localizacion 1: Banco
    // localizacion 2: Cuartel_General
    // localizacion 3: Casa
    // localizacion 4: Querida
    // localizacion 5: Nightclub
    // localizacion 6: Embajada

    private String cargo;

    public AgentIdentifier getAgentID() {
		return aid;
	}

	public void	setAgentID(AgentIdentifier aid) {
		this.aid	= aid;
	}

    public int getFamilia() {
        return familia;
    }

    public void setFamilia(int familia) {
        this.familia = familia;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean getEsLeal() {
        return es_leal;
    }

    public void setEsLeal(boolean leal) {
        this.es_leal = leal;
    }

    public int getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(int efectivo) {
        this.efectivo = efectivo;
    }

    public boolean isMuerto() {
        return muerto;
    }

    public void setMuerto(boolean muerto) {
        this.muerto = muerto;
    }

    public int getNCartas() {
        return n_cartas;
    }

    public void setNCartas(int n_cartas) {
        this.n_cartas = n_cartas;
    }

    public int getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(int localizacion) {
        this.localizacion = localizacion;
    }

    public boolean isExhiliado() {
        return exhiliado;
    }

    public void setExhiliado(boolean exhiliado) {
        this.exhiliado = exhiliado;
    }

    public Jugador()
    { ; }

    public Jugador(int fam, int efectivo, boolean muerto) {
        this.familia = fam;
        this.efectivo = efectivo;
        this.muerto = muerto;
    }

}