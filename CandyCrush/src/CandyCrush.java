import java.util.Optional;

import TypeDePartie.Partie;
import TypeDePartie.RestrictionTemps;
import exception.CandyException;
import game.Joueur;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
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
	private Joueur joueur;
	private Label score;
	private Label nbCoup;
	Partie partie;
	int minute,seconde;
	String nomPlateau;
	/**
	 * Tableau 2D d'entiers. Chaque entier correspond à l'indice d'une image (0-->Candy_0, 1-->Candy_1,...)
	 * Faudra faire mieux évidemment dans le projet...
	 */


	@Override
	public void start(Stage primaryStage) {
		try {
			
			fenetreChoixJeu();
			primaryStage.setTitle("Candy Crush");

			plateau = new Plateau("plateaux/"+nomPlateau+".csv");
			joueur = new Joueur("Samet");
			score = new Label();
			nbCoup = new Label();
			partie = new Partie(joueur,plateau,"plateaux/"+nomPlateau+".csv");
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
		hbox.getChildren().add(score);
		hbox.getChildren().add(nbCoup);
		
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

	private void fenetreChoixJeu()
	{
		TextInputDialog dialog = new TextInputDialog("plateau1");
		
		dialog.setTitle("Paramètres");
		
		dialog.setTitle("Choix du plateau");
		dialog.setHeaderText("Entrez le plateau sur lequel vous voulez jouer");
		dialog.setContentText("Entrez ici ");
		 
		Optional<String> result = dialog.showAndWait();
		 
		result.ifPresent(name -> {
		    this.nomPlateau = name;
		});
		
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


				minute = secondesEcoulees / 60;
				seconde = secondesEcoulees % 60;
				if(partie.getRestriction()!=null && partie.getRestriction().estRestrictionTemps())
				{
					RestrictionTemps temp = (RestrictionTemps) partie.getRestriction();
					temp.setSeconde(seconde);
					temp.setMinute(minute);
				}
				lChrono.setText(""+minute+"m "+seconde+"s");
				
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

		private DragDetectedEvent(){
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
			/** On échange les deux entiers, c'est tout ce que l'on fait dans la démo */
			
			try {
				plateau.echange(ls, cs, lt, ct,joueur);
				plateau.chute();
				score.setText("Votre score est : "+joueur.getScore());
				joueur.addNbDeplacement();
				nbCoup.setText("  Nombre de deplacement : "+joueur.getNbDeplacement());
				

				OutilsPlateau outils = new OutilsPlateau();
				outils.traitementPlateauAll(plateau,joueur);
				score.setText("  Votre score est : "+joueur.getScore());
				
				
				if(partie.getObjectif().objectifAtteint())
				{
					fenetreFinJeu();
				}
				else if(partie.getRestriction().restrictionsAtteinte())
				{
					fenetreFinJeu();
				}

				
				
			} catch (CandyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public void fenetreFinJeu() {
		Alert dialog = new Alert(AlertType.CONFIRMATION);

		

		if(partie.getObjectif().objectifAtteint())
		{
			dialog.setTitle("Victoire");
			dialog.setHeaderText("Félicitation ! Vous avez gagné ! Voulez-vous quitter le jeu ?");
		}
		if(partie.getRestriction().restrictionsAtteinte())
		{
			dialog.setTitle("Defaite");
			dialog.setHeaderText("Nuul ! Vous avez perdu ! Voulez-vous quitter le jeu ?");
		}

		ButtonType oui = new ButtonType("Oui");
		ButtonType non = new ButtonType("Non", ButtonData.CANCEL_CLOSE);
		dialog.getButtonTypes().setAll(oui,non);
		
		Optional<ButtonType> answer = dialog.showAndWait();
		if (answer.get() == oui) {
			Platform.exit();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
