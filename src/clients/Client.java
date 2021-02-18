package clients;

import cartographieReseau.ReseauMap;
import clients.reseau.*;


public class Client {
	ReseauMap reseau;
	String nom;
	
	public Client() {
		super ();
	}
	
	public Client(String pNom) {
		this.nom = pNom;
		this.reseau = null;
	}

	public String toString() {
		return this.nom;
	}

}
