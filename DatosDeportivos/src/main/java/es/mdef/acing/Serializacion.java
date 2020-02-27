package es.mdef.acing;

import java.io.IOException;
import java.util.Collection;

public class Serializacion {

	public static void main(String[] args) throws IOException {
		EventoDAO eventoDAO = 
								new SerializadorCSV("SP1.csv");
//								new SerializadorJSON("eventos.json");	
		
		Collection<Evento> eventos = eventoDAO.getEventos();//.deserializar(ruta);
		
		eventos.forEach(System.out::println);
		
//		System.out.println(mapper
//				.writerWithDefaultPrettyPrinter()
//				.writeValueAsString(eventos));
	}

}
