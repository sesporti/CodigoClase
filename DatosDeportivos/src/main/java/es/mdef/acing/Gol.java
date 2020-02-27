package es.mdef.acing;

public class Gol implements Suceso {
	Participante participante;

	public Gol(Participante participante) {
		this.participante = participante;
	}
	
	@Override
	public Participante getParticipante() {
		return participante;
	}
}
