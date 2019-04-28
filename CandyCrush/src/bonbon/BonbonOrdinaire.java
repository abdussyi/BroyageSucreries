package bonbon;


public class BonbonOrdinaire implements Contenant{
	
	private Couleur couleur;
	private boolean estMeringue;
	private boolean estSpecial;

	public BonbonOrdinaire(Couleur couleur) {
		setCouleur(couleur);
		this.estMeringue=false;
		this.estSpecial=false;
	}
	
	private void setCouleur(Couleur couleur)
	{
		this.couleur = couleur;
	}
	
	//exeption si utilisé avec meringue
	public Couleur getCouleur() {
		return couleur;
	}
	
	
	public boolean getEstMeingue()
	{
		return estMeringue;
	}


	public boolean estSpecial() {
		return estSpecial;
	}

	@Override
	public String toString() {
		return "BonbonOrdinaire [couleur=" + couleur + ", estMeringue=" + estMeringue + ", estSpecial=" + estSpecial
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result + (estMeringue ? 1231 : 1237);
		result = prime * result + (estSpecial ? 1231 : 1237);
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BonbonOrdinaire other = (BonbonOrdinaire) obj;
		if (couleur != other.couleur)
			return false;
		if (estMeringue != other.estMeringue)
			return false;
		if (estSpecial != other.estSpecial)
			return false;
		return true;
	}

	
	
}
