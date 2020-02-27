package es.mdef.acing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class Partido implements EventoConGoles {//EventoConLocalYVisitante, GestorSucesos {
	Participante local, visitante;
	LocalDateTime fecha;
//	Suceso golesLocal, golesVisitante, cornerLocal, cornerVisitante;
	private Collection<Suceso> sucesos;
	
	@Override
	public Participante getLocal() {
		return local;
	}

	public void setLocal(Participante local) {
		this.local = local;
	}

	@Override
	public Participante getVisitante() {
		return visitante;
	}

	public void setVisitante(Participante visitante) {
		this.visitante = visitante;
	}

	@Override
	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String getResultado() {
		return getGolesLocal().size() + " - " + getGolesVisitante().size();
	}
	
	@Override
	public Collection<Suceso> getSucesos() {
		if (sucesos == null) {
			sucesos = new ArrayList<>();
		}
		return sucesos;
	}

	@Override
	public String toString() {
		return getLocal() + " " + getResultado() + " " + getVisitante()
				+ " " + getFecha() + "";
	}

	
}
