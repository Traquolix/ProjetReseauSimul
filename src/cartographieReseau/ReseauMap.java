package cartographieReseau;

import clients.Client;
import clients.reseau.EquipementReseau;
import connexions.Cable;

import java.util.ArrayList;

public class ReseauMap {
      ArrayList<Cable> map = new ArrayList<>();

      public ReseauMap(Cable... cables) {
        addCable(cables);
      }

      public ReseauMap addCable(Cable... cables){
              for (Cable c:cables) {
                  if (getLegitimacyOfAddition(c)) {
                      this.map.add(c);
                  } else {
                      System.out.println("+++++++++++++++++++++\nLe cable suivant n'a pas pu être ajouté pour dépassage de capacité sur l'équipement réseau (" + getEquipementReseau(c) + ")" + " : " + c.toString().replace("_", "") + "\n----------------------\n");
                  }
              }
              return this;
      }

      public int returnReseauActualSize(EquipementReseau equipementReseau) {
          int counter = 0;
          for (Cable c:map) {
              ArrayList<Client> tuple = c.getEnds();
                if (tuple.contains(equipementReseau)) {
                    counter++;
                }
          }
          return counter;

      }

      private boolean getLegitimacyOfAddition(Cable c) {

        EquipementReseau equipementReseau = getEquipementReseau(c);
        if (equipementReseau == null) {
            return true;
        } else if (1 + returnReseauActualSize(equipementReseau) > equipementReseau.getMaxsize()) {
            return false;
        } else {
            return true;
        }
      }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (Cable cable:map) {
            counter++;
            sb.append("Cable " + counter + " : " + cable.toString() + "\n");
        }
        return sb.toString();
    }

    private EquipementReseau getEquipementReseau(Cable c) {
        ArrayList<Client> ends = c.getEnds();
        EquipementReseau equipementReseau;

        if (ends.get(0) instanceof EquipementReseau) {
            equipementReseau = (EquipementReseau) ends.get(0);
        } else if (ends.get(1) instanceof EquipementReseau){
            equipementReseau = (EquipementReseau) ends.get(1);
        } else {
            return null;
        }

        return equipementReseau;
    }


 // -------------------------------------------------------------- Partie Récursion pour trouver le PATH, TODO


    private Client getOppositeClient(Cable c, Client client) {
        ArrayList<Client> ends = c.getEnds();

        if (ends.get(0).equals(client)) {
            return ends.get(1);
        } else {
            return ends.get(0);
        }
    }


    public ArrayList<Cable> getAllConnected(Client client) {
          ArrayList<Cable> connexions = new ArrayList<Cable>();
        for (Cable c:this.map) {
            if (c.getEnds().contains(client)) {
                connexions.add(c);
            }
        }
        return connexions;
    }

    public ArrayList<Cable> getPath(Client start, Client finish) {
          // Start of the web
        ArrayList<Cable> forbiddenPath = new ArrayList<>();
        ArrayList<Cable> veryStart = getAllConnected(start);
        System.out.println(veryStart);
        ArrayList<Cable> webStart = new ArrayList<>();
          for (Cable c:veryStart) {
            Client oppositeClient = getOppositeClient(c, start);
            System.out.println("Opposite client = " + oppositeClient);
            webStart.add(c);
            if (oppositeClient.equals(finish)) {
                return webStart;
            } else {
                forbiddenPath.add(c);
                webStart = getPath(oppositeClient, finish);
            }
          }
          return webStart;
    }
    /*
    private ArrayList<Cable> getAllOppositeSidesOfConnectedCables(ArrayList<Cable> cableList, Client client) {
          ArrayList<Cable> nextLevelCable = new ArrayList<Cable>();
          for(Cable c: cableList) {

          }
    }
    */

}
