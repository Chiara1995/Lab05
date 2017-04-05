/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagramma;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalcolaAnagrammi"
    private Button btnCalcolaAnagrammi; // Value injected by FXMLLoader

    @FXML // fx:id="txtAnagrammiCorretti"
    private TextArea txtAnagrammiCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtAnagrammiErrati"
    private TextArea txtAnagrammiErrati; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    public void setModel(Model model) {
		this.model=model;   
    }
    
    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	
    	this.txtAnagrammiCorretti.clear();
    	this.txtAnagrammiErrati.clear();
 
		String parola=txtParola.getText().trim();
		if(parola.matches("[a-zA-Z]*")){
    		model.creaListaLettere(parola);
    		List<Anagramma> soluzione=model.getCheckAnagrammi(model.risolvi());
    		for(Anagramma a : soluzione){
    			if(a.isCorretto()==true)
    				this.txtAnagrammiCorretti.appendText(a.getParola()+"\n");
    			else
    				this.txtAnagrammiErrati.appendText(a.getParola()+"\n");
    		}
    		return;
    	}
    	else{
    		this.txtAnagrammiCorretti.setText("Errore: inserire una parola.\n");
    		return;
    	}

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	this.txtParola.clear();
    	this.txtAnagrammiCorretti.clear();
    	this.txtAnagrammiErrati.clear();
    	return;

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}
