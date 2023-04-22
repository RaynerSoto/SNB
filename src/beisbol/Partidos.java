package beisbol;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Partidos {
	private Equipo homeClub;
	private Equipo visitante;
	private Lanzador homeClub_lanzador;
	private Lanzador visitante_lanzador;
	private int homeclub_carreras;
	private int visitante_carreras;
	private Date fecha;
	
	public Partidos(Equipo homeClub,Equipo visitante,Lanzador homeClub_lanzador,Lanzador visitante_lanzador,int homeclub_carreras,int visitante_carreras,Date fecha){
		this.fecha=fecha;
		this.homeClub=homeClub;
		this.visitante=visitante;
		this.homeClub_lanzador=homeClub_lanzador;
		this.visitante_lanzador=visitante_lanzador;
		this.homeclub_carreras=homeclub_carreras;
		this.visitante_carreras=visitante_carreras;
	}
	
	public Equipo getHomeClub() {
		return homeClub;
	}
	public Equipo getVisitante() {
		return visitante;
	}
	public Lanzador getHomeClub_lanzador() {
		return homeClub_lanzador;
	}
	public Lanzador getVisitante_lanzador() {
		return visitante_lanzador;
	}
	public int getHomeclub_carreras() {
		return homeclub_carreras;
	}
	public int getVisitante_carreras() {
		return visitante_carreras;
	}
	public void setHomeClub(Equipo homeClub) {
		this.homeClub = homeClub;
	}
	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}
	public void setHomeClub_lanzador(Lanzador homeClub_lanzador) {
		this.homeClub_lanzador = homeClub_lanzador;
	}
	public void setVisitante_lanzador(Lanzador visitante_lanzador) {
		this.visitante_lanzador = visitante_lanzador;
	}
	public void setHomeclub_carreras(int homeclub_carreras) {
		this.homeclub_carreras = homeclub_carreras;
	}
	public void setVisitante_carreras(int visitante_carreras) {
		this.visitante_carreras = visitante_carreras;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Equipo Ganador()
	{
		if(homeclub_carreras > visitante_carreras)
			return homeClub;
		else
			return visitante;
	}
	
	public Equipo Perdedor()
	{
		if(homeclub_carreras < visitante_carreras)
			return homeClub;
		else
			return visitante;
	}
	
}
