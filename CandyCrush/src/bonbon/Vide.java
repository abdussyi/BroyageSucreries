package bonbon;

public class Vide implements Contenant {
	
	public Vide()
	{
		
	}

	@Override
	public Couleur getCouleur() {
		return null;
	}

	@Override
	public boolean estSpecial() {
		return false;
	}

	@Override
	public boolean estMemeCouleur(Contenant a) {
		return false;
	}

	@Override
	public String AfficherCouleur() {
		return "  VID  ";
	}

	@Override
	public boolean estMeringue() {
		return false;
	}

	@Override
	public boolean estVide() {
		return true;
	}

}
