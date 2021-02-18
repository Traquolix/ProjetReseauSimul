package clients.reseau;

public class Routeur extends EquipementReseau {

	String IP;
	String Gate;

	public Routeur(String nom, String IP, String Gate) {
		super(nom);
		this.IP = IP;
		this.Gate = Gate;
		super.maxsize = 2;
	}
}
