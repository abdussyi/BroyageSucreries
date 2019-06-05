package TypeDePartie;

/*
 * interface qui va donner les differentes restrictions possibles dans un plateau
 * @author akkus et karabay
 */
public interface Restriction {
	public boolean restrictionsAtteinte();
	public boolean estRestrictionDeplacement();
	public boolean estRestrictionsTempsDeplacement();
	public boolean estRestrictionTemps();
}
