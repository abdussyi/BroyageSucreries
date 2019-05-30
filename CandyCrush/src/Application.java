import exception.CandyException;
import terrain.Plateau;

public class Application {
	
	public static void main(String[] args) throws CandyException
	{
		
//		Verifications verif = new Verifications();
//		verif.test();
		Plateau plateau = new Plateau("plateaux/plateau_demo.csv");
		plateau.afficherGrille();
		System.out.println("");
		plateau.decaleVersBas();
		plateau.afficherGrille();
	}
	
	
}