package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private List<Esame> esami;
	
	public Model(){
		this.esami= new ArrayList<Esame>();
	}
	public boolean addEsame(Esame s){
		if(!esami.contains(s)){
		esami.add(s);
		return true;}
		else
		return false;
			
	}
	
	public Esame trovaEsame(String codice){
		int pos = this.esami.indexOf(new Esame(codice,null,null));
		if(pos==-1)
			return null;
		else
			return esami.get(pos);
	}
	
}
