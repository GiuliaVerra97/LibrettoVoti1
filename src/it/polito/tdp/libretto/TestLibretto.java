package it.polito.tdp.libretto;

import java.util.*;
import java.time.LocalDate;

public class TestLibretto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Libretto libr=new Libretto();
		
		libr.add(new Voto(30, "Analisi I", LocalDate.of(2017, 1, 15)));
		libr.add(new Voto(21, "Analisi II", LocalDate.of(2018, 1, 5)));
		libr.add(new Voto(25, "Fisica I", LocalDate.of(2017, 6, 10)));
		libr.add(new Voto(28, "Fisica II", LocalDate.of(2018, 9, 3)));
		libr.add(new Voto(18, "Geometria", LocalDate.of(2017, 9, 1)));
		libr.add(new Voto(20, "Economia", LocalDate.of(2018, 1, 27)));
		libr.add(new Voto(25, "Ricerca operstiva", LocalDate.of(2018, 6, 5)));
		libr.add(new Voto(24, "Complementi di economia", LocalDate.of(2018, 2, 15)));
		libr.add(new Voto(25, "Logistica", LocalDate.of(2019, 2, 1)));
		libr.add(new Voto(27, "Programmazione ad oggetti", LocalDate.of(2019, 1, 25)));

		System.out.println("\n**Cercare esami con il voto=25**");
		List<Voto> venticinque=libr.cercaVoti(25);
		System.out.println(venticinque);
		
		System.out.println("\n**Cercare erami**");
		Voto a1=libr.cercaEsame("Analisi I");
		Voto a3=libr.cercaEsame("Analisi III");
		System.out.println(a1);
		System.out.println(a3);

		System.out.println("\n**Voti esistenti e in conflitto**");
		Voto votoGiusto=new Voto(18, "Geometria", LocalDate.now());		//now mi da la data di oggi
		Voto votoSbagliato=new Voto(28, "Geometria", LocalDate.now());	
		Voto mancante=new Voto(30, "Merendine", LocalDate.now());
		System.out.format("Il voto %s � %s\n", votoGiusto.toString(), libr.esisteGiaVoto(votoGiusto));
		System.out.format("Il voto %s � %s\n",votoSbagliato.toString(), libr.esisteGiaVoto(votoSbagliato));
		System.out.format("Il voto %s � %s\n",mancante.toString(), libr.esisteGiaVoto(mancante));
		System.out.format("Il voto %s � %s\n", votoGiusto.toString(), libr.votoInConflitto(votoGiusto));
		System.out.format("Il voto %s � %s\n",votoSbagliato.toString(), libr.votoInConflitto(votoSbagliato));
		System.out.format("Il voto %s � %s\n",mancante.toString(), libr.votoInConflitto(mancante));

		
		System.out.println("\n**Lista con aggiunta di voti giusti, sbagliati, mancanti**");
		libr.add(votoGiusto);
		libr.add(votoSbagliato);
		libr.add(mancante);
		System.out.println(libr.toString());
		
		
		System.out.println("\n**Migliorare libretto**");
		Libretto migliore=libr.librettoMigliorato();
		System.out.println(libr.toString());
		System.out.println(migliore.toString());

		
		System.out.println("\n**Cancellati voti scarsi**");
		migliore.cancellaVotiScarsi();
		System.out.println(migliore.toString());

		
		
		
	}

}
