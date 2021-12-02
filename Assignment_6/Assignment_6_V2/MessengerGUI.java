import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * @author 	Zulhelmi (Zoella) Mohamad
 * @author	Chendong (Oliver) Zhu
 * 
 * This is a GUI for the Messenger program.
 * 
 * Currently there are only 4 users that are registered, and this program does not have the functionality to add any more users.
 * We can however send and receive messages from and to the 4 different users.
 * 
 * The 4 current registered users are: A, B, Zoey & Oliver. These usernames are case sensitive.
 * 
 */

public class MessengerGUI extends Application {
	private boolean isUserSelected = false;
	private String currentUser;

	private ArrayList<Message> loadedMsgs;
	private int loadedMsgIndex = 0, loadedMsgSize = 0;

	private Text displayText = new Text("Select A User");
	private TextField chooseUserField, toUserField;
	final private Font TEXT_AREA_FONT = Font.font("Monospace"); 
	
	private Button selectUserButton, nextMsg, loadAllMsg, loadUnreadMsg, sendMsg;
	private RadioButton smile, written;
	private Messenger msngr;
	private TextArea sendMsgArea, readMsgArea;


	
	@Override
	public void start(Stage primaryStage){

		
		msngr = new Messenger();
		MessengerInit();
		Text enterUser = new Text("Enter Username");
		chooseUserField = new TextField();
		selectUserButton = new Button("Select");
		selectUserButton.setOnAction(new UsernameSelectorListener());
		
		HBox chooseUser = new HBox(5, enterUser, chooseUserField, selectUserButton);
		chooseUser.setPadding(new Insets(5));
		chooseUser.setAlignment(Pos.CENTER);
		
		readMsgArea = new TextArea("No Message Displayed");
        readMsgArea.setEditable(false);
		nextMsg = new Button("Next");
		nextMsg.setDisable(true);
		HBox loadDispBox = new HBox(5, readMsgArea, nextMsg);
		loadDispBox.setAlignment(Pos.CENTER);

		loadAllMsg = new Button("Load All Messages");
		loadUnreadMsg = new Button("Load Unread Messages");
		LoadMsgListener lml = new LoadMsgListener();
		loadAllMsg.setOnAction(lml);
		loadUnreadMsg.setOnAction(lml);
		nextMsg.setOnAction(new NextMsgListener());

		HBox loadMsgBox = new HBox(5 ,loadAllMsg, loadUnreadMsg);
		loadMsgBox.setAlignment(Pos.CENTER);
		loadMsgBox.setPadding(new Insets(10, 0, 0, 0));

		VBox readMsgBox = new VBox(5, loadDispBox, loadMsgBox);
		readMsgBox.setAlignment(Pos.CENTER);
		readMsgBox.setPadding(new Insets(5));
		
		
		toUserField = new TextField();
		toUserField.setEditable(false);
		HBox sendToBox = new HBox(2, new Text("To"), toUserField);
		sendMsgArea = new TextArea();
		sendMsgArea.setEditable(false);
		
		sendMsgArea.setFont(TEXT_AREA_FONT);
		readMsgArea.setFont(TEXT_AREA_FONT);
		toUserField.setFont(TEXT_AREA_FONT);
		chooseUserField.setFont(TEXT_AREA_FONT);
		

		ToggleGroup msgStyleGroup = new ToggleGroup();
		smile = new RadioButton("Smile");
		written = new RadioButton("Written");
		smile.setToggleGroup(msgStyleGroup);
		written.setToggleGroup(msgStyleGroup);
		written.setSelected(true);
		MsgOptionListener mol = new MsgOptionListener();
		smile.setOnAction(mol);
		written.setOnAction(mol);
		
		sendMsg = new Button("Send");
		sendMsg.setOnAction(new SendMsgListener());
		
		HBox msgOptionBox = new HBox(2, new Text("Message Type"), smile, written, sendMsg);
		HBox.setMargin(sendMsg, new Insets(0,0, 0,60));
		msgOptionBox.setAlignment(Pos.CENTER);

		VBox sendMsgBox = new VBox(2, sendToBox, sendMsgArea, msgOptionBox);
		sendMsgBox.setAlignment(Pos.CENTER);
		sendMsgBox.setPadding(new Insets(5));
		
		Tab chooseUserTab, readMsgTab, sendMsgTab;
		chooseUserTab = new Tab("Choose User", chooseUser);
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
	
	private void MessengerInit() {
		msngr.addUser("A");
		msngr.addUser("B");
		msngr.addUser("Zoey");
		msngr.addUser("Oliver");
		
		msngr.sendMessage("Zoey", "Oliver", "Foo");
		msngr.sendMessage("Zoey", "Oliver", "Bar");
		msngr.sendMessage("Oliver", "Zoey", "Marco Polo");
		msngr.sendMessage("Zoey", "Oliver", "I don't think I did well on the 2nd Midterm, I didn't finish the coding part :(");
		
		msngr.sendMessage("A", "B", "Hello B, this is A");
		msngr.sendMessage("A", "B", "Hello B, this is still A");
		msngr.sendMessage("B", "A", "Hi A, I am a human, just like you.");


	}
	
	private class UsernameSelectorListener implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			
			if(chooseUserField.getText().equals("")) {
				return;
			}
			else {
				currentUser = chooseUserField.getText();
			}
			
			if(msngr.getUserList().contains(currentUser)){
				displayText.setText("Current User: " + currentUser);
				isUserSelected = true;
				readMsgArea.setText("No Message Displayed");
				toUserField.setEditable(true);
				sendMsgArea.setEditable(true);
				
			}
			else {
				displayText.setText("Incorrect Username");
				readMsgArea.setText("No Message Displayed");
				nextMsg.setDisable(true);
				sendMsgArea.setEditable(false);
				toUserField.setEditable(false);
			}
		}
	}
	
	private class LoadMsgListener implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {
			
			if(!isUserSelected || (currentUser == null) || currentUser.equals("")) {
				return;
			}
			else {
				nextMsg.setDisable(false);
			}
			
			if(e.getSource() == loadAllMsg) {
				loadedMsgs = msngr.getReceivedMessages(currentUser);
			}
			else if(e.getSource() == loadUnreadMsg){
				loadedMsgs = msngr.getReceivedMessages(currentUser, Message.Status.unread);
			}
			
			loadedMsgIndex = 0;
			loadedMsgSize = loadedMsgs.size();
			displayText.setText(loadedMsgSize + " message(s) loaded");
			
			if (loadedMsgSize <= 0) {
				readMsgArea.setText("No Message Displayed");
				nextMsg.setDisable(true);
			}
			else {
				readMsgArea.setText(loadedMsgs.get(loadedMsgIndex).toString()); 
				if (loadedMsgSize > 1) {
					nextMsg.setDisable(false);
				}
				else {
					nextMsg.setDisable(true);
				}
			}
		}	
	}

	private class NextMsgListener implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			loadedMsgIndex++;
			loadedMsgSize--;

			if(loadedMsgIndex >= loadedMsgs.size()) {
				nextMsg.setDisable(true);
			}
			else {
				nextMsg.setDisable(false);
				readMsgArea.setText(loadedMsgs.get(loadedMsgIndex).toString()); 
				
				if((loadedMsgIndex + 1) >= loadedMsgs.size()){
					nextMsg.setDisable(true);
				}
			}
			

		}
	}
	
	private class MsgOptionListener implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {

			if(e.getSource() == smile) {
				sendMsgArea.setEditable(false);
				sendMsgArea.setText(SmileMessage.smile);
			}
			else if (e.getSource() == written){
				sendMsgArea.setEditable(true);
				sendMsgArea.setText("");
			}
			
		}
		
	}
	
	private class SendMsgListener implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {
			String sendTo, sendMsg;
			sendTo = toUserField.getText();
			
			if(sendTo == null || sendTo.equals("")) {
				return;
			}
			
			if(msngr.getUserList().contains(sendTo)) {
				if(smile.isSelected()) {
					msngr.sendSmile(currentUser, sendTo);
					displayText.setText("Smile Successfully Sent");
				}
				else if(written.isSelected()) {
					sendMsg = sendMsgArea.getText();
					msngr.sendMessage(currentUser, sendTo, sendMsg);
					displayText.setText("Message Successfully Sent");
				}
			}
			else {
				displayText.setText("Recipient Username Not Found");
			}
			



		}
	}

}