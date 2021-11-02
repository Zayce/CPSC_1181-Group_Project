
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
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

		root.getChildren().addAll(sky, grass, bldg1, bldg2, langara);
		
		Scene scene = new Scene(root, 800, 500);
		primaryStage.setTitle("Drawing With Shapes");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	


}
