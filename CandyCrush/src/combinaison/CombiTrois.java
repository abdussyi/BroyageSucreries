package combinaison;

import bonbon.Couleur;
import terrain.Case;
import terrain.Plateau;

public class CombiTrois {
		
		
		private boolean estDetectable;

		public boolean isestDetectable() {
			return estDetectable;
		}

		public void setEstDetectable(boolean estDetectable) {
			this.estDetectable= estDetectable;
		}
		
		public void dedectionTroisMemeCouleur(Plateau p,int l, int c)
		{
			//sauvegarde des voisin de la case afin de faciliter la la lisibilité du code
			
			//les case sont numéroté de -2 à 2
			
			Case moinsDeux,moinsUn,zero,un,deux;
			
			
			//verification horizontale
			if(p.caseEstDansGrille(l, c-2) && !(p.getGrille()[l][c-2].getBonbon().getCouleur()==Couleur.VIDE))
			{

				moinsDeux = p.getGrille()[l][c-2];

			}
			else
			{
				moinsDeux=null;
			}
			if(p.caseEstDansGrille(l, c-1) && !(p.getGrille()[l][c-1].getBonbon().getCouleur()==Couleur.VIDE))
			{
				moinsUn = p.getGrille()[l][c-1];
			}
			else
			{
				moinsUn = null;
			}
			if(p.caseEstDansGrille(l, c) && !(p.getGrille()[l][c].getBonbon().getCouleur()==Couleur.VIDE))
			{
				zero = p.getGrille()[l][c];
			}
			else
			{
				zero = null;
			}
			if(p.caseEstDansGrille(l, c+1) && !(p.getGrille()[l][c+1].getBonbon().getCouleur()==Couleur.VIDE))
			{
				un = p.getGrille()[l][c+1];
			}
			else
			{
				un = null;
			}
			if(p.caseEstDansGrille(l, c+2) && !(p.getGrille()[l][c+2].getBonbon().getCouleur()==Couleur.VIDE))
			{
				deux = p.getGrille()[l][c+2];
			}
			else
			{
				deux = null;
			}
			
			if(moinsDeux!=null)
			{
				if( moinsDeux.getBonbon().estMemeCouleur(moinsUn.getBonbon())&&moinsUn.getBonbon().estMemeCouleur(zero.getBonbon()))
				{
					//il exite une combinaison en -2 -1 et 0
				}
			}
			else if(moinsUn!=null&&un!=null)
			{
				if( moinsUn.getBonbon().estMemeCouleur(zero.getBonbon())&&zero.getBonbon().estMemeCouleur(un.getBonbon()))
				{
					//il exite une combinaison en  -1 et 0 et 1
				}
			}
			else if(un!=null&&deux!=null)
			{
				if( zero.getBonbon().estMemeCouleur(un.getBonbon())&&un.getBonbon().estMemeCouleur(deux.getBonbon()))
				{
					//il exite une combinaison en  0,1 et 2
				}
			
			}
			
			//verification Verticale
			if(p.caseEstDansGrille(l-2, c))
			{
				moinsDeux = p.getGrille()[l-2][c];
			}
			else
			{
				moinsDeux=null;
			}
			if(p.caseEstDansGrille(l-1, c))
			{
				moinsUn = p.getGrille()[l-1][c];
			}
			else
			{
				moinsUn = null;
			}
			//pas vraiment bseoin de cela
			if(p.caseEstDansGrille(l, c))
			{
				zero = p.getGrille()[l][c];
			}
			else
			{
				zero = null;
			}
			if(p.caseEstDansGrille(l+1, c))
			{
				un = p.getGrille()[l+1][c];
			}
			else
			{
				un = null;
			}
			if(p.caseEstDansGrille(l+2, c))
			{
				deux = p.getGrille()[l+2][c];
			}
			else
			{
				deux = null;
			}
			
			if(moinsDeux!=null)
			{
				if( moinsDeux.getBonbon().estMemeCouleur(moinsUn.getBonbon())&&moinsUn.getBonbon().estMemeCouleur(zero.getBonbon()))
				{
					//il exite une combinaison en -2 -1 et 0
				}
			}
			else if(moinsUn!=null&&un!=null)
			{
				if( moinsUn.getBonbon().estMemeCouleur(zero.getBonbon())&&zero.getBonbon().estMemeCouleur(un.getBonbon()))
				{
					//il exite une combinaison en  -1 et 0 et 1
				}
			}
			else if(un!=null&&deux!=null)
			{
				if( zero.getBonbon().estMemeCouleur(un.getBonbon())&&un.getBonbon().estMemeCouleur(deux.getBonbon()))
				{
					//il exite une combinaison en  0,1 et 2
				}
			
			}
		}
		
}
