package Ejercicio4;

/**
 * <h1>Crea una clase Rectangulo definida por su base y su altura.</h1>
 * <h2>Requisitos:</h2>
 * <p>
 * Atributos privados base y altura (double).
 * <p>
 * Tres constructores:
 * <ul>
 * <li>Constructor por defecto (base 1, altura 1).</li>
 * <li>Constructor con parámetros Rectangulo(double base, double altura).</li>
 * <li>Constructor de copia Rectangulo(Rectangulo r).</li>
 * </ul>
 * <p>
 * Métodos get y set con validación: no se permite base ni altura negativa (si
 * se intenta, se deja el valor anterior o se pone 1).
 * <p>
 * Método double area() que devuelva el área.
 * <p>
 * Método double perimetro() que devuelva el perímetro.
 * <p>
 * Sobrecarga de un método redimensionar:
 * <ul>
 * <li>redimensionar(double factor) multiplica base y altura por un factor.</li>
 * <li>redimensionar(double nuevaBase, double nuevaAltura) asigna nuevas
 * dimensiones con validación.</li>
 * </ul>
 * <h2>Pablo Illescas</h2>
 */
public class Rectangulo {

	/**
	 * Base del Rectángulo
	 */
	private double base;

	/**
	 * Altura del Rectángulo
	 */
	private double altura;

	/**
	 * Genera un Rectángulo con los valores pasados
	 * 
	 * @param base   Base del rectángulo
	 * @param altura Altura del rectángulo
	 */
	public Rectangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	/**
	 * Genera un Rectángulo de tamaño 1
	 */
	public Rectangulo() {
		this(1, 1);
	}

	/**
	 * Duplica el Rectángulo r
	 * 
	 * @param r Rectángulo a duplicar
	 */
	public Rectangulo(Rectangulo r) {
		this.base = r.getWidth();
		this.altura = r.getHeight();
	}

	/**
	 * Genera un Cuadrado de tamaño lado
	 * 
	 * @param lado Tamaño del cuadrado
	 */
	public Rectangulo(double lado) {
		this.base = lado;
		this.altura = lado;
	}

	/**
	 * Obtener la base
	 * 
	 * @return Base del Rectángulo
	 */
	public double getWidth() {
		if (base < 0)
			base = 1;
		return base;
	}

	/**
	 * Obtener la altura
	 * 
	 * @return Altura del Rectángulo
	 */
	public double getHeight() {
		if (altura < 0)
			altura = 1;
		return altura;
	}

	/**
	 * Asignar la base
	 * 
	 * @param width Nueva dimesión de la base
	 */
	public void setWidth(double width) {
		base = width;
	}

	/**
	 * Asignar la altura
	 * 
	 * @param height Nueva dimesión de la Altura
	 */
	public void setHeight(double height) {
		altura = height;
	}

	/**
	 * Obtener el area del rectángulo
	 * 
	 * @return Base por Altura
	 */
	public double area() {
		return base * altura;
	}

	/**
	 * Obtener el perímetro del rectángulo
	 * 
	 * @return doble de la base más altura
	 */
	public double perimetro() {
		return 2 * (base + altura);
	}

	/**
	 * Multiplica base y altura por un factor
	 * 
	 * @param factor Factor de crecimiento
	 */
	public void redimensionar(double factor) {
		if (factor < 0)
			factor *= -1;
		this.base *= factor;
		this.altura *= factor;
	}

	/**
	 * Asigna nuevas dimensiones con validación.
	 * 
	 * @param nuevaBase   Nueva dimensión de la base
	 * @param nuevaAltura Nueva dimensión de la altura
	 */
	public void redimensionar(double nuevaBase, double nuevaAltura) {
		if (nuevaBase < 0)
			nuevaBase = 1;
		if (nuevaAltura < 0)
			nuevaAltura = 1;
		this.base = nuevaBase;
		this.altura = nuevaAltura;
	}
}
