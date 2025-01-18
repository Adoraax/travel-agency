package controller.Trip;

import java.io.IOException;
import java.util.InputMismatchException;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Flight;
import model.Trip;
import model.Exceptions.ErrorModel;

public class DisplayTripController extends Controller<Trip> {
@FXML private Button closeBtn;
@FXML private ListView<Trip> tripLv;
@FXML private Button viewIndividualBtn;

public final Trip getTrip() { return model; }

    @FXML protected void close(ActionEvent e){
        //System.out.println("closed");
        stage.close();
    }

    @FXML protected void viewIndividual(ActionEvent e){
        //System.out.println("closed");
        System.out.println(tripLv.getSelectionModel().getSelectedIndices());

        ObservableList<Integer> selectedItems =  tripLv.getSelectionModel().getSelectedIndices();
        Integer[] il = selectedItems.toArray(new Integer[selectedItems.size()]);

        boolean checkSelection = allEvenOrAllOdd(il);
        System.out.println("is selected correct:"+checkSelection);

        if (checkSelection){
            if (il[0] % 2 == 0) {        
                    //is a destination
                System.out.println("show destinations");
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/image/destinations_icon.png"));
                try {
                    ViewLoader.showStage(getTrip().getDestinations(), "/view/Destinations/DisplayDestinationsView.fxml", "Display Destinations", stage);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            

            }else{
                   //is a flight
                   System.out.println("flights");
                   Stage stage = new Stage();
                   stage.setX(ViewLoader.X + 601);
                   stage.setY(ViewLoader.Y);
                   stage.getIcons().add(new Image("/image/flights_icon.png"));
                   try {
                    ViewLoader.showStage(getTrip().getFlights(), "/view/Flights/DisplayFlightsView.fxml", "Display Flights", stage);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }else{
            //show error
            ErrorModel errorModel = new ErrorModel(new InputMismatchException(""), "Try again.");
            ViewLoader.showErrorWindow(errorModel); 
        }
        
        /*
        for(Trip t: selectedItems){

        }
        ObservableList<Trip> selectedItems =  tripLv.getSelectionModel().getSelectedItems();

                        for(Trip t: selectedItems){
                            System.out.println("selected item " + t.);
                        }
 */

    }

    public boolean allEvenOrAllOdd(Integer[] array) {
        boolean hasOdd = false;
        boolean hasEven = false;
        for (int i = 0; i<array.length; i++) {
            if (array[i] % 2 == 0) {
                hasEven = true;
                if (hasOdd) { // has both odds and evens
                    return false;
                }
            } else {
                hasOdd = true;
                if (hasEven) { // has both odds and evens
                    return false;
                }
            }
        }
        return true; // either all elements are odd or all elements are even
    }

    
    public void initialize() {
        tripLv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }



}
