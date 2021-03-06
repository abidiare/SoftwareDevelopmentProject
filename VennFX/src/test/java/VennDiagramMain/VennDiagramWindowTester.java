package VennDiagramMain;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VennDiagramWindowTester extends ApplicationTest {

	@FXML
	public Text filler, filler2;

	@FXML
	public ColorPicker color1;

	@FXML
	public ColorPicker color2;

	@FXML
	public TextField textField;

	@FXML
	public TextField title1;

	@FXML
	public TextField title2;

	@FXML
	public StackPane stackPane;

	@FXML
	public Circle circle1;

	@FXML
	public Circle circle2;

	@FXML
	public Button entryButton;

	@FXML
	public Button title1Button;

	@FXML
	public Button title2Button;

	@FXML
	public Button change1Button;

	@FXML
	public Button change2Button;

	@FXML
	public Button exportButton;

	@FXML
	public Button clearButton;

	VennDiagramWindowController controller;

	@Before
	public void setUpClass() throws Exception {
		System.setProperty("testfx.robot", "glass");
		System.setProperty("testfx.headless", "true");
		System.setProperty("prism.order", "sw");
		System.setProperty("prism.text", "t2k");
		System.setProperty("java.awt.headless", "true");

		ApplicationTest.launch(VennDiagramWindowMain.class);
	}
//
//	/* This operation comes from ApplicationTest and loads the GUI to test. */
//	public void start(Stage primaryStage) throws IOException {
//		Parent VennDiagramWindow = FXMLLoader.load(getClass().getResource("VennDiagramWindowView.fxml"));
//		primaryStage.setScene(new Scene(VennDiagramWindow));
//		primaryStage.show();
//		primaryStage.toFront();
//	}
//
//	/* Just a shortcut to retrieve widgets in the GUI. */
//	public <T extends Node> T find(final String query) {
//		/** TestFX provides many operations to retrieve elements from the loaded GUI. */
//		return lookup(query).query();
//	}
//
//	@Before
//	public void setUp() throws Exception {
//		// THESE ARE THE NAMES OF YOUR @FXML FIELDS
//
//		color1 = find("#color1");
//		color2 = find("#color2");
//		textField = find("#textField");
//		title1 = find("#title1");
//		title2 = find("#title2");
//		stackPane = find("#stackPane");
//		circle1 = find("#circle1");
//		circle2 = find("#circle2");
//		entryButton = find("#entryButton");
//		title1Button = find("#title1Button");
//		title2Button = find("#title2Button");
//		change1Button = find("#change1Button");
//		change2Button = find("#change2Button");
//		exportButton = find("#exportButton");
//		clearButton = find("#clearButton");
//		filler = find("#filler");
//
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		/* Close the window. It will be re-opened at the next test. */
//		FxToolkit.hideStage();
//		release(new KeyCode[] {});
//		release(new MouseButton[] {});
//	}
//
//	@Test
//	public void EntryFieldTester1() throws InterruptedException {
//		clickOn("#textField");
//		write("eric");
//		textField.setText("eric");
//		assertEquals(textField.getText(), "eric");
//	}
//
//	@Test
//	public void EntryFieldTester2() throws InterruptedException {
//		clickOn("#textField");
//		write("");
//		textField.setText("");
//		assertEquals(textField.getText(), "");
//	}
//
//	@Test
//	public void EntryFieldTesterLeft() throws InterruptedException {
//		clickOn("#textField");
//		write("eric");
//		textField.setText("eric");
//		clickOn("#entryButton");
//		type(KeyCode.ENTER);
//		Node tf = stackPane.getChildren().get(1);
//		tf.setTranslateX(-174);
//		Thread.sleep(1000);
//		clickOn("#filler").drag(MouseButton.PRIMARY).dropTo("#circle1");
//		Thread.sleep(1000);
//		assertEquals(textField.getText(), "eric");
//	}
//	
//	@Test
//	public void EntryFieldTesterRight() throws InterruptedException {
//		clickOn("#textField");
//		write("eric");
//		textField.setText("eric");
//		clickOn("#entryButton");
//		type(KeyCode.ENTER);
//		Node tf = stackPane.getChildren().get(1);
//		tf.setTranslateX(-174);
//		Thread.sleep(1000);
//		clickOn("#filler").drag(MouseButton.PRIMARY).dropTo("#circle2");
//		Thread.sleep(1000);
//		assertEquals(textField.getText(), "eric");
//	}
//	
//	@Test
//	public void EntryFieldTesterMiddle() throws InterruptedException {
//		clickOn("#textField");
//		write("eric");
//		textField.setText("eric");
//		assertEquals(textField.getText(), "eric");
//	}
//	
//	@Test
//	public void EntryFieldOutOfBoundsTester() throws InterruptedException {
//		clickOn("#textField");
//		write("eric");
//		textField.setText("eric");
//		clickOn("#entryButton");
//		type(KeyCode.ENTER);
//		Node tf = stackPane.getChildren().get(1);
//		tf.setTranslateX(-174);
//		Thread.sleep(1000);
//		clickOn("#filler").drag(MouseButton.PRIMARY).dropTo("#filler2");
//		Thread.sleep(2000);
//		type(KeyCode.ENTER);
//		assertEquals(textField.getText(), "eric");
//	}
//	
//	@Test
//	public void Title1Tester() throws InterruptedException {
//		clickOn("#title1");
//		write("eric");
//		title1.setText("eric");
//		assertEquals(title1.getText(), "eric");
//	}
//	
//	
//	@Test
//	public void Title2Tester() throws InterruptedException {		
//	clickOn("#title2");
//	write("eric");
//	title2.setText("eric");
//	assertEquals(title2.getText(), "eric");
//	Thread.sleep(4000);
//	}
//
//	@Test
//	public void Color1Tester() throws InterruptedException {
//		clickOn("#color1");
//		type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT)
//				.type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT)
//				.type(KeyCode.RIGHT).type(KeyCode.ENTER);
//		circle1.setFill(Color.BLACK);
//		assertEquals(circle1.getFill(), Color.BLACK);
//		Thread.sleep(1000);
//	}
//
//	@Test
//	public void Color2Tester() throws InterruptedException {
//		clickOn("#color2");
//		type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT)
//				.type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT)
//				.type(KeyCode.RIGHT).type(KeyCode.ENTER);
//		circle2.setFill(Color.BLACK);
//		assertEquals(circle2.getFill(), Color.BLACK);
//		Thread.sleep(1000);
//	}
//
//	@Test
//	public void ClearAllTester() throws InterruptedException {
//		clickOn("#textField");
//		write("First");
//		clickOn("#entryButton");
//		type(KeyCode.ENTER);
//		Node tf = stackPane.getChildren().get(1);
//		tf.setTranslateX(-174);
//		Thread.sleep(1000);
//		clickOn("#filler").drag(MouseButton.PRIMARY).dropTo("#circle2");
//
//		clickOn("#textField");
//		write("Second");
//		clickOn("#entryButton");
//		type(KeyCode.ENTER);
//		tf.setTranslateX(-174);
//		Thread.sleep(1000);
//		clickOn("#filler").drag(MouseButton.PRIMARY).dropTo("#circle1");
//
//		clickOn("#textField");
//		write("Third");
//		clickOn("#entryButton");
//		type(KeyCode.ENTER);
//
//		clickOn("#color2");
//		type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT)
//				.type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT)
//				.type(KeyCode.RIGHT).type(KeyCode.UP).type(KeyCode.ENTER);
//
//		clickOn("#color1");
//		type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT)
//				.type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT).type(KeyCode.RIGHT)
//				.type(KeyCode.RIGHT).type(KeyCode.UP).type(KeyCode.ENTER);
//
//		clickOn("#clearButton");
//		clickOn("#textField");
//		type(KeyCode.ENTER);
//		assertEquals(textField.getText(), "");
//	}
	

}
