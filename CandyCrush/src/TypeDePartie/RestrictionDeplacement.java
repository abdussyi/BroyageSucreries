package TypeDePartie;

import game.Joueur;

/*
 * la classe qui va implementer une partie avec un nombre de deplacement restreint
 * @author 
 */
public class RestrictionDeplacement implements Restriction {
	private int deplacementLimite;
	private Joueur joueur;
	
	public RestrictionDeplacement(int deplacementLimite,Joueur joueur)
	{
		this.deplacementLimite=deplacementLimite;
		this.joueur=joueur;
	}
	
	/*
	 * verifie si la restriction est atteinte
	 * @return true si le nombre de deplacement est superieur au nombre de deplacement autorise
	 */
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
