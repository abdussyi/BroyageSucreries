import exception.CandyException;
import terrain.Plateau;

public class Application {
	
	public static void main(String[] args) throws CandyException
	{
		
//		Verifications verif = new Verifications();
//		verif.test();
		Plateau plateau = new Plateau("plateaux/plateau5.csv");
		plateau.afficherGrille();
		System.out.println("");
		System.out.println("");
		plateau.echange(4, 2, 5, 2);
		plateau.decaleVersBas();

		plateau.afficherGrille();


	}
	
	
}