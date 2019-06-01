package bonbon;

public class BonbonSpecial implements Contenant {
	
	Couleur couleur;
	private boolean estSpecial;
	
	
	public BonbonSpecial(Couleur couleur)
	{
		this.estSpecial=true;
		setCouleur(couleur);
	}
	

	
	private void setCouleur(Couleur couleur)
	{
		this.couleur = couleur;
	}

	public Couleur getCouleur() {
		return couleur;
	}
	
	public String AfficherCouleur()
	{

		if(couleur==Couleur.BLEU)
		{
			return "BLE_RAY";
		}
		else if(couleur==Couleur.JAUNE)
		{
			return "JAU_RAY";
		}
		else if(couleur==Couleur.VERT)
		{
			return "VER_RAY";
		}
		else
		{
			return "VIO_RAY";
		}
	}
	public boolean estSpecial() {
		return estSpecial;
	}
	public boolean estMemeCouleur(Contenant a)
	{
		if(a.getCouleur()==this.couleur)
			return true;
		else
			return false;
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