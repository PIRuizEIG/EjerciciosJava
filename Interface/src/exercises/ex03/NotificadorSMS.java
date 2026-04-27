package exercises.ex03;

public class NotificadorSMS implements Notificable {
	/** Destinatario */
	private String to;

	/**
	 * Crea un NotificadorSMS a un destinatario concreto
	 * 
	 * @param to Destinatario
	 */
	public NotificadorSMS(int to) {
		this(String.format("%09d", to));
	}

	/**
	 * Crea un NotificadorSMS a un destinatario concreto
	 * 
	 * @param pre Prefijo
	 * @param num Número destino
	 */
	public NotificadorSMS(int pre, int num) {
		this(String.format("+%d %09d", pre, num));
	}

	/**
	 * Crea un NotificadorSMS a un destinatario concreto
	 * 
	 * @param to Destinatartio
	 */
	public NotificadorSMS(String to) {
		if (to == null || to.isBlank())
			throw new IllegalArgumentException("Destinatario obligatorio.");
		this.to = to.strip();
	}

	/** Envia mensaje a destinatario */
	@Override
	public void enviarNotificacion(String mensaje) {
		if (mensaje == null || mensaje.isBlank()) {
			System.err.println("Mensaje vacío");
			return;
		}
		System.out.printf("[SMS]\tDestinatario:%s\tMensaje:%s\n", to, mensaje);
	}

}
