package beisbol;

public class Lanzador extends Pelotero {
	public Lanzador(String nombre, String apellido, String id, int numero,int años_equipo, Brazo_Hábil brazo,String lanzamiento_preferido,int velocidad_maxima) {
		super(nombre, apellido, id, numero, años_equipo, brazo);
		this.carreras_permitidas=0;
		this.juegos_ganados=0;
		this.juegos_perdidos=0;
		this.velocidad_maxima=velocidad_maxima;
		lanzamiento = lanzamiento_preferido;
	}
	private int carreras_permitidas;
	private int juegos_ganados;
	private int juegos_perdidos;
	private int velocidad_maxima;
	private String lanzamiento;

	public double PCL() {
		if(getJuegos_ganados()+getJuegos_perdidos()== 0){
			return 0;
		}
		else{
			return carreras_permitidas*9/9;
		}
	}
	public int getCarreras_permitidas() {
		return carreras_permitidas;
	}
	public void setCarreras_permitidas(int carreras_permitidas) {
		this.carreras_permitidas = carreras_permitidas;
	}
	public int getJuegos_ganados() {
		return juegos_ganados;
	}
	public void setJuegos_ganados(int juegos_ganados) {
		this.juegos_ganados = juegos_ganados;
	}
	public int getJuegos_perdidos() {
		return juegos_perdidos;
	}
	public void setJuegos_perdidos(int juegos_perdidos) {
		this.juegos_perdidos = juegos_perdidos;
	}
	public int getVelocidad_maxima() {
		return velocidad_maxima;
	}
	public String getLanzamiento() {
		return lanzamiento;
	}
	public void setVelocidad_maxima(int velocidad_maxima) {
		this.velocidad_maxima = velocidad_maxima;
	}
	public void setLanzamiento(String lanzamiento) {
		this.lanzamiento = lanzamiento;
	}
}
