package beisbol;

import java.util.ArrayList;

public class Serie {
	private int id;
	private ArrayList<Equipo>Equipos;
	private ArrayList<Fases>Fase;
	
	public ArrayList<Equipo> getEquipos() {
		return Equipos;
	}
	public void setEquipos(ArrayList<Equipo> Equipos) {
		this.Equipos = Equipos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Serie(int id){
		Equipos = new ArrayList<Equipo>();
		this.id=id;
		Fase=new ArrayList<Fases>(4);
		Fase.add(new Fases("1er Fase"));
		Fase.add(new Fases("2da Fase"));
		Fase.add(new Fases("Semifinal"));
		Fase.add(new Fases("Final"));
			
	}
	public void ingresarequipo(String nombre, String estadio, String provincia , String mascota, String color){
		Equipo equipo = new Equipo(nombre , estadio, provincia , mascota,color);
		Equipos.add(equipo);
	}
	public ArrayList<Fases> getFase() {
		return Fase;
	}
	public void setFase(ArrayList<Fases> fase) {
		Fase = fase;
	}
	public boolean norepetir_nombre(String nombre){
		boolean verdad=false;
		for(int contador=0;contador<Equipos.size();contador++){
			if(Equipos.get(contador).getNombre().equals(nombre)){
				verdad=true;
			}
		}
		return verdad;
	}
	public int posicion(String nombre){
		int result =-1;
		int contador=0;
		while(contador<Equipos.size()&& result== -1){
			if(Equipos.get(contador).getNombre().equals(nombre)){
				result = contador;
			}
			else{
				contador ++;
			}
		}
		return result;
	}
	public Equipo buscar_equipo(String nombre){
    	int x = posicion(nombre);
    	if(x!=-1){
    		return Equipos.get(x);
    	}
    	else{
    		return null;
    	}
	}
	
	public boolean EsOk(){
		int i = 0;
		int count = 0;
		while(i < Equipos.size() && count < 8){
			if(Equipos.get(i).CantidadLanzadores() > 0)
				count++;
			i++;
		}
		return count>7;
	}
	
	public ArrayList<Equipo> Ganadores(int cantidad)
	{
		ArrayList<Equipo> resultado = new ArrayList<Equipo>(Equipos);
		burbuja(resultado);
		return new ArrayList<Equipo>(resultado.subList(0, Math.min(cantidad, Equipos.size())));
	}
	
	public void burbuja(ArrayList<Equipo> list){
		Equipo aux;
		for(int i=0; i < list.size()-1; i++){
		   for(int j=i+1; j < list.size(); j++){
			   if(list.get(i).getCantidad_ganados() < list.get(j).getCantidad_ganados()){
				   aux = list.get(i);
				   list.set(i,list.get(j));
				   list.set(j,aux);
			   }
		   }
		}
	}
	
	public Equipo Campeon()
	{
		if(Fase.get(3).getPartido().size()>0)
		{
			Equipo uno = Fase.get(3).getPartido().get(0).Ganador();
			Equipo dos = Fase.get(3).getPartido().get(0).Perdedor();
			int contadorUno = 1;
			for(int i = 1; i < Fase.get(3).getPartido().size(); i++)
				if(Fase.get(3).getPartido().get(i).Ganador() == uno)
					contadorUno++;
			int contadorDos = Fase.get(3).getPartido().size()-contadorUno;
			if(contadorUno > contadorDos)
				return uno;
			else if(contadorUno < contadorDos)
				return dos;
			else
				return null;
		}
		else
			return null;
	}
	
}
