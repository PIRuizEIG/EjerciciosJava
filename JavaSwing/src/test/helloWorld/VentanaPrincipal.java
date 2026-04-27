package test.helloWorld;

import javax.swing.JFrame; // ventana principal de una aplicación gráfica.
import javax.swing.JLabel; // permite mostrar texto dentro de la ventana.

public class VentanaPrincipal extends JFrame {
	/** ID por defecto para quitar warning */
	private static final long serialVersionUID = 1L;
	/** Ancho por defecto */
	public static final int DEFAULT_WIDTH = 400;
	/** Alto por defecto */
	public static final int DEFAULT_HEIGHT = 200;
	/** Título por defecto */
	public static final String DEFAULT_TITLE = "Hola Mundo Swing";
	/** Texto de ventana por defecto */
	public static final String DEFAULT_LABEL = "¡Hola, Swing!";

	/**
	 * Ventana con atributos configurables
	 * 
	 * @param width  Ancho de ventana
	 * @param height Alto de ventana
	 * @param title  Título de la ventana
	 * @param label  Etiqueta de texto en la ventana
	 */
	public VentanaPrincipal(int width, int height, String title, String label) {
		// Asigna el título que aparecerá en la barra superior de la ventana.
		setTitle(title);
		// Establece el tamaño de la ventana
		setSize(width, height);
		// Indica que al cerrar la ventana debe finalizar el programa.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Coloca la ventana en el centro de la pantalla.
		setLocationRelativeTo(null);
		// Crea una etiqueta con texto centrado.
		JLabel newLabel = new JLabel(label, JLabel.CENTER);
		// Añade la etiqueta al contenido de la ventana.
		add(newLabel);
	}

	/** Ventana con atributos por defecto */
	public VentanaPrincipal() {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_TITLE, DEFAULT_LABEL);
	}
}