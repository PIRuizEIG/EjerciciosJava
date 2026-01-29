package archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class EjemploFichero01 {
	private static void readFile(String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String linea = br.readLine();
			while (linea != null) {
				System.out.println(linea);
				linea = br.readLine();
			}
			br.close(); // ¡IMPORTANTE CERRAR EL FICHERO!
		} catch (IOException ioe) {
			System.out.println("Error al leer");
		}
	}

	private static void writeFile(String filename) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

			bw.write("naranja\n");
			bw.write("mango\n");
			bw.write("chirimoya\n");

			bw.close();
		} catch (IOException ioe) {
			System.out.println("No se ha podido escribir");
		}
	}

	public static void main(String[] args) {
		readFile("malaga.txt");
		writeFile("frutas.txt");
	}
}
