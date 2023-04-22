package beisbol;

public class Entrenador extends Pelotero{
	private int cantidad_años_experiencia;
	
	public Entrenador(String nombre,String apellido,String id,int numero,int años_equipo,Brazo_Hábil brazo,int cantidad_años_experiencia){
		super(nombre,apellido,id,numero,años_equipo,brazo);
		this.cantidad_años_experiencia=cantidad_años_experiencia;
	}

	public int getCantidad_años_experiencia() {
		return cantidad_años_experiencia;
	}

	public void setCantidad_años_experiencia(int cantidad_años_experiencia) {
		this.cantidad_años_experiencia = cantidad_años_experiencia;
	}
}
