package terrain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import bonbon.Contenant;
//penser a faire la fonction qui fait que les bonbon tombent(decale) vers le bas
public class Plateau {
	
	//Deux initialisation possible : un aleatoirement et l'autre par les fichiers du prof
	//une grille est un ensemble de case
	//sa taille est carré, et est invariable une fois fixé, c'est pourquoi il n'y a pas de setter
	
	private int taille;
	private ArrayList<ArrayList<Case>> grille;
	
	//il y aura deux constructeur un aleatoire en argument la taille, et un en parametre la taille et un fichier
	
	
	public Plateau(int taille, String file)
	{
		setTaille(taille);
		initGrille(taille);
		
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
	public void loadFile() throws IOException
	{
		//read the file, line by line from txt
		File file = new File("train/traindata.txt");
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
	    		ArrayList<Case> ligne = new ArrayList<Case>(); 
		    	for(int i=0;i<taille;i++)
		    	{
		    		temp = Integer.parseInt(lines[i]);
		    		ligne.add(new Case(temp));
		    	}
		    	this.grille.add(ligne);
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
		this.grille=new ArrayList<ArrayList<Case>>();
		for (int i = 0; i <=taille;i++)
		{
			//a verifier, j'ai un doute sur la syntaxe
			ArrayList<Case> col = new ArrayList<Case>();
			for (int j = 0; j <=taille;j++)
			{
				col.add(null);
			}
			this.grille.add(col);
		}
	}
	
	public void setCaseGrille(int ligne, int colonne,Contenant bonbon)
	{
		ArrayList<Case> line = this.grille.get(ligne);
		Case nimp =  line.get(colonne);
		nimp.setBonbon(bonbon);
	}
	public Contenant getCaseBonbon(int ligne, int colonne)
	{
		ArrayList<Case> line = this.grille.get(ligne);
		Case nimp =  line.get(colonne);
		return nimp.getBonbon();
	}
	
	
}
