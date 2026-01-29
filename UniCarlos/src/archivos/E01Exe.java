package archivos;

public class E01Exe {
	public static void main (String args[]) {
		CountLines.count("malaga.txt");
		System.out.printf("La media es: %d%n", FileAverage.average("numbers.txt"));
	}
}
