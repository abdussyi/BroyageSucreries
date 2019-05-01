package bonbon;


//A faire estMeringue, getCouleur, estSpecial
public interface Contenant {
	public Couleur getCouleur();
	public boolean estSpecial();
	public boolean estMemeCouleur(Contenant a);
	public boolean equals(Object obj);
	public String AfficherCouleur();
}