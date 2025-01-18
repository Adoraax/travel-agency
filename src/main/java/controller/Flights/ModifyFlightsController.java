package controller.Flights;

import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Agency;
import model.Flight;
import model.Exceptions.DuplicateItemException;
import model.Exceptions.ErrorModel;
import model.Exceptions.ItemNotFoundException;


public class ModifyFlightsController extends Controller<Agency> {
@FXML private Button closeBtn;
@FXML private Button addFlightBtn;
@FXML private Button removeFlightBtn;
@FXML private TextField airlineTf;
@FXML private TextField flightNoTf;
@FXML private TextField takeoffTf;
@FXML private TextField landingTf;
@FXML private TextField costTf;



    @FXML protected void addFlight(ActionEvent e) throws IOException
    {
        System.out.println("added airlineTf="+airlineTf.getText());
        double cost = 0;
        int flightNo = 0;
    try{
        cost = Double.valueOf(costTf.getText()).doubleValue();
        flightNo = Integer.parseInt(flightNoTf.getText());
    }catch (NumberFormatException e2) {
        ErrorModel errorModel = new ErrorModel(e2, "Try again.");
        ViewLoader.showErrorWindow(errorModel); 
        //open error window    
    }
    Flight f = new Flight(airlineTf.getText(), flightNo, takeoffTf.getText(), landingTf.getText(), cost);
    try {
        model.getFlights().addFlight(f);
        stage.close();
    } catch (DuplicateItemException e1) {
        // TODO Auto-generated catch block
        //e1.printStackTrace();
        ErrorModel errorModel = new ErrorModel(e1, "Try again.");
            ViewLoader.showErrorWindow(errorModel); 
    }
    }




    @FXML protected void removeFlight(ActionEvent e) throws IOException{
    //Flight f = new Flight(null, 0, takeoffTf.getText(), landingTf.getText(), 0);
        try {
            Flight f = model.getFlights().getFlight(takeoffTf.getText(), landingTf.getText());

            System.out.println("removing flight");
            model.getFlights().removeFlight(f);
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
        System.out.println("ModifyFlightsController initialize called");
        if (addFlightBtn != null) {
            addFlightBtn.setDisable(true);
            addFlightBtn.disableProperty().bind(airlineTf.textProperty().isEmpty().or(flightNoTf.textProperty().isEmpty()).or(takeoffTf.textProperty().isEmpty()).or(landingTf.textProperty().isEmpty()).or(costTf.textProperty().isEmpty()));
            //addFlightBtn.disableProperty().bind(flightNoTf.textProperty().isEmpty());

        }
        if (removeFlightBtn != null) {
            removeFlightBtn.setDisable(true);
            removeFlightBtn.disableProperty().bind(landingTf.textProperty().isEmpty().or(landingTf.textProperty().isEmpty()));
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
