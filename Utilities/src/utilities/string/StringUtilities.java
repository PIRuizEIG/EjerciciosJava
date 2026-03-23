package utilities.string;

/**
 * Utilidades de cadenas
 */
public class StringUtilities {
	/**
	 * @param text Cadena original
	 * @return Texto capitalizado
	 */
	public static String capitalize(String text) {
		if (text == null || text.isEmpty())
			return text;
		return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
	}

	/**
	 * @param text Cadena original
	 * @return Cadena con espacios normalizados
	 */
	public static String cleanSpaces(String text) {
		return text.trim().replaceAll("\\s+", " ");
	}

	/**
	 * @param text Cadena original
	 * @return Cadena sin carácteres especiales
	 */
	public static String normalize(String text) {
		text = text.toLowerCase();
		return text.replace('á', 'a').replace('é', 'e').replace('í', 'i').replace('ó', 'o').replace('ú', 'u')
				.replace('ü', 'u').replace('ñ', 'n');
	}
}
