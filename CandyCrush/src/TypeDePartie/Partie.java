package TypeDePartie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import game.Joueur;
import javafx.scene.control.Label;
import terrain.Case;
import terrain.Plateau;

public class Partie {
	Objectif objectif;
	Restriction restriction;
	Joueur joueur;
	Plateau plateau;
	
	public Partie(Joueur joueur,Plateau plateau,String repertoire) throws IOException
	{
		this.joueur=joueur;
		this.plateau=plateau;
		loadTypePartie(repertoire);
	}
	
	public Objectif getObjectif() {
		return objectif;
	}

	public void setObjectif(Objectif objectif) {
		this.objectif = objectif;
	}

	public Restriction getRestriction() {
		return restriction;
	}

	public void setRestriction(Restriction restriction) {
		this.restriction = restriction;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}


	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	
	

	
	public void loadTypePartie(String rep) throws IOException
	{
		
		{
			//read the file, line by line from txt
			File file = new File(rep);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			//premiere ligne
			line = br.readLine();
		    //line = br.readLine();         
		    //line = br.readLine();         
			
			
			while(line != null)
			{
				//le separateur
			    String[] lines = line.split(";");
			    if(lines[0].matches("SCORE"))
			    {
					int score = Integer.parseInt(lines[1]);
					
					objectif = new ObjectifScore(score, joueur);
			    }
			    else if(lines[0].matches("DEPLACEMENT_LIMITE"))
			    {
					line = br.readLine();
				    lines = line.split(";");
					int nbDeplacement = Integer.parseInt(lines[1]);
					
					restriction = new RestrictionDeplacement(nbDeplacement, joueur);
			    }
			    else if(lines[0].matches("TEMPS_LIMITE"))
			    {
					line = br.readLine();
				    lines = line.split(";");
					int temps=Integer.parseInt(lines[1]);
					restriction = new RestrictionTemps(temps,joueur);
			    }
			    else if(lines[0].matches("TEMPS"))
			    {
			    	lines = line.split(";");
					int temps=Integer.parseInt(lines[1]);
					restriction = new RestrictionTemps(temps,joueur);
			    }
			    else if(lines[0].matches("ELIMINER_MERINGUE"))
			    {
			    	objectif = new ObjectifMeringue(plateau);
			    }
			    else if(lines[0].matches("SANS_OBJECTIF"))
			    {
			    	objectif=null;
			    }
				line = br.readLine();
			    
			}

			fr.close();
			
		}
		
	}
}