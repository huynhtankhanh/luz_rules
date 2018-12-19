package ch.klara.luz.store;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CDeserializer extends JsonDeserializer<LocalDate> {
	
	public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
			String string = parser.getText().trim();
			if (string.length() == 0) {
				return null;
			} else {
				Instant instant = Instant.parse(string);
				return LocalDateTime.ofInstant(instant, ZoneOffset.UTC).toLocalDate();
			}
		}
		return null;
	}
}