package combinaison;

import exception.CandyException;
import game.Joueur;
import terrain.Plateau;

/**
 * Definit l'interface d'un maillon de la chaine.
 * @author karabay
 */
public abstract class Combinaison {

    private Combinaison suivant;
    
    /**
     * Fixe le maillon suivant dans la chaine
     * @param pSuivant qui nous aide a passer a la prochaine detection
     */
    public void setSuivant(Combinaison pSuivant) {
        suivant = pSuivant;
    }
    
    /**
     * Appelle le traitement sur le maillon courant
     * Puis demande au maillon suivant d'en faire autant,
     * si le maillon courant n'a pas géré l'opération.
     * @param pNombre
     * @param l	designe le numero de la ligne dans le plateau
	 * @param c designe le numero de la colonne dans le plateau
	 * @param p	designe le plateau dans lequel la detection va etre faite
	 * @param joueur designe le joueur et nous permet d'ajouter les points suivant la combinaison trouver  
     * @return Si l'opération a été gérée.
     */
    public boolean TraitementCombi(int l, int c,Plateau p,Joueur joueur) {

    	if(traitementSpecial(l,c,p)) {
    		joueur.addScore(gainPoints());
        	return true;
        };
        
        if(suivant != null) {
            return suivant.TraitementCombi(l,c,p,joueur);
        }
        return false;
    }
    
    /**
     * Appelle la detection sur le maillon courant
     * Puis demande au maillon suivant d'en faire autant,
     * si le maillon courant n'a pas géré l'opération.
     * @param pNombre
     * @param l	designe le numero de la ligne dans le plateau
	 * @param c designe le numero de la colonne dans le plateau
	 * @param p	designe le plateau dans lequel la detection va etre faite
	 * @return true si la detection a pu se faire
	 */
    public boolean testDetection(int l, int c,Plateau p) {
        try {

			if(detection(l,c,p)) {

				return true;
			}
		} catch (CandyException e) {
			e.printStackTrace();
		};
        
        if(suivant != null) {
            return suivant.testDetection(l,c,p);
        }
        return false;
    }
    
    
    
    //La fonction traitementSpecial verifie d'abord s'il y a une combinaison, si oui effectue le traitement
    public abstract boolean traitementSpecial(int l, int c,Plateau p);
    public abstract boolean detection(int l, int c, Plateau p) throws CandyException;
    public abstract int gainPoints();
}