package test.helloWorld;

import javax.swing.SwingUtilities; // ayuda a ejecutar código Swing en el hilo correcto.

public class HelloWorld {

	public static void main(String[] args) {
		/**
		 * Ejecuta el código de Swing en el Event Dispatch Thread.(EDT) es el hilo
		 * especial de Swing que gestiona toda la interfaz gráfica: clics,
		 * redimensiones, repintados....
		 */
		SwingUtilities.invokeLater(() -> {
			
			// new VentanaPrincipal().setVisible(true);
			// Crea la ventana y la hace visible en pantalla.
			new VentanaPrincipal(300, 150, "Hecho por Pablo IR", "Hola clase").setVisible(true);
		});
	}

}
