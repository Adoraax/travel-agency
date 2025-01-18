package controller;

import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Administrator;
import model.Administrators;
import model.Agency;
import model.Exceptions.ErrorModel;
import model.Exceptions.InvalidCredentialsException;

public class LoginController extends Controller<Administrator>   {

    @FXML private TextField loginTf;
    @FXML private PasswordField passwordPf;
    private Agency agency;
    @FXML
    private Button loginBtn;


    @FXML private Label actiontarget;
    
    
   // @FXML protected void userTyped(StringProperty property, String oldValue, String newValue) {
   //     System.out.println("username entered");
   // }

    @FXML protected void login(ActionEvent event) {
        System.out.println("dsdsdsdsds");
        //boolean exists;
        try {
            //if (loginTf != null && passwordPf != null ){
                //exists = agency.getAdministrators().hasAdministrator(login.getText(), password.getText());
                agency.getAdministrators().hasAdministrator(loginTf.getText(), passwordPf.getText());

                System.out.println("test1");
                Agency agency = new Agency();
                Administrator loggedInUser = agency.getAdministrators().getAdministrator(loginTf.getText(), passwordPf.getText());
                System.out.println(loggedInUser.getName());
                agency.setLoggedInUser(loggedInUser);
                try {
                    ViewLoader.showStage(agency, "/view/AgencyView.fxml", "Agency", new Stage());
                    stage.getIcons().add(new Image("/image/agency_icon.png"));
                    System.out.println();

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //ViewLoader.showStage(new Agency(), "/view/AgenctView.fxml", "Agency", stage);

                        
                
                //Administrators admins = agency.getAdministrators();
                //System.out.println(admins.toString());
                //exists = agency.getAdministrators().hasAdministrator("", "");
                System.out.println("test3");
                //System.out.println(exists);
                
                //if (exists){

                //}else{
                    //try again
                   //actiontarget.setText("Incorrect. Try again");
                  // ErrorModel errorModel = new ErrorModel(null, "Incorrect. Try again");
                  // ViewLoader.showErrorWindow(errorModel);
               // }
            /*}else{
                    //try again
                    //actiontarget.setText("Incorrect. Try again");
                }
                 */
        } catch (InvalidCredentialsException e) {
            // TODO Auto-generated catch block
            ErrorModel errorModel = new ErrorModel(e, "Try again.");
            ViewLoader.showErrorWindow(errorModel); 
            //InvalidCredentialsException invalidCredentialsException = new InvalidCredentialsException();
            //ViewLoader.showErrorWindow(invalidCredentialsException);
        }

        
    }


    public LoginController(){
        System.out.println("LoginController constructor");
        agency = new Agency();

       /* loginBtn.disableProperty().bind(
                loginTf.textProperty().isEmpty());
 */
    }


    @FXML protected void exit(ActionEvent event){
        //System.exit(0);
        stage.close();
    }

    public void initialize() {
        System.out.println("LoginController initialize called");
        loginBtn.setDisable(true);
        loginTf.textProperty().addListener((obs, oldText, newText) -> {
            // do what you need with newText here, e.g.
            loginBtn.setDisable(newText.isEmpty());
        });
    }
    
}
