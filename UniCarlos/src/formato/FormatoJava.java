package formato;

public class FormatoJava {
	public static void main(String[] args) {
		System.out.println("Texto normal");
		
		System.out.print(JavaFormat.BOLD);
		System.out.println("Texto negrita");
		System.out.print(JavaFormat.RESET);
		
		System.out.print(JavaFormat.ITALIC);
		System.out.println("Texto cursiva");
		System.out.print(JavaFormat.RESET);
		
		System.out.print(JavaFormat.RED);
        System.out.println("Este texto es rojo");
        System.out.print(JavaFormat.RESET);
        
        System.out.print(JavaFormat.RED_BG);
        System.out.println("Este fondo es rojo");
        System.out.print(JavaFormat.RESET);
        
        System.out.print(JavaFormat.BOLD + JavaFormat.GREEN);
        System.out.println("Texto en negrita y verde");
        System.out.print(JavaFormat.RESET);
        
        System.out.print(JavaFormat.UNDERLINE + JavaFormat.BLUE_BG + JavaFormat.YELLOW);
        System.out.println("Texto Amarillo, Fondo Azul, Subrayado");
        System.out.print(JavaFormat.RESET);
	}
}
