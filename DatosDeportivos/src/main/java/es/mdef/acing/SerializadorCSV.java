package es.mdef.acing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

public class SerializadorCSV implements EventoDAO {
	String ruta;

	private String getRuta() {
		return ruta;
	}
	
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public SerializadorCSV(String ruta) {
		setRuta(ruta);
	}
	
	public Collection<Evento> deserializar(String ruta) {
		Collection<Evento> eventos = new ArrayList<>();
		
		try (BufferedReader buffer = new BufferedReader(
				new InputStreamReader(//new FileInputStream(rutaSP1),
						Serializacion.class.getClassLoader().getResource(ruta).openStream(),
						"UTF-8"))) {
			String linea;
			buffer.readLine();
			String patronFecha = "dd/MM/yyyy";
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(patronFecha);
			
			while ((linea = buffer.readLine()) != null) {
				Partido evento = new Partido();
				String[] columnas = linea.split(",");
				Participante local = new Participante(columnas[2]);
				Participante visitante = new Participante(columnas[3]);
				evento.setLocal(local);
				evento.setVisitante(visitante);
				evento.setFecha(LocalDate.parse(columnas[1], dtf).atTime(20, 45));
				
				addNumeroGoles(evento, Integer.parseInt(columnas[4]), local);
				addNumeroGoles(evento, Integer.parseInt(columnas[5]), visitante);
				
//				evento.setGolesLocal(Integer.parseInt(columnas[4]));
//				evento.setGolesVisitante(Integer.parseInt(columnas[5]));
//				evento.setCornerLocal(Integer.parseInt(columnas[15]));
//				evento.setCornerVisitante(Integer.parseInt(columnas[16]));
				
				eventos.add(evento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return eventos;
	}
	
	static void addNumeroGoles(GestorSucesos evento, int numeroGoles, Participante participante) {
		for (int i = 0; i < numeroGoles; i++) {
			evento.getSucesos().add(new Gol(participante));
		}
	}

	@Override
	public Collection<Evento> getEventos() {
		return deserializar(getRuta());
	}
}
