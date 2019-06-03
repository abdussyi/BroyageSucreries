import java.io.IOException;

import TypeDePartie.Partie;
import exception.CandyException;
import game.Joueur;
import terrain.OutilsPlateau;
import terrain.Plateau;

public class Application {
	
	public static void main(String[] args) throws CandyException, IOException
	{
		
//		Verifications verif = new Verifications();
//		verif.test();
		Plateau plateau = new Plateau("plateaux/plateau4.csv");
		Joueur joueur = new Joueur("Samet");
		plateau.afficherGrille();
		System.out.println("");
		System.out.println("");
		//plateau.echange(0, 6, 1, 6,joueur);
		plateau.chute();
		
		Partie partie = new Partie(joueur, plateau, "plateaux/plateau4.csv");
		
		if (partie.getObjectif().objectifAtteint())
		{
			System.out.println("fini");
		}
		if(partie.getRestriction().restrictionsAtteinte())
		{
			System.out.println("perdu");
		}
		
		//il fauudrait une fonction qui teste toutes les cases modifié
		//arretez de cherchez si aucune combinaison a ete trouvé sur toute la grille
		//cette boucle parcours tout le tableau et recherche des combi

		OutilsPlateau outils = new OutilsPlateau();
		outils.traitementPlateauAll(plateau,joueur);
		
		plateau.afficherGrille();


	}
	
	
}