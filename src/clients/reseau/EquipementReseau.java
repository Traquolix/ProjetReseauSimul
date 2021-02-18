package clients.reseau;

import clients.Client;

public abstract class EquipementReseau extends Client {
	int maxsize;
	
	public EquipementReseau(String nom) {
		super(nom);
	}
	
	public String toString() {
		return super.toString() + " (" + (this.getClass().toString().substring(21)) + ")";
	}


	public int getMaxsize() {
		return maxsize;
	}
}
