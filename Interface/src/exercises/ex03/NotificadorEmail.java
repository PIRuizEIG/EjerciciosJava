package exercises.ex03;

public class NotificadorEmail implements Notificable {
	/** Destinatario */
	private String to;

	/**
	 * Crea un NotificadorEmail a un destinatario concreto
	 * 
	 * @param email Destinatario
	 */
	public NotificadorEmail(String email) {
		if (email == null || email.isBlank())
			throw new IllegalArgumentException("Destinatario obligatorio.");
		this.to = email.strip();
	}

	/**
	 * Crea un NotificadorEmail a un destinatario concreto
	 * 
	 * @param to     Destinatario
	 * @param domain Dominio
	 */
	public NotificadorEmail(String to, String domain) {
		this(String.format("%s@%s", to.strip(), domain.strip()));
	}

	/** Enviar mensaje a destinatario */
	@Override
	public void enviarNotificacion(String mensaje) {
		if (mensaje == null || mensaje.isBlank()) {
			System.err.println("Mensaje vacío");
			return;
		}
		System.out.printf("[Email]\tDestinatario:%s\tMensaje:%s\n", to, mensaje);
	}

}
