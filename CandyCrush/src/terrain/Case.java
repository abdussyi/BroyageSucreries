package terrain;

import bonbon.BonbonOrdinaire;
import bonbon.BonbonSpecial;
import bonbon.Contenant;
import bonbon.Couleur;

public class Case {
	//une case contient soit un bonbon, soit rien
	
	private static final Couleur BLEU = null;
	private static final Couleur VIOLET = null;
	private static final Couleur JAUNE = null;
	private static final Couleur VERT = null;
	private Contenant bonbon;
	
	
	


	public Case(Contenant bonbon) {
		setBonbon(bonbon);
	}
	
	//constructeur à partir d'un chiffre qui est utile pour exploiter le fichier plateau
	public Case(int bonbon)
	{
		if(bonbon==0)
		{
			this.bonbon=null;
		}
		if(bonbon==1)
		{
			this.bonbon=new BonbonOrdinaire(BLEU);
		}
		if(bonbon==2)
		{
			this.bonbon=new BonbonOrdinaire(VIOLET);
		}
		if(bonbon==3)
		{
			this.bonbon=new BonbonOrdinaire(JAUNE);
		}
		if(bonbon==4)
		{
			this.bonbon=new BonbonOrdinaire(VERT);
		}
		if(bonbon==5)
		{
			this.bonbon=new BonbonSpecial(BLEU);
		}
		if(bonbon==6)
		{
			this.bonbon=new BonbonSpecial(VIOLET);
		}
		if(bonbon==7)
		{
			this.bonbon=new BonbonSpecial(JAUNE);
		}
		if(bonbon==8)
		{
			this.bonbon=new BonbonSpecial(VERT);
		}
		if(bonbon==9)
		{
			this.bonbon=new BonbonSpecial(true);
		}
	}

	public Contenant getBonbon() {
		return bonbon;
	}
	
	
	//en argument mettre object peut etre... à voir
	
	public void setBonbon(Contenant bonbon) {
		this.bonbon = bonbon;
	}
	
	public boolean estVide()
	{
		if(bonbon==null)
			return true;
		else
			return false;
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
