package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Level {
	
	//convention; champs nuls --> pas d'objectifs
	private int nbDeplacement;
	private int scoreMax;
	private int temps;
	private String ObjectifPricipale;
	
	
	
	//load depuis un fichier
	public Level(String repertoire) throws IOException
	{
		setNbDeplacement(0);
		setScoreMax(0);
		setTemps(0);
		setObjectifs("");
		loadTypePartie(repertoire);
	}
	
	//Constructeur manuel, peu utile
	public Level(int nbDeplacement, int scoreMax, int temps, String nomJoueur, String objectifPricipale) {
		super();
		this.nbDeplacement = nbDeplacement;
		this.scoreMax = scoreMax;
		this.temps = temps;
		ObjectifPricipale = objectifPricipale;
	}


	public void loadTypePartie(String rep) throws IOException
	{
		
		{
			//read the file, line by line from txt
			File file = new File(rep);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			//go à la premiere ligne
			line = br.readLine();
			
			while(line != null)
			{
				//le separateur
			    String[] lines = line.split(";");
			    if(!lines[0].matches("DEPLACEMENT_LIMITE"))
			    {
			    	//go a la deuxieme ligne
					line = br.readLine();
					nbDeplacement = Integer.parseInt(lines[1]);
			    }
			    else if(!lines[0].matches("TEMPS_LIMITE"))
			    {
			    	//go a la deuxieme ligne
					line = br.readLine();
					temps=Integer.parseInt(lines[1]);
			    }
			    else if(!lines[0].matches("ELIMINER_MERINGUE"))
			    {
			    	//go a la deuxieme ligne
			    	ObjectifPricipale ="ELIMINER_MERINGUE";
					line = br.readLine();
			    }
			    else if(!lines[0].matches("SANS_OBJECTIF"))
			    {
			    	ObjectifPricipale ="SANS_OBJECTIF";
			    }
				
			    
			    
			    line = br.readLine();         
			}

			fr.close();
			
		}
		
	}

	public int getNbDeplacement() {
		return nbDeplacement;
	}

	public void setNbDeplacement(int nbDeplacement) {
		this.nbDeplacement = nbDeplacement;
	}

	public int getScoreMax() {
		return scoreMax;
	}

	public void setScoreMax(int scoreMax) {
		this.scoreMax = scoreMax;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}


	public String getObjectifs() {
		return ObjectifPricipale;
	}

	public void setObjectifs(String objectifs) {
		ObjectifPricipale = objectifs;
	}

	@Override
	public String toString() {
		return "Level [nbDeplacement=" + nbDeplacement + ", scoreMax=" + scoreMax + ", temps=" + temps
				 + ", ObjectifPricipale=" + ObjectifPricipale + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Level other = (Level) obj;
		if (ObjectifPricipale == null) {
			if (other.ObjectifPricipale != null)
				return false;
		} else if (!ObjectifPricipale.equals(other.ObjectifPricipale))
			return false;
		if (nbDeplacement != other.nbDeplacement)
			return false;

		if (scoreMax != other.scoreMax)
			return false;
		if (temps != other.temps)
			return false;
		return true;
	}
	
}
