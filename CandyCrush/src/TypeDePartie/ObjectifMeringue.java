package TypeDePartie;

import terrain.Plateau;

/*
 * designe la classe ou le type de partie est l'objectid de faire disparaitre toutes les meringues
 * @author akkus et karabay
 */
public class ObjectifMeringue implements Objectif{
	
	
	
	private Plateau plateau;
	
	public ObjectifMeringue(Plateau plateau)
	{
		this.plateau=plateau;
	}
	
	/*
	 * verifie si l'objectif des meringues est atteint
	 * @return true si il n'y a plus de meringue sur le plateau
	 */
	public boolean objectifAtteint()
	{
		int taille=plateau.getTaille();
		for(int ligne=0; ligne<taille;ligne++)
		{
			for(int colonne=0; colonne<taille;colonne++)
			{
				if(plateau.getGrille()[ligne][colonne].getBonbon().estMeringue())
				{
					return false;
				}
			}	
		}
		return true;
	}
	
	public boolean estObjectifMeringue()
	{
		return true;
	}

	@Override
	public boolean estObjectifScore() {
		// TODO Auto-generated method stub
		return false;
	}
}
