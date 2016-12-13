package at.struct.was9bugs.bug7;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class BooleanTFConverter implements AttributeConverter<Boolean, String> {

    private static final String TRUE_STRING = "T";
    private static final String FALSE_STRING = "F";

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return toString(attribute, TRUE_STRING, FALSE_STRING, null);
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return toBooleanObject(dbData, TRUE_STRING, FALSE_STRING, null);
    }

    // from Apache Commons Lang3
    private static String toString(final Boolean bool, final String trueString, final String falseString, final String nullString) {
        if (bool == null) {
            return nullString;
        }
        return bool ? trueString : falseString;
    }

    // from Apache Commons Lang3
    private static Boolean toBooleanObject(final String str, final String trueString, final String falseString, final String nullString) {
        if (str == null) {
            if (trueString == null) {
                return Boolean.TRUE;
            }
            if (falseString == null) {
                return Boolean.FALSE;
            }
            if (nullString == null) {
                return null;
            }
        }
        else if (str.equals(trueString)) {
            return Boolean.TRUE;
        }
        else if (str.equals(falseString)) {
            return Boolean.FALSE;
        }
        else if (str.equals(nullString)) {
            return null;
        }
        // no match
        throw new IllegalArgumentException("The String did not match any specified value");
    }
}
