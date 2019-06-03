package bonbon;

/*
 * classe de gestion des bonbons ordinaire implementant l'interface contenant
 * @author 
 */
public class BonbonOrdinaire implements Contenant{

	private Couleur couleur;
	private boolean estSpecial;

	/*
	 * creer un bonbon ordianire
	 */
	public BonbonOrdinaire(Couleur couleur) {
		setCouleur(couleur);
		this.estSpecial=false;
	}
	
	/*
	 * creer un bonbon de couleur du parametre couleur
	 * @param couleur couleur que l'on veut donner au bonbon
	 */
	private void setCouleur(Couleur couleur)
	{
		this.couleur = couleur;
	}
	
	/*
	 * recupere la couleur d'un bonbon ordinaire
	 * @return couleur	la couleur du bonbon ordinaire
	 */
	public Couleur getCouleur() {
		return couleur;
	}
	

	/*
	 * retourne si le bonbon est special
	 * @return false comme le bonbon n'est pas un bonbon rayé
	 */
	public boolean estSpecial() {
		return estSpecial;
	}

	public String AfficherCouleur()
	{

		if(couleur==Couleur.BLEU)
		{
			return "  BLE  ";
		}
		else if(couleur==Couleur.JAUNE)
		{
			return "  JAU  ";
		}
		else if(couleur==Couleur.VERT)
		{
			return "  VER  ";
		}
		else
		{
			return "  VIO  ";
		}
	}
	
	/*
	 * verifie si un bonbon est de meme couleur qu'un autre bonbon
	 * @param a	contenant verifiant la couleur
	 * @return true si a est de meme couleur que le bonbon voulue , false sinon
	 */
	public boolean estMemeCouleur(Contenant a)
	{
		
		if(a.getCouleur()==this.couleur)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "BonbonOrdinaire [couleur=" + couleur  + ", estSpecial=" + estSpecial
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
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

		if (estSpecial != other.estSpecial)
			return false;
		return true;
	}

	
	@Override
	public boolean estMeringue() {
		return false;
	}

	@Override
	public boolean estVide() {
		return false;
	}

	
	
}
