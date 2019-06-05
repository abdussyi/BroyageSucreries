package bonbon;


/*
 * interface qui implemente bonbon speciale, meringue, vide et bonbon ordinaire 
 * grace aux methodes ci-dessous
 * @author karabay
 */
public interface Contenant {
	public Couleur getCouleur();
	public boolean estSpecial();
	public boolean estMemeCouleur(Contenant a);
	public boolean equals(Object obj);
	public String AfficherCouleur();
	public boolean estMeringue();
	public boolean estVide();
}