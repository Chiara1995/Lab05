package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	private List<String> anagrammi;
	private List<Anagramma> anagrammiControllati=new ArrayList<Anagramma>();
	private Character caratteri[];
	
	public List<Anagramma> getCheckAnagrammi(List<String> anagrammi){
		anagrammiControllati.clear();
		AnagrammaDAO adao=new AnagrammaDAO();
		for(int i=0; i<anagrammi.size(); i++){
			Anagramma a=new Anagramma(anagrammi.get(i));
			adao.getCheck(a);
			anagrammiControllati.add(a);
		}
		return anagrammiControllati;
		
	}
	
	public List<String> risolvi(){
		String parziale="";
		anagrammi=new ArrayList<String>();
		scegli(parziale, 0);
		return anagrammi;

	}
	
	public void creaListaLettere(String s){
		caratteri=new Character[s.length()];
		for(int i=0; i<s.length(); i++){
			caratteri[i]=s.charAt(i);
		}
	}
	
	/**
	 * Restituisce il numero di occorrenze del carattere nell'array
	 * @param caratteri
	 * @param c
	 * @return
	 */
	private int numeroLetteraLista(Character [] caratteri, Character c){
		int numLettere=0;
		for(int i=0; i<caratteri.length; i++){
			if(caratteri[i]==c){
				numLettere++;
			}
		}
		return numLettere;
	}
	
	/**
	 * Restituisce il numero di occorrenze del carattere nella stringa
	 * @param stringa
	 * @param c
	 * @return
	 */
	private int numeroLetteraStringa(String stringa, Character c){
		int numLettere=0;
		for(int i=0; i<stringa.length(); i++){
			if(stringa.charAt(i)==c){
				numLettere++;
			}
		}
		return numLettere;
	}
	
	private void scegli(String parziale, int livello){
		//Condizione di terminazione
		if(parziale.length()==caratteri.length){
			if(!anagrammi.contains(parziale))
				anagrammi.add(parziale);
			return;
		}
		//Generazione di una nuova soluzione
		for(Character c : caratteri){
			//Filtro sulla chiamata ricorsiva
			if(numeroLetteraStringa(parziale, c)<numeroLetteraLista(caratteri,c)){
				parziale+=c;
				scegli(parziale, livello+1);
				//Backtracking
				parziale=parziale.substring(0, parziale.length()-1);
			}
		}
	}
	
}
