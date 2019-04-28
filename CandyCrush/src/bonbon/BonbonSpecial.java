package bonbon;

public class BonbonSpecial implements Contenant {
	
	boolean estMeringue;
	Couleur couleur;
	private boolean estSpecial;
	
	
	public BonbonSpecial(Couleur couleur)
	{
		this.estMeringue=false;
		this.estSpecial=true;
		setCouleur(couleur);
	}
	public BonbonSpecial(boolean estMeringue)
	{
		this.estMeringue=estMeringue;
		setCouleur(null);
		estSpecial=true;
	}
	
	public void setEstMeringue(boolean estMeringue)
	{
		this.estMeringue=estMeringue;
	}
	
	private void setCouleur(Couleur couleur)
	{
		this.couleur = couleur;
	}

	public boolean getEstMeingue()
	{
		return estMeringue;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public boolean estSpecial() {
		return estSpecial;
	}
	
}