package terrain;

import bonbon.BonbonOrdinaire;
import bonbon.BonbonSpecial;
import bonbon.Contenant;
import bonbon.Couleur;
import bonbon.Meringue;
import bonbon.Vide;

/*
 * initialise une case grace a une ligne et une colonne et permet d'avoir le bonbon
 * @author akkus
 */
public class Case {
	//une case contient un Contenant
	
	private Contenant bonbon;
	private int ligne;
	private int colonne;
	
	/*
	 * recupere le nombre du bonbon du package bonbon
	 * @return le nombre du bonbon
	 */
	public int getBonbonNum()
	{
		if(bonbon.estSpecial())
		{
			switch (bonbon.getCouleur())
			{

	
			case BLEU:
				return 5;
			case VIOLET:
				return 6;
			case JAUNE:
				return 7;
			case VERT:
				return 8;
			default:
				return -1;
			}
		}
		else if(bonbon.estMeringue())
		{
			return 9;
		}
		if(bonbon.estVide())
		{
			return 0;
		}
		else
		{
			switch (bonbon.getCouleur())
			{

			case BLEU:
				return 1;
			case VIOLET:
				return 2;
			case JAUNE:
				return 3;
			case VERT:
				return 4;
			default:
				return -1;
			}
		}
	}

	public Case(Contenant bonbon, int ligne, int colonne) {
		setBonbon(bonbon);
		setColonne(colonne);
		setLigne(ligne);
	}
	
	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	//constructeur à partir d'un chiffre qui est utile pour exploiter le fichier plateau
	public Case(int bonbon,int ligne, int colonne)
	{
		if(bonbon==0)
		{
			this.bonbon=new Vide();
		}
		if(bonbon==1)
		{
			this.bonbon=new BonbonOrdinaire(Couleur.BLEU);
		}
		if(bonbon==2)
		{
			this.bonbon=new BonbonOrdinaire(Couleur.VIOLET);
		}
		if(bonbon==3)
		{
			this.bonbon=new BonbonOrdinaire(Couleur.JAUNE);
		}
		if(bonbon==4)
		{
			this.bonbon=new BonbonOrdinaire(Couleur.VERT);
		}
		if(bonbon==5)
		{
			this.bonbon=new BonbonSpecial(Couleur.BLEU);
		}
		if(bonbon==6)
		{
			this.bonbon=new BonbonSpecial(Couleur.VIOLET);
		}
		if(bonbon==7)
		{
			this.bonbon=new BonbonSpecial(Couleur.JAUNE);
		}
		if(bonbon==8)
		{
			this.bonbon=new BonbonSpecial(Couleur.VERT);
		}
		if(bonbon==9)
		{
			this.bonbon=new Meringue();
		}
		setLigne(ligne);
		setColonne(colonne);
	}

	public Contenant getBonbon() {
		return bonbon;
	}
	
	
	
	//en argument mettre object peut etre... à voir
	public void setBonbon(Contenant bonbon) {
		this.bonbon = bonbon;
	}
	

	
	@Override
	public String toString() {
		return "Case [bonbon=" + bonbon + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bonbon == null) ? 0 : bonbon.hashCode());
		result = prime * result + colonne;
		result = prime * result + ligne;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Case other = (Case) obj;
		if (bonbon == null) {
			if (other.bonbon != null)
				return false;
		} else if (!bonbon.equals(other.bonbon))
			return false;
		if (colonne != other.colonne)
			return false;
		if (ligne != other.ligne)
			return false;
		return true;
	}





	
}
