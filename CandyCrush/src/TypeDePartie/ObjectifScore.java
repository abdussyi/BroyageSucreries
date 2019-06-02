package TypeDePartie;

import game.Joueur;

public class ObjectifScore implements Objectif{
	private int objectifScore;
	Joueur joueur;
	
	public ObjectifScore(int objectifScore, Joueur joueur)
	{
		this.objectifScore=objectifScore;
		this.joueur=joueur;
	}
	
	
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
