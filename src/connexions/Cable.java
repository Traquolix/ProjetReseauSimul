package connexions;

import clients.Client;

public class Cable extends Connexion {
	
	public Cable(Client a, Client b) {
		super(a, b);
	}

	@Override
	public String toString() {
		return "\n" + super.printEnds() + "\n________";
	}
}
