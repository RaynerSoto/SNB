package beisbol;

public class Jugador_cuadro extends Pelotero{
	private Posicion_espec�fica posici�n;
	private int cantidad_errores;
	private int outs;
	private int sencillo;
	private int dobles;
	private int triples;
	private int homerun;
	
	public Jugador_cuadro(String nombre,String apellido,String id,int numero,int a�os_equipo,Brazo_H�bil brazo, Posicion_espec�fica posici�n, int cantidad_errores, int outs, int sencillo, int dobles, int triples, int homerun){
		super(nombre,apellido,id,numero,a�os_equipo,brazo);
		this.posici�n=posici�n;
		this.cantidad_errores=cantidad_errores;
		this.outs=outs;
		this.sencillo=sencillo;
		this.dobles=dobles;
		this.triples=triples;
		this.homerun=homerun;
	}
	
	public Posicion_espec�fica getPosici�n() {
		return posici�n;
	}
	public void setPosici�n(Posicion_espec�fica posici�n) {
		this.posici�n = posici�n;
	}
	public int getCantidad_errores() {
		return cantidad_errores;
	}
	public void setCantidad_errores(int cantidad_errores) {
		this.cantidad_errores = cantidad_errores;
	}
	public int getOuts() {
		return outs;
	}
	public void setOuts(int outs) {
		this.outs = outs;
	}
	public int getSencillo() {
		return sencillo;
	}
	public void setSencillo(int sencillo) {
		this.sencillo = sencillo;
	}
	public int getDobles() {
		return dobles;
	}
	public void setDobles(int dobles) {
		this.dobles = dobles;
	}
	public int getTriples() {
		return triples;
	}
	public void setTriples(int triples) {
		this.triples = triples;
	}
	public int getHomerun() {
		return homerun;
	}
	public void setHomerun(int homerun) {
		this.homerun = homerun;
	}
	
	public int Hits()
	{
		return sencillo+dobles+triples+homerun;
	}
	
	public int Veces_Bate()
	{
		return Hits()+outs;
	}
	
	public int Average(){
		return Hits()*1000/Veces_Bate();
	}
	
	public int Slugin(){
		return (sencillo+(2*dobles)+(3*triples)+(4*homerun))*1000/Veces_Bate();
	}
}
