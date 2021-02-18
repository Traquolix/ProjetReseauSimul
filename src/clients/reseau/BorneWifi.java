package clients.reseau;

public class BorneWifi extends EquipementReseau {

    String IP;

    public BorneWifi(String nom, String IP) {
        super(nom);
        this.IP = IP;
        super.maxsize = Integer.MAX_VALUE;
    }
}
