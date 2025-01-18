package controller.Error;

import java.io.File;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import model.Administrator;
import model.Exceptions.ErrorModel;


public class ErrorController extends Controller<ErrorModel>{

    @FXML
    private ImageView imageView;

    @FXML
    private Label errorMessage;
    
    @FXML
    private Label message;
    
    public void initialize() {
        System.out.println("intialise ErrorController");
        /*File file = new File("src/images/error.png");
        Image image = new Image(file.toURI().toString());
        //this.imageView = new ImageView(image);
        imageView.setImage(image);
        */
                System.out.println(this.model.getException().getClass().getSimpleName());
        message.setText(this.model.getMessage());
        this.errorMessage.setText(this.model.getException().getClass().getSimpleName());
        //errorMessage.setStyle("-fx-font-weight: bold");

        //this.errorMessage = new Label("Tewst");
        
    }

     @FXML protected void close(ActionEvent event) {
        this.stage.close();
     }
}
