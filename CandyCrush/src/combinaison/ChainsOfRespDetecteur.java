package combinaison;

import game.Joueur;
import terrain.Plateau;

/*
 * Classe qui fait la chaine de responsabilite qui nous sert a detecter et ensuite pouvoir
 * traiter les differentes combinaisions possible
 * @author akkus
 */
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
    
	/*
	 * La methode Detecteur va nous servir a detecter les differentes combinaisons 
	 * que l'on peut trouuver dans le plateau
	 * @param ligne	designe le numero de la ligne dans le plateau
	 * @param colonne designe le numero de la colonne dans le plateau
	 * @param p	designe le plateau dans lequel la detection va etre faite
	 * @return vrai si l'on trouve une detection
	 */
    public boolean detecteur(int ligne, int colonne, Plateau p)
    {
    	// Définition de l'enchainement des maillons
    	quatreH.setSuivant(quatreV);
        quatreV.setSuivant(troisH);
        troisH.setSuivant(troisV);
        return quatreH.testDetection(ligne,colonne, p);
    }
    
    /*
	 * La methode Tratement va nous servir a traiter les differentes combinaisons 
	 * que l'on peut trouuver dans le plateau
	 * @param ligne	designe le numero de la ligne dans le plateau
	 * @param colonne designe le numero de la colonne dans le plateau
	 * @param p	designe le plateau dans lequel la detection va etre faite
	 * @param joueur designe le joueur et nous permet d'ajouter les points suivant la combinaison trouver 
	 * @return vrai si le traitement peut se faire
	 */
    public boolean traitement(int ligne, int colonne, Plateau p,Joueur joueur)
    {
    	// Définition de l'enchainement des maillons
    	quatreH.setSuivant(quatreV);
        quatreV.setSuivant(troisH);
        troisH.setSuivant(troisV);
        return quatreH.TraitementCombi(ligne,colonne, p,joueur);
    }
    
}
