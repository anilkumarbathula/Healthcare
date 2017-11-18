package com.dotridge.util;

import javax.persistence.AttributeConverter;

public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

	public String convertToDatabaseColumn(Boolean value) {
		   return (value != null && value) ? "TRUE" : "FALSE";  
	}

	public Boolean convertToEntityAttribute(String value) {
		return "TRUE".equals(value);	}

}
