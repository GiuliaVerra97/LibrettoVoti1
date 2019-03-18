package it.polito.tdp.libretto;

import java.time.LocalDate;

public class Voto {

	
	private int punti;
	private String corso;
	
	/*
	private Date data;	
	private Calendar data;
	unico modo per gestire la data fino a java 6
	*/
	
	private LocalDate data;		//nella libreria java.time da java 7

	public Voto(int voto, String corso, LocalDate data) {
		super();
		this.punti = voto;
		this.corso = corso;
		this.data = data;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int voto) {
		this.punti = voto;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.format("Voto [punti=%s, corso=%s, data=%s]", punti, corso, data);
	}

	

	
	
	
	
	
	
}
