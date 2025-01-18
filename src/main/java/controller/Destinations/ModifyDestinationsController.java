package controller.Destinations;

import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Destinations;
import model.Destination;
import model.Exceptions.DuplicateItemException;
import model.Exceptions.ErrorModel;
import model.Exceptions.ItemNotFoundException;
import model.Agency;


public class ModifyDestinationsController extends Controller<Destinations> {
@FXML private Button closeBtn;
@FXML private Button addDestinationBtn;
@FXML private Button removeDestinationBtn;
@FXML private TextField nameTf;
@FXML private TextField countryTf;

    @FXML protected void addDestination(ActionEvent e) throws IOException{

    Destination d = new Destination(nameTf.getText(), countryTf.getText());
    try {
        //model.getDestinations().addDestination(d);
        model.addDestination(d);
        stage.close();
    } catch (DuplicateItemException e1) {
        // TODO Auto-generated catch block
        //e1.printStackTrace();
        ErrorModel errorModel = new ErrorModel(e1, "Try again.");
            ViewLoader.showErrorWindow(errorModel); 
    }
    }




    @FXML protected void removeDestination(ActionEvent e) throws IOException{
    //Flight f = new Flight(null, 0, takeoffTf.getText(), landingTf.getText(), 0);
        try {
            Destination d = model.destination(nameTf.getText(), countryTf.getText());

            System.out.println("removing flight");
            model.removeDestination(d);
            stage.close();
            System.out.println("removed flight");
        } catch (ItemNotFoundException e3) {
            // TODO Auto-generated catch block
            //e1.printStackTrace();
            ErrorModel errorModel = new ErrorModel(e3, "Try again.");
            ViewLoader.showErrorWindow(errorModel); 
            
        }
        // TODO Auto-generated catch block
    }

    public void initialize() {
        System.out.println("ModifyDestinationsController initialize called");
        if (addDestinationBtn != null) {
            addDestinationBtn.setDisable(true);
            addDestinationBtn.disableProperty().bind(nameTf.textProperty().isEmpty().or(countryTf.textProperty().isEmpty()));
            //addFlightBtn.disableProperty().bind(flightNoTf.textProperty().isEmpty());

        }
        if (removeDestinationBtn != null) {
            removeDestinationBtn.setDisable(true);
            removeDestinationBtn.disableProperty().bind(nameTf.textProperty().isEmpty().or(countryTf.textProperty().isEmpty()));
        }
        /*loginTf.textProperty().addListener((obs, oldText, newText) -> {
            // do what you need with newText here, e.g.
            loginBtn.setDisable(newText.isEmpty());
        });*/
    }


    @FXML protected void close(ActionEvent e){
        //System.out.println("closed");
        stage.close();
    }

}
