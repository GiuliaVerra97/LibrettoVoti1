package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.*;

public class Libretto {

	
	//mantengo le interfacce pi� generali possibili
	
	private List<Voto> voti;		//meglio essere il pi� generale possibile
	//private indica che � accessibile solo ai metodi della stessa classe in cui viene dichiarata la variabile private
	
	public Libretto() {
		this.voti=new ArrayList<Voto>();	
	}
	
	
	
	/**
	 * aggiunge nuovo voto al libretto
	 * @param v il {@link Voto} da aggiungere
	 * @return {@code true} nel caso normale, {@code false} se non � riusciro ad aggiungere nulla
	 */
	
	public boolean add(Voto v) {
		
		if(!this.esisteGiaVoto(v) && !this.votoInConflitto(v)) {
			voti.add(v);		//add restisuisce true se � stato aggiunto un elemento, false altrimenti
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
	 * Ricerca un {@link Voto} relativo al corso di cui � specificato il nome
	 * @param nomeEsame nome del corso da ricercare
	 * @return il {@link Voto} corrispondente a quanto cercato
	 */
	public Voto cercaEsame(String nomeEsame) {
		
		Voto v=new Voto(0,nomeEsame, null);	//creo oggetto fasullo, incompleto che mi serve per criterio di ricerca
		int posizione=this.voti.indexOf(v);		
		if(posizione==-1) {
			return null;
		}else {
		return this.voti.get(posizione);
		}
	}
	
	
	/**
	 * Dato un {@link Voto}, determina se esiste gi� un voto con uguale corso ed uguale punteggio.
	 * @param v
	 * @return {@code true} se ha trovato un corso e punteggio uguali,
	 * 			{@code false} se non ha trovato un corso oppure l'ha trovato con voto diverso
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
	 * Mi dice se il {@link Voto} {@code v} � in conflitto con uno dei voti esistenti. 
	 * Se il voto non esiste, non c'� conflitto. Se esiste ed ha un punteggio diverso, c'� conflitto
	 * @param v
	 * @return false se non c'� conflitto, true se c'� conflitto
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
	
	//posso restituire anche istanze della stessa classe in cui sto lavorando
	public Libretto librettoMigliorato() {
		Libretto librettoNuovo=new Libretto();		
		/*											
		for(Voto v: this.voti) {				//quando modifico l'elemento di una lista sto in realt� modificando anche la lista vecchia, perch� sto separando solo i puntatori e non gli oggetti
			librettoNuovo.add(v);				// sto mantenendo collegate le liste, esse rimangono uguali
		}										//in questo metodo sia il libretto vecchio sia il libretto nuovo hanno gli stessi elementi
		*/
		for(Voto v: this.voti) {
			librettoNuovo.add(v.clone());		// per creare, clonare due liste che inizialmente saranno uguali, ma poi verranno utilizzate separatamente
		}	
		
		
		for(Voto v:librettoNuovo.voti) {
			int punti=v.getPunti();
			if(punti<=24) {
				punti=punti+1;
			}else if(punti<=28) {
				punti=punti+2;
			}
			v.setPunti(punti);
		}
		
		return librettoNuovo;
	}
	
	
	public void cancellaVotiScarsi() {
		List<Voto> cancellare=new ArrayList<Voto>();
		for(Voto v:this.voti) {
			if(v.getPunti()<24) {
				cancellare.add(v);
			}
		}
		this.voti.removeAll(cancellare);
	}
	
	
	
}
