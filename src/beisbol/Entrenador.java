package beisbol;

public class Entrenador extends Pelotero{
	private int cantidad_a�os_experiencia;
	
	public Entrenador(String nombre,String apellido,String id,int numero,int a�os_equipo,Brazo_H�bil brazo,int cantidad_a�os_experiencia){
		super(nombre,apellido,id,numero,a�os_equipo,brazo);
		this.cantidad_a�os_experiencia=cantidad_a�os_experiencia;
	}

	public int getCantidad_a�os_experiencia() {
		return cantidad_a�os_experiencia;
	}

	public void setCantidad_a�os_experiencia(int cantidad_a�os_experiencia) {
		this.cantidad_a�os_experiencia = cantidad_a�os_experiencia;
	}
}
