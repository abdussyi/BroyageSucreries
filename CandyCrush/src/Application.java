import java.io.IOException;

import Exception.CandyException;
import terrain.Plateau;

public class Application {
	
	public static void main(String[] args) throws CandyException
	{
		//test des consultations
		Plateau plateau = new Plateau("/Users/abduss/Documents/BPOO/plateaux/plateau_demo.csv");
		plateau.afficherGrille();
		System.out.print("Quelle est la couleur du bonbon situé en (3,2) ? Réponse : ");
		System.out.println(plateau.getGrille()[3][2].getBonbon().getCouleur());
		System.out.print("Le bonbon situé en (3,2) est-il rayé ? Réponse : ");
		if(plateau.getGrille()[3][2].getBonbon().estSpecial()==false)
		{
			System.out.println("NON");
		}
		else
		{
			System.out.println("OUI");
		}
		System.out.print("Quelle est la couleur du bonbon situé en (4,2) ? Réponse : ");
		System.out.println(plateau.getGrille()[4][2].getBonbon().getCouleur());
		System.out.print("Le bonbon situé en (4,2) est-il rayé ? Réponse : ");
		if(plateau.getGrille()[4][2].getBonbon().estSpecial()==true)
		{
			System.out.println("OUI");
		}
		else
		{
			System.out.println("NON");
		}
		System.out.print("Quelle est la couleur du bonbon situé en (3,8) ? Réponse : ");
		System.out.println(plateau.getGrille()[3][8].getBonbon().getCouleur());
		System.out.print("Le bonbon situé en (2,4) est-il rayé ? Réponse : ");
		if(plateau.getGrille()[3][8].getBonbon().estSpecial()==true)
		{
			System.out.println("OUI");
		}
		else
		{
			System.out.println("NON");
		}
		System.out.print("Quelle est la couleur du bonbon situé en (3,0) ? Réponse : ");
		System.out.println(plateau.getGrille()[3][0].getBonbon().getCouleur());
		System.out.print("Le bonbon situé en (3,0) est-il rayé ? Réponse : ");
		if(plateau.getGrille()[3][0].getBonbon().estSpecial()==true)
		{
			System.out.println("OUI");
		}
		else
		{
			System.out.println("NON");
		}
		System.out.print("Quelle est la couleur du bonbon situé en (3,10) ? Réponse : ");
		System.out.println(plateau.getGrille()[3][10].getBonbon().getCouleur());
		System.out.print("Le bonbon situé en (3,10) est-il rayé ? Réponse : ");
		if(plateau.getGrille()[3][10].getBonbon().estSpecial()==true)
		{
			System.out.println("OUI");
		}
		else
		{
			System.out.println("NON");
		}
		
	}
		
	
}