package terrain;

import bonbon.BonbonOrdinaire;
import bonbon.Contenant;
import bonbon.Couleur;
import combinaison.ChainsOfRespDetecteur;
import game.Joueur;

/*
 * outils permettant de traiter le plateau
 * @author akkus
 */
public class OutilsPlateau{
	
	
	

	
	
	public OutilsPlateau() {
	}

	
	
	
	public Couleur getAleaCouleur()
	{
		double randCouleur = Math.random();
		if(randCouleur<=0.25)
		{
			return Couleur.BLEU;
		}
		else if(randCouleur>0.25 && randCouleur<=0.5)
		{
			return Couleur.JAUNE;
		}
		else if(randCouleur>0.5 && randCouleur<=0.75)
		{
			return Couleur.VERT;
		}
		else
		{
			return Couleur.VIOLET;
		}
	}
	
	public Contenant getAleaContenant()
	{	
		
		//deja, nous allons prendre une couleurs aleatoirement
		
	
		//double randBonbonType = Math.random();
		/*
		if(randBonbonType<=0.03)
		{
			return new Meringue();
		}
		else //if(randBonbonType>0.03 && randBonbonType<=0.75)
		{
			return new BonbonOrdinaire(getAleaCouleur());
		}
		//else
			//return new BonbonSpecial(getAleaCouleur());
		*/
			return new BonbonOrdinaire(getAleaCouleur());
		
	}
	
	/*
	 * rempli la grille aleatoirement 
	 * @param p le plateau dans lequel la grille sera rempli
	 */
	public void rempliAleaGrille(Plateau p)
	{
		int taille = p.getTaille();
		for(int ligne = 0;ligne<taille;ligne++)
		{
			for(int colonne = 0;colonne<taille;colonne++)
			{
				if(p.getGrille()[ligne][colonne].getBonbon().estVide()==true)
				{
					p.getGrille()[ligne][colonne].setBonbon(getAleaContenant());
				}
			}
		}
	}
	
	
	/*
	 * cherche les combinaisons apres la premiere combinaison trouver et le remplissement 
	 * aleatoire de la grille
	 * @param p le plateau dans lequel nous jouons 
	 * @param joueur classe du joueur
	 */
	public void traitementPlateauAll(Plateau p,Joueur joueur)
	{
		//ajouter le remplissage auto apres traitement
		boolean continuerRecherche=true;
		while(continuerRecherche==true)
		{
			continuerRecherche=traitementPlateau(0,0,p,joueur);
			rempliAleaGrille(p);
			continuerRecherche=traitementPlateau(0,0,p,joueur);
		}
	}
	
	
	
	
	
	/* traitement recursif, qui permet de traiter entierement le tableau apres un echange
	* mais en meme permet de savoir s'il y a eu au moins un traitement dans la grille
	* dans le cas ou il y a eu un traitement, la grille doit re-etre explorer sinon pas la peine
	* en somme cette fonction parcours le tableau et effectue un traitement s'il y en a un
	* @param l	designe le numero de la ligne dans le plateau
	* @param c designe le numero de la colonne dans le plateau
	* @param p	designe le plateau dans lequel la detection va etre faite
	* @param joueur repris de la classe joueur
	*/
	public boolean traitementPlateau(int ligne, int colonne,Plateau p,Joueur joueur)
	{
		if(ligne==9 && colonne==9)
		{
			ChainsOfRespDetecteur chaine = new ChainsOfRespDetecteur();
			if(chaine.detecteur(ligne, colonne, p)==true)
			{
				chaine.traitement(ligne, colonne, p,joueur);
				p.chute();
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
				test.traitement(ligne, colonne, p,joueur);
				p.chute();
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
					return traitementPlateau(ligne+1,1,p,joueur);
				}
				else
					//ancienne versions
					//return (false || traitementPlateauAll(ligne,colonne+1,p));
					return traitementPlateau(ligne,colonne+1,p,joueur);
		}
	}

	
}
