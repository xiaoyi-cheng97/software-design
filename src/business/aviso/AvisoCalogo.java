package business.aviso;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AvisoCalogo {

	
	
	private static AvisoCalogo instance;
	
	private HashMap<Integer, AvisosTimer> avisosTimer;
	private HashMap<Integer, Aviso> avisos;
	private int i;
			
	public AvisoCalogo() {
		
		this.avisosTimer = new HashMap<Integer, AvisosTimer>();
		this.avisos = new HashMap<Integer, Aviso>();
		this.i = 1; 
	}
	
	public void addAviso(AvisosTimer at, Aviso a) {
		avisosTimer.put(i, at);
		avisos.put(i, a);
		i++;
	}
	
	public void deleteAviso(int j) {
		avisos.remove(j);
		AvisosTimer at = avisosTimer.get(i);
		at.endTimer();
		avisosTimer.remove(j);
	}
	
	
	public  List<String> getAvisos(){
		List<String> lista = new  ArrayList<String>();
		Iterator<Integer> i = avisos.keySet().iterator();
		while (i.hasNext()) {
			lista.add(i.next() + " - " + avisos.get(i).getMsg());
		}
		return lista;
	}
	
	public Iterator<Aviso> getAvisoToSms(){
		return avisos.values().iterator();
	}

	public static AvisoCalogo getInstance() {
		if (instance == null) {
			instance = new AvisoCalogo();
		}
		
		return instance;
	}
	
	
	
}
