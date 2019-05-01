package terrain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import Exception.CandyException;
import bonbon.Contenant;
//penser a faire la fonction qui fait que les bonbon tombent(decale) vers le bas
public class Plateau {
	
	//Deux initialisation possible : un aleatoirement et l'autre par les fichiers du prof
	//une grille est un ensemble de case
	//sa taille est carré, et est invariable une fois fixé, c'est pourquoi il n'y a pas de setter
	
	private int taille;
	private Case[][] grille;
	
	//il y aura deux constructeur, un qui charge le plateau depuis un fichiers et l'autre aleatoirement
	
	public Plateau(String file) throws IOException
	{
		loadFile(file);
	}
	
	//grille généré aleatoirement
	//Pas encore fait :/
	public Plateau(int taille)
	{
		setTaille(taille);
		initGrille(taille);
	}
	
	//possibilité de setTaille par rapport a un fichier
	private void setTaille(int taille)
	{
		this.taille=taille;
	}
	
	//Cete methode charge le plateau depuis un fichier
	public void loadFile(String rep) throws IOException
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
		
		int ligne =0;
		while(line != null)
		{
			//le separateur
		    String[] lines = line.split(";");
		    if(!lines[0].matches("NB_LIG"))
		    {
		    	//integer.parse permet de convertir un string en int
		    	this.taille=Integer.parseInt(lines[1]);
				initGrille(taille);
				
		    }
		    else if(!lines[0].matches("[0-9]"))
		    {
			    line = br.readLine();         
		    }
		    else
		    {
	    		//ArrayList<Case> ligne = new ArrayList<Case>(); 
		    	for(int i=0;i<taille;i++)
			    {
			   		temp = Integer.parseInt(lines[i]);
			   		grille[ligne][i]=new Case(temp);
			   	}
		    	ligne++;
		    }
		    //Do something for line here
		    //Store the data read into a variable

		    line = br.readLine();         
		}

		fr.close();
	}
	
	
	
	//Cette methode metier, permet d'initaialiser a NULL toutes la grille
	//c'est une grille carré
	public void initGrille(int taille)
	{
		//a verifier, j'ai un doute sur la syntaxe
		this.grille= new Case[taille][taille];
		for (int i = 0; i <taille;i++)
		{
			for(int j = 0;j<taille;j++)
			{
	    		grille[j][i]=null;
			}
		}
	}
	
	public void setCaseGrille(int ligne, int colonne,Contenant bonbon)
	{
		this.grille[ligne][colonne]=new Case(bonbon);
	}
	public Contenant getCaseBonbon(int ligne, int colonne) throws CandyException
	{
		if (ligne>taille-1 || colonne>taille-1)
			throw new CandyException("On depasse la limite du plateau");
		return this.grille[ligne][colonne].getBonbon();
	}
	
	public int getTaille()
	{
		return this.taille;
	}

	@Override
	public String toString() {
		return "Plateau [taille=" + taille + ", grille=" + Arrays.toString(grille) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(grille);
		result = prime * result + taille;
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
		Plateau other = (Plateau) obj;
		if (!Arrays.deepEquals(grille, other.grille))
			return false;
		if (taille != other.taille)
			return false;
		return true;
	}

	
	//coordonnée du bonbon à echanger sur le tableau en parametre
	public void echange(int x, int y,int x2,int y2) throws CandyException
	{
		if(   (x!=x2 && y!=y2)    ||    (   (x2!=x+1||x2!=x-1)     &&     (y2!=y+1||y2!=y-1)   )   )
		{
			throw new CandyException("Case non conforme");
		}
		else if(x>taille-1||y>taille-1||x2>taille-1||y2>taille-1||x<0||y<0||x2<0||y2<0)
		{
			throw new IllegalArgumentException("Argument probleme case vide");
		}
		else
		{
			//c'est l'echange
			Contenant temp = grille[x2][y2].getBonbon();
			grille[x2][y2].setBonbon(grille[x][y].getBonbon());
			grille[x][y].setBonbon(temp);
		}
	}
	
	public void detection(int x, int y)
	{
		
	}
	
	
}
