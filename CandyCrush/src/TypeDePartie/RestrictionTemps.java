package TypeDePartie;

import game.Joueur;
import javafx.scene.control.Label;

public class RestrictionTemps implements Restriction{
	private int tempsLimite;//en seconde
	private Label lChrono;
	
	
	public RestrictionTemps(int deplacementLimite,int tempsLimite,Joueur joueur,Label lChrono)
	{
		this.tempsLimite=tempsLimite;
		this.lChrono=lChrono;
	}
	
	public int currentTime()
	{
		String temps = this.lChrono.getText();
		char[] tabChar = temps.toCharArray();
		int minute = tabChar[0];
		int seconde = tabChar[4];
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
