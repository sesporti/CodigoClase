package es.mdef.acing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class Serializacion {

	public static void main(String[] args) throws IOException {
		String ruta = "SP1.csv";
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
				Evento evento = new Evento();
				String[] columnas = linea.split(",");
				evento.setLocal(columnas[2]);
				evento.setVisitante(columnas[3]);
				evento.setFecha(LocalDate.parse(columnas[1], dtf).atTime(20, 45));
				evento.setGolesLocal(Integer.parseInt(columnas[4]));
				evento.setGolesVisitante(Integer.parseInt(columnas[5]));
				evento.setCornerLocal(Integer.parseInt(columnas[15]));
				evento.setCornerVisitante(Integer.parseInt(columnas[16]));
				eventos.add(evento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		File misEventos = new File("eventos.json");
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.addMixIn(Evento.class, MixinEvento.class);
		mapper.writerWithDefaultPrettyPrinter()
			.writeValue(misEventos, eventos);
		Collection<Evento> eventosLeidos = Arrays
				.asList(mapper.readValue(misEventos, Evento[].class));
		eventosLeidos.forEach(System.out::println);
//		System.out.println(mapper
//				.writerWithDefaultPrettyPrinter()
//				.writeValueAsString(eventos));
	}
	
	@JsonIgnoreProperties({ "HC", "AC" })
	@JsonPropertyOrder({ "HC", "AC", "home", "golesLocal" })
	abstract class MixinEvento {
		
		@JsonProperty("home")
		public abstract String getLocal();
		
		@JsonFormat(pattern = "dd MMMM yyyy")// (HH:mm)")//"yyyy-MM-dd hh:mm:ss")
		@JsonSerialize(using = LocalDateTimeSerializer.class)
		@JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
		abstract LocalDateTime getFecha();

		@JsonProperty("HC")
		public abstract String getCornerLocal(); 
		
		@JsonProperty("AC")
		public abstract String getCornerVisitante(); 
	}
	
	abstract class MixinEvento2 {
		
		@JsonProperty("home")
		public abstract String getLocal();
		
		@JsonProperty("Away")
		public abstract String getVisitante(); 
	}

}
