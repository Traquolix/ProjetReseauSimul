package connexions;

import clients.Client;

import java.util.ArrayList;

public abstract class Connexion {

    Client a;
    Client b;

    public Connexion(Client a, Client b) {
        this.a = a;
        this.b = b;
    }

    public String printEnds() {
        return a.toString() + " <===> " + b.toString();
    }

    public ArrayList<Client> getEnds() {
        ArrayList<Client> end = new ArrayList<Client>();
        end.add(a);
        end.add(b);
        return end;
    }

}
