package it.polito.tdp.libretto;

import java.time.LocalDate;

public class TestLibretto {

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

	}

}
