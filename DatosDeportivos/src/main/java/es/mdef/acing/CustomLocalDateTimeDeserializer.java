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

public class CustomLocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {
	public static String patronFecha = "dd MMMM yyyy";
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern(patronFecha);

	public CustomLocalDateTimeDeserializer() {
		this(null);
	}

	public CustomLocalDateTimeDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		JsonNode node = jp.getCodec().readTree(jp);
		String fecha = node.asText();

		return LocalDate.parse(fecha, dtf).atTime(20, 45);
	}
}
