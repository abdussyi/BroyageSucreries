package combinaison;

import exception.CandyException;
import terrain.Plateau;

/**
 * Définit l'interface d'un maillon de la chaine.
 */
public abstract class Combinaison {

    private Combinaison suivant;
    
    /**
     * Fixe le maillon suivant dans la chaine
     * @param pSuivant
     */
    public void setSuivant(Combinaison pSuivant) {
        suivant = pSuivant;
    }
    
    /**
     * Appelle le traitement sur le maillon courant
     * Puis demande au maillon suivant d'en faire autant,
     * si le maillon courant n'a pas géré l'opération.
     * @param pNombre
     * @return Si l'opération a été gérée.
     */
    public boolean TraitementCombi(int l, int c,Plateau p) {
    	//On devrait peut etre enlever le if, et traiter le suivant dans tous les cas
        if(traitementSpecial(l,c,p)) {
        	return true;
        };
        
        if(suivant != null) {
            return suivant.TraitementCombi(l,c,p);
        }
        return false;
    }

    
    //La fonction traitementSpecial verifie d'abord s'il y a une combinaison, si oui effectue le traitement
    public abstract boolean traitementSpecial(int l, int c,Plateau p);
    public abstract void detection(int l, int c, Plateau p) throws CandyException;
}