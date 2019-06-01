package terrain;

import bonbon.BonbonOrdinaire;
import bonbon.Contenant;
import bonbon.Couleur;
import combinaison.ChainsOfRespDetecteur;

public class OutilsPlateau{
	
	
	

	
	
	public OutilsPlateau() {
	}

	/*
	public Contenant getAleaContenant()
	{	
		
		//deja, nous allons prendre une couleurs aleatoirement
		
		
		double rand =Math.random();
		
		if(rand<=0.03)
		{
			return new BonbonOrdinaire(Couleur.MERINGUE);
		}
		//0.12125 chacun des bonbon
		else if(rand>0.03 && rand<=0.03)
		{
			
		}
		
	}
	
	
	public void rempliAleaGrille(Plateau p)
	{
		
	}
	
	*/
	
	
	public void traitementPlateauAll(Plateau p)
	{
		//ajouter le remplissage auto apres traitement
		boolean continuerRecherche=true;
		while(continuerRecherche==true)
		{
			continuerRecherche=traitementPlateauAll(0,0,p);
		}
	}
	
	
	
	
	
	// traitement recursif, qui permet de traiter entierement le tableau apres un echange
	// mais en meme permet de savoir s'il y a eu au moins un traitement dans la grille
	// dans le cas ou il y a eu un traitement, la grille doit re-etre explorer sinon pas la peine
	public boolean traitementPlateauAll(int ligne, int colonne,Plateau p)
	{
		if(ligne==9 && colonne==9)
		{
			ChainsOfRespDetecteur chaine = new ChainsOfRespDetecteur();
			if(chaine.detecteur(ligne, colonne, p)==true)
			{
				chaine.traitement(ligne, colonne, p);
				p.decaleVersBas();
				return true;
			}
			else
				return false;
		}
		else
		{
			ChainsOfRespDetecteur test = new ChainsOfRespDetecteur();
			if(test.detecteur(ligne, colonne, p)==true)
			{
				test.traitement(ligne, colonne, p);
				p.decaleVersBas();
				//ici la fonction retourne true et on recommance a verifier a partir du debut de la grille
				if(colonne==9)
				{
					return true;
				}
				else
					return true;
			}
			else
				if(colonne==9)
				{
					//ancienne versions
					//return (false || traitementPlateauAll(ligne+1,1,p));
					return traitementPlateauAll(ligne+1,1,p);
				}
				else
					//ancienne versions
					//return (false || traitementPlateauAll(ligne,colonne+1,p));
					return traitementPlateauAll(ligne,colonne+1,p);
		}
	}

	
}
