package connexions;

import clients.Client;

public class ConnexionWifi extends Connexion {

    public ConnexionWifi(Client a, Client b) {
        super(a, b);
    }

    @Override
    public String toString() {
        return super.printEnds();
    }
}
