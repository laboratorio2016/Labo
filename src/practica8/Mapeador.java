package practica8;

@Archivo (nombre="/tmp/mapeador.txt")
public class Mapeador {

	@AlmacenarAtributo
	private String valor ="Default1";
	
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Integer getValor2() {
		return valor2;
	}

	public void setValor2(Integer valor2) {
		this.valor2 = valor2;
	}

	public Float getValor3() {
		return valor3;
	}

	public void setValor3(Float valor3) {
		this.valor3 = valor3;
	}

	public Float getValor4() {
		return valor4;
	}

	public void setValor4(Float valor4) {
		this.valor4 = valor4;
	}

	@AlmacenarAtributo
	private Integer valor2 =20;
	
	@AlmacenarAtributo
	private Float valor3 =30.20f;
	
	@ExceptuarAtributo
	private Float valor4 =30.20f;
	
	//Metodos getters y setters
	
	

	public static void main(String[] args) {
		
	}

}
