import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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

	@Override
	public void start(Stage primaryStage){
		Text langara = new Text(300, 234, "LANGARA");
		langara.setFont(Font.font("The Sans", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 45));
		langara.setFill(Color.DARKORANGE);
		langara.setStroke(Color.BLACK);
		langara.setStrokeWidth(2);
		Pane root = new Pane();
		
		Rectangle sky = new Rectangle(0, 0, 800, 500);
		sky.setFill(Color.LIGHTSKYBLUE);
	
		Rectangle grass = new Rectangle(0, 333, 800, 167);
		grass.setFill(Color.DARKOLIVEGREEN);
		
		double[] bldgPoints1 = {280,167, 280,350, 600,420, 600,100 };
		double[] bldgPoints2 = {600,420, 600,100, 800,145, 800,400 };
		
		Polygon bldg1 = new Polygon(bldgPoints1);
		Polygon bldg2 = new Polygon(bldgPoints2);

		bldg1.setFill(Color.DIMGREY);
		bldg2.setFill(Color.DIMGREY);
		
		bldg1.setStroke(Color.BLACK);
		bldg2.setStroke(Color.BLACK);
		bldg1.setStrokeWidth(4);
		bldg2.setStrokeWidth(4);
		
		Human h1 = new Human(200, 310, 2, 20);
		Human h2 = new Human(150, 310, 2, 20);
		Human h3 = new Human(100, 310, 2, 20);

		Person p1 = new Person(200, 400);
		
		root.getChildren().addAll(sky, grass, bldg1, bldg2, langara, p1,h1,h2,h3);
		
		Scene scene = new Scene(root, 800, 500);
		primaryStage.setTitle("Langara");
		primaryStage.setScene(scene);
		primaryStage.show();
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
		
		public Person(int x, int y) {
			body = new Line(x, y, x, y+50);
			body.setFill(Color.BLACK);
			body.setStrokeWidth(4);
			
			double[] armPoints = {x-20,y+30, x,y+5, x+20,y+30};
			arms = new Polyline(armPoints);
			arms.setStroke(Color.BLACK);
			arms.setStrokeWidth(3);
			
			double[] legPoints = {x-20,y+80, x,y+50, x+20,y+80};
			legs = new Polyline(legPoints);
			legs.setStroke(Color.BLACK);
			legs.setStrokeWidth(3);
			
			double faceRadius = 10;
			face = new Ellipse(x, y-faceRadius, faceRadius, faceRadius + 3);
			face.setFill(Color.rgb(238, 187, 153));
			face.setStroke(Color.BLACK);
			face.setStrokeWidth(2);
			
			mouth = new Arc(x, y-4, 4, 4, 180, 180);
			mouth.setType(ArcType.CHORD);
			mouth.setStroke(Color.BLACK);
			mouth.setStrokeWidth(2);
			mouth.setFill(Color.INDIANRED);
			
			leftEye = new Line(x-5, y-18, x-5, y-10);
			rightEye = new Line(x+5, y-18, x+5, y-10);
			leftEye.setStrokeWidth(1.5);
			rightEye.setStrokeWidth(1.5);

			this.getChildren().addAll(body, arms, legs, face, mouth, leftEye, rightEye);
			
		}
	
	private class Human extends Group{
		private Line body;
		private Ellipse head;
		private Line leftArm;
		private Line rightArm;
		private Arc legs;
		
		public Human(int x, int y, int width, int height) {
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
	}
	


}
