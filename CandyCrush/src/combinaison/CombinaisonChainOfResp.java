package combinaison;

public class CombinaisonChainOfResp {

    public static void main(String[] args) {
        // Création des maillons
        Combinaison lMaillonA = new CombinaisonQuatreH();
        Combinaison lMaillonB = new CombinaisonQuatreV();
        Combinaison lMaillonC = new CombinaisonTroisH();
        Combinaison lMaillonD = new CombinaisonTroisV();
        
        
        // Définition de l'enchainement des maillons
        lMaillonA.setSuivant(lMaillonB);
        lMaillonB.setSuivant(lMaillonC);
        
        // Appel de la méthode du premier maillon
        // avec des valeurs différentes
        System.out.println("--> Appel de la méthode avec paramètre '1' : ");
        lMaillonA.operation(1);
        System.out.println("--> Appel de la méthode avec paramètre '2' : ");
        lMaillonA.operation(2);
        System.out.println("--> Appel de la méthode avec paramètre '3' : ");
        lMaillonA.operation(3);
        System.out.println("--> Appel de la méthode avec paramètre '4' : ");
        lMaillonA.operation(4);
        
        // Affichage : 
        // --> Appel de la méthode avec paramètre '1' : 
        // MaillonB : 1 : < 2
        // --> Appel de la méthode avec paramètre '2' : 
        // MaillonA : 2 : pair
        // --> Appel de la méthode avec paramètre '3' : 
        // MaillonC : 3 : > 2
        // --> Appel de la méthode avec paramètre '4' : 
        // MaillonA : 4 : pair
    }
}
