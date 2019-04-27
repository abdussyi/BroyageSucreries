package bonbon;


public class BonbonOrdinaire implements Contenant{
	
	private Couleur coul;

	public BonbonOrdinaire(Couleur coul) {
		this.coul = coul;
	}

	public Couleur getBonbon() {
		return coul;
	}


	@Override
	public String toString() {
		return "BonbonOrdinaire [bonbon=" + coul + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coul == null) ? 0 : coul.hashCode());
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
		BonbonOrdinaire other = (BonbonOrdinaire) obj;
		if (coul != other.coul)
			return false;
		return true;
	}
	
}
