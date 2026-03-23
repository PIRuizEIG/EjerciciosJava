package utilities.console;

/**
 * Utilidades para mostrar mensajes formateados con iconos
 */
public class ConsoleUI {

	/**
	 * Mostrar mensaje con icono y estilo
	 * 
	 * @param icon    Icono Unicode
	 * @param message Mensaje
	 * @param styles  Estilos
	 */
	private static void print(String icon, String message, String... styles) {
		Format.println(icon + " " + message, styles);
	}

	/**
	 * Mensaje sin formato
	 * 
	 * @param message Mensaje a mostrar
	 */
	public static void plain(String message) {
		System.out.println(message);
	}

	/**
	 * Mensaje invertido
	 * 
	 * @param message Mensaje a mostrar
	 */
	public static void highlight(String message) {
		Format.println(message, Format.REVERSE, Format.BOLD);
	}

	/** Muestra un mensaje de éxito en verde */
	public static void success(String message) {
		print(Icons.CHECK, message, Format.GREEN, Format.BOLD);
	}

	/** Muestra un mensaje de error en rojo */
	public static void error(String message) {
		print(Icons.CROSS, message, Format.RED, Format.BOLD);
	}

	/** Muestra una advertencia en amarillo */
	public static void warning(String message) {
		print(Icons.WARNING, message, Format.YELLOW, Format.BOLD);
	}

	/** Muestra información */
	public static void info(String message) {
		print(Icons.INFO, message, Format.CYAN, Format.BRIGHT_WHITE);
	}

	/** Crea un título visual para los menús */
	public static void header(String title) {
		String line = "========================================";
		Format.println(line, Format.BRIGHT_WHITE);
		print(Icons.MENU, " " + title, Format.BRIGHT_WHITE, Format.BOLD);
		Format.println(line, Format.BRIGHT_WHITE);
	}
}