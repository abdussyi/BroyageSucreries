package bonbon;

/*
 * classe qui creer la meringue implementé par contenant
 * @author
 */
public class Meringue implements Contenant{
	
	public Meringue()
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
	public String AfficherCouleur()
	{
			return "  MER  ";
	}

	@Override
	public boolean estMeringue() {
		return true;
	}

	@Override
	public boolean estVide() {
		return false;
	}

}
