package ontology.actions;

import ontology.concepts.Jugador;

public class votar implements action {

    private Jugador votante;
    private Jugador votado;
    private int votos;

    public votar() {
    }

    public Jugador getVotante() {
        return this.votante;
    }

    public void setVotante(Jugador votante) {
        this.votante = votante;
    }

    public Jugador getVotado() {
        return this.votado;
    }
    public int getVotos() {
        return this.votos;
    }

    public void setVotado(Jugador votado) { this.votado = votado; }

    public void setVotos(int n_votos) { this.votos = n_votos;}
    // votar a jug1 => jug1.votos ++
}
