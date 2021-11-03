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
		Human h0 = new Human();

		Person p1 = new Person(100, 400, 1);
		Person p2 = new Person(200, 200, 2);
		Person p3 = new Person(450, 400, 0.5);
		
		root.getChildren().addAll(sky, grass, bldg1, bldg2, langara, p1, p2, p3, h1, h2, h3, h0);
		
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
}
