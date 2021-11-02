
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Langara extends Application {

	@Override
	public void start(Stage primaryStage){
		Text langara = new Text(400, 250, "LANGARA");
		langara.setFill(Color.DARKORANGE);
		langara.setStroke(Color.BLACK);
		langara.setStrokeWidth(1.5);
		Pane root = new Pane();
		
		Rectangle sky = new Rectangle(0, 0, 800, 500);
		
		sky.setFill(Color.LIGHTSKYBLUE);
	
		Rectangle pavement = new Rectangle(0, 333, 800, 167);
		pavement.setFill(Color.LIGHTGREY);

		
		root.getChildren().addAll(sky, pavement, langara);
		
		
		
		
		Scene scene = new Scene(root, 800, 500);
		primaryStage.setTitle("Drawing With Shapes");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	


}
