package terrain;

import bonbon.Contenant;

public class Case {
	//une case contient soit un bonbon, soit rien
	
	private Contenant bonbon;
	
	
	


	public Case(Contenant bonbon) {
		setBonbon(bonbon);
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
