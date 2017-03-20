package it.polito.tdp.libretto;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.model.Esame;
import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {
    Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCodice;

    @FXML
    private TextField txtTitolo;

    @FXML
    private TextField txtDocente;

    @FXML
    private TextArea txtMessage;

    @FXML
    void handleCerca(ActionEvent event) {
     String codice= txtCodice.getText();
     if(codice.length()<5){
    	 txtMessage.appendText("codice non valido\n");
    	 return;
     }
     
     Esame e = model.trovaEsame(codice);
     if(e==null){
    	 txtMessage.appendText("esame "+codice+" non trovato\n");
    	 txtCodice.clear();
         txtTitolo.clear();
         txtDocente.clear();}
     else{
    	 txtMessage.appendText("esame "+codice+" trovato\n");
         txtCodice.setText(e.getCodice());
         txtTitolo.setText(e.getTitolo());
         txtDocente.setText(e.getDocente());}
    }

    @FXML
    void handleInserisci(ActionEvent event) {
      String codice = txtCodice.getText();
      String titolo  =txtTitolo.getText();
      String docente = txtDocente.getText();
      
      if(codice.length()< 5 || titolo.length()==0 || docente.length()==0){
    	  txtMessage.appendText("dati esami non validi\n");
    	  txtCodice.clear();
          txtTitolo.clear();
          txtDocente.clear();
    	  return;
      }
      
      
      Esame e = new Esame (codice, titolo,docente);
      boolean result =  model.addEsame(e);
      if(result){
    	  txtMessage.appendText("Esame aggiunto correttamente\n");
          txtCodice.clear();
           txtTitolo.clear();
          txtDocente.clear();}
      else{
    	  txtMessage.appendText("Esame non aggiunto (codice duplicato)\n");
          txtCodice.clear();
          txtTitolo.clear();
          txtDocente.clear();}
    }

    @FXML
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'Libretto.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
	}
    
}


