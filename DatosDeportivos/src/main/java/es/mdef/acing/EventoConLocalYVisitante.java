package es.mdef.acing;

import java.util.Arrays;
import java.util.Collection;

public interface EventoConLocalYVisitante extends Evento {

	Participante getLocal();

	Participante getVisitante();

	@Override
	default Collection<Participante> getParticipantes() {
		return Arrays.asList(getLocal(), getVisitante());
	}
}