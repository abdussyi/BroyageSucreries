package terrain;

import bonbon.Contenant;

public class Grille extends Case{

	//une grille est un ensemble de case
	//sa taille est carré, et est invariable une fois fixé, c'est pourquoi il n'y a pas de setter
	
	private int taille;
	
	public Grille(Contenant bonbon, int taille) {
		super(bonbon);
		this.taille=taille;
	}

	public int getTaille() {
		return taille;
	}

	@Override
	public String toString() {
		return "Grille [taille=" + taille + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + taille;
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
		Grille other = (Grille) obj;
		if (taille != other.taille)
			return false;
		return true;
	}

	
}
