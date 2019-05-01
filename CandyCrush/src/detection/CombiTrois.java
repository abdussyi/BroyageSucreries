package detection;

import terrain.Case;

public class CombiTrois {
		
		
		private boolean estDetectable;

		public boolean isestDetectable() {
			return estDetectable;
		}

		public void setEstDetectable(boolean estDetectable) {
			this.estDetectable= estDetectable;
		}
		
		public void ExecuterInterface(Case[][] grille,int l, int c) {
			if (grille[l][c].getBonbon().estSpecial())
			{
				
			}
	}
}
