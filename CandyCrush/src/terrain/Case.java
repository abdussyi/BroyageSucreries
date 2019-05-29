package terrain;

import bonbon.BonbonOrdinaire;
import bonbon.BonbonSpecial;
import bonbon.Contenant;
import bonbon.Couleur;

public class Case {
	//une case contient soit un bonbon, soit rien
	
	private Contenant bonbon;
	private int ligne;
	private int colonne;
	
	


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
			this.bonbon=new BonbonOrdinaire(Couleur.VIDE);
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
			this.bonbon=new BonbonOrdinaire(Couleur.MERINGUE);
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
		return true;
	}
	
	
}
