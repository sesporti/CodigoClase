package es.mdef.acing;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class SucesoDeserializer extends StdDeserializer<Suceso> {
	
	public SucesoDeserializer() {
		this(null);
	}

	public SucesoDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public Suceso deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		JsonNode node = jp.getCodec().readTree(jp);
		String nombre = node.findValue("participante").get("nombre").asText();

		return new Gol(new Participante(nombre));
	}
}
