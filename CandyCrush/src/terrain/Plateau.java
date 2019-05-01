package terrain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
		int temp;
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
		if (this.grille[ligne][colonne].getBonbon()==null)
			throw new CandyException("C'est une case vide");
		return this.grille[ligne][colonne].getBonbon();
	}
	
	
}
