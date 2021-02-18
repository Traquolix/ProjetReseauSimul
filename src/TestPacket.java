import cartographieReseau.ReseauMap;
import clients.ordinateurs.OrdiFixe;
import clients.ordinateurs.OrdiPortable;
import clients.reseau.Routeur;
import connexions.Cable;

public class TestPacket {

	public static void main(String[] args) {

		// -------------------------------------------------
		// Ajouter / Modifier / Supprimer des éléments
		OrdiPortable jacques = new OrdiPortable("192.168.1.1", "MAC DE JACQUES", "182.168.1.254","Ordi Portable de Jacques");
		OrdiFixe michelle = new OrdiFixe("192.168.1.2", "MAC DE MICHELLE", "182.168.1.254","Ordi Fixe de Michelle");
		OrdiPortable jean = new OrdiPortable("192.168.1.3", "MAC DE JEAN", "3", "Ordi Portable de Jean");

		Routeur reseau1 = new Routeur("reseau1", "192.168.1.2", "2");

		Cable cable1 = new Cable(michelle, reseau1);
		Cable cable2 = new Cable(jacques, michelle);
		Cable cable3 = new Cable(jean, jacques);

		ReseauMap gigarezo = new ReseauMap(cable1);

		gigarezo.addCable(cable2).addCable(cable3);

		System.out.println(gigarezo.toString());

		// -------------------------------------------------
		// Calculer le nombre de machines actives connectées à un switch / hub / borne wifi
		System.out.println(gigarezo.returnReseauActualSize(reseau1));

		// -------------------------------------------------
		// Déterminer les machines joignables depuis un poste donné (+ nombre)
		System.out.println(gigarezo.getAllConnected(jacques));
		System.out.println(gigarezo.getAllConnected(jacques).size());

		// -------------------------------------------------
		// Calculer le trajet entre une machine A et une machine B
		// System.out.println(gigarezo.getPath(michelle, jacques));
		// C'est un bordel, à supprimer, voir modifier, voir plus tard. Je suis fatigué, dodo.


		// -------------------------------------------------
		// Interface agréable et simple = JavaFX







	}

}
