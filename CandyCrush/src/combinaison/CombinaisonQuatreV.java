package combinaison;


import bonbon.BonbonSpecial;
import bonbon.Couleur;
import bonbon.Vide;
import exception.CandyException;
import game.Joueur;
import terrain.Case;
import terrain.Plateau;

/**
 * Sous-classe concrète qui définit un maillon de la chaine.
 * @author karabay
 */
public class CombinaisonQuatreV extends Combinaison {

		//Les eventuels cases de combinaison que nous sauvegardons
		private Case un;
		private Case deux;
		private Case trois;
		private Case quatre;
		private boolean estCombinaison;
		private boolean estCombiRaye;
		
		public CombinaisonQuatreV()
		{
			un = null;
			deux = null;
			trois = null;
			quatre =null;
			setEstCombinaison(false);
		}
		
		/*
		 * cette fonction detecte une eventuelle combinaison et la sauvegarde dans les champs
		 * @param l	designe le numero de la ligne dans le plateau
		 * @param c designe le numero de la colonne dans le plateau
		 * @param p	designe le plateau dans lequel la detection va etre faite
		 * @throws CandyException
		 * @return true si la detection a pu se faire
		 */
		public boolean detection(int l, int c, Plateau p) throws CandyException{
			
			//4, 2, 5, 2
			if((l==4 && c == 2)||(l==5 && c == 2))
			{
				System.out.println("");
			}
			//sauvegarde des voisin de la case afin de faciliter la la lisibilité du code

			//les case sont numéroté de -2 à 2
			
			Case moinsTrois,moinsDeux,moinsUn,zero,un,deux,trois;
			//verification Verticale
			if(p.caseEstDansGrille(l-3, c) && !(p.getCaseBonbon(l-3, c).estVide()))
			{
				moinsTrois = p.getGrille()[l-3][c];
			}
			else
			{
				moinsTrois=null;
			}
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
			if(p.caseEstDansGrille(l+3, c) && !(p.getCaseBonbon(l+3, c).estVide()))
			{
				trois = p.getGrille()[l+3][c];
			}
			else
			{
				trois=null;
			}
			
			if(moinsTrois!=null && zero!=null && moinsDeux!=null && moinsUn!=null)
			{
				if(moinsTrois.getBonbon().estMemeCouleur(moinsDeux.getBonbon()) && moinsDeux.getBonbon().estMemeCouleur(moinsUn.getBonbon()) && moinsUn.getBonbon().estMemeCouleur(zero.getBonbon()))
				{
					setEstCombinaison(true);
					setEstCombiRaye(verifRaye(moinsDeux,moinsUn,zero,moinsTrois));
					setUn(moinsTrois);
					setDeux(moinsDeux);
					setTrois(moinsUn);
					setQuatre(zero);
					//s'il exite une combinaison en -3 -2 -1 et 0
				}
			}
			if(moinsDeux!=null && un!=null && moinsUn!=null && zero!=null)
			{
				if(moinsDeux.getBonbon().estMemeCouleur(moinsUn.getBonbon()) && moinsUn.getBonbon().estMemeCouleur(zero.getBonbon()) && zero.getBonbon().estMemeCouleur(un.getBonbon()))
				{
					setEstCombinaison(true);
					setEstCombiRaye(verifRaye(moinsDeux,moinsUn,zero,un));
					setUn(moinsDeux);
					setDeux(moinsUn);
					setTrois(zero);
					setQuatre(un);
					//il exite une combinaison en  -2 -1 et 0 et 1
				}
			}
			if(moinsUn!=null && deux!=null && un!=null && zero!=null)
			{
				if(moinsUn.getBonbon().estMemeCouleur(zero.getBonbon()) && zero.getBonbon().estMemeCouleur(un.getBonbon()) &&  un.getBonbon().estMemeCouleur(deux.getBonbon()))
				{
					setEstCombinaison(true);
					setEstCombiRaye(verifRaye(deux,moinsUn,zero,un));
					setUn(moinsUn);
					setDeux(zero);
					setTrois(un);
					setQuatre(deux);
					//il exite une combinaison en  -1 0,1 et 2
				}
			
			}
			if(zero!=null && trois!=null && deux!=null && un!=null)
			{
				if(zero.getBonbon().estMemeCouleur(un.getBonbon()) &&  un.getBonbon().estMemeCouleur(deux.getBonbon()) && deux.getBonbon().estMemeCouleur(trois.getBonbon()))
				{
					setEstCombinaison(true);
					setEstCombiRaye(verifRaye(deux,trois,zero,un));
					setUn(zero);
					setDeux(un);
					setTrois(deux);
					setQuatre(trois);
					//il exite une combinaison en  0,1,2 et 3
				}
			
			}
			return estCombinaison();
			
		}
		
		/*
		 * verifie si dans la combinaison se trouve un bonbon special
		 * @param a designe le premier bonbon
		 * @param b designe le deuxieme bonbon
		 * @param c designe le troisieme bonbon
		 * @param d designe le quatrieme bonbon
		 * return true si il existe un bonbon raye dans la combinaison
		 */
		public boolean verifRaye(Case a,Case b, Case c, Case d)
		{
			if(a.getBonbon().estSpecial() || b.getBonbon().estSpecial() || c.getBonbon().estSpecial() || d.getBonbon().estSpecial())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public boolean estCombiRaye() {
			return estCombiRaye;
		}

		public void setEstCombiRaye(boolean estCombiRaye) {
			this.estCombiRaye = estCombiRaye;
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


		public boolean estCombinaison() {
			return estCombinaison;
		}


		public void setEstCombinaison(boolean estCombinaison) {
			this.estCombinaison = estCombinaison;
		}
		
		/*
		 * cette fonction determine comment l'un des bonbon rayé a été généré
		 * @return ture si le bonbon raye est genere
		 */
		public boolean supprVerticale()
		{
			BonbonSpecial test = (BonbonSpecial) BonbonRaye().getBonbon();
			return test.estObtenuVerticalement();
		}
		
		/*
		 * cette fonction retourne la case ou le bonbon rayé est situé
		 * @return case la case ou le bonbon raye va etre situe
		 */
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
			if(trois.getBonbon().estSpecial())
			{
				return trois;
			}
			else
			{
				return quatre;
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
				Couleur save = un.getBonbon().getCouleur();
				un.setBonbon(new Vide());
				deux.setBonbon(new Vide());
				trois.setBonbon(new Vide());
				quatre.setBonbon(new Vide());
				BonbonSpecial raye = new BonbonSpecial(save);
				raye.setObtenuVerticalement(true);
				quatre.setBonbon(raye);
				return true;
			}
			else
				return false;
		}
		
		/*
		 * affiche le gain de point suivant la combinaison trouve
		 */
		@Override
		public int gainPoints() {
			if(estCombiRaye())
			{
				return 200;
			}
			return 60;
		}
}