package net.horvoje.querydsl.bugs.contains.converter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import net.horvoje.querydsl.bugs.contains.enums.UserRole;

public class UserRolesConverter implements AttributeConverter<Set<UserRole>, String>, Serializable {

	@Serial private static final long serialVersionUID = -6105356555706277280L;

	public static final TypeReference<Set<UserRole>> TYPE_REFERENCE = new TypeReference<>() { /**/ };

	@Override
	public String convertToDatabaseColumn(final Set<UserRole> attribute) {
		if (attribute == null || attribute.isEmpty()) {
			return null;
		}
		try {
			return new ObjectMapper().writeValueAsString(attribute);
		}
        catch (final JsonProcessingException e) {
        	System.out.println(e.getMessage());
            return null;
        }
	}

	@Override
	public Set<UserRole> convertToEntityAttribute(final String dbData) {
		if (dbData == null) {
			return Collections.emptySet();
		}
		try {
			final Set<UserRole> result = new ObjectMapper().readValue(dbData, TYPE_REFERENCE);
			if (result == null) {
				throw new IllegalStateException("This should never happen but here we are; to fix this just return empty list instead");
			}
			return result;
        }
        catch (final JsonProcessingException e) {
        	System.out.println(e.getMessage());
            throw new IllegalStateException("JsonProcessingException: " + e.getMessage());
        }
	}

}
