/**
 * Sample Skeleton for 'login.fxml' Controller Class
 */

package sisgem.controllers;

import java.net.URL;
import java.security.MessageDigest;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sisgem.Login;
import sisgem.db.UserDAO;
import sisgem.model.User;
import sisgem.utils.Navigator;

public class LoginController implements Initializable {

	 @FXML // fx:id="label_login"
	 private Label label_login; // Value injected by FXMLLoader

	 @FXML // fx:id="label_password"
	 private Label label_password; // Value injected by FXMLLoader

	@FXML // fx:id="textfield_password"
	private PasswordField passwordfield_password; // Value injected by FXMLLoader

	@FXML // fx:id="textfield_login"
	private TextField textfield_login; // Value injected by FXMLLoader

	@FXML // fx:id="button_signin"
	private Button button_signin; // Value injected by FXMLLoader

    @FXML // fx:id="label_statusbar"
    private Label label_statusbar; // Value injected by FXMLLoader
    
	@Override // This method is called by the FXMLLoader when initialization is complete
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		
		textfield_login.focusedProperty().addListener(new ChangeListener<Boolean>()
		{
		    @Override
		    public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
		    {
		        if (newPropertyValue)
		        {
		        	textfield_login.selectAll();
		    		textfield_login.setStyle("-fx-border-color: rgb(59,134,134);");
		        }
		    }
		});
		
		passwordfield_password.focusedProperty().addListener(new ChangeListener<Boolean>()
		{
		    @Override
		    public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
		    {
		        if (newPropertyValue)
		        {
		        	passwordfield_password.selectAll();
		        	passwordfield_password.setStyle("-fx-border-color: rgb(59,134,134);");
		        }
		    }
		});
		
	}

	@FXML
	public void enterPressed(KeyEvent event)
	{
	    if (event.getCode() == KeyCode.ENTER)
	    {
	        button_signin.fire();
	    }
	}

    @FXML
    void validateUser(ActionEvent event) 
    {
    	String login = textfield_login.getText();
    	
    	UserDAO userDAO = new UserDAO();
    	
    	User user = userDAO.findByLogin(login);
 
    	if (user == null)
    	{
    		textfield_login.setStyle("-fx-border-color: red");
    		label_statusbar.setText("Usuário " + login + " não encontrado!");
    		label_statusbar.setVisible(true);

    		return;
    	}
    	
    	else
    	{
    		String passwordSalt = passwordfield_password.getText() + "" + user.getSalt();
		
    		MessageDigest messageDigest = null;
    		
    		try
    		{
				byte[] plainText = passwordSalt.getBytes("UTF8");
				
				messageDigest = MessageDigest.getInstance("SHA-256");
				
				messageDigest.update(plainText);
    		}
    		catch (Exception e)
    		{
    			e.printStackTrace();
    		}
    		
			byte [] digest = messageDigest.digest();
			
			StringBuffer digestbuf = new StringBuffer();
			
			for (int i = 0; i < digest.length; i++) 
			{
				String hex = Integer.toHexString(0x0100 + (digest[i] & 0x00FF)).substring(1);
				digestbuf.append((hex.length() < 2 ? "0" : "") + hex);
			}
			
			String digestComp = digestbuf.toString();

			if (digestComp.equals(user.getPassword()))
			{
				Login.setLoggedUser(user);
				Navigator.getMainController().setMenuVisibilityAndFooter(user);
				Navigator.loadVista("loggeduser.fxml");
			}
			else
			{
	    		passwordfield_password.setStyle("-fx-border-color: red");
	    		
	    		label_statusbar.setText("Senha incorreta para usuário " + login + "!");
	    		label_statusbar.setVisible(true);

	    		return;
				
			}
    	}
    }
    
}
