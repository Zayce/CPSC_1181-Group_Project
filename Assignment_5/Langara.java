import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author 	Zulhelmi (Zoella) Mohamad
 * @author	Chendong (Oliver) Zhu
 * 
 * Program will start with only sky and grass showing.
 * Users can click on the checkboxes above to show/hide a pathway, the Langara building and people.
 * 
 * The sizes are scaled to the original person size.
 * 
 * The original number of people will be zero, so users can add people of different dimensions by the controls below the picture.
 * The controls will let the users change the width and height to be narrow, wide, short or tall and in any other combinations.
 * The user can only decide from MIN_SIZE, MAX_SIZE or 1 size scaling in width and height dimensions. 
 * 1 is the default size if no radio buttons are selected.
 * 
 * If the people checkbox isn't ticked, there will stil be persons added, however they are hidden.
 * 
 * If the user cannot decide how many and what sizes to add, they can add a randomize button that will randomly create between 2-8 persons.
 * The sizes for the random are continuous and range from MIN_SIZE to MAX_SIZE.
 * 
 * You can create additional persons on top of random, but not in reverse.
 * This is because on every click of Random, it clears the people, and randomly adds a new set of person.
 * 
 * The positions for any of the options are random and bounded from the anchor point of the upper most part of the neck. 
 * This is bounded by the background size.
 * 
 * If the number of persons are too much, the user can press the clear button to remove all created persons.
 */

public class Langara extends Application {
	
	private final int BG_WIDTH = 800;
	private final int BG_HEIGHT = 500;
	
	private ArrayList<Person> people;
	
	final private double MIN_SIZE = 0.666;
	final private double MAX_SIZE = 1.332;
	
	private double personWidth, personHeight;

	private CheckBox buildingCB, pathCB, peopleCB;
	private RadioButton narrowRB, wideRB, shortRB, tallRB;
	private Building bd;
	private Path pt;
	private Button randommize, createNew, clear;
	private Pane picture;
	
	private boolean isPersonVisible = false;
		
	@Override
	public void start(Stage primaryStage){
		
		//=======Top Part========//
			Text backgroundTxt = new Text("Background");
					
					buildingCB = new CheckBox("Building");
					pathCB = new CheckBox("Path");
					peopleCB = new CheckBox("Person");
					
					ObjShowListener oSL = new ObjShowListener();
					buildingCB.setOnAction(oSL);
					pathCB.setOnAction(oSL);
					peopleCB.setOnAction(oSL);

				HBox backgroundObjController = new HBox(10, buildingCB, pathCB, peopleCB);	
			backgroundObjController.setAlignment(Pos.CENTER);
		
		VBox backgroundController = new VBox(10, backgroundTxt, backgroundObjController);
		backgroundController.setAlignment(Pos.CENTER);
		backgroundController.setPadding(new Insets(5));
		
		//=======Centre Part========//
			picture = new Pane();
			picture.setPrefWidth(800);
			picture.setPrefHeight(500);
			Rectangle sky = new Rectangle(0, 0, 800, 500);
			sky.setFill(Color.LIGHTSKYBLUE);
			Rectangle grass = new Rectangle(0, 333, 800, 167);
			grass.setFill(Color.DARKOLIVEGREEN);
			
			bd = new Building();
			pt = new Path();

		bd.setVisible(false);
		pt.setVisible(false);
		
		people = new ArrayList<Person>();
				
		picture.getChildren().addAll(sky, grass, bd, pt);
		
		
		Rectangle clip = new Rectangle(0,0,800,500);
		picture.setClip(clip);
		
		//=======Bottom Part========//
			Text addPerson = new Text("Add a person");
			
					Text widthRBText = new Text("Width");
					narrowRB = new RadioButton("Narrow");
					wideRB = new RadioButton("Wide");
					ToggleGroup widthRBGroup = new ToggleGroup();
					narrowRB.setToggleGroup(widthRBGroup);
					wideRB.setToggleGroup(widthRBGroup);
				VBox widthGroup = new VBox(5, widthRBText, narrowRB, wideRB);
			
					Text heightRBText = new Text("Height");
					shortRB = new RadioButton("Short");
					tallRB = new RadioButton("Tall");
					ToggleGroup heightRBGroup = new ToggleGroup();
					shortRB.setToggleGroup(heightRBGroup);
					tallRB.setToggleGroup(heightRBGroup);
				VBox heightGroup = new VBox(5, heightRBText, shortRB, tallRB);
			
					createNew = new Button("Create New");
					clear = new Button("Clear");

				VBox buttonGroup = new VBox(5, createNew, clear);
				randommize = new Button("Randomize");
				buttonGroup.setPrefWidth(100);
				randommize.setMinWidth(buttonGroup.getPrefWidth());
				randommize.setMinHeight(60);
				createNew.setMinWidth(buttonGroup.getPrefWidth());
				clear.setMinWidth(buttonGroup.getPrefWidth());
				
				Line divider = new Line(0, 0, 0, 60);
				divider.setStroke(Color.LIGHTGREY);
				divider.setStrokeWidth(3);
				
				PersonSizeListener pSL = new PersonSizeListener();
				narrowRB.setOnAction(pSL);
				wideRB.setOnAction(pSL);
				shortRB.setOnAction(pSL);
				tallRB.setOnAction(pSL);
				
				PersonCreatorListener pCL = new PersonCreatorListener();
				randommize.setOnAction(pCL);
				createNew.setOnAction(pCL);
				clear.setOnAction(pCL);
				
	
			HBox foreGroundController = new HBox(15, widthGroup, heightGroup, buttonGroup, divider, randommize);
			foreGroundController.setAlignment(Pos.CENTER);
			foreGroundController.setPadding(new Insets(5));

		VBox foreGroundOptions = new VBox(10, addPerson, foreGroundController);
		foreGroundOptions.setAlignment(Pos.CENTER);
		foreGroundOptions.setPadding(new Insets(5));
				
		//=======Border Pane========//
		
		BorderPane root = new BorderPane();
		root.setTop(backgroundController);
		root.setCenter(picture);
		root.setBottom(foreGroundOptions);
		
		//================//
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Langara");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private class Person extends Group {
		private Line body;
		private Polyline arms;
		private Polyline legs;
		private Ellipse face;
		private Arc mouth;
		private Line leftEye;
		private Line rightEye;
		
		
		public Person() {
			this(randomPos(true), randomPos(false), ranSize(MIN_SIZE, MAX_SIZE));
		}
		
		/**
		 * Defined constructor for person
		 * 
		 * @param x: x-coordinate
		 * @param y: y-coordinate 
		 * @param w: width
		 * @param h: height
		 */
		public Person(int x, int y, double w, double h) {
			double strokeWidthScale = (w+h)/2;
			//Starting line of the body is the anchor point when we scale. 
			body = new Line(x, y, x, y+(h*50));
			body.setFill(Color.BLACK);
			body.setStrokeWidth(strokeWidthScale*4);
			
			double[] armPoints = {x-(w*20),y+(h*30), x,y+(h*5), x+(w*20),y+(h*30)};
			arms = new Polyline(armPoints);
			arms.setStroke(Color.BLACK);
			arms.setStrokeWidth(strokeWidthScale*3);
			
			double[] legPoints = {x-(w*20),y+(h*80), x, y+(h*50), x+(w*20),y+(h*80)};
			legs = new Polyline(legPoints);
			legs.setStroke(Color.BLACK);
			legs.setStrokeWidth(strokeWidthScale*3);
			
			double faceRadius = 10;
			face = new Ellipse(x, y-(h*faceRadius), w*faceRadius, h*(faceRadius + 3));
			face.setFill(Color.rgb(238, 187, 153));
			face.setStroke(Color.BLACK);
			face.setStrokeWidth(strokeWidthScale*2);
			
			mouth = new Arc(x, y-(h*4) , w*4, h*4, 180, 180);
			mouth.setType(ArcType.CHORD);
			mouth.setStroke(Color.BLACK);
			mouth.setStrokeWidth(strokeWidthScale*2);
			mouth.setFill(Color.INDIANRED);
			
			leftEye = new Line(x-(w*5), y-(h*18), x-(w*5), y-(h*10));
			rightEye = new Line(x+(w*5), y-(h*18), x+(w*5), y-(h*10));
			leftEye.setStrokeWidth(strokeWidthScale*1.5);
			rightEye.setStrokeWidth(strokeWidthScale*1.5);

			this.getChildren().addAll(body, arms, legs, face, mouth, leftEye, rightEye);
		}
		public Person(int x, int y) {
			this(x,y, 1, 1);
		}
		public Person(int x, int y, double s) {
			this(x,y, s, s);
		}
	}
	
	private class Path extends Group {
		Polyline path1, path2;
		double[] pathPoints1 = {0,360, 100,370, 180,390, 150,400, 190,460, 160,450, 120,430, 0,400};
		double[] pathPoints2 = {450,500, 300,430, 200,390, 172,412, 200,460, 240,480, 300,500};
		
		public Path() {
			path1 = new Polyline(pathPoints1);
			path2 = new Polyline(pathPoints2);
			
			path1.setStroke(Color.BLACK);
			path1.setStrokeWidth(1.5);
			path1.setFill(Color.rgb(155, 118, 83));
			path1.setStrokeWidth(1.5);
			path2.setStroke(Color.BLACK);
			path2.setStrokeWidth(1.5);
			path2.setFill(Color.rgb(155, 118, 83));
			path2.setStrokeWidth(1.5);
			
			this.getChildren().addAll(path1, path2);
		}
	}
	
	private class Building extends Group {
		Polygon bldgLeft, bldgRight;
		Text langaraLogo;
		
		double[] bldgLeftPoints = {280,167, 280,350, 600,420, 600,100 };
		double[] bldgRightPoints = {600,420, 600,100, 800,145, 800,400 };
		
		public Building() {
			bldgLeft = new Polygon(bldgLeftPoints);
			bldgRight = new Polygon(bldgRightPoints);

			bldgLeft.setFill(Color.DIMGREY);
			bldgRight.setFill(Color.DIMGREY);
			
			bldgLeft.setStroke(Color.BLACK);
			bldgRight.setStroke(Color.BLACK);
			
			bldgLeft.setStrokeWidth(3);
			bldgRight.setStrokeWidth(3);
			
			langaraLogo = new Text(300, 234, "LANGARA");
			langaraLogo.setFont(Font.font("The Sans", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 45));
			langaraLogo.setFill(Color.DARKORANGE);
			langaraLogo.setStroke(Color.BLACK);
			langaraLogo.setStrokeWidth(2);
			
			this.getChildren().addAll(bldgLeft, bldgRight, langaraLogo);
		}
	}
	
	private class ObjShowListener implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {
			if(e.getSource() == buildingCB) {
				if(buildingCB.isSelected()) {
					bd.setVisible(true);
				}
				else {
					bd.setVisible(false);
				}
			}
			else if (e.getSource() == pathCB) {
				if(pathCB.isSelected()) {
					pt.setVisible(true);
				}
				else {
					pt.setVisible(false);
				}
			}
			else if(e.getSource() == peopleCB){
				if(peopleCB.isSelected()) {
					isPersonVisible = true;
					for(int i = 0; i < people.size(); i++) {
						people.get(i).setVisible(true);
					}
				}
				else {
					isPersonVisible = false;
					for(int i = 0; i < people.size(); i++) {
						people.get(i).setVisible(false);
					}				
				}			
			}
		}
	}
	
	private class PersonCreatorListener implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {
			double w, h;
			
			if(e.getSource() == createNew){
				WidthHeightDecider();
				Person p = new Person(randomPos(true), randomPos(false), personWidth, personHeight);
				if(isPersonVisible) {
					p.setVisible(true);
				}
				else {
					p.setVisible(false);
				}
				picture.getChildren().add(p);
				people.add(p);
			}
			else if(e.getSource() == clear) {
				if(people != null && people.size() > 0) {
					picture.getChildren().removeAll(people);
					people.clear();
				}			
			}
			else if(e.getSource() == randommize){
				if(people != null && people.size() > 0) {
					picture.getChildren().removeAll(people);
					people.clear();
				}
				randomObjNumDecider();
				picture.getChildren().addAll(people);
			}
		}

	}
	
	private class PersonSizeListener implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			WidthHeightDecider();	
		}
		
	}
	
	private void WidthHeightDecider() {
		if(narrowRB.isSelected()) {
			this.personWidth = MIN_SIZE;
		}
		else if(wideRB.isSelected()) {
			this.personWidth = MAX_SIZE;
		}
		else {
			this.personWidth = 1;
		}
		
		if(shortRB.isSelected()) {
			this.personHeight = MIN_SIZE;
		}
		else if(tallRB.isSelected()) {
			this.personHeight = MAX_SIZE;
		}
		else {
			this.personHeight = 1;
		}	
	}
	
	/*
	 * Initialize random number of object created, their positions and size.
	 */			
	public void randomObjNumDecider() {
		double ranNumFGObjProb;
		int numberOfObjects;
	
		Random rand = new Random();

		this.people = new ArrayList<Person>();
		
		//Sets the number of objects created. Probability of creating n object is half the probability of creating (n-1) objects until 8 people
		ranNumFGObjProb = rand.nextDouble();
		if((0.00000000 <= ranNumFGObjProb) && (ranNumFGObjProb < 0.5)) {
			numberOfObjects = 2;
		}
		else if((0.5 <= ranNumFGObjProb) && (ranNumFGObjProb < 0.75)) {
			numberOfObjects = 3;
		}
		else if((0.75 <= ranNumFGObjProb) && (ranNumFGObjProb < 0.875)) {
			numberOfObjects = 4;
		}
		else if((0.875 <= ranNumFGObjProb) && (ranNumFGObjProb < 0.9375)) {
			numberOfObjects = 5;
		}
		else if((0.9375 <= ranNumFGObjProb) && (ranNumFGObjProb < 0.96875)) {
			numberOfObjects = 6;
		}
		else if((0.96875 <= ranNumFGObjProb) && (ranNumFGObjProb < 0.984375)) {
			numberOfObjects = 7;
		}
		else{
			numberOfObjects = 8;
		}
		
		//Sets a random position for each object
		for(int i = 0; i < numberOfObjects; i++) {
			Person p = new Person();
			if(isPersonVisible) {
				p.setVisible(true);
			}
			else {
				p.setVisible(false);
			}
			people.add(p);
		}
		
	} 
	
	
	/**
	 * A method to return a random position within background's width and height
	 * 
	 * @param isWidth: To know if the Random position is the x or y coordinate
	 * @return 	For Width, returns int vlues of 0 to BG_WIDTH (Width of background)
	 * 			For Height, returns int values of 0 to BG_HEIGHT (Height of Background)
	 */
	public int randomPos(boolean isWidth) {
		Random ranPosSeed = new Random();

		if(isWidth) {
			return ranPosSeed.nextInt(BG_WIDTH);
		}
		else {
			return ranPosSeed.nextInt(BG_HEIGHT);
		}
	}
	
	/**
	 * Generates random size from min to max
	 * 
	 * @param min: Min size possible for an object
	 * @param max: Max size possible for an object
	 * @return Random double size from min to max
	 */
	public double ranSize(double min, double max) {
		Random ranSizeSeed = new Random();
		return (min + (max*ranSizeSeed.nextDouble()));
	}
	
	/**
	 * Below group not used as I (Zoella) did not create it, and I did not understand it.
	 */
	private class Human extends Group{
		private Line body;
		private Ellipse head;
		private Line leftArm;
		private Line rightArm;
		private Arc legs;
		
		// default constructor
		// student got 0 on the final
		public Human() {
			int x = 600;
			int y = 70;
			int height = 20;
			int width = 2;
			head = new Ellipse(x, y-height/4, height/2, height/4);
			head.setFill(Color.BLACK);
			
			body = new Line(x,y,x,y+height);
			body.setStroke(Color.BLACK);
			body.setStrokeWidth(width);
			
			leftArm = new Line(x-width/2,y,x-height/2, y+height/2);
			leftArm.setStroke(Color.BLACK);
			leftArm.setStrokeWidth(width/2);
			
			rightArm = new Line(x+width/2,y,x+height/2, y+height/2);
			rightArm.setStroke(Color.BLACK);
			rightArm.setStrokeWidth(width/2);
			
			legs = new Arc(x,y+height+height/2,(height+width)/3,height/2,0,180);
			legs.setType(ArcType.OPEN);
			legs.setFill(Color.TRANSPARENT);
			legs.setStroke(Color.BLACK);
			
			this.getChildren().addAll(body,head,leftArm,rightArm,legs);
		}
		
		public Human(int x, int y, int width, int height) {
			head = new Ellipse(x, y-height/4.0, height/2.0, height/4.0);
			head.setFill(Color.BLACK);
			
			body = new Line(x,y,x,y+height);
			body.setStroke(Color.BLACK);
			body.setStrokeWidth(width);
			
			leftArm = new Line(x-width/2.0,y,x-height/2.0, y+height/2.0);
			leftArm.setStroke(Color.BLACK);
			leftArm.setStrokeWidth(width/2);
			
			rightArm = new Line(x+width/2.0,y,x+height/2.0, y+height/2.0);
			rightArm.setStroke(Color.BLACK);
			rightArm.setStrokeWidth(width/2);
			
			legs = new Arc(x,y+height+(height+width)/2.0,(height+width)/3.0,(height+width)/2.0,0,180);
			legs.setType(ArcType.OPEN);
			legs.setFill(Color.TRANSPARENT);
			legs.setStroke(Color.BLACK);
			
			this.getChildren().addAll(body,head,leftArm,rightArm,legs);
		}
	}
}