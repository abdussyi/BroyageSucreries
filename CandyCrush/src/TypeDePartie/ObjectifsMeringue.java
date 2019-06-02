package TypeDePartie;

import terrain.Plateau;

public class ObjectifsMeringue implements Objectif{
	
	
	
	private Plateau plateau;
	
	public ObjectifsMeringue(Plateau plateau)
	{
		this.plateau=plateau;
	}
	
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
