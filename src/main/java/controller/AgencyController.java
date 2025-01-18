package controller;

import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import javafx.scene.control.Button;
import model.Agency;
import model.Flight;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Administrator;
import model.Administrators;
import model.Agency;
import model.Exceptions.ErrorModel;
import model.Exceptions.InvalidCredentialsException;

public class AgencyController extends Controller<Agency>{


@FXML private Button flightsBtn;
@FXML private Button destinationsBtn;
@FXML private Button tripBtn;
@FXML private Button exitBtn;
//@FXML private Label loggedInUserName;
@FXML private Text loggedInUserName;

    @FXML protected void exploreFlights(ActionEvent e){
        System.out.println("flights");
        /*public void start(Stage stage) throws Exception{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayFilteredFlightsView.fxml"));
        }*/
        
        //Flight flight = new Flight(null, 0, null, null, 0);
        
        try {
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/image/flights_icon.png"));
            ViewLoader.showStage(getAgency(), "/view/Flights/ExploreFlightsView.fxml", "Explore Flights", stage);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }
    
    @FXML protected void exploreDestinations(ActionEvent e){
        //System.out.println("destinations");
        try {
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/image/destinations_icon.png"));
            ViewLoader.showStage(getAgency(), "/view/Destinations/ExploreDestinationsView.fxml", "Explore Destinations", stage);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML protected void bookTrip(ActionEvent e){
        System.out.println("trip");
        try {
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/image/trip_icon.png"));
            ViewLoader.showStage(getAgency(), "/view/Trip/BookTripView.fxml", "Book a Trip", stage);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML protected void exit(ActionEvent e){
        //System.out.println("exit");
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
