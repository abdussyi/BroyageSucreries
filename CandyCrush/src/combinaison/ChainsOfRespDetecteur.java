package combinaison;

import terrain.Plateau;

public class ChainsOfRespDetecteur {

	Combinaison test ;
    Combinaison quatreV ;
    Combinaison troisH ;
    Combinaison troisV ;
	
	
	public ChainsOfRespDetecteur()
	{
	    test = new CombinaisonQuatreH();
	    quatreV = new CombinaisonQuatreV();
	    troisH = new CombinaisonTroisH();
	    troisV = new CombinaisonTroisV();
	}
    
    public boolean detecteur(int ligne, int colonne, Plateau p)
    {
    	// Définition de l'enchainement des maillons
        test.setSuivant(quatreV);
        quatreV.setSuivant(troisH);
        troisH.setSuivant(troisV);
        return test.testDetection(ligne,colonne, p);
    }
}
