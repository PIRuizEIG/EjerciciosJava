package exercises.ex01;

import java.awt.FlowLayout;

import javax.swing.*;

/**
 * <h1>FlowLayout: Galería de Botones</h1> Crea una ventana (JFrame) que
 * contenga un JPanel con FlowLayout. Añade cinco botones con diferentes textos
 * (por ejemplo, "Botón 1", "Botón 2", etc.) y observa cómo se organizan
 * automáticamente. Experimenta con diferentes tamaños de ventana.
 * <h2>Autor: Pablo Illescas</h2>
 * 
 */
public class Flow extends JFrame {

	/** ID de ventana */
	private static final long serialVersionUID = 1L;

	public Flow(int width, int height, String title, int amount) {
		// Asigna el título que aparecerá en la barra superior de la ventana.
		setTitle(title);
		// Establece el tamaño de la ventana
		setSize(width, height);
		// Indica que al cerrar la ventana debe finalizar el programa.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Coloca la ventana en el centro de la pantalla.
		setLocationRelativeTo(null);
		// Configurar layout
		setLayout(new FlowLayout());
		// Crear botones
		for (int i = 1; i <= amount; i++)
		{
			add(new JButton(Integer.toString(i)));
		}		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Flow(300, 300, "Ventana",  7).setVisible(true));
	}
}
