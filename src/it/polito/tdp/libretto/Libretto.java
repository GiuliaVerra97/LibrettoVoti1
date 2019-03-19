package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.*;

public class Libretto {

	
	//mantengo le interfacce più generali possibili
	
	private List<Voto> voti;		//meglio essere il più generale possibile
	
	
	public Libretto() {
		this.voti=new ArrayList<Voto>();	
	}
	
	
	
	/**
	 * aggiunge nuovo voto al libretto
	 * @param v il {@link Voto} da aggiungere
	 */
	
	public void add(Voto v) {
		voti.add(v);
	}
	
	
	
	
	/**
	 * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * @param punti punteggio da ricerca
	 * @return lista di {@link Voto} aventi quel punteggio (eventualmente vuota)
	 */
	
	public List<Voto> cercaVoti(int voto){
		
		List<Voto> result=new ArrayList<Voto>();
		
		for(Voto v: this.voti) {
			if(v.getPunti()==voto) {
				result.add(v);
			}
		}
		
		return result;
	}
	
	
	/**
	 * Ricerca un {@link Voto} relativo al corso di cui è specificato il nome
	 * @param nomeEsame nome del corso da ricercare
	 * @return il {@link Voto} corrispondente a quanto cercato
	 */
	
	
	
	public Voto cercaEsame(String nomeEsame) {
		
		for(Voto v: this.voti) {
			if(nomeEsame.equals(v.getCorso())) {
				return v;
			}
		}
		
		return null;
	}
	
	
	/**
	 * Dato un {@link Voto}, determina se esiste già un voto con uguale corso ed uguale punteggio.
	 * @param v
	 * @return {@code true} se ha trovato un corso e punteggio uguali
	 * @return {@code true} se non ha trovato un corso oppure l'ha trovato con voto diverso
	 */
	public boolean esisteGiaVoto(Voto v) {
		Voto trovato=this.cercaEsame(v.getCorso());
		if(trovato==null) {
			return false;
		}
		if(trovato.getPunti()==v.getPunti()) {
			return true;
		}	
		else {
			return false;
		}
	}
	
	
	
}
