package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import terrain.Case;

public class Level {
	private int taille;
	private String nomJoueur;
	private String TypePartie;
	
	
	public Partie loadTypePartie()
	{
		{
			//read the file, line by line from txt
			File file = new File(rep);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			int temp;
			//premiere ligne
			line = br.readLine();
		    //line = br.readLine();         
		    //line = br.readLine();         
			
			while(line != null)
			{
				//le separateur
			    String[] lines = line.split(";");
			    if(!lines[0].matches("DEPLACEMENT_LIMITE"))
			    {
			    	//go a la deuxieme ligne
					line = br.readLine();
					return lines[1];
			    }
			    else if(!lines[0].matches("TEMPS_LIMITE"))
			    {
			    	//go a la deuxieme ligne
					line = br.readLine();
					return lines[1];
			    }
			    else if(!lines[0].matches("ELIMINER_MERINGUE"))
			    {
			    	//go a la deuxieme ligne
					line = br.readLine();
					return lines[1];
			    }
					


			    line = br.readLine();         
			}

			fr.close();
	}
	
}
