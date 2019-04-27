package terrain;

import java.util.ArrayList;

import bonbon.Contenant;
//penser a faire la fonction qui fait que les bonbon tombent(decale) vers le bas
public class Grille {
	
	//Deux initialisation possible : un aleatoirement et l'autre par les fichiers du prof
	//une grille est un ensemble de case
	//sa taille est carré, et est invariable une fois fixé, c'est pourquoi il n'y a pas de setter
	
	private int taille;
	private ArrayList<ArrayList<Case>> ligne;
	
	
	//Cette methode metier, permet d'initaialiser a NULL toutes la grille
	//c'est une grille carré
	public void initLigne(int taille)
	{
		//a verifier, j'ai un doute sur la syntaxe
		this.ligne=new ArrayList<ArrayList<Case>>();
		for (int i = 0; i <=taille;i++)
		{
			//a verifier, j'ai un doute sur la syntaxe
			ArrayList<Case> col = new ArrayList<Case>();
			for (int j = 0; j <=taille;j++)
			{
				col.add(null);
			}
			this.ligne.add(col);
		}
	}
	
	public void setCaseGrille(int ligne, int colonne,Contenant bonbon)
	{
		ArrayList<Case> line = this.ligne.get(ligne);
		Case nimp =  line.get(colonne);
		nimp.setBonbon(bonbon);
	}
	public Contenant getCaseBonbon(int ligne, int colonne)
	{
		ArrayList<Case> line = this.ligne.get(ligne);
		Case nimp =  line.get(colonne);
		return nimp.getBonbon();
	}
	
}
