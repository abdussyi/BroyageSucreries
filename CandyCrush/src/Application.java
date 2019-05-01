import java.io.IOException;

import terrain.Plateau;

public class Application {
	
	public static void main(String[] args)
	{
		Plateau plateau = new Plateau("/Users/abduss/Documents/BPOO/plateaux/plateau1.csv");
		plateau.afficherGrille();
	}
		
	
}