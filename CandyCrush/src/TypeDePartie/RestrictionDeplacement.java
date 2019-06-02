package TypeDePartie;

import game.Joueur;

public class RestrictionDeplacement implements Restriction {
	private int deplacementLimite;
	private Joueur joueur;
	
	public RestrictionDeplacement(int deplacementLimite,int tempsLimite,Joueur joueur)
	{
		this.deplacementLimite=deplacementLimite;
		this.joueur=joueur;
	}
	

	public boolean restrictionsAtteinte()
	{
		if(joueur.getNbDeplacement()>=deplacementLimite)
		{
			return true;
		}
		return false;
	}
	
	public boolean estRestrictionDeplacement()
	{
		return true;
	}


	@Override
	public boolean estRestrictionsTempsDeplacement() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean estRestrictionTemps() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
