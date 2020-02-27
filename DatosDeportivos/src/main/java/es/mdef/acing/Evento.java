package es.mdef.acing;

import java.time.LocalDateTime;
import java.util.Collection;

public interface Evento {

	Collection<Participante> getParticipantes();

	LocalDateTime getFecha();
	
	String getResultado();

}