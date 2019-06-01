package terrain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import bonbon.BonbonOrdinaire;
import bonbon.Contenant;
import bonbon.Couleur;
import bonbon.Vide;
import combinaison.ChainsOfRespDetecteur;
import combinaison.Combinaison;
import exception.CandyException;
//penser a faire la fonction qui fait que les bonbon tombent(decale) vers le bas
public class Plateau {
	
	/*
	 * Deux initialisation possible : un aleatoirement et l'autre par les fichiers du prof
	 * une grille est un ensemble de case
	 * sa taille est carré, et est invariable une fois fixé, c'est pourquoi il n'y a pas de setter
	 */
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
	public void setTaille(int taille)
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
			   		grille[ligne][i]=new Case(temp,ligne,i);
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
		this.grille[ligne][colonne]=new Case(bonbon,ligne,colonne);
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
	
	public void echange_aux(int ligne, int colonne,int ligne2,int colonne2)
	{
		Contenant temp = grille[ligne2][colonne2].getBonbon();
		grille[ligne2][colonne2].setBonbon(grille[ligne][colonne].getBonbon());
		grille[ligne][colonne].setBonbon(temp);
	}
	
	/*
	 * Cette fonction effectue l'echange de deux cases selon les conditions suivantes :
	 * - les deux cases sont adjacentes
	 * - les deux cases ne sont pas en dehors de la grille
	 * - il existe une combinaison dans l'une des deux cases echangé
	 */
	public void echange(int ligne, int colonne,int ligne2,int colonne2) throws CandyException
	{
		ChainsOfRespDetecteur test = new ChainsOfRespDetecteur();
		if(getCaseBonbon(ligne, colonne).estMeringue() || getCaseBonbon(ligne2, colonne2).estMeringue())
		{
			throw new CandyException("Echange impossible avec une meringue");
		}
		else if(caseEstDansGrille(ligne,colonne)==false)
		{
			throw new CandyException("Case en dehors de la grille");
		}
		else if(caseEstDansGrille(ligne2,colonne2)==false)
		{
			throw new CandyException("Case en dehors de la grille");
		}
		if( (ligne!=ligne2 && colonne!=colonne2))
		{
			throw new CandyException("Case non conforme, il n'est pas adjacent");
		}
		else if(ligne==ligne2)
		{
			if(colonne2>colonne+1||colonne2<colonne-1)
			{
				throw new CandyException("Case non conforme, beaucoup trop eloigné");
			}
			else
			{
				echange_aux(ligne, colonne,ligne2,colonne2);
				boolean coord2 = test.detecteur(ligne2, colonne2, this);
				boolean coord1 = test.detecteur(ligne, colonne, this);
				if(!coord2 && !coord1)
				{
					echange_aux(ligne, colonne,ligne2,colonne2);
					throw new CandyException("echange impossible, il n'y a pas de combinaison");
				}
				else if(coord1)
				{
					test.traitement(ligne, colonne, this);
				}
				else
				{
					test.traitement(ligne2, colonne2, this);
				}
			}

		}
		else if(colonne==colonne2)
		{
			if(ligne2>ligne+1 || ligne2<ligne-1)
			{
				throw new CandyException("Case non conforme, beaucoup trop eloigné");
			}
			else
			{
				
				echange_aux(ligne, colonne,ligne2,colonne2);
				boolean coord2 = test.detecteur(ligne2, colonne2, this);
				boolean coord1 = test.detecteur(ligne, colonne, this);
				if(!coord2 && !coord1)
				{
					echange_aux(ligne, colonne,ligne2,colonne2);
					throw new CandyException("echange impossible, il n'y a pas de combinaison");
				}
				else if(coord1)
				{
					test.traitement(ligne, colonne, this);
				}
				else
				{
					test.traitement(ligne2, colonne2, this);
				}
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
	
	
	//cette fonction decale vers le bas un ensemble de bonbon, c'est utile pour decaleVersBasColonne
	public void decaleEnsembleColonne(int colonne, int ligneArrive) throws IllegalArgumentException
	{
		if(!(grille[ligneArrive][colonne].getBonbon().estVide()))
		{
			throw new IllegalArgumentException("erreur parametre, la case vers laquelle vous voulez decaler les bonbons doit etre vide");
		}
		for(int i=ligneArrive; i>0; i--)
		{
			echange_aux(i,colonne,i-1,colonne);
		}
		grille[0][colonne].setBonbon(new Vide());
	}
	
	/*
	 * cette fonction fait tomber les bonbon d'une colonne de sorte qu'il n'y ait plus de vide
	 */
	public void decaleVersBasColonne(int colonne)
	{
		for(int i = 0 ;i<taille-1;i++)
		{
			if(grille[i+1][colonne].getBonbon().estVide())
			{
				decaleEnsembleColonne(colonne,i+1);
			}
		}
	}
	
	/*
	 * cette fonction fait tomber tout les bonbons la ou il y a du vide
	 */
	public void decaleVersBas()
	{
		for(int i=0;i<taille;i++)
		{
			decaleVersBasColonne(i);
		}
	}
	
	public void supprLigne(int ligne)
	{
		for(int i=0;i<taille;i++)
		{
			getGrille()[ligne][i].setBonbon(new Vide());
		}
	}
	
	public void supprColonne(int colonne)
	{
		for(int i=0;i<taille;i++)
		{
			getGrille()[i][colonne].setBonbon(new Vide());
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
