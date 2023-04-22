package beisbol;

import java.awt.Color;
import java.util.ArrayList;

public class Equipo {
	private String nombre;
	private String provincia;
	private String mascota;
	private String color;
	private String estadio;
	private ArrayList<Pelotero>Jugadores;
	private Entrenador Entrenador;
	
	public String getMascota() {
		return mascota;
	}
	public void setMascota(String mascota) {
		this.mascota = mascota;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public Entrenador getEntrenador() {
		return Entrenador;
	}
	public void setEntrenador(Entrenador Entrenador) {
		this.Entrenador = Entrenador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public int getCantidad_ganados() {
		int resultado = 0;
		for(int i = 0; i < Jugadores.size(); i++)
			if(Jugadores.get(i) instanceof Lanzador)
			resultado+= ((Lanzador)Jugadores.get(i)).getJuegos_ganados();
		return resultado;
	}
	
	public int getCantidad_perdidos() {
		int resultado = 0;
		for(int i = 0; i < Jugadores.size(); i++)
			if(Jugadores.get(i) instanceof Lanzador)
			resultado+= ((Lanzador)Jugadores.get(i)).getJuegos_perdidos();
		return resultado;
	}
	
	public ArrayList<Pelotero> getJugadores() {
		return Jugadores;
	}
	public void setJugadores(ArrayList<Pelotero> jugadores) {
		Jugadores = jugadores;
	}
	public Equipo(String nombre, String estadio, String provincia, String mascota, String color) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.mascota = mascota;
		this.color = color;
		this.estadio=estadio;
		Jugadores=new ArrayList<Pelotero>();
	}
	public void ingresar_jugador_cuadro(String nombre,String apellido,String id,int numero,int años_equipo,Brazo_Hábil brazo, Posicion_específica posición, int cantidad_errores, int outs, int sencillo, int dobles, int triples, int homerun){
		Jugador_cuadro cuadro=new Jugador_cuadro(nombre,apellido,id,numero,años_equipo,brazo,posición,cantidad_errores,outs,sencillo,dobles,triples,homerun);
		Jugadores.add(cuadro);
	}
	public void ingresar_jugador_lanzador(String nombre, String apellido, String id, int numero,int años_equipo, Brazo_Hábil brazo,String lanzamiento,int velocidad){
		Lanzador pitcher=new Lanzador(nombre,apellido,id,numero,años_equipo,brazo,lanzamiento,velocidad);
		Jugadores.add(pitcher);
	}
	public void ingresar_manager(String nombre,String apellido,String id,int numero,int años_equipo,Brazo_Hábil brazo,int cantidad_años_experiencia){
		if(Entrenador == null)
			Entrenador = new Entrenador(nombre, apellido, id, numero, años_equipo, brazo, cantidad_años_experiencia);
		else{
		Entrenador.setNombre(nombre);
		Entrenador.setApellido(apellido);
		Entrenador.setId(id);
		Entrenador.setNumero(numero);
		Entrenador.setAños_equipo(años_equipo);
		Entrenador.setBrazo(brazo);
		Entrenador.setCantidad_años_experiencia(cantidad_años_experiencia);
		}
	}
	
	public Pelotero buscador_pelotero(int numero){
		Pelotero jugador = null;
		int i = 0;
		boolean encontrado = false;
		while(i<Jugadores.size() && !encontrado){
			if(Jugadores.get(i).getNumero()==numero){
				jugador = Jugadores.get(i);
				encontrado = true;
			}
			i++;
		}
		return jugador;
	}
	public int posicion_jugador(int numero){
		int contador=0;
		int posi=-1;
		while(contador<Jugadores.size() && posi==-1){
			if(Jugadores.get(contador).getNumero() == numero){
				posi = contador;
			}
			contador ++;
		}
		return posi;
	}
	
	public int CantidadLanzadores(){
		int resultado = 0;
		for(int i = 0; i < Jugadores.size(); i++)
			if(Jugadores.get(i) instanceof Lanzador)
				resultado++;
		return resultado;
	}
	
	@Override
	public String toString(){
		return nombre;
	}
	
	public ArrayList<Jugador_cuadro> AverageJC()
	{
		ArrayList<Jugador_cuadro> resultado = new ArrayList<Jugador_cuadro>();
		for(int i = 0; i < Jugadores.size(); i++)
			if(Jugadores.get(i) instanceof Jugador_cuadro)
				resultado.add((Jugador_cuadro)Jugadores.get(i));
		burbuja_jugadores_average(resultado);
		return resultado;
	}
	public ArrayList<Jugador_cuadro> Hits()
	{
		ArrayList<Jugador_cuadro> resultado = new ArrayList<Jugador_cuadro>();
		for(int i = 0; i < Jugadores.size(); i++)
			if(Jugadores.get(i) instanceof Jugador_cuadro)
				resultado.add((Jugador_cuadro)Jugadores.get(i));
		burbuja_jugadores_hits(resultado);
		return resultado;
	}
	
	public ArrayList<Jugador_cuadro> Triples()
	{
		ArrayList<Jugador_cuadro> resultado = new ArrayList<Jugador_cuadro>();
		for(int i = 0; i < Jugadores.size(); i++)
			if(Jugadores.get(i) instanceof Jugador_cuadro)
				resultado.add((Jugador_cuadro)Jugadores.get(i));
		burbuja_jugadores_triples(resultado);
		return resultado;
	}
	public ArrayList<Jugador_cuadro> Homeround()
	{
		ArrayList<Jugador_cuadro> resultado = new ArrayList<Jugador_cuadro>();
		for(int i = 0; i < Jugadores.size(); i++)
			if(Jugadores.get(i) instanceof Jugador_cuadro)
				resultado.add((Jugador_cuadro)Jugadores.get(i));
		burbuja_jugadores_homeround(resultado);
		return resultado;
	}
	public ArrayList<Jugador_cuadro> Sencillo()
	{
		ArrayList<Jugador_cuadro> resultado = new ArrayList<Jugador_cuadro>();
		for(int i = 0; i < Jugadores.size(); i++)
			if(Jugadores.get(i) instanceof Jugador_cuadro)
				resultado.add((Jugador_cuadro)Jugadores.get(i));
		burbuja_jugadores_sencillos(resultado);
		return resultado;
	}
	public ArrayList<Jugador_cuadro> Dobles()
	{
		ArrayList<Jugador_cuadro> resultado = new ArrayList<Jugador_cuadro>();
		for(int i = 0; i < Jugadores.size(); i++)
			if(Jugadores.get(i) instanceof Jugador_cuadro)
				resultado.add((Jugador_cuadro)Jugadores.get(i));
		burbuja_jugadores_dobles(resultado);
		return resultado;
	}
	
	public ArrayList<Lanzador> Ganadores()
	{
		ArrayList<Lanzador> resultado = new ArrayList<Lanzador>();
		for(int i = 0; i < Jugadores.size(); i++)
			if(Jugadores.get(i) instanceof Lanzador)
				resultado.add((Lanzador)Jugadores.get(i));
		burbuja_lanzadores_ganados(resultado);
		return resultado;
	}
	
	public ArrayList<Lanzador> PCL()
	{
		ArrayList<Lanzador> resultado = new ArrayList<Lanzador>();
		for(int i = 0; i < Jugadores.size(); i++)
			if(Jugadores.get(i) instanceof Lanzador)
				resultado.add((Lanzador)Jugadores.get(i));
		burbujaPCL(resultado);
		return resultado;
	}
	
	public ArrayList<Lanzador> Perdedores()
	{
		ArrayList<Lanzador> resultado = new ArrayList<Lanzador>();
		for(int i = 0; i < Jugadores.size(); i++)
			if(Jugadores.get(i) instanceof Lanzador)
				resultado.add((Lanzador)Jugadores.get(i));
		burbuja_lanzadores_perdidos(resultado);
		return resultado;
	}
	
	public void burbuja_lanzadores_ganados(ArrayList<Lanzador> list){
		Lanzador aux;
		for(int i=0; i < list.size()-1; i++){
		   for(int j=i+1; j < list.size(); j++){
			   if(list.get(i).getJuegos_ganados() < list.get(j).getJuegos_ganados()){
				   aux = list.get(i);
				   list.set(i,list.get(j));
				   list.set(j,aux);
			   }
		   }
		}
	}
	public void burbuja_lanzadores_perdidos(ArrayList<Lanzador> list){
		Lanzador aux;
		for(int i=0; i < list.size()-1; i++){
		   for(int j=i+1; j < list.size(); j++){
			   if(list.get(i).getJuegos_perdidos() < list.get(j).getJuegos_perdidos()){
				   aux = list.get(i);
				   list.set(i,list.get(j));
				   list.set(j,aux);
			   }
		   }
		}
	}
	
	public void burbuja_jugadores_average(ArrayList<Jugador_cuadro> list){
		Jugador_cuadro aux;
		for(int i=0; i < list.size()-1; i++){
		   for(int j=i+1; j < list.size(); j++){
			   if(list.get(i).Average() < list.get(j).Average()){
				   aux = list.get(i);
				   list.set(i,list.get(j));
				   list.set(j,aux);
			   }
		   }
		}
	}
	public void burbuja_jugadores_hits(ArrayList<Jugador_cuadro> list){
		Jugador_cuadro aux;
		for(int i=0; i < list.size()-1; i++){
		   for(int j=i+1; j < list.size(); j++){
			   if(list.get(i).Hits() < list.get(j).Hits()){
				   aux = list.get(i);
				   list.set(i,list.get(j));
				   list.set(j,aux);
			   }
		   }
		}
	}
	public void burbuja_jugadores_sencillos(ArrayList<Jugador_cuadro> list){
		Jugador_cuadro aux;
		for(int i=0; i < list.size()-1; i++){
		   for(int j=i+1; j < list.size(); j++){
			   if(list.get(i).getSencillo() < list.get(j).getSencillo()){
				   aux = list.get(i);
				   list.set(i,list.get(j));
				   list.set(j,aux);
			   }
		   }
		}
	}
	public void burbuja_jugadores_dobles(ArrayList<Jugador_cuadro> list){
		Jugador_cuadro aux;
		for(int i=0; i < list.size()-1; i++){
		   for(int j=i+1; j < list.size(); j++){
			   if(list.get(i).getDobles() < list.get(j).getDobles()){
				   aux = list.get(i);
				   list.set(i,list.get(j));
				   list.set(j,aux);
			   }
		   }
		}
	}
	public void burbuja_jugadores_triples(ArrayList<Jugador_cuadro> list){
		Jugador_cuadro aux;
		for(int i=0; i < list.size()-1; i++){
		   for(int j=i+1; j < list.size(); j++){
			   if(list.get(i).getTriples() < list.get(j).getTriples()){
				   aux = list.get(i);
				   list.set(i,list.get(j));
				   list.set(j,aux);
			   }
		   }
		}
	}
	public void burbuja_jugadores_homeround(ArrayList<Jugador_cuadro> list){
		Jugador_cuadro aux;
		for(int i=0; i < list.size()-1; i++){
		   for(int j=i+1; j < list.size(); j++){
			   if(list.get(i).getHomerun() < list.get(j).getHomerun()){
				   aux = list.get(i);
				   list.set(i,list.get(j));
				   list.set(j,aux);
			   }
		   }
		}
	}
	public void burbujaPCL(ArrayList<Lanzador> list){
		Lanzador aux;
		for(int i=0; i < list.size()-1; i++){
		   for(int j=i+1; j < list.size(); j++){
			   if(list.get(i).getJuegos_perdidos() > list.get(j).getJuegos_perdidos()){
				   aux = list.get(i);
				   list.set(i,list.get(j));
				   list.set(j,aux);
			   }
		   }
		}
	}
}
