package buscaminas;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Window extends JFrame {
	/** ID para quitar el warning */
	private static final long serialVersionUID = 1L;
	/** Título por defecto */
	public static final String DEFAULT_TITLE = "Buscaminas por PabloIR";
	/** Array de botones */
	private JButton[][] buttons;
	/** Array de minas */
	private boolean[][] mineArray;
	/** Array de banderas */
	private boolean[][] flagArray;
	/** Cantidad de bombas */
	private int bombAmount;

	/** Tamaño de los botones */
	public static final int BTN_SIZE = 30;
	/** Divisor para calcular bombas */
	public static final int DIFICULTY = 8;
	/** Bomba */
	public static final String BOMB = "💣";
	/** Explosión */
	public static final String EXPLOSION = "💥";
	/** Bandera */
	public static final String FLAG = "🚩";

	/**
	 * Generar tablero
	 * 
	 * @param rows    Filas
	 * @param columns Columnas
	 * @return Array de minas
	 */
	private static boolean[][] generateBoard(int rows, int columns, int bombAmount) {
		var rng = new Random();
		var array = new boolean[rows][columns];
		var bombs = 0;
		while (bombs < bombAmount) {
			int row = rng.nextInt(0, rows);
			int col = rng.nextInt(0, columns);
			if (!array[row][col]) {
				array[row][col] = true;
				bombs++;
			}
		}
		return array;
	}

	/**
	 * Crear ventana de buscamnas
	 * 
	 * @param rows    Filas
	 * @param columns Columnas
	 */
	public Window(int rows, int columns) {
		// Calcular cantidad de minas
		bombAmount = (rows * columns) / DIFICULTY;
		// Crear array de minas;
		mineArray = generateBoard(rows, columns, bombAmount);
		// Crear array de banderas
		flagArray = new boolean[rows][columns];
		// Calcular tamaño de ventana
		int width = columns * BTN_SIZE;
		int height = rows * BTN_SIZE;
		// Configurar ventana
		this.setSize(width, height);
		setTitle(DEFAULT_TITLE + " " + BOMB + ": " + (bombAmount - countFlags()));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// Crear un grid lay out de tamaño filas por columnas
		setLayout(new GridLayout(rows, columns));
		// Crear matriz de botones
		buttons = new JButton[rows][columns];
		// Colocar botones en el grid
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				int r = row;
				int c = col;
				// Crear botón
				buttons[row][col] = new JButton();
				// Reducir margenes para permitir botones más pequeños
				buttons[row][col].setMargin(new Insets(0, 0, 0, 0));
				// Añadir Listener de ratón
				// buttons[row][col].addActionListener(e -> { reveal(r, c); });
				buttons[row][col].addMouseListener(new java.awt.event.MouseAdapter() {
					@Override
					// Al hacer click
					public void mousePressed(java.awt.event.MouseEvent e) {
						// Si izquierdo mirar bandera
						if (SwingUtilities.isRightMouseButton(e)) {
							toggleFlag(r, c);
							// Si derecho revelar el contenido
						} else if (SwingUtilities.isLeftMouseButton(e)) {
							reveal(r, c);
						}
					}
				});

				add(buttons[row][col]);
			}
		}
	}

	/**
	 * Contar minas para una casilla
	 * 
	 * @param row Posición por filas
	 * @param col Posición por columnas
	 * @return
	 */
	private int countMines(int row, int col) {
		int mines = 0;

		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {
				// Saltar fuera de límites
				if (r < 0 || r >= mineArray.length || c < 0 || c >= mineArray[0].length)
					continue;
				// Saltar la propia casilla
				if (r == row && c == col)
					continue;
				// Aumentar contador
				if (mineArray[r][c])
					mines++;
			}
		}
		return mines;
	}

	/**
	 * Revelar contenido de la casilla
	 * 
	 * @param row Fila
	 * @param col Columna
	 */
	private void reveal(int row, int col) {
		// Obtener botón actual
		JButton btn = buttons[row][col];
		// Evitar procesar varias veces
		if (!btn.isEnabled() || flagArray[row][col])
			return;
		btn.setEnabled(false);
		// Si es bomba explota
		if (mineArray[row][col]) {
			btn.setText(EXPLOSION);
			revealAllBombs();
			int option = JOptionPane.showConfirmDialog(this, "Has perdido. ¿Reintentar?", "Game Over",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION)
				resetGame();
			return;
		}
		// Si no es bomba contamos continuas
		int mines = countMines(row, col);
		// Si hay minas continuas ponemos la cantidad
		if (mines > 0) {
			btn.setText(String.valueOf(mines));
		} else {
			// Si no hay minas dejamos la etiqueta en blanco
			btn.setText("");
			// Expandir (recursividad tipo flood fill)
			for (int r = row - 1; r <= row + 1; r++) {
				for (int c = col - 1; c <= col + 1; c++) {
					if (r < 0 || r >= mineArray.length || c < 0 || c >= mineArray[0].length) {
						continue;
					}
					if (r == row && c == col)
						continue;
					reveal(r, c);
				}
			}
		}
		checkVictory();
	}

	/** Revelar todas las bombas */
	private void revealAllBombs() {
		for (int row = 0; row < mineArray.length; row++) {
			for (int col = 0; col < mineArray[0].length; col++) {
				JButton btn = buttons[row][col];
				// Evitar procesar varias veces
				if (!btn.isEnabled())
					continue;
				if (mineArray[row][col])
					btn.setText(BOMB);
				btn.setEnabled(false);
			}
		}
	}

	/**
	 * Cambiar estado bandera
	 * 
	 * @param row Fila
	 * @param col Columna
	 */
	private void toggleFlag(int row, int col) {
		JButton btn = buttons[row][col];
		// No permitir marcar si ya está revelado
		if (!btn.isEnabled())
			return;
		// Cambiar a estado puesto
		flagArray[row][col] = !flagArray[row][col];
		// Cambiar etiqueta
		if (flagArray[row][col])
			btn.setText("🚩");
		else
			btn.setText("");
		// Actualizar título
		setTitle(DEFAULT_TITLE + " " + BOMB + ": " + (bombAmount - countFlags()));
	}

	/** Contar banderas */
	private int countFlags() {
		int count = 0;
		for (int row = 0; row < flagArray.length; row++) {
			for (int col = 0; col < flagArray[0].length; col++) {
				if (flagArray[row][col])
					count++;
			}
		}
		return count;
	}

	/** Comprobar victoria */
	private void checkVictory() {
		for (int row = 0; row < mineArray.length; row++) {
			for (int col = 0; col < mineArray[0].length; col++) {
				// Si hay una casilla sin mina que NO está revelada no has ganado
				if (!mineArray[row][col] && buttons[row][col].isEnabled()) {
					return;
				}
			}
		}
		// Si llega aquí victoria
		int option = JOptionPane.showConfirmDialog(this, "¿Volver a jugar?", "¡Has ganado!", JOptionPane.YES_NO_OPTION);
		revealAllBombs();
		// Pedir nueva partida
		if (option == JOptionPane.YES_OPTION) {
			resetGame();
		}
	}

	/** Reiniciar partida */
	private void resetGame() {
		int rows = mineArray.length;
		int columns = mineArray[0].length;
		bombAmount = (rows * columns) / DIFICULTY;
		// Nuevo tablero
		mineArray = generateBoard(rows, columns, bombAmount);
		// Reset banderas
		flagArray = new boolean[rows][columns];
		// Reset botones
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				JButton btn = buttons[row][col];
				btn.setText("");
				btn.setEnabled(true);
			}
		}
		// Actualizar título
		setTitle(DEFAULT_TITLE + " " + BOMB + ": " + (bombAmount - countFlags()));
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Window(20, 20).setVisible(true));
	}
}
