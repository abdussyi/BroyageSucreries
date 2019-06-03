package TypeDePartie;

/*
 * interface qui va donner les differentes restrictions possibles dans un plateau
 * @author 
 */
public interface Restriction {
	public boolean restrictionsAtteinte();
	public boolean estRestrictionDeplacement();
	public boolean estRestrictionsTempsDeplacement();
	public boolean estRestrictionTemps();
	//public boolean estRestrictionTemps();
}
