package exception;

/*
 * classe CandyException qui etends les exceptions qui va afficher l'erreur trouver
 * @author karabay
 */
public class CandyException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * methode qui envoie un message lorsque condyException apparait
	 * @param msg string qui est le message ecrit dasn les methodes qui va etre recuperer par super
	 */
	public CandyException(String msg) {
		super(msg);
	}
}
