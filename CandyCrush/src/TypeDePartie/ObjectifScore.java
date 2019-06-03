package TypeDePartie;

import game.Joueur;

/*
 * la classe qui implemente l'objectif d'avoir un certain score pour gagner la partie 
 * @author 
 */
public class ObjectifScore implements Objectif{
	private int objectifScore;
	Joueur joueur;
	
	public ObjectifScore(int objectifScore, Joueur joueur)
	{
		this.objectifScore=objectifScore;
		this.joueur=joueur;
	}
	
	/*
	 * verifie si l'objectif du score est atteint
	 * @return true si le score a battre est depasse
	 */
	public boolean objectifAtteint()
	{
		if(joueur.getScore()>=objectifScore)
		{
			return true;
		}
		else
			return false;
	}

	public int getObjectifScore() {
		return objectifScore;
	}


	public void setObjectifScore(int objectifScore) {
		this.objectifScore = objectifScore;
	}
	
	public boolean estObjectifScore()
	{
		return true;
	}


	@Override
	public boolean estObjectifMeringue() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
