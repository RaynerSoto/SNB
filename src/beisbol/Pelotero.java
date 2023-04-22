package beisbol;

public abstract class Pelotero {
	private String nombre;
	private String apellido;
	private String id;
	private int numero;
	private int años_equipo;
	private Brazo_Hábil brazo;
	
	public Pelotero(String nombre,String apellido,String id,int numero,int años_equipo,Brazo_Hábil brazo){
		this.nombre=nombre;
		this.apellido=apellido;
		this.id=id;
		this.numero=numero;
		this.años_equipo=años_equipo;
		this.brazo=brazo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getAños_equipo() {
		return años_equipo;
	}
	public void setAños_equipo(int años_equipo) {
		this.años_equipo = años_equipo;
	}
	public Brazo_Hábil getBrazo() {
		return brazo;
	}
	public void setBrazo(Brazo_Hábil brazo) {
		this.brazo = brazo;
	}
	
	@Override
	public String toString(){
		return nombre;
	}
}
