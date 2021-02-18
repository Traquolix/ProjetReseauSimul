package clients.ordinateurs;

import clients.Client;

public class Ordinateur extends Client {

    String IP;
    String MAC;
    String Gate;

    public Ordinateur(String pIP, String pMAC, String pGate, String pNom) {
        super(pNom);
        IP = pIP;
        MAC = pMAC;
        Gate = pGate;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + (this.getClass().toString().substring(26)) + ")";
    }
}
