package es.mdef.acing;

import java.time.LocalDateTime;

public class Evento {
	String local, visitante;
	LocalDateTime fecha;
	int golesLocal, golesVisitante, cornerLocal, cornerVisitante;

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getVisitante() {
		return visitante;
	}

	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	public int getCornerLocal() {
		return cornerLocal;
	}

	public void setCornerLocal(int cornerLocal) {
		this.cornerLocal = cornerLocal;
	}

	public int getCornerVisitante() {
		return cornerVisitante;
	}

	public void setCornerVisitante(int cornerVisitante) {
		this.cornerVisitante = cornerVisitante;
	}
	
	@Override
	public String toString() {
		return getLocal() + " " + getGolesLocal() + " - "
				+ getGolesVisitante() + " " + getVisitante()
				+ " " + getFecha() + "";
	}
	
}
