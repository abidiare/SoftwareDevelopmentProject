package login;

import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController implements Initializable {
	
	@FXML
	public TextField username, password;
	
	@FXML
	public Button loginButton, newUserButton, deleteUserButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void loginButton(ActionEvent event) {
		try {

			/*
			 * Login Button Function:
			 * 
			 */

			if (username.getText().isEmpty() || String.valueOf(password.getText()).isEmpty()
					|| username.getText().trim().length() != username.getText().length()
					|| String.valueOf(password.getText()).trim().length() != String.valueOf(password.getText())
							.length()) {

				throw new Exception();
			}

			Connection connection = DriverManager.getConnection(AccessToLogin.getJdbcURL(), AccessToLogin.getUsername(),
					AccessToLogin.getPassword());

			String sql = "SELECT * FROM user WHERE Username='" + username.getText() + "'";
			java.sql.Statement statement = connection.createStatement();
			ResultSet result = null;
			result = statement.executeQuery(sql);
			if (result.next() == false) {
				throw new Exception();
			}

			sql = "SELECT * FROM user WHERE Password='" + String.valueOf(password.getText()) + "'";
			java.sql.Statement statement1 = connection.createStatement();
			result = null;
			result = statement1.executeQuery(sql);
			if (result.next() == false) {
				throw new Exception();
			} else {
				
				JOptionPane.showMessageDialog(null, "Welcome");
				// Open Venn Diagram Window

				username.setText("...");
				password.setText("...");
				((Node) event.getSource()).getScene().getWindow().hide();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VennDiagramWindowView.fxml"));
				Parent part = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				Scene scene = new Scene(part);
				stage.setScene(scene);
				stage.show();

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Incorrect");
			username.setText("");
			password.setText("");
		}
	}

	public void newUserButton(ActionEvent event) {

		/*
		 * New User Function:
		 * 
		 */

		try {
			if (username.getText().isEmpty() || String.valueOf(password.getText()).isEmpty()
					|| username.getText().trim().length() != username.getText().length()
					|| String.valueOf(password.getText()).trim().length() != String.valueOf(password.getText())
							.length()) {
				throw new Exception();
			}
			Connection connection = DriverManager.getConnection(AccessToLogin.getJdbcURL(), AccessToLogin.getUsername(),
					AccessToLogin.getPassword());

			String sql1 = "SELECT * FROM user WHERE Username='" + username.getText() + "'";
			java.sql.Statement statement1 = connection.createStatement();
			ResultSet result = null;
			result = statement1.executeQuery(sql1);
			if (result.next() == true) {
				throw new Exception();
			}

			String sql = "INSERT INTO user (Username, Password)" + " VALUES ( '" + username.getText() + "', '"
					+ String.valueOf(password.getText()) + "')";
			java.sql.Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "New User: " + username.getText() + " has been created");
			// Open VennDiagramWindow Now
			JOptionPane.showMessageDialog(null, "Welcome");
			username.setText("...");
			password.setText("...");
			// Open Venn Diagram Window

			((Node) event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VennDiagramWindowView.fxml"));
			Parent part = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(part);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Please enter a valid entry");
			username.setText("");
			password.setText("");
		}
	}

	public void deleteUserButton(ActionEvent event) {

		/*
		 * Delete User Function:
		 *
		 * 
		 */

		try {

			Connection connection = DriverManager.getConnection(AccessToLogin.getJdbcURL(), AccessToLogin.getUsername(),
					AccessToLogin.getPassword());

			String sql = "SELECT * FROM user WHERE Username='" + username.getText() + "'";
			java.sql.Statement statement = connection.createStatement();
			ResultSet result = null;
			result = statement.executeQuery(sql);
			if (result.next() == false) {
				throw new Exception();
			} else {
				String sql1 = "DELETE FROM user WHERE Username = '" + username.getText() + "'";
				java.sql.Statement statement1 = connection.createStatement();
				statement1.executeUpdate(sql1);
				JOptionPane.showMessageDialog(null, "User: " + username.getText() + " has been deleted");
				username.setText("");
				password.setText("");
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Username Does Not Exist");
			username.setText("");
			password.setText("");
		}
	}
}
