import exception.CandyException;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import terrain.OutilsPlateau;
import terrain.Plateau;



public class CandyCrush extends Application {

	/**
	 * Cette constantes définit la durée pendant laquelle la keyframe1 sera affichée (ici, 0.1 seconde)
	 */
	private static final double TEMPS_AFFICHAGE_KEYFRAME1 = 0.1;
	
	
	/**
	 * Nombre de bonbons (candies) pris en charge pour la démo. En réalité, il y en a plus...
	 */
	private static final int NOMBRE_DE_CANDIES = 10;
	
	
	private Scene scene;
	private Pane root;

	/**
	 * Coordonnées des pixels de départ et de fin du DnD
	 */
	private int xd, yd, xf, yf;
	
	/**
	 * Un canvas pour affiche rdu graphisme (ici, des images
	 */
	private Canvas grillePane;
	private GraphicsContext gc;
	
	/**
	 * Le tableau contenant les images des bonbons
	 */
	private Image[] candies;
	
	private Timeline timeline;
	
	/**
	 * Pour la gestion et l'affichage du chrono
	 */
	private Label lChrono;
	private	int secondesEcoulees = 0;
	private Timeline timelineChrono;
	private Plateau plateau;
	/**
	 * Tableau 2D d'entiers. Chaque entier correspond à l'indice d'une image (0-->Candy_0, 1-->Candy_1,...)
	 * Faudra faire mieux évidemment dans le projet...
	 */


	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Candy Crush");

			plateau = new Plateau("plateaux/plateau5.csv");
			//plateau.decaleVersBas();
			initImagesCandies();
			
			root = new BorderPane(grillePane);
			initGrille();
			initChrono();

			scene = new Scene(root);

			initTimelineJeu();
			initTimelineChrono();

			primaryStage.setScene(scene);
			primaryStage.show();

			//faire une fonction qui dessine une classe Plateau
			demarrerPartie();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initChrono() {
		HBox hbox = new HBox();
		lChrono = new Label();
		hbox.getChildren().add(lChrono);
		((BorderPane)root).setBottom(hbox);
		
	}

	private void demarrerPartie() {
		
		dessinerPlateau();
		
		timeline.play();
		
		/**
		 * Si on veut suspendre le déroulement d'une timeline --> timeline.pause()
		 * Si on veut l'arrêter --> timeline.stop()
		 */
	}


	private void initGrille() {

		
		grillePane = new Canvas(640, 640);
		((BorderPane) root).setCenter(grillePane);

		gc = grillePane.getGraphicsContext2D();

		
		grillePane.setOnDragDetected(new DragDetectedEvent());	// Si on veut inactiver le DnD --> grillePane.setOnDragDetected(null)
		grillePane.setOnDragOver(new DragOverEvent());
		grillePane.setOnDragDropped(new DragDroppedEvent());

	}

	

	private void initTimelineChrono() {
		// Cette KeyFrame apparaît 1s après le début de la timeline
		KeyFrame k = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {


			@Override
			public void handle(ActionEvent event) {
				secondesEcoulees++;
				mettreAJourTemps();
			}

			private void mettreAJourTemps() {
				int s, m;

				m = secondesEcoulees / 60;
				s = secondesEcoulees % 60;
				lChrono.setText(""+m+"m "+s+"s");
			}
		});

		timelineChrono = new Timeline(k);
		// La timeline va boucler à l'infinie. Donc la keyframe k sera bien dclenchée toutes les secondes
		timelineChrono.setCycleCount(Animation.INDEFINITE);
		timelineChrono.play();
	}


	private void initTimelineJeu() {
		final KeyFrame keyframe1 = new KeyFrame(Duration.seconds(0), new KeyFrame1()); // Cette KF sera affichée tout de suite et restera jusqu'à la prochaine KF
		final KeyFrame keyframe2 = new KeyFrame(Duration.seconds(TEMPS_AFFICHAGE_KEYFRAME1 ), new KeyFrame2()); // Cette KF2 sera affichée après 0.1s, c'est-à-dire la durée que l'on a défini pour la KF 1
		timeline = new Timeline(keyframe1, keyframe2);
		timeline.setCycleCount(Animation.INDEFINITE); // L'animation va également boucler à l'infinie
	}

	private void dessinerPlateau() {
		int temp;
		for (int l = 0; l < 10; l++) {
			for (int c = 0; c < 10; c++) {
				temp=plateau.getGrille()[l][c].getBonbonNum();
				gc.drawImage(candies[temp], c * 64, l * 64);
			}
		}
	}

	private void initImagesCandies() {
		candies = new Image[NOMBRE_DE_CANDIES];

		try {
			for (int i = 0; i < candies.length; i++) {
				candies[i] = new Image(getClass().getResourceAsStream("/Candy_" + i + ".png"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	private final class KeyFrame2 implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {

			gc.clearRect(0, 0, 640, 640);
			// Dans cette frame, on est sensé voir des étoiles qui matérialisent la prochaine
			// disparition des bonbons (etoile = case vide)

		}
	}

	private final class KeyFrame1 implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {

			// Dans cette frame, pour la démo, on redessine la grille et c'est tout
			// Pour le projet, il y a sans doute des choses à faire pour compter les points, faire apparaître des bonbons spéciaux
			// ou autre chose encore...
			dessinerPlateau();
		}
	}

	private final class DragDetectedEvent implements EventHandler<MouseEvent> {

		private DragDetectedEvent() {
		}

		/**
		 * Début du DnD (Drag and Drop)
		 */
		public void handle(MouseEvent event) {
			Dragboard db = grillePane.startDragAndDrop(TransferMode.ANY);

			/**
			 * Coordonnées du pixel de départ
			 */
			xd = (int) event.getX();
			yd = (int) event.getY();

			int l = yd / 64;
			int c = xd / 64;

			/**
			 * On définit l'image qui va suivre la souris pendant le DnD
			 */
			db.setDragView(candies[plateau.getGrille()[l][c].getBonbonNum()]);

			ClipboardContent content = new ClipboardContent();
			content.putString("");
			db.setContent(content);

			event.consume();
		}
	}

	private final class DragOverEvent implements EventHandler<DragEvent> {

		private DragOverEvent() {
		}

		public void handle(DragEvent event) {

			event.acceptTransferModes(TransferMode.ANY);
			event.consume();
		}
	}

	private final class DragDroppedEvent implements EventHandler<DragEvent> {
		private DragDroppedEvent() {
		}

		/**
		 * Fin du Drag and Drop 
		 */
		public void handle(DragEvent event) {

			/**
			 * Coordonnées du pixel de fin
			 */
			xf = (int) event.getX();
			yf = (int) event.getY();

			echangerSourceTarget();

			event.consume();
		}

		private void echangerSourceTarget() {
			int ls = 0, cs = 0, lt = 0, ct = 0;
			/** coordonnées de la case de départ (s comme source) */
			ls = yd / 64;
			cs = xd / 64;
			
			/** coordonnées de la case d'arrivée du DnD (t comme target) */
			lt = yf / 64;
			ct = xf / 64;
			int taille = plateau.getTaille();
			/** On échange les deux entiers, c'est tout ce que l'on fait dans la démo */
			
			try {
				plateau.echange(ls, cs, lt, ct);
				plateau.decaleVersBas();
				
				//il fauudrait une fonction qui teste toutes les cases modifié
				//arretez de cherchez si aucune combinaison a ete trouvé sur toute la grille
				//cette boucle parcours tout le tableau et recherche des combi
//				for(int ligne = 0;ligne<taille;ligne++)
//				{
//					for(int colonne=0;colonne<taille;colonne++)
//					{
//						ChainsOfRespDetecteur test = new ChainsOfRespDetecteur();
//						if(test.detecteur(ligne, colonne, plateau)==true)
//						{
//							test.traitement(ligne, colonne, plateau);
//							plateau.decaleVersBas();
//						}
//
//					}
//				}
				OutilsPlateau outils = new OutilsPlateau();
				outils.traitementPlateauAll(plateau);

				
			} catch (CandyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
