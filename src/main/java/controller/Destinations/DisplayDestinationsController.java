package controller.Destinations;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Agency;
import model.Destination;
import model.Destinations;

public class DisplayDestinationsController extends Controller<Destinations> {
@FXML private Button closeBtn;
@FXML private TextField countryFilterTf;
@FXML private TableView<Destination> destinationsTv;

    @FXML protected void close(ActionEvent e){
        //System.out.println("closed");
        stage.close();
    }

    public final ObservableList<Destination> getDestinations() {
        //System.out.println("controller getFlights size="+model.getFlights().getFlights().size());
        return model.getDisplayDestinations();
    }
 

 
    public void initialize(){
        if (countryFilterTf != null){
        countryFilterTf.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()){
                model.setDisplayedDestinations(model.getDestinations());
            }else{
          
                model.setDisplayedDestinations(model.getFilteredDestinations(countryFilterTf.getText()));
            }
            destinationsTv.refresh();
        });
    }
    }
    
}
