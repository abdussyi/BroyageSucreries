package TypeDePartie;

import game.Joueur;
import javafx.scene.control.Label;

public class RestrictionTemps implements Restriction{
	private int tempsLimite;//en seconde
	private int minute;
	private int seconde;
	
	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSeconde() {
		return seconde;
	}

	public void setSeconde(int seconde) {
		this.seconde = seconde;
	}

	public RestrictionTemps(int tempsLimite,Joueur joueur)
	{
		this.tempsLimite=tempsLimite;
		this.seconde=0;
		this.minute=0;
	}
	
	public int currentTime()
	{

		return minute*60+seconde;
	}
	
	public boolean restrictionsAtteinte()
	{
		if(currentTime()>=tempsLimite)
		{
			return true;
		}
		return false;
	}
	
	public boolean estRestrictionTemps()
	{
		return true;
	}

	@Override
	public boolean estRestrictionDeplacement() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estRestrictionsTempsDeplacement() {
		// TODO Auto-generated method stub
		return false;
	}
}
