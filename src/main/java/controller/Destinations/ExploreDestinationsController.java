package controller.Destinations;

import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Agency;

public class ExploreDestinationsController extends Controller<Agency> {

@FXML private Button viewAllDestinationsBtn;
@FXML private Button viewDestinationsByCountryBtn;
@FXML private Button addDestinationBtn;
@FXML private Button removeDestinationBtn;
@FXML private Button closeBtn;
@FXML private Text loggedInUserName;

    @FXML protected void viewAllDestinations(ActionEvent e) throws IOException{
        System.out.println("flights");
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/image/destinations_icon.png"));
            ViewLoader.showStage(getAgency().getDestinations(), "/view/Destinations/DisplayDestinationsView.fxml", "Display Destinations", stage);
    }
    
    @FXML protected void viewDestinationsByCountry(ActionEvent e) throws IOException{
        System.out.println("by country");
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/image/destinations_icon.png"));
            ViewLoader.showStage(getAgency().getDestinations(), "/view/Destinations/DisplayFilteredDestinationsView.fxml", "Display Filtered Destinations", stage);
    }

    @FXML protected void addDestination(ActionEvent e) throws IOException{
        System.out.println("added");
        Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/image/destinations_icon.png"));
            ViewLoader.showStage(getAgency().getDestinations(), "/view/Destinations/AddDestinationView.fxml", "Add Destination", stage);
    }

    @FXML protected void removeDestination(ActionEvent e) throws IOException{
        System.out.println("removed");
        Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/image/destinations_icon.png"));
            ViewLoader.showStage(getAgency().getDestinations(), "/view/Destinations/RemoveDestinationView.fxml", "Remove Destination", stage);
        //stage.close();
    }   

    @FXML protected void close(ActionEvent e){
        //System.out.println("closed");
        stage.close();
    }

    public void initialize() {
        //loggedInUserName = new Label();
        //loggedInUserName.setText(model.getLoggedInUser().getName());
    }

    public final Agency getAgency() {
        return model;
    }
    
   
}
