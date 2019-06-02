package TypeDePartie;

public class RestrictionsTempsDeplacement implements Restriction{
	
	private RestrictionDeplacement deplacement;
	private RestrictionTemps temps;
	
	public RestrictionsTempsDeplacement(RestrictionDeplacement deplacement,RestrictionTemps temps)
	{
		this.deplacement=deplacement;
		this.temps=temps;
	}
	
	public boolean restrictionsAtteinte()
	{
		if(deplacement.restrictionsAtteinte() && temps.restrictionsAtteinte())
		{
			return true;
		}
		return false;
	}

	public boolean estRestrictionsTempsDeplacement()
	{
		return true;
	}

	@Override
	public boolean estRestrictionDeplacement() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estRestrictionTemps() {
		// TODO Auto-generated method stub
		return false;
	}
}
