package combinaison;

import terrain.Plateau;

public class ChainsOfRespDetecteur {

	Combinaison quatreH ;
    Combinaison quatreV ;
    Combinaison troisH ;
    Combinaison troisV ;
	
	
	public ChainsOfRespDetecteur()
	{
		quatreH = new CombinaisonQuatreH();
	    quatreV = new CombinaisonQuatreV();
	    troisH = new CombinaisonTroisH();
	    troisV = new CombinaisonTroisV();
	}
    
    public boolean detecteur(int ligne, int colonne, Plateau p)
    {
    	// Définition de l'enchainement des maillons
    	quatreH.setSuivant(quatreV);
        quatreV.setSuivant(troisH);
        troisH.setSuivant(troisV);
        return quatreH.testDetection(ligne,colonne, p);
    }
    public boolean traitement(int ligne, int colonne, Plateau p)
    {
    	// Définition de l'enchainement des maillons
    	quatreH.setSuivant(quatreV);
        quatreV.setSuivant(troisH);
        troisH.setSuivant(troisV);
        return quatreH.TraitementCombi(ligne,colonne, p);
    }
    
}
