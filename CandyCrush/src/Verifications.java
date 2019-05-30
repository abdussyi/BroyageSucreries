import exception.CandyException;
import terrain.Plateau;

//classe qui est utile pour compacter les verifications demandé par le prof
public class Verifications {
	
	
	public void test()
	{
		//test des consultations
				Plateau plateau = new Plateau("plateaux/plateau_demo.csv");
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
				
				try {
					System.out.print("Quelle est la couleur du bonbon situé en (3,10) ? Réponse : ");
					System.out.println(plateau.getGrille()[3][10].getBonbon().getCouleur());
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				try {
					System.out.print("Le bonbon situé en (3,10) est-il rayé ? Réponse : ");
					if(plateau.getGrille()[3][10].getBonbon().estSpecial()==true)
					{
						System.out.println("OUI");
					}
					else
					{
						System.out.println("NON");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("LES ECHANGES \n");
				System.out.println("Echanger les cases (4,4) avec la case (5,4)");
				plateau.afficherGrille();
				System.out.print("Le bonbon situé en (3,4) est-il Jaune : ");
				System.out.print(plateau.getGrille()[3][4].getBonbon().getCouleur());
				if(plateau.getGrille()[3][4].getBonbon().estSpecial()==true)
				{
					System.out.println(" RAYE");
				}
				else
				{
					System.out.println("PAS RAYE");
				}
				
				try {
					plateau.echange(4, 3, 3, 3);
				} catch (CandyException e) {
					e.printStackTrace();
				}
				
				
	}
}
