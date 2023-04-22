package beisbol;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fases {
	private String nombre;
	private ArrayList<Partidos>partidos;
	
	
	public Fases(String nombre) {
		this.setNombre(nombre);
		this.setPartido(new ArrayList<Partidos>());
	}
	public ArrayList<Partidos> getPartido() {
		return partidos;
	}
	public void setPartido(ArrayList<Partidos> partido) {
		this.partidos = partido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void ingresar_partido(Equipo homeClub,Equipo visitante,Lanzador homeClub_lanzador,Lanzador visitante_lanzador,int homeclub_carreras,int visitante_carreras,Date fecha){
		Partidos partido =new Partidos(homeClub,visitante,homeClub_lanzador,visitante_lanzador,homeclub_carreras,visitante_carreras,fecha);
		partidos.add(partido);
	}
	
	public Date UltimaFecha(){
		Date result = null;
		if(partidos.size()>0){
			result = partidos.get(0).getFecha();
			for(int i = 1; i < partidos.size(); i++)
				if(partidos.get(i).getFecha().after(result))
					result = partidos.get(i).getFecha();
					
		}
		return result;
	}
	public int buscar_posicion_partido(Equipo homeclub, Equipo visitante,Date fecha){
		int result = -1;
		int contador = 0;
		while(contador<partidos.size() && result == -1){
			if(((partidos.get(contador).getHomeClub().equals(homeclub) && partidos.get(contador).getVisitante().equals(visitante))||(partidos.get(contador).getHomeClub().equals(visitante) && partidos.get(contador).getVisitante().equals(homeclub))) && partidos.get(contador).getFecha().equals(fecha)){
				result = contador;
			}
			else{
				contador++;
			}
		}
		return result;
	}
	public Partidos partido(Equipo homeclub, Equipo visitante,Date fecha){
		int x = buscar_posicion_partido(homeclub, visitante,fecha);
		if(x!=-1){
			return partidos.get(x);
		}
		else{
			return null;
		}
	}

	
}
