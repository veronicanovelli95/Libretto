package it.polito.tdp.model;

import java.time.LocalDate;

public class TestEsame {

	public static void main(String[] args) {
		Esame tdp = new Esame("O3FYZ", "TECNICHE DI PROGRAMMAZIONE", "Fulvio Corno");
		System.out.println(tdp);

	
		Esame ami = new Esame("01QZP", "Ambient Intelligence", "Fulvio Corno");
		System.out.println(ami);
		
		System.out.println(ami.equals(tdp));
		tdp.supera(30, LocalDate.now());
		tdp.supera(18, LocalDate.now());
	}

}
