package exercises.ex03;

import java.util.List;

public class Executable {

	/**
	 * Envia el mensaje a todos los elementos de la lista
	 * 
	 * @param notificadores Lista de destinatarios tipo Notificables
	 * @param mensaje       Mensaje a enviar
	 */
	private static void procesarNotificaciones(List<Notificable> notificadores, String mensaje) {
		// Para cada Notificable
		notificadores.forEach(n -> {
			// Enviar mensaje a cada destinatario n de la lista
			n.enviarNotificacion(mensaje);
		});
	}

	public static void main(String[] args) {
		// Crear Notificable
		var e1 = new NotificadorEmail("test@test.com");
		var e2 = new NotificadorEmail("paco", "gmail.com");
		var m1 = new NotificadorSMS(987654321);
		var m2 = new NotificadorSMS(34, 654321987);
		var m3 = new NotificadorSMS("+34 666 66 66 66");
		// Mandar mensajes
		procesarNotificaciones(List.of(e1, m1, e2, m2, m3), "Este es el mensaje");
	}
}
