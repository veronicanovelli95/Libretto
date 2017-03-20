package it.polito.tdp.model;

import java.time.LocalDate;

/*
 oggetto semplice che contiene i dati relativi ad un singolo esame
 pojo - plain old java object

 dati privati(proprietà)
 costruttore
 metodi getter e setter
 metodi di servizio(toString, compareTo, equals, hashCode
 
 */
public class Esame {
 private String codice;
 private String titolo;
 private String docente;
 //private Docente docente;
 private boolean superato;
 private int voto;
 private LocalDate dataSuperamento;
 
 public Esame(String codice, String titolo, String docente) {
	
	this.codice = codice;
	this.titolo = titolo;
	this.docente = docente;
	this.superato =false;
	this.voto = 0;
    this.dataSuperamento=null;
 }

public String getCodice() {
	return codice;
}

public void setCodice(String codice) {
	this.codice = codice;
}

public String getTitolo() {
	return titolo;
}

public void setTitolo(String titolo) {
	this.titolo = titolo;
}

public String getDocente() {
	return docente;
}

public void setDocente(String docente) {
	this.docente = docente;
}

public boolean isSuperato() {
	return superato;
}

private void setSuperato(boolean superato) {
	this.superato = superato;
}
//restituisce solo se esame è stato superato altrimenti eccezione
public int getVoto() {
	if(this.superato)
	return voto;
	else
		throw new IllegalStateException("Esame "+ this.codice+ " non ancora sparato");
}

private void setVoto(int voto) {
	this.voto = voto;
}

public LocalDate getDataSuperamento() {
	if(this.superato)
		return dataSuperamento;
		else
			throw new IllegalStateException("Esame "+ this.codice+ " non ancora sparato");
}

private void setDataSuperamento(LocalDate dataSuperamento) {
	this.dataSuperamento = dataSuperamento;
}

@Override
public String toString() {
	return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", superato=" + superato
			+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((codice == null) ? 0 : codice.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Esame other = (Esame) obj;
	if (codice == null) {
		if (other.codice != null)
			return false;
	} else if (!codice.equals(other.codice))
		return false;
	return true;
}


public void supera(int voto, LocalDate data){
	if(! this.superato){
		this.superato = true;
		this.dataSuperamento= data;
		this.voto = voto;
	}
	else{
//		ho chiamato un metodo il cui stato interno non permetteva che fosse chiamato
		throw new IllegalStateException("Esame "+ this.codice+ " già sparato");
	}
}
 
}
