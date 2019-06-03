package combinaison;

import bonbon.BonbonSpecial;
import bonbon.Vide;
import exception.CandyException;
import game.Joueur;
import terrain.Case;
import terrain.Plateau;


public class CombinaisonTroisV extends Combinaison {

	//Les eventuels cases de combinaison que nous sauvegardons
	private Case un;
	private Case deux;
	private Case trois;
	private boolean estCombinaison;
	private boolean estCombiRaye;
	
	public CombinaisonTroisV()
	{
		un = null;
		deux = null;
		trois = null;
		setEstCombinaison(false);
	}
	
	public boolean estCombiRaye() {
		return estCombiRaye;
	}


	public void setEstCombiRaye(boolean estCombiRaye) {
		this.estCombiRaye = estCombiRaye;
	}
	

	
	
	public boolean detection(int l, int c, Plateau p) throws CandyException{
		
		//sauvegarde des voisin de la case afin de faciliter la la lisibilité du code

		//les case sont numéroté de -2 à 2
		
		//4, 2, 5, 2
		if((l==4 && c == 2)||(l==5 && c == 2))
		{
			System.out.println("");
		}
		
		
		Case moinsDeux,moinsUn,zero,un,deux;

		//verification Verticale
		if(p.caseEstDansGrille(l-2, c) && !(p.getCaseBonbon(l-2, c).estVide()))
		{
			moinsDeux = p.getGrille()[l-2][c];
		}
		else
		{
			moinsDeux=null;
		}
		if(p.caseEstDansGrille(l-1, c) && !(p.getCaseBonbon(l-1, c).estVide()))
		{
			moinsUn = p.getGrille()[l-1][c];
		}
		else
		{
			moinsUn = null;
		}
		//pas vraiment bseoin de cela
		if(p.caseEstDansGrille(l, c) && !(p.getCaseBonbon(l, c).estVide()))
		{
			zero = p.getGrille()[l][c];
		}
		else
		{
			zero = null;
		}
		if(p.caseEstDansGrille(l+1, c) && !(p.getCaseBonbon(l+1, c).estVide()))
		{
			un = p.getGrille()[l+1][c];
		}
		else
		{
			un = null;
		}
		if(p.caseEstDansGrille(l+2, c) && !(p.getCaseBonbon(l+2, c).estVide()))
		{
			deux = p.getGrille()[l+2][c];
		}
		else
		{
			deux = null;
		}
		
		if(moinsDeux!=null && zero!=null && moinsUn!=null)
		{
			if( moinsDeux.getBonbon().estMemeCouleur(moinsUn.getBonbon())&&moinsUn.getBonbon().estMemeCouleur(zero.getBonbon()))
			{
				setEstCombinaison(true);
				setEstCombiRaye(verifRaye(moinsDeux,moinsUn,zero));
				setUn(moinsDeux);
				setDeux(moinsUn);
				setTrois(zero);
				//il exite une combinaison en -2 -1 et 0
				
			}
		}
		if(moinsUn!=null && un!=null && zero!=null)
		{
			if( moinsUn.getBonbon().estMemeCouleur(zero.getBonbon())&&zero.getBonbon().estMemeCouleur(un.getBonbon()))
			{
				setEstCombinaison(true);
				setEstCombiRaye(verifRaye(un,moinsUn,zero));
				setUn(moinsUn);
				setDeux(zero);
				setTrois(un);
				//il exite une combinaison en  -1 et 0 et 1
			}
		}
		if(zero!=null && deux!=null && un!=null)
		{
			if( zero.getBonbon().estMemeCouleur(un.getBonbon())&&un.getBonbon().estMemeCouleur(deux.getBonbon()))
			{
				setEstCombinaison(true);
				setEstCombiRaye(verifRaye(un,deux,zero));
				setUn(zero);
				setDeux(un);
				setTrois(deux);
				//il exite une combinaison en  0,1 et 2
			}
		
		}
		return estCombinaison();
		
	}
	
	public boolean verifRaye(Case a,Case b, Case c)
	{
		if(a.getBonbon().estSpecial() || b.getBonbon().estSpecial() || c.getBonbon().estSpecial())
		{
			return true;
		}
		else
		{
			return false;
		}
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


	public boolean estCombinaison() {
		return estCombinaison;
	}


	public void setEstCombinaison(boolean estCombinaison) {
		this.estCombinaison = estCombinaison;
	}

	//cette fonction determine comment l'un des bonbon rayé a été généré
	public boolean supprVerticale()
	{
		BonbonSpecial test = (BonbonSpecial) BonbonRaye().getBonbon();
		return test.estObtenuVerticalement();
	}
	
	//cette fonction retourne la case ou le bonbon rayé est situé
	public Case BonbonRaye()
	{
		if(un.getBonbon().estSpecial())
		{
			return un;
		}
		if(deux.getBonbon().estSpecial())
		{
			return deux;
		}
		else
		{
			return trois;
		}
	}


	@Override
	public boolean traitementSpecial(int l, int c, Plateau p) {
		if(estCombinaison()==true && estCombiRaye())
		{
			if(supprVerticale()==true)
			{
				p.supprColonne(BonbonRaye().getColonne());
			}
			else
			{
				p.supprLigne(BonbonRaye().getLigne());
			}
			return true;
		}
		else if(estCombinaison()==true)
		{
			un.setBonbon(new Vide());
			deux.setBonbon(new Vide());
			trois.setBonbon(new Vide());
			return true;
		}
		else
			return false;
	}
	
	@Override
	public int gainPoints() {
		if(estCombiRaye())
		{
			return 120;
		}
		return 30;
	}

}