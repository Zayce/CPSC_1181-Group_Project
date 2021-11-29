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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import Messenger;

/**
 * @author 	Zulhelmi (Zoella) Mohamad
 * @author	Chendong (Oliver) Zhu
 * 
 */

public class MessengerGUI extends Application {
	private boolean isUserSelected = false;
	private String currentUser;

	private ArrayList<String> userNames;
	private Text displayText = new Text("Select A User");
	private TextField chooseUserField;
	private Messenger messenger;
//	final private Font TEXT_AREA_FONT = Font.font(MONOSPACE); //TODO: FIX THIS
	
	private Button selectUserButton, nextMsg, loadAllMsg, loadUnreadMsg, sendMsg;
	private Messenger msngr;
	
	@Override
	public void start(Stage primaryStage){
//		Font.getFamilies(); TODO: IDK WHY FONT DONT WORK
//		TEXT_AREA_FONT = 
/
		
		messenger = new Messenger();
		Text enterUser = new Text("Enter Username");
		chooseUserField = new TextField();
		Button selectUserButton = new Button("Select");
		
		selectUserButton.setOnAction(new UsernameEventHandler());
		
		HBox chooseUser = new HBox(5, enterUser, chooseUserField, selectUserButton);
		chooseUser.setPadding(new Insets(5));
		chooseUser.setAlignment(Pos.CENTER);
		
		TextArea readMsgArea = new TextArea("No Message Displayed");
        readMsgArea.setEditable(false);
		nextMsg = new Button("Next");
		nextMsg.setDisable(true);
		HBox loadDispBox = new HBox(5, readMsgArea, nextMsg);
		loadDispBox.setAlignment(Pos.CENTER);

		loadAllMsg = new Button("Load All Messages");
		loadUnreadMsg = new Button("Load Unread Messages");
		ReadMsgButtonListener rmbl = new ReadMsgButtonListener();
		loadAllMsg.setOnAction(rmbl);
		loadUnreadMsg.setOnAction(rmbl);

		HBox loadMsgBox = new HBox(5 ,loadAllMsg, loadUnreadMsg);
		loadMsgBox.setAlignment(Pos.CENTER);
		loadMsgBox.setPadding(new Insets(10, 0, 0, 0));

		VBox readMsgBox = new VBox(5, loadDispBox, loadMsgBox);
		readMsgBox.setAlignment(Pos.CENTER);
		readMsgBox.setPadding(new Insets(5));
		
		
		
		
		
		TextField toUserField = new TextField();
		HBox sendToBox = new HBox(2, new Text("To"), toUserField);
		TextArea sendMsgArea = new TextArea();
		sendMsgArea.setDisable(true);
		
		ToggleGroup msgStyleGroup = new ToggleGroup();
		RadioButton smile = new RadioButton("Smile");
		RadioButton written = new RadioButton("Written");
		smile.setToggleGroup(msgStyleGroup);
		written.setToggleGroup(msgStyleGroup);
		written.setSelected(true);
		
		sendMsg = new Button("Send");

		
		HBox msgOptionBox = new HBox(2, new Text("Message Type"), smile, written, sendMsg);
		HBox.setMargin(sendMsg, new Insets(0,0, 0,60));
		msgOptionBox.setAlignment(Pos.CENTER);

		
		
		
		Tab chooseUserTab, readMsgTab, sendMsgTab;
		chooseUserTab = new Tab("Choose User", chooseUser);
		readMsgTab = new Tab("Read Message", readMsg);
		sendMsgTab = new Tab("Send Message", sendMsg);
		
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
	
	private class ReadMsgButtonListener implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {
			if(!isUserSelected) {
				return;
			}
			else if(e.getSource() == loadAllMsg) {
				msngr.getReceivedMessages(currentUser);
			}
			else {
				msngr.getReceivedMessages(currentUser, Message.Status.unread);
			}
			
		}
		
	}

	public class UsernameEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			displayText.setText("Incorrect Username");
			String input = chooseUserField.getText();
			for (String x: messenger.getUserList()){
				System.out.println(x);
				System.out.println(input);
				System.out.println(input == x);
				if (x == input) {
					displayText.setText("Current user: " + input);
					System.out.println("Name changed");
					break;
				}
			}
		}
	}
	
	
}