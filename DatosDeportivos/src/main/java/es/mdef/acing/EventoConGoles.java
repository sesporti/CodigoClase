package es.mdef.acing;

import java.util.ArrayList;
import java.util.Collection;

public interface EventoConGoles extends EventoConLocalYVisitante, GestorSucesos {

	default Collection<Suceso> getGolesLocal() {
		return getGolesParticipante(getLocal());
	}

	default Collection<Suceso> getGolesVisitante() {
		return getGolesParticipante(getVisitante());
	}
	
	default Collection<Suceso> getGolesParticipante(Participante participante) {
		Collection<Suceso> goles = new ArrayList<Suceso>();
		for (Suceso s : getSucesos()) {
			if (s.getClass().getSimpleName().contentEquals("Gol")
					&& s.getParticipante().equals(participante)) {
				goles.add(s);
			}
		}
		return goles;
	}

}