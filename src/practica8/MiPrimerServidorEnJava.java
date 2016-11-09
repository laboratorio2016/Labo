package practica8;

@Servidor (direccion="/test", puerto=8080)
public class MiPrimerServidorEnJava {
	
	@Invocar
	public static void cualquiera(){
		System.out.println("SOY CUALQUIERA 1, ¿ME LLAMARON?");
	}
	
	public static void cualquiera2(){
		System.out.println("SOY CUALQUIERA 2, ¿ME LLAMARON?");
	}	
	
	@Invocar
	public static void cualquiera3(){
		System.out.println("SOY CUALQUIERA 3, ¿ME LLAMARON?");
	}
}
