package exercises.ex07;

public class Main {

	public static void main(String[] args) {
		var tmp1 = new Tiempo(0, 30, 40);
		var tmp2 = new Tiempo(0, 35, 20);
		System.out.printf("%s + %s", tmp1.toString(), tmp2.toString());
		tmp1.suma(tmp2);
		System.out.printf(" = %s", tmp1.toString());
	}

}
