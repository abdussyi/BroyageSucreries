package game;

import java.io.IOException;

import exception.CandyException;
import terrain.OutilsPlateau;
import terrain.Plateau;

/*
 * permet de sauvegarder ses parties
 * @author akkus
 */
public class Jeu {
	
	private Plateau plateau;
	private Level level;
	private Joueur joueur;
	private boolean finPartie;
	
	
	public Jeu(String repertoire, Joueur joueur) throws IOException
	{
		this.plateau = new Plateau(repertoire);
		this.level = new Level(repertoire);
		this.joueur=joueur;
		this.finPartie=false;
	}
	
	/*
	 * initialise la partie avec le plateau donnee
	 * @throws CandyException
	 */
	public void jouer() throws CandyException
	{
		while(finPartie==false)
		{
			//echanger bonbon
			plateau.echange(0, 0, 0, 1,this.joueur);
			OutilsPlateau outil = new OutilsPlateau();
			outil.traitementPlateauAll(plateau,this.joueur);
		}
	}
	
	
	//public boolean verifFinPartie

	public Plateau getPlateau() {
		return plateau;
	}


	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}


	public Level getLevel() {
		return level;
	}


	public void setLevel(Level level) {
		this.level = level;
	}


	public Joueur getJoueur() {
		return joueur;
	}


	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}


	public boolean EstFinPartie() {
		return finPartie;
	}


	public void setFinPartie(boolean finPartie) {
		this.finPartie = finPartie;
	}
	
	
}
