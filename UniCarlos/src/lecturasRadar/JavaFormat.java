package lecturasRadar;

public class JavaFormat {
	/**
	 * Carácter de escape ANSI
	 */
    public static final String ESCAPE = "\u001B[";
    
    /**
     * Carácter para restablecer el formato
     */
    public static final String RESET = ESCAPE + "0m";

    // --- ESTILOS DE FORMATO BÁSICOS (TextStyle) ---
    /**
     * Negrita
     */
    public static final String BOLD = ESCAPE + "1m";
    /**
     * Atenuado/Baja Intensidad
     */
    public static final String FAINT = ESCAPE + "2m";
    /**
     * Cursiva
     */
    public static final String ITALIC = ESCAPE + "3m";
    /**
     * Subrayado
     */
    public static final String UNDERLINE = ESCAPE + "4m";
    /**
     * Parpadeo Lento
     */
    public static final String SLOW_BLINK = ESCAPE + "5m";  //
    /**
     * Inverso (intercambia primer plano y fondo)
     */
    public static final String REVERSE = ESCAPE + "7m";
    /**
     * Oculto
     */
    public static final String HIDDEN = ESCAPE + "8m";
    /**
     * Tachado
     */
    public static final String STRIKETHROUGH = ESCAPE + "9m";

    // --- COLORES DE PRIMER PLANO (Foreground Colors) ---
    /**
     * Color de texto Negro
     */
    public static final String BLACK = ESCAPE + "30m";
    /**
     * Color de texto Rojo
     */
    public static final String RED = ESCAPE + "31m";
    /**
     * Color de texto Verde
     */
    public static final String GREEN = ESCAPE + "32m";
    /**
     * Color de texto Amarillo
     */
    public static final String YELLOW = ESCAPE + "33m";
    /**
     * Color de texto Azul
     */
    public static final String BLUE = ESCAPE + "34m";
    /**
     * Color de texto Magenta
     */
    public static final String MAGENTA = ESCAPE + "35m";
    /**
     * Color de texto Cian
     */
    public static final String CYAN = ESCAPE + "36m";
    /**
     * Color de texto Blanco
     */
    public static final String WHITE = ESCAPE + "37m";
    /**
     * Color de texto predeterminado
     */
    public static final String DEFAULT_FG = ESCAPE + "39m";

    // --- COLORES DE FONDO (Background Colors) ---
    /**
     * Color de fondo negro
     */
    public static final String BLACK_BG = ESCAPE + "40m";
    /**
     * Color de fondo rojo
     */
    public static final String RED_BG = ESCAPE + "41m";
    /**
     * Color de fondo verde
     */
    public static final String GREEN_BG = ESCAPE + "42m";
    /**
     * Color de fondo amarillo
     */
    public static final String YELLOW_BG = ESCAPE + "43m";
    /**
     * Color de fondo azul
     */
    public static final String BLUE_BG = ESCAPE + "44m";
    /**
     * Color de fondo magenta
     */
    public static final String MAGENTA_BG = ESCAPE + "45m";
    /**
     * Color de texto fondo cian
     */
    public static final String CYAN_BG = ESCAPE + "46m";
    /**
     * Color de texto fondo blanco
     */
    public static final String WHITE_BG = ESCAPE + "47m";
    /**
     * Color de texto fondo predeterminado
     */
    public static final String DEFAULT_BG = ESCAPE + "49m"; // Color de 

    // --- COLORES BRILLANTES DE PRIMER PLANO (Bright Foreground Colors) ---
    /**
     * Color de texto gris
     */
    public static final String BRIGHT_BLACK = ESCAPE + "90m";
    /**
     * Color de texto rojo claro
     */
    public static final String BRIGHT_RED = ESCAPE + "91m";
    /**
     * Color de texto verde claro
     */
    public static final String BRIGHT_GREEN = ESCAPE + "92m";
    /**
     * Color de texto amarillo claro
     */
    public static final String BRIGHT_YELLOW = ESCAPE + "93m";
    /**
     * Color de texto azul claro
     */
    public static final String BRIGHT_BLUE = ESCAPE + "94m";
    /**
     * Color de texto magenta claro
     */
    public static final String BRIGHT_MAGENTA = ESCAPE + "95m";
    /**
     * Color de texto cian claro
     */
    public static final String BRIGHT_CYAN = ESCAPE + "96m";
    /**
     * Color de texto blanco
     */
    public static final String BRIGHT_WHITE = ESCAPE + "97m";

    // --- RESTABLECER ESTILOS ESPECÍFICOS (Opcional, menos común) ---
    /**
     * Desactivar negrita
     */
    public static final String RESET_BOLD = ESCAPE + "22m";
    /**
     * Desactivar cursiva
     */
    public static final String RESET_ITALIC = ESCAPE + "23m";
    /**
     * Desactivar subrayado
     */
    public static final String RESET_UNDERLINE = ESCAPE + "24m";
    /**
     * Desactivar tachado
     */
    public static final String RESET_STRIKE = ESCAPE + "29m";
}
