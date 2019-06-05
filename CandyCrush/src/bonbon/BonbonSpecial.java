package bonbon;

/*
 * classe des bonbons speciaux implementant l'interface contenant
 * @author karabay
 */
public class BonbonSpecial implements Contenant {
	
	Couleur couleur;
	private boolean estSpecial;
	private boolean obtenuHorizontalement;
	private boolean obtenuVerticalement;
	
	public BonbonSpecial(Couleur couleur)
	{
		this.estSpecial=true;
		setCouleur(couleur);
		this.obtenuHorizontalement=false;
		this.obtenuVerticalement=false;
	}
	

	
	public boolean estObtenuHorizontalement() {
		return obtenuHorizontalement;
	}



	public void setObtenuHorizontalement(boolean obtenuHorizontalement) {
		this.obtenuHorizontalement = obtenuHorizontalement;
	}



	public boolean estObtenuVerticalement() {
		return obtenuVerticalement;
	}



	public void setObtenuVerticalement(boolean obtenuVerticalement) {
		this.obtenuVerticalement = obtenuVerticalement;
	}



	private void setCouleur(Couleur couleur)
	{
		this.couleur = couleur;
	}

	public Couleur getCouleur()
	{
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