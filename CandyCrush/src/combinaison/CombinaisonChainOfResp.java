package combinaison;

public class CombinaisonChainOfResp {

    public static void main(String[] args) {
        // Création des maillons
        Combinaison quatreH = new CombinaisonQuatreH();
        Combinaison quatreV = new CombinaisonQuatreV();
        Combinaison troisH = new CombinaisonTroisH();
        Combinaison troisV = new CombinaisonTroisV();
        
        
        // Définition de l'enchainement des maillons
        quatreH.setSuivant(quatreV);
        quatreV.setSuivant(troisH);
        troisH.setSuivant(troisV);
        
        // Appel de la méthode du premier maillon
        // avec des valeurs différentes
        System.out.println("--> Appel de la méthode avec paramètre '1' : ");
        quatreH.traitementSpecial(1, 0, null);
        System.out.println("--> Appel de la méthode avec paramètre '2' : ");
        quatreH.traitementSpecial(2, 0, null);
        System.out.println("--> Appel de la méthode avec paramètre '3' : ");
        quatreH.traitementSpecial(3, 0, null);
        System.out.println("--> Appel de la méthode avec paramètre '4' : ");
        quatreH.traitementSpecial(4, 0, null);
        

    }
}
