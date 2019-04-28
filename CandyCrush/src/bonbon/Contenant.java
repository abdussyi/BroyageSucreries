package bonbon;


//A faire estMeringue, getCouleur, estSpecial
public interface Contenant {
	public boolean getEstMeingue();
	public Couleur getCouleur();
	public boolean estSpecial();

	public boolean equals(Object obj);
}