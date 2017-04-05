package it.polito.tdp.anagrammi.model;

import java.util.*;

public class TestModel {
	
	public static void main(String[] args) {
	
		Model model=new Model();
		model.creaListaLettere("ciao");
		List<String> soluzione=model.risolvi();
		System.out.println(soluzione);
		
	}

}
