package bonbon;


public class BonbonOrdinaire implements Contenant{
	
	private Couleur couleur;
	private boolean estSpecial;

	public BonbonOrdinaire(Couleur couleur) {
		setCouleur(couleur);
		this.estSpecial=false;
	}
	
	private void setCouleur(Couleur couleur)
	{
		this.couleur = couleur;
	}
	
	public Couleur getCouleur() {
		return couleur;
	}
	

	public boolean estSpecial() {
		return estSpecial;
	}

	public String AfficherCouleur()
	{
		if(couleur==Couleur.VIDE)
		{
			return "  VID  ";
		}
		else if(couleur==Couleur.BLEU)
		{
			return "  BLE  ";
		}
		else if(couleur==Couleur.JAUNE)
		{
			return "  JAU  ";
		}
		else if(couleur==Couleur.MERINGUE)
		{
			return "  MER  ";
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

	
	
}
