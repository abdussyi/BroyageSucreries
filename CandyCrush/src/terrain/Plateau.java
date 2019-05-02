package terrain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
	
	public Plateau(String file)
	{
		try {
			loadFile(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		    if(lines[0].matches("NB_LIG"))
		    {
		    	//integer.parse permet de convertir un string en int
		    	this.taille=Integer.parseInt(lines[1]);
				initGrille(taille);
			    line = br.readLine();
		    }
		    else if(!lines[0].matches("[0-9]"))
		    {
			    line = br.readLine();         
		    }
		    else
		    {
		    	for(int i=0;i<taille;i++)
			    {
			   		temp = Integer.parseInt(lines[i]);
			   		grille[ligne][i]=new Case(temp);
			   	}
		    	ligne++;
			    line = br.readLine();         

		    }

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
	
	public Case[][] getGrille()
	{
		return this.grille;
	}
	//coordonnée du bonbon à echanger sur le tableau en parametre
	//x correspond a la ligne et y correspond a la colonne
	public void echange(int x, int y,int x2,int y2) throws CandyException
	{
		if(caseEstDansGrille(x,y)==false)
		{
			throw new CandyException("Case en dehors de la grille");
		}
		else if(caseEstDansGrille(x2,y2)==false)
		{
			throw new CandyException("Case en dehors de la grille");
		}
		if( (x!=x2 && y!=y2))
		{
			throw new CandyException("Case non conforme");
		}
		else if(x==x2)
		{
			if(y2>y+1||y2<y-1)
			{
				throw new CandyException("Case non conforme");
			}
			else
			{
				//c'est l'echange
				Contenant temp = grille[x2][y2].getBonbon();
				grille[x2][y2].setBonbon(grille[x][y].getBonbon());
				grille[x][y].setBonbon(temp);
			}

		}
		else if(y==y2)
		{
			if(x2>x+1 || x2<x-1)
			{
				throw new CandyException("Case non conforme");
			}
			else
			{
				//c'est l'echange
				Contenant temp = grille[x2][y2].getBonbon();
				grille[x2][y2].setBonbon(grille[x][y].getBonbon());
				grille[x][y].setBonbon(temp);
			}
		}
	}
	
	
	
	public boolean caseEstDansGrille(int l, int c)
	{
		if(l>taille-1||c>taille-1||l<0||c<0)
		{
			return false;
		}
		else
			return true;
	}
	
	public void dedectionTroisMemeCouleur(int l, int c)
	{
		//sauvegarde des voisin de la case afin de faciliter la la lisibilité du code
		
		//les case sont numéroté de -2 à 2
		
		Case moinsDeux,moinsUn,zero,un,deux;
		
		
		//verification horizontale
		if(caseEstDansGrille(l, c-2))
		{
			moinsDeux = grille[l][c-2];
		}
		else
		{
			moinsDeux=null;
		}
		if(caseEstDansGrille(l, c-1))
		{
			moinsUn = grille[l][c-1];
		}
		else
		{
			moinsUn = null;
		}
		if(caseEstDansGrille(l, c))
		{
			zero = grille[l][c];
		}
		else
		{
			zero = null;
		}
		if(caseEstDansGrille(l, c+1))
		{
			un = grille[l][c+1];
		}
		else
		{
			un = null;
		}
		if(caseEstDansGrille(l, c+2))
		{
			deux = grille[l][c+2];
		}
		else
		{
			deux = null;
		}
		
		if(moinsDeux!=null)
		{
			if( moinsDeux.getBonbon().estMemeCouleur(moinsUn.getBonbon())&&moinsUn.getBonbon().estMemeCouleur(zero.getBonbon()))
			{
				//il exite une combinaison en -2 -1 et 0
			}
		}
		else if(moinsUn!=null&&un!=null)
		{
			if( moinsUn.getBonbon().estMemeCouleur(zero.getBonbon())&&zero.getBonbon().estMemeCouleur(un.getBonbon()))
			{
				//il exite une combinaison en  -1 et 0 et 1
			}
		}
		else if(un!=null&&deux!=null)
		{
			if( zero.getBonbon().estMemeCouleur(un.getBonbon())&&un.getBonbon().estMemeCouleur(deux.getBonbon()))
			{
				//il exite une combinaison en  0,1 et 2
			}
		
		}
		
		//verification Verticale
		if(caseEstDansGrille(l-2, c))
		{
			moinsDeux = grille[l-2][c];
		}
		else
		{
			moinsDeux=null;
		}
		if(caseEstDansGrille(l-1, c))
		{
			moinsUn = grille[l-1][c];
		}
		else
		{
			moinsUn = null;
		}
		//pas vraiment bseoin de cela
		if(caseEstDansGrille(l, c))
		{
			zero = grille[l][c];
		}
		else
		{
			zero = null;
		}
		if(caseEstDansGrille(l+1, c))
		{
			un = grille[l+1][c];
		}
		else
		{
			un = null;
		}
		if(caseEstDansGrille(l+2, c))
		{
			deux = grille[l+2][c];
		}
		else
		{
			deux = null;
		}
		
		if(moinsDeux!=null)
		{
			if( moinsDeux.getBonbon().estMemeCouleur(moinsUn.getBonbon())&&moinsUn.getBonbon().estMemeCouleur(zero.getBonbon()))
			{
				//il exite une combinaison en -2 -1 et 0
			}
		}
		else if(moinsUn!=null&&un!=null)
		{
			if( moinsUn.getBonbon().estMemeCouleur(zero.getBonbon())&&zero.getBonbon().estMemeCouleur(un.getBonbon()))
			{
				//il exite une combinaison en  -1 et 0 et 1
			}
		}
		else if(un!=null&&deux!=null)
		{
			if( zero.getBonbon().estMemeCouleur(un.getBonbon())&&un.getBonbon().estMemeCouleur(deux.getBonbon()))
			{
				//il exite une combinaison en  0,1 et 2
			}
		
		}
	}
	
	public void afficherGrille()
	{
		for(int ligne=0;ligne<taille;ligne++)
		{
			for(int colonne=0;colonne<taille;colonne++)
			{
				System.out.print("["+grille[ligne][colonne].getBonbon().AfficherCouleur()+"]");
			}
			System.out.print("\n");
		}
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

	
}
