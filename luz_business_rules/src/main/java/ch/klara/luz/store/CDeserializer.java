package ch.klara.luz.store;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CDeserializer extends JsonDeserializer<LocalDate> {
	
	public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		if (parser.getCurrentToken() == JsonToken.VALUE_NUMBER_INT) {
			long t = parser.getLongValue();
			return Instant.ofEpochMilli(t).atZone(ZoneId.systemDefault()).toLocalDate();
		}
		return null;
	}
}