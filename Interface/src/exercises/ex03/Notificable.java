package exercises.ex03;

/**
 * <h1>Ejercicio 3: Sistema de Notificaciones</h1> Diseña una interfaz
 * Notificable con un método `enviarNotificacion(String mensaje)`. Implementa
 * esta interfaz en dos clases: `NotificadorEmail` y `NotificadorSMS`. Luego,
 * crea una función `procesarNotificaciones(List notificadores, String mensaje)`
 * que itere sobre una lista de notificadores y envíe el mismo mensaje a través
 * de todos ellos.
 * <h2>Autor: Pablo Illescas</h2>
 */
public interface Notificable {
	public void enviarNotificacion(String mensaje);
}
