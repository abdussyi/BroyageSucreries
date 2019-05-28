package combinaison;

import bonbon.Couleur;
import exception.CandyException;
import terrain.Case;
import terrain.Plateau;

/**
 * Sous-classe concrète qui définit un maillon de la chaine.
 */
public class CombinaisonQuatreH extends Combinaison {

	//Les eventuels cases de combinaison que nous sauvegardons
	private Case un;
	private Case deux;
	private Case trois;
	private Case quatre;
	private boolean estCombinaison;
	
	public CombinaisonQuatreH()
	{
		un = null;
		deux = null;
		trois = null;
		quatre =null;
	}
	
	
	public void detection(int l, int c, Plateau p) throws CandyException{
		
		//sauvegarde des voisin de la case afin de faciliter la la lisibilité du code

		//les case sont numéroté de -2 à 2
		
		Case moinsTrois,moinsDeux,moinsUn,zero,un,deux,trois;
		
		
		//verification Verticale
		if(p.caseEstDansGrille(l, c-3) && !(p.getCaseBonbon(l, c-3).getCouleur()==Couleur.VIDE))
		{
			moinsTrois = p.getGrille()[l][c-3];
		}
		else
		{
			moinsTrois=null;
		}
		if(p.caseEstDansGrille(l, c-2) && !(p.getCaseBonbon(l, c-2).getCouleur()==Couleur.VIDE))
		{
			moinsDeux = p.getGrille()[l][c-2];
		}
		else
		{
			moinsDeux=null;
		}
		if(p.caseEstDansGrille(l, c-1) && !(p.getCaseBonbon(l, c-1).getCouleur()==Couleur.VIDE))
		{
			moinsUn = p.getGrille()[l][c-1];
		}
		else
		{
			moinsUn = null;
		}
		//pas vraiment bseoin de cela
		if(p.caseEstDansGrille(l, c) && !(p.getCaseBonbon(l, c).getCouleur()==Couleur.VIDE))
		{
			zero = p.getGrille()[l][c];
		}
		else
		{
			zero = null;
		}
		if(p.caseEstDansGrille(l, c+1) && !(p.getCaseBonbon(l, c+1).getCouleur()==Couleur.VIDE))
		{
			un = p.getGrille()[l][c+1];
		}
		else
		{
			un = null;
		}
		if(p.caseEstDansGrille(l, c+2) && !(p.getCaseBonbon(l, c+2).getCouleur()==Couleur.VIDE))
		{
			deux = p.getGrille()[l][c+2];
		}
		else
		{
			deux = null;
		}
		if(p.caseEstDansGrille(l, c+3) && !(p.getCaseBonbon(l, c+3).getCouleur()==Couleur.VIDE))
		{
			trois = p.getGrille()[l][c+3];
		}
		else
		{
			trois=null;
		}
		
		if(moinsTrois!=null && zero!=null)
		{
			if(moinsTrois.getBonbon().estMemeCouleur(moinsDeux.getBonbon()) && moinsDeux.getBonbon().estMemeCouleur(moinsUn.getBonbon()) && moinsUn.getBonbon().estMemeCouleur(zero.getBonbon()))
			{
				setEstCombinaison(true);
				
				setUn(moinsTrois);
				setDeux(moinsDeux);
				setTrois(moinsUn);
				setQuatre(zero);
				//s'il exite une combinaison en -3 -2 -1 et 0
			}
		}
		if(moinsDeux!=null&& un!=null)
		{
			if(moinsDeux.getBonbon().estMemeCouleur(moinsUn.getBonbon()) && moinsUn.getBonbon().estMemeCouleur(zero.getBonbon()) && zero.getBonbon().estMemeCouleur(un.getBonbon()))
			{
				setEstCombinaison(true);
				setUn(moinsDeux);
				setDeux(moinsUn);
				setTrois(zero);
				setQuatre(un);
				//il exite une combinaison en  -2 -1 et 0 et 1
			}
		}
		if(moinsUn!=null && deux!=null)
		{
			if(moinsUn.getBonbon().estMemeCouleur(zero.getBonbon()) && zero.getBonbon().estMemeCouleur(un.getBonbon()) &&  un.getBonbon().estMemeCouleur(deux.getBonbon()))
			{
				setEstCombinaison(true);
				setUn(moinsUn);
				setDeux(zero);
				setTrois(un);
				setQuatre(deux);
				//il exite une combinaison en  -1 0,1 et 2
			}
		
		}
		if(zero!=null && trois!=null)
		{
			if(zero.getBonbon().estMemeCouleur(un.getBonbon()) &&  un.getBonbon().estMemeCouleur(deux.getBonbon()) && deux.getBonbon().estMemeCouleur(trois.getBonbon()))
			{
				setEstCombinaison(true);
				setUn(zero);
				setDeux(un);
				setTrois(deux);
				setQuatre(trois);
				//il exite une combinaison en  0,1,2 et 3
			}
		
		}
		
	}
	
    public Case getQuatre() {
		return quatre;
	}


	public void setQuatre(Case quatre) {
		this.quatre = quatre;
	}


	public Case getUn() {
		return un;
	}


	public void setUn(Case un) {
		this.un = un;
	}


	public Case getDeux() {
		return deux;
	}


	public void setDeux(Case deux) {
		this.deux = deux;
	}


	public Case getTrois() {
		return trois;
	}


	public void setTrois(Case trois) {
		this.trois = trois;
	}


	public boolean EstCombinaison() {
		return estCombinaison;
	}


	public void setEstCombinaison(boolean estCombinaison) {
		this.estCombinaison = estCombinaison;
	}


	@Override
	public boolean traitementSpecial(int l, int c, Plateau p) {
		// TODO Auto-generated method stub
		return false;
	}
}