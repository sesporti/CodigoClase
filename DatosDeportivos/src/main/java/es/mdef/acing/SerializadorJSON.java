package es.mdef.acing;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class SerializadorJSON implements EventoDAO {
	ObjectMapper mapper;
	String ruta;
	
	@Override
	public Collection<Evento> getEventos() {
		File misEventos = new File(ruta);
		Collection<Evento> eventos = null;
		try {
			eventos = Arrays.asList(mapper.readValue(misEventos, Partido[].class));
		} catch (IOException e) {
			e.printStackTrace();
		};
		
		return eventos;
	}
	
	public SerializadorJSON(String ruta) {
		this.ruta = ruta;
		mapper = new ObjectMapper();
//		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.addMixIn(Partido.class, MixinEvento.class);
		SimpleModule module = new SimpleModule();
		module.addDeserializer(Suceso.class, new SucesoDeserializer());
		mapper.registerModule(module);
	}

	@JsonIgnoreProperties({ "golesLocal", "golesVisitante", "resultado", "participantes" })
	@JsonPropertyOrder({ "home", "golesLocal" })
	abstract class MixinEvento {
		
		@JsonProperty("home")
		public abstract Participante getLocal();
		
		@JsonFormat(pattern = "dd MMMM yyyy")// (HH:mm)")//"yyyy-MM-dd hh:mm:ss")
		@JsonSerialize(using = LocalDateTimeSerializer.class)
		@JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
		abstract LocalDateTime getFecha();
		
//		@JsonDeserialize(using = SucesoDeserializer.class)
		abstract Collection<Suceso> getSucesos();

//		@JsonProperty("HC")
//		public abstract String getCornerLocal(); 
		
//		@JsonProperty("AC")
//		public abstract String getCornerVisitante(); 
	}
	
	abstract class MixinEvento2 {
		
		@JsonProperty("home")
		public abstract String getLocal();
		
		@JsonProperty("Away")
		public abstract String getVisitante(); 
	}
}
