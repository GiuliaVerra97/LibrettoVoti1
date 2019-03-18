package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.*;

public class Libretto {

	
	//mantengo le interfacce più generali possibili
	
	private List<Voto> voti;		//meglio essere il più generale possibile
	
	
	public Libretto() {
		this.voti=new ArrayList<Voto>();	
	}
	
	
	/*public void add(int voto, String corso, LocalDate data) {
		
	}*/
	
	/**
	 * aggiunge nuovo voto al libretto
	 * @param v il {@link Voto} da aggiungere
	 */
	
	public void add(Voto v) {
		voti.add(v);
	}
	
}
