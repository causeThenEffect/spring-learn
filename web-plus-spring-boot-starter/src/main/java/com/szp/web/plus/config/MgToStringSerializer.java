package com.szp.web.plus.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.io.IOException;
import java.util.Optional;

@JacksonStdImpl
@SuppressWarnings("serial")
public class MgToStringSerializer extends ToStringSerializer {

	@Override
	public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
			throws IOException {
		Optional.of(value).ifPresent(v -> {
			try {
				if (v.toString().length() >= 17) {
					gen.writeString(value.toString());
				} else {
					gen.writeNumber(value.toString());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public void serializeWithType(Object value, JsonGenerator g, SerializerProvider provider,
			TypeSerializer typeSer) throws IOException {
		WritableTypeId typeIdDef = typeSer.writeTypePrefix(g,
				typeSer.typeId(value,
						value.toString().length() >= 17 ? JsonToken.VALUE_STRING : JsonToken.VALUE_NUMBER_INT));
		serialize(value, g, provider);
		typeSer.writeTypeSuffix(g, typeIdDef);
	}
}
