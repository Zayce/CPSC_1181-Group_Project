import java.util.ArrayList;
import java.util.Random;

import javax.swing.RootPaneContainer;

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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * @author 	Zulhelmi (Zoella) Mohamad
 * @author	Chendong (Oliver) Zhu
 * 
 */

public class MessengerGUI extends Application {
	private boolean isUserSelected = false;
	private ArrayList<String> userNames;
//	final private Font TEXT_AREA_FONT = Font.font(MONOSPACE); //TODO: FIX THIS
	
	@Override
	public void start(Stage primaryStage){
//		Font.getFamilies(); TODO: IDK WHY FONT DONT WORK
//		TEXT_AREA_FONT = 


		
		Text enterUser = new Text("Enter Username");
		TextField chooseUserField = new TextField();
		Button selectUserButton = new Button("Select");
		HBox chooseUserBox = new HBox(5, enterUser, chooseUserField, selectUserButton);
		chooseUserBox.setPadding(new Insets(5));
		chooseUserBox.setAlignment(Pos.CENTER);
		
		TextArea readMsgArea = new TextArea("No Message Displayed");
		readMsgArea.setEditable(false);
		
		Button loadAllMsg = new Button("Load All Messages");
		Button loadUnreadMsg = new Button("Load Unread Messages");
		HBox loadMsgBox = new HBox(loadAllMsg, loadUnreadMsg);
		VBox loadDispBox = new VBox(readMsgArea, loadMsgBox);
		loadMsgBox.setAlignment(Pos.CENTER);
		

		
		Button nextMsg = new Button("Next");
		nextMsg.setDisable(true);
		 
		HBox readMsgBox = new HBox(5, loadDispBox, nextMsg);
		readMsgBox.setAlignment(Pos.CENTER);
		readMsgBox.setPadding(new Insets(5));
		
		
		TextField toUserField = new TextField();
		HBox sendToBox = new HBox(2, new Text("To"), toUserField);
		TextArea sendMsgArea = new TextArea();
		
		ToggleGroup msgStyleGroup = new ToggleGroup();
		RadioButton smile = new RadioButton("Smile");
		RadioButton written = new RadioButton("Written");
		smile.setToggleGroup(msgStyleGroup);
		written.setToggleGroup(msgStyleGroup);
		written.setSelected(true);
		
		Button sendMsg = new Button("Send");

		
		HBox msgOptionBox = new HBox(2, new Text("Message Type"), smile, written, sendMsg);
		msgOptionBox.setMargin(sendMsg, new Insets(0,0, 0, 60));
		msgOptionBox.setAlignment(Pos.CENTER);

		VBox sendMsgBox = new VBox(2, sendToBox, sendMsgArea, msgOptionBox);
		sendMsgBox.setPadding(new Insets(5));
		
		
		
		Text displayText = new Text("Select A User");
		
		Tab chooseUserTab, readMsgTab, sendMsgTab;
		chooseUserTab = new Tab("Choose User", chooseUserBox);
		readMsgTab = new Tab("Read Message", readMsgBox);
		sendMsgTab = new Tab("Send Message", sendMsgBox);
		
		TabPane optionTabs = new TabPane(chooseUserTab, readMsgTab, sendMsgTab);
		optionTabs.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		
		BorderPane root = new BorderPane();
		root.setTop(displayText);
		root.setCenter(optionTabs);
		BorderPane.setAlignment(displayText, Pos.CENTER);
		BorderPane.setAlignment(optionTabs, Pos.CENTER);

		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Messenger GUI");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
}