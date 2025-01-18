package controller.Flights;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Agency;
import model.Flight;
import model.Flights;

public class DisplayFlightsController extends Controller<Flights>  {
    
@FXML private Button closeBtn;
@FXML private TextField flightsFilterTf;
@FXML private TableView<Flight> flightsTv;

    @FXML protected void close(ActionEvent e){
        //System.out.println("closed");
        stage.close();
    }

    /*
    @FXML protected void filterFlights(ActionEvent e){
        System.out.println("filter by="+flightsFilterTf.getText());
        String country = flightsFilterTf.getText();
        if (country.isEmpty()){
            //flightsTv.getItems().clear();
            //flightsTv.getItems().addAll(getFlights());
            model.getDestinations().insertDummyData();
        }else{
            //flightsTv.getItems().clear();
            //flightsTv.getItems().addAll(model.getFlights().getFilteredFlights(flightsFilterTf.getText()));
            flightsTv.setItems(model.getFlights().getFilteredFlights(flightsFilterTf.getText()));
             //model.getFlights().setFlights(model.getFlights().getFilteredFlights(flightsFilterTf.getText()));
        }
        flightsTv.refresh();

       
    }
 */

    /*private Flight getFlight(){
        return flightsTv.getSelectionModel().getSelectedItem();
    }*/
    public final ObservableList<Flight> getFlights() {
        //System.out.println("controller getFlights size="+model.getFlights().getFlights().size());
        return model.getDisplayFlights();
    }

    public void initialize(){
        if (flightsFilterTf != null){
        flightsFilterTf.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()){
                model.setDisplayedFlights(model.getFlights());
            }else{
          
                model.setDisplayedFlights(model.getFilteredFlights(flightsFilterTf.getText()));
            }
            flightsTv.refresh();
        });
        }
    }
}
