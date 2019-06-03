package game;
/*
 * classe qui initialise le joueur
 * @author 
 */
public class Joueur {
	private String nom;
	private int score;
	private int nbDeplacement;
	
	
	
	public Joueur(String nom)
	{
		this.nom=nom;
		this.score=0;
		this.nbDeplacement=0;
	}
	
	
	
	public int getNbDeplacement() {
		return nbDeplacement;
	}



	public void addNbDeplacement() {
		this.nbDeplacement = nbDeplacement + 1;
	}



	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getScore() {
		return score;
	}
	
	public void addScore(int score) {
		this.score = this.score + score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", score=" + score + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + score;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (score != other.score)
			return false;
		return true;
	}
	
	
}