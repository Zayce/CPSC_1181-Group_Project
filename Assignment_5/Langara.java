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

public class Langara extends Application {
	
	private final int BG_WIDTH = 800;
	private final int BG_HEIGHT = 500;
	
	private ArrayList<Person> people;
	
	final private double MIN_SIZE = 0.666;
	final private double MAX_SIZE = 1.332;

	private CheckBox buildingCB, pathCB, peopleCB;
	private RadioButton narrowRB, wideRB, shortRB, tallRB;
	private Building bd;
	private Path pt;
	private Button randommize, createNew, clear;
	private Pane picture;
		
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
		picture.getChildren().addAll(people);
		
		
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
			
					randommize = new Button("Randomize");
					createNew = new Button("Create New");
					clear = new Button("Clear");

				VBox buttonGroup = new VBox(5, randommize, createNew, clear);
				buttonGroup.setPrefWidth(100);
				randommize.setMinWidth(buttonGroup.getPrefWidth());
				createNew.setMinWidth(buttonGroup.getPrefWidth());
				clear.setMinWidth(buttonGroup.getPrefWidth());
				
				PersonCreatorListener pCL = new PersonCreatorListener();
				narrowRB.setOnAction(pCL);
				wideRB.setOnAction(pCL);
				shortRB.setOnAction(pCL);
				tallRB.setOnAction(pCL);
				randommize.setOnAction(pCL);
				createNew.setOnAction(pCL);
				clear.setOnAction(pCL);
				
	
			HBox foreGroundController = new HBox(15, widthGroup, heightGroup, buttonGroup);
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
	
	private class Path extends Group {
		Polyline path;
		Line divider1;
		double[] pathPoints = {0,360, 100,370, 200,390, 300,430, 450,500, 
							   300,500, 200,460, 100,420, 0,400};		
		public Path() {
			path  = new Polyline(pathPoints);
			path.setStroke(Color.BLACK);
			path.setStrokeWidth(1.5);
			path.setFill(Color.rgb(155, 118, 83));
			
			divider1 = new Line(35,380, 135,400);
			divider1.setStroke(Color.ANTIQUEWHITE);
			path.setStrokeWidth(1.5);
			this.getChildren().addAll(path, divider1);

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
			if (e.getSource() == pathCB) {
				if(pathCB.isSelected()) {
					pt.setVisible(true);
				}
				else {
					pt.setVisible(false);
				}
			}
			if(e.getSource() == peopleCB){
				if(peopleCB.isSelected()) {
					for(int i = 0; i < people.size(); i++) {
						people.get(i).setVisible(true);
					}
				}
				else {
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
			double width, height;
			
			if(e.getSource() == randommize) {
				if(people != null && people.size() > 0) {
					people.clear();
				}
				randomObjNumDecider();
			}
			else if(e.getSource() == createNew){
				
				if(narrowRB.isSelected()) {
					width = MIN_SIZE;
				}
				else if(wideRB.isSelected()) {
					width = MAX_SIZE;
				}
				else {
					width = 1; //Could happen if no radio button is selected.
				}
				
				if(shortRB.isSelected()) {
					height = MIN_SIZE;
				}
				else if(tallRB.isSelected()) {
					height = MAX_SIZE;
				}
				else {
					height = 1;
				}
				
				Person p = new Person(randomPos(true), randomPos(false), width, height);
				p.setVisible(false);
				picture.getChildren().add(p);
				people.add(p);
			}
			else {
				if(people != null && people.size() > 0) {
					picture.getChildren().removeAll(people);
					people.clear();
				}			
			}
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
			people.add(new Person());
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
	
}
