package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <h1>2. Colecciones y Polimorfismo</h1>
 * <p>
 * Crea una clase TorneoApp con el método main:
 * <p>
 * Declara una lista polimórfica:<br>
 * List<<Participante>> torneo = new ArrayList<>();
 * <p>
 * Añade al menos dos jugadores y dos equipos.
 * <p>
 * Mete a alguno de los jugadores en partida usando entrarPartida() (necesitarás
 * comprobar el tipo con instanceof antes del cast).
 * <p>
 * Recorre la lista con un bucle y llama a obtenerResumen() en cada elemento,
 * demostrando ligadura dinámica.
 * <p>
 * Al terminar, muestra cuántos jugadores hay actualmente en partida usando el
 * atributo estático.
 * <h2>Autor: Pablo Illescas</h2>
 */
public class TorneoApp {
	/**
	 * Comprobar participantes del torneo
	 * 
	 * @param torneo Lista de participantes
	 */
	private static void checkParticipants(List<Participante> torneo) {
		System.out.println("=== Participantes del Torneo ===");
		for (var participant : torneo) {
			System.out.println(participant);
		}
		System.out.println();
	}

	/**
	 * Comprobar resúmenes del torneo
	 * 
	 * @param torneo Lista de participantes
	 */
	private static void checkSummary(List<Participante> torneo) {
		System.out.println("=== Resúmenes ===");
		for (var participant : torneo) {
			System.out.println(participant.obtenerResumen());
		}
		System.out.println();
	}

	/** Comprobar jugadores activos */
	private static void checkPlayerStatus() {
		System.out.println("=== Estado actual del torneo ===");
		System.out.println("Jugadores en partida ahora mismo: " + Jugador.getJugadoresEnPartida());
		System.out.println();
	}

	/**
	 * Contar jugadores en un torneo
	 * 
	 * @param torneo Lista de participantes
	 * @return Cantidad de jugadores
	 */
	private static int countPlayers(List<Participante> torneo) {
		int players = 0;
		for (var p : torneo) {
			if (p instanceof Jugador)
				players++;
		}
		return players;
	}

	/**
	 * Simular ronda de juego
	 * 
	 * @param torneo Lista de participantes
	 * @return Lista de jugadores en la ronda
	 */
	private static List<Jugador> simRound(List<Participante> torneo) {
		// Crear lista de jugadores
		List<Jugador> participants = new ArrayList<>();
		// Comprobar si hay suficientes jugadores para simular la ronda
		if (countPlayers(torneo) < 2) {
			System.err.println("No hay suficientes jugadores para simular la ronda");
			return participants;
		}
		System.out.println("=== Inicio de ronda ===");
		var rnd = new Random();
		// Jugadores a intentar crear
		var players = rnd.nextInt(5) + 1;
		// Bucle de al menos dos jugadores
		for (int i = 0; i < players || participants.size() < 2; i++) {
			// Si es jugador meter en la partida
			if (torneo.get(rnd.nextInt(torneo.size())) instanceof Jugador p) {
				p.entrarPartida();
				if (!participants.contains(p))
					participants.add(p);
			}
		}
		// Si la lista de jugadores no es vacía
		if (!participants.isEmpty()) {
			// Cantidad de movimientos a realizar en la partida
			var actions = rnd.nextInt(15) + 1;
			// Aumentar la puntuación de los jugadores
			for (int i = 0; i < actions; i++) {
				var p = participants.get(rnd.nextInt(participants.size()));
				p.addScore();
				System.out.println(p.nombre + " ha ganado 1 punto.");
			}
		}
		System.out.println();
		return participants;
	}

	/**
	 * Cerrar la ronda
	 * 
	 * @param players Lista de jugadores a sacar de la partida
	 */
	private static void endRound(List<Jugador> players) {
		for (var p : players) {
			p.salirPartida();
		}
	}

	public static void main(String[] args) {
		// Lista de participantes
		List<Participante> torneo = new ArrayList<>();
		// Añadir equipo y jugadores
		var p1 = new Jugador("JUG-01", "NightWolf", 0);
		var p2 = new Jugador("JUG-02", "ShadowFox", 0);
		var e1 = new Equipo("EQU-01", "Nexus", 0, 5);
		var e2 = new Equipo("EQU-02", "Red Dragons", 0, 3);

		torneo.add(p1);
		torneo.add(e1);
		torneo.add(p2);
		torneo.add(e2);

		// Simular torneo
		checkParticipants(torneo);
		checkSummary(torneo);

		var round1 = simRound(torneo);

		checkPlayerStatus();

		endRound(round1);

		checkPlayerStatus();

		checkParticipants(torneo);
		checkSummary(torneo);
	}

}
