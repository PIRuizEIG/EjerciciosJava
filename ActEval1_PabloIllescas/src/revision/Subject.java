package revision;

/**
 * Clase que gestiona las notas de una asignatura
 */
public class Subject {
	/**
	 * Nombre de la asignatura
	 */
	private String name;

	/**
	 * Nota mínima de la clase
	 */
	private double min;

	/**
	 * Nota mayor de la clase
	 */
	private double max;

	/**
	 * Suma de notas
	 */
	private double total;

	/**
	 * Cantidad de alumnos
	 */
	private int amount;

	public Subject(String name, int amount) {
		this.name = name;
		min = Double.POSITIVE_INFINITY;
		max = Double.NEGATIVE_INFINITY;
		total = 0;
		this.amount = amount;
	}

	/**
	 * Añadir asignatura
	 * 
	 * @param value Nota
	 */
	public void addEval(double value) {
		total += value;
		if (value < min)
			min = value;
		if (value > max)
			max = value;
	}

	/**
	 * Calcular media
	 * 
	 * @return Double con media
	 */
	public double average() {
		return total / amount;
	}

	/**
	 * Getter del nombre
	 * 
	 * @return String con el nombre
	 */
	public String getName() {
		return name;
	}

	/**
	 * Mostrar evaluación de la asignatura
	 */
	public void showEval() {
		System.out.printf("%s:\n", name.toUpperCase());
		System.out.printf(" Nota media: %.2f\n", average());
		System.out.printf(" Nota más alta: %.2f\n", max);
		System.out.printf(" Nota más baja: %.2f\n", min);
	}
}
