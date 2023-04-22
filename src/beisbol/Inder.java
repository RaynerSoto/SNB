package beisbol;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import interfaz.Listado_jugadores;

public class Inder {
	
	private static Inder ind;
	private ArrayList<Serie>Series;
	
	

	public void setSeries(ArrayList<Serie> series) {
		Series = series;
	}

	public ArrayList<Serie> getSeries() {
		return Series;
	}
	
	public static Inder getInstancia(){
		if(ind == null)
			ind = new Inder();
		return ind;
	}
	
	private Inder(){
		Series = new ArrayList<Serie>();
		CargarDefecto();
	}
	
	private void CargarDefecto(){
		Serie ser = new Serie(1);
		Equipo e1 = new Equipo("Industriales","Latino", "La Habana","Le�n","Azul");
		e1.setEntrenador(new Entrenador("Rey","Anglada","54060511343",26,7,Brazo_H�bil.Derecho,20));
		e1.getJugadores().add(new Jugador_cuadro("Alexander", "Mayeta", "80103025641", 55, 10, Brazo_H�bil.Izquierdo, Posicion_espec�fica.B1, 10, 5, 5, 2, 1, 3));
		e1.getJugadores().add(new Lanzador("Frank", "Montieth", "90040480123", 24, 5, Brazo_H�bil.Derecho, "Slider", 92));
		Equipo e2 = new Equipo("Pinar del R�o","Gran Parque", "Pinar del R�o","Tabaco","Verde");
		e2.setEntrenador(new Entrenador("Pedro","Lazo","80060511483",35,2,Brazo_H�bil.Derecho,10));
		e2.getJugadores().add(new Jugador_cuadro("Richar ", "Medina", "80103025629", 70, 11, Brazo_H�bil.Ambidiestro, Posicion_espec�fica.C, 10, 5, 5, 2, 1, 3));
		e2.getJugadores().add(new Lanzador("Ernesto", "Ramsey", "95040480123", 24, 5, Brazo_H�bil.Derecho, "Recta de cuatro costuras", 80));
		Equipo e3 = new Equipo("Guant�namo","M�ximo G�mez", "Guant�namo","Indios","Amarillo");
		e3.setEntrenador(new Entrenador("Carlos","Perez","70060511343",90,5,Brazo_H�bil.Derecho,10));
		e3.getJugadores().add(new Jugador_cuadro("Reinier", "Marcoman", "90103025641", 10, 4, Brazo_H�bil.Derecho, Posicion_espec�fica.B3, 10, 5, 5, 2, 1, 3));
		e3.getJugadores().add(new Lanzador("Michael", "Carmelo", "90100480123", 46, 3, Brazo_H�bil.Izquierdo, "Recta de dos costuras", 100));
		Equipo e4 = new Equipo("Cienfuegos","Victoria de Gir�n", "Cienfuegos","Elefante","Verde");
		e4.setEntrenador(new Entrenador("Lisandri","Linares","65010111347",40,10,Brazo_H�bil.Derecho,16));
		e4.getJugadores().add(new Jugador_cuadro("Tom�s", "Cao", "80020525641", 59, 15, Brazo_H�bil.Izquierdo, Posicion_espec�fica.LF, 10, 5, 5, 2, 1, 3));
		e4.getJugadores().add(new Lanzador("Frank", "Isaac", "90040480123", 24, 5, Brazo_H�bil.Derecho, "Submarino", 92));
		Equipo e5 = new Equipo("Villa Clara","San Ju�n de Tom�s", "Villa Clara","Naranja","Anaranjado");
		e5.setEntrenador(new Entrenador("Victo","Fundora","80060511343",26,1,Brazo_H�bil.Derecho,15));
		e5.getJugadores().add(new Jugador_cuadro("Tom�s", "Roloff", "80103025641", 70, 5, Brazo_H�bil.Derecho, Posicion_espec�fica.SS, 10, 5, 5, 2, 1, 3));
		e5.getJugadores().add(new Lanzador("Fernado", "Zamora", "90040480123", 35, 2, Brazo_H�bil.Izquierdo, "Slider", 100));
		Equipo e6 = new Equipo("Mantazas","Jos� Mart�", "Matanzas","Cocodrilo","Verde");
		e6.setEntrenador(new Entrenador("Victor","Mesa","74060511343",25,5,Brazo_H�bil.Derecho,25));
		e6.getJugadores().add(new Jugador_cuadro("Yurisbel", "Gracial", "90103025641", 7, 8, Brazo_H�bil.Izquierdo, Posicion_espec�fica.B1, 10, 5, 5, 2, 1, 3));
		e6.getJugadores().add(new Lanzador("Ayader", "Mart�nez", "80120580123", 98, 6, Brazo_H�bil.Izquierdo, "Curva", 89));
		Equipo e7 = new Equipo("Las Tunas","Antonio Maceo", "Las Tunas","Mariposa","Rojo");
		e7.setEntrenador(new Entrenador("Omar","Linares","74060511343",35,10,Brazo_H�bil.Derecho,20));
		e7.getJugadores().add(new Jugador_cuadro("Osmany", "Alarcon", "85123025641", 55, 10, Brazo_H�bil.Derecho, Posicion_espec�fica.C, 10, 5, 5, 2, 1, 3));
		e7.getJugadores().add(new Lanzador("Reinier", "Per�", "90040480123", 24, 5, Brazo_H�bil.Derecho, "Submarino", 95));
		Equipo e8 = new Equipo("Santi Sp�ritus","Tit�n de Bronce", "Santi Sp�ritus","Orca","Naranja");
		e8.setEntrenador(new Entrenador("Ren�","Mesa","74060511343",99,4,Brazo_H�bil.Derecho,25));
		e8.getJugadores().add(new Jugador_cuadro("Pablo", "Manuel", "85103025641", 56, 12, Brazo_H�bil.Derecho, Posicion_espec�fica.CF, 10, 5, 5, 2, 1, 3));
		e8.getJugadores().add(new Lanzador("Lizandro", "Mart�nez", "010040480123", 24, 2, Brazo_H�bil.Ambidiestro, "Submarino", 99));
		Equipo e9 = new Equipo("Granma","Desembarco del Granma", "Granma","Le�adores","Camelita");
		e9.setEntrenador(new Entrenador("Ra�l","D�az","44060511343",76,8,Brazo_H�bil.Derecho,30));
		e9.getJugadores().add(new Jugador_cuadro("Miguel", "Castro", "85103025641", 59, 11, Brazo_H�bil.Izquierdo, Posicion_espec�fica.RF, 10, 5, 5, 2, 1, 3));
		e9.getJugadores().add(new Lanzador("Mario", "Brody", "90040480123", 52, 5, Brazo_H�bil.Derecho, "Slider", 101));
		ser.getEquipos().add(e1);
		ser.getEquipos().add(e2);
		ser.getEquipos().add(e3);
		ser.getEquipos().add(e4);
		ser.getEquipos().add(e5);
		ser.getEquipos().add(e6);
		ser.getEquipos().add(e7);
		ser.getEquipos().add(e8);
		ser.getEquipos().add(e9);
		Series.add(ser);
	}
	
	public Serie buscarSerie(int serie){
		Serie serieA = null;
		int i = 0;
		boolean encontrado = false;
		while(i<Series.size() && !encontrado){
			if(Series.get(i).getId()==serie){
				serieA = Series.get(i);
				encontrado = true;
			}
			i++;
		}
		return serieA;
	}
	
	public int buscarSeriePos(int serie){
		int result = -1;
		int i = 0;
		while(i < Series.size() && result == -1){
			if(Series.get(i).getId()==serie)
				result = i;
			else
				i++;
		}
		return result;
	}
	
	public ArrayList<Jugador_cuadro> MayorAverage(int idSerie)
	{
		ArrayList<Jugador_cuadro> resultado = new ArrayList<Jugador_cuadro>();
		double ave = 0;
		Serie serie = buscarSerie(idSerie);
		if(serie != null)
		{
			Equipo eq;
			Pelotero pel;
			Jugador_cuadro jc;
			double cave;
			for(int i = 0; i < serie.getEquipos().size(); i++)
			{
				eq = serie.getEquipos().get(i);
				for(int j = 0; j < eq.getJugadores().size(); j++){
					pel = eq.getJugadores().get(j);
					if(pel instanceof Jugador_cuadro){
						jc = (Jugador_cuadro)pel;
						cave=jc.Average();
						if(cave>ave){
							resultado.clear();
							resultado.add(jc);
							ave=cave;
						}
						else if(cave==ave)
							resultado.add(jc);
					}
			}
			}
		}
		return resultado;
	}
}
