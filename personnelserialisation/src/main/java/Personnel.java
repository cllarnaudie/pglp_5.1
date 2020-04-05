package main.java;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;


public final class Personnel implements Composant, Serializable{
	
    private final String nom;
	private final String prenom; 
	private final   String fonction; 
	private final    LocalDate dateNaissance; 
	private final    ArrayList <String> numeroTelephone; 
	
	private static final long serialVersionUID = 150;
	
	
	public  static  class Builder  {
	    private   String  nom;
		private    String prenom; 
		private   String fonction; 
		private    LocalDate dateNaissance; 
		private    ArrayList <String> numeroTelephone; 
	
	public Builder (String nom, String prenom){

		this.nom = nom; 
        this.prenom = prenom; 
		this.fonction = "inconnu";
		this.dateNaissance = LocalDate.of(1, Month.JANUARY, 1); 
		this.numeroTelephone = new ArrayList<String> (); 
		
	}
	
	public Builder fonction (String fonction) {
		this.fonction = fonction; 
		return this; 
	}
	
	public Builder dateNaissance (int annee, Month mois, int jour) {
		try {
					
		dateNaissance = LocalDate.of(annee, mois, jour); 
		}catch (DateTimeException  e) {
			System.out.println(" date de naissance incorrecte - initilialisee à la valeur par defaut \n");
			this.dateNaissance = LocalDate.of(1, Month.JANUARY, 1); 
		}
		return this; 
		
	}
	
	
	
	public Builder numeroTelephone(String numero) {
		numeroTelephone.add(numero); 
		return this; 
		}
	
	public Personnel build () {
		return new  Personnel (this); 
	}
		
}
	public Personnel (Builder builder) {
		nom = builder.nom; 
		prenom = builder.prenom; 
		fonction = builder.fonction; 
		dateNaissance = builder.dateNaissance; 
		numeroTelephone = builder.numeroTelephone; 
		
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getFonction() {
		return fonction;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public ArrayList<String> getNumeroTelephone() {
		return numeroTelephone;
	}
	
	
	
	/**
	 * Serialisation 
	 * @param personne
	 * @param fichier
	 */
	public void writePersonnel (String nomFichier) {
		
		ObjectOutputStream oos=null ;
		try {
		File fichier =  new File(nomFichier) ;
		FileOutputStream file = new FileOutputStream(fichier);
		
		 // ouverture d'un flux sur un fichier
		/*
		oos =  new ObjectOutputStream(
				//new BufferedOutputStream(
					new FileOutputStream(fichier)) ;*/
		
		// ouverture d'un flux sur un fichier
		oos =  new ObjectOutputStream(
				//new BufferedOutputStream(
						file) ;
				
		 // sérialization de l'objet
		oos.writeObject(this) ;
		
		oos.close();
		file.close();
		
		}
		catch (IOException ex) {
			System.out.println(ex);
		}
		
	}
	
	
	/**
	 * Deserialisation
	 * @param personne
	 * @param fichier
	 */
	public Personnel readPersonnel ( String  nomFichier) {
		Personnel m = null;
		try {
		File fichier =  new File(nomFichier) ;
		FileInputStream file = new FileInputStream(fichier);
		
		// ouverture d'un flux sur un fichier
		/*ObjectInputStream ois =  new ObjectInputStream(
				new BufferedInputStream(
				new FileInputStream(fichier)) );*/
		// ouverture d'un flux sur un fichier
				ObjectInputStream ois =  new ObjectInputStream(
						new BufferedInputStream(
						file));
				
		 // désérialization de l'objet
		m = (Personnel)ois.readObject() ;
		System.out.println(m) ;
		
		ois.close();
		file.close();
		
		}
		catch (IOException ex) {
			System.out.println(ex);
		}
		catch (ClassNotFoundException ey) {
			System.out.println(ey);
		}
	
		
		return m ;
	}
	
	
	
	 /**
	    * 
	    * @param oos
	    * @throws IOException
	    */
	    
	
	    private  void writeObject(ObjectOutputStream oos)
	    throws IOException {

	       // écriture  
	      oos.writeUTF(nom) ;
	      oos.writeUTF(prenom) ;
	      oos.writeUTF(fonction) ;
	      oos.writeUTF(dateNaissance.toString()) ;
	      
	      for (int i=0 ; i < numeroTelephone.size(); i++) {
	    	  oos.writeUTF(numeroTelephone.get(i));
	      }
	       
	   }
	
}

