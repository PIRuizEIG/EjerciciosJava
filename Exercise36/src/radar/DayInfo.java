package radar;

/**
 * Clase para guardar la información de un día
 */
public class DayInfo {
	/**
	 * Valor inicial máximo
	 */
	private static final double DEFAULT_MAX = Double.NEGATIVE_INFINITY;

	/**
	 * Valor inicial mínimo
	 */
	private static final double DEFAULT_SUM = 0;

	/**
	 * Valor inicial de tickets
	 */
	private static final int DEFAULT_TICKETS = 0;
	
	/**
	 * Valor límite para multa
	 */
	private static final double LIMIT = 120;

	/**
	 * Crear objeto para guardar la información de un día
	 */
	public DayInfo() {
		this(DEFAULT_MAX, DEFAULT_SUM, DEFAULT_TICKETS);
	}

	/**
	 * Crear objeto para guardar la información de un día con valores concretos
	 * 
	 * @param max     Velocidad máxima
	 * @param sum     Suma de velocidades
	 * @param tickets Multas en el día
	 */
	public DayInfo(double max, double sum, int tickets) {
		this.max = max;
		this.sum = sum;
		this.tickets = tickets;
		this.counter = 0;
	}

	/**
	 * Velocidad máxima
	 */
	private double max;

	/**
	 * Suma de velocidades
	 */
	private double sum;
	
	/**
	 * Contador de velocidades
	 */
	private int counter;

	/**
	 * Multas en el día
	 */
	private int tickets;

	/**
	 * Velocidad máxima
	 * 
	 * @return Double con la velocidad máxima en el día
	 */
	public double getMax() {
		return max;
	}

	/**
	 * Asignar velocidad máxima
	 * 
	 * @param max Velocidad máxima
	 */
	public void setMax(double max) {
		this.max = max;
	}

	/**
	 * Suma de todas las velocidades
	 * 
	 * @return Double con la suma de todas las velocidades
	 */
	public double getSum() {
		return sum;
	}

	/**
	 * Añadir velocidad a la suma
	 * 
	 * @param amount Velocidad a añadir
	 */
	public void addToSum(double amount) {
		sum += amount;
		counter++;
	}

	/**
	 * Conseguir media
	 * @param count	Número de multas
	 * @return		Double con la media de multas
	 */
	public double getAverage(int count) {
		return sum / count;
	}
	
	/**
	 * Conseguir media
	 * @return		Double con la media de multas
	 */
	public double getAverage() {
		return sum / counter;
	}

	/**
	 * Multas del día
	 * 
	 * @return Entero con las multas del día
	 */
	public int getTickets() {
		return tickets;
	}

	/**
	 * Añadir multa
	 */
	public void addToTickets() {
		tickets++;
	}
	
	/**
	 * Añadir lectura
	 * 
	 * @param speed Lectura de velocidad
	 */
	public void addReading(double speed) {
	    addToSum(speed);
	    if (speed > max) setMax(speed);
	    if (speed > LIMIT) addToTickets();
	}
}
