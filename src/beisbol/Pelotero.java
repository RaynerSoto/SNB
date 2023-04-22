package beisbol;

public abstract class Pelotero {
	private String nombre;
	private String apellido;
	private String id;
	private int numero;
	private int a�os_equipo;
	private Brazo_H�bil brazo;
	
	public Pelotero(String nombre,String apellido,String id,int numero,int a�os_equipo,Brazo_H�bil brazo){
		this.nombre=nombre;
		this.apellido=apellido;
		this.id=id;
		this.numero=numero;
		this.a�os_equipo=a�os_equipo;
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
	public int getA�os_equipo() {
		return a�os_equipo;
	}
	public void setA�os_equipo(int a�os_equipo) {
		this.a�os_equipo = a�os_equipo;
	}
	public Brazo_H�bil getBrazo() {
		return brazo;
	}
	public void setBrazo(Brazo_H�bil brazo) {
		this.brazo = brazo;
	}
	
	@Override
	public String toString(){
		return nombre;
	}
}
