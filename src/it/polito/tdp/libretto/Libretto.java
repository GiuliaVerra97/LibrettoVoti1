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
	 * @return {@code true} nel caso normale, {@code false} se non è riusciro ad aggiungere nulla
	 */
	
	public boolean add(Voto v) {
		
		if(!this.esisteGiaVoto(v) && !this.votoInConflitto(v)) {
			voti.add(v);		//add restisuisce true se è stato aggiunto un elemento, false altrimenti
			return true;
		}else {
			return false;
		}
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
		
		Voto v=new Voto(0,nomeEsame, null);	//creo oggetto fasullo, incompleto che mi serve per criterio di ricerca
		int posizione=this.voti.indexOf(v);		//cerca all'interno della lista  se c'è il voto v, ma noi non abbiamo un oggetto voto, ma solo il nome del corso quindi creo dei campi fasulli dell'oggetto
		if(posizione==-1) {
			return null;
		}else {
		return this.voti.get(posizione);
		}
	}
	
	
	/**
	 * Dato un {@link Voto}, determina se esiste già un voto con uguale corso ed uguale punteggio.
	 * @param v
	 * @return {@code true} se ha trovato un corso e punteggio uguali
	 * @return {@code true} se non ha trovato un corso oppure l'ha trovato con voto diverso
	 */
	public boolean esisteGiaVoto(Voto v) {
		
		int posizione=this.voti.indexOf(v);
		if(posizione==-1) {
			return false;
		}else {
		return (v.getPunti()==this.voti.get(posizione).getPunti());		//ritorno il valore dell'uguaglianza ovvere o false o true	
		}
	}
	
	/**
	 * Mi dice se il {@link Voto} {@code v} è in conflitto con uno dei voti esistenti. 
	 * Se il voto non esiste, non c'è conflitto. Se esiste ed ha un punteggio dicerso, c'è conflitto
	 * @param v
	 * @return false se non c'è conflitto, true se c'è conflitto
	 */
	
	
	public boolean votoInConflitto(Voto v) {
		int posizione=this.voti.indexOf(v);
		if(posizione==-1) {
			return false;
		}else {
		return (v.getPunti()!=this.voti.get(posizione).getPunti());		//ritorno il valore dell'uguaglianza ovvere o false o true	
		}
	}
	
	public String toString() {
		return this.voti.toString();
	}
	
	
	
	
}
