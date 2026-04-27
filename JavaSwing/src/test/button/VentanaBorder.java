package test.button;

import javax.swing.*;
import java.awt.*;

public class VentanaBorder extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaBorder() {
		setTitle("BorderLayout Demo");
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);// El JFrame ya usa BorderLayout por defecto
		add(new JButton("NORTE"), BorderLayout.NORTH);
		add(new JButton("SUR"), BorderLayout.SOUTH);
		add(new JButton("ESTE"), BorderLayout.EAST);
		add(new JButton("OESTE"), BorderLayout.WEST);
		add(new JLabel("CENTRO", JLabel.CENTER), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new VentanaBorder().setVisible(true));
	}
}
