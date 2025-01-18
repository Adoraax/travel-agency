package controller.Flights;

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

public class ExploreFlightsController extends Controller<Agency>{

@FXML private Button viewAllFlightsBtn;
@FXML private Button viewFlightsByCountryBtn;
@FXML private Button addFlightBtn;
@FXML private Button removeFlightBtn;
@FXML private Button closeBtn;
@FXML private Text loggedInUserName;

    @FXML protected void viewAllFlights(ActionEvent e) throws IOException{
        System.out.println("flights");
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/image/flights_icon.png"));
            ViewLoader.showStage(getAgency().getFlights(), "/view/Flights/DisplayFlightsView.fxml", "Display Flights", stage);
    }
    
    @FXML protected void viewFlightsByCountry(ActionEvent e) throws IOException{
        System.out.println("by country");
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/image/flights_icon.png"));
            ViewLoader.showStage(getAgency().getFlights(), "/view/Flights/DisplayFilteredFlightsView.fxml", "Filtered Flights", stage);
    }

    @FXML protected void addFlight(ActionEvent e) throws IOException{
        System.out.println("added");
        Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/image/flights_icon.png"));
            ViewLoader.showStage(getAgency(), "/view/Flights/AddFlightView.fxml", "Add Flight", stage);
    }

    @FXML protected void removeFlight(ActionEvent e) throws IOException{
        System.out.println("removed");
        Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/image/flights_icon.png"));
            ViewLoader.showStage(getAgency(), "/view/Flights/RemoveFlightView.fxml", "Remove Flight", stage);
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
