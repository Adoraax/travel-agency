package controller.Trip;

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
import model.Trip;
import model.Exceptions.DuplicateItemException;
import model.Exceptions.ErrorModel;
import model.Exceptions.InsufficientDestinationsException;

public class BookTripController extends Controller<Agency>{
@FXML private Button addDestinationBtn;
@FXML private Button removeestinationBtn;
@FXML private Button addConnectingFlightBtn;
@FXML private Button viewTripBtn;
@FXML private Button closeBtn;
@FXML private Text loggedInUserName;

private Trip trip;

    @FXML protected void addDestination(ActionEvent e) throws IOException{
        System.out.println("flights");
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/image/destinations_icon.png"));
            ViewLoader.showStage(getTrip().getDestinations(), "/view/Destinations/AddDestinationView.fxml", "Add a Destination", stage);
    }
    
    @FXML protected void removeDestination(ActionEvent e) throws IOException{
        System.out.println("by country");
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/image/destinations_icon.png"));
            ViewLoader.showStage(getTrip().getDestinations(), "/view/Destinations/RemoveDestinationView.fxml", "Remove A Destination", stage);
    }

    @FXML protected void addConnectingFlight(ActionEvent e) throws IOException{
       try {
        getTrip().addConnectingFlights();
    } catch (DuplicateItemException e1) {
        // TODO Auto-generated catch block
        //e1.printStackTrace();
        ErrorModel errorModel = new ErrorModel(e1, "Try again.");
        ViewLoader.showErrorWindow(errorModel);
    } catch (InsufficientDestinationsException e1) {
        // TODO Auto-generated catch block
        //e1.printStackTrace();
        ErrorModel errorModel = new ErrorModel(e1, "Try again.");
        ViewLoader.showErrorWindow(errorModel);
    }
    }

    @FXML protected void viewTrip(ActionEvent e) throws IOException{
        System.out.println("viewing trip");
        Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/image/trip_icon.png"));
            ViewLoader.showStage(getTrip(), "/view/Trip/DisplayTripView.fxml", "Display Trip View", stage);
        //stage.close();
    }   

    @FXML protected void close(ActionEvent e){
        //System.out.println("closed");
        stage.close();
    }

    public void initialize() {
        //loggedInUserName = new Label();
        //loggedInUserName.setText(model.getLoggedInUser().getName());
        trip = new Trip(getAgency());
    }

    public final Trip getTrip() {
        return trip;
    }

    public final Agency getAgency() {
        return model;
    }
}
