package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.models.MyMan;
import ku.cs.models.MyManList;
import ku.cs.services.Datasource;
import ku.cs.services.FXRouter;
import ku.cs.services.MyManListFileDatasource;

import java.io.IOException;

public class MyManPriceController {
    @FXML private Label nameLabel ;
    @FXML private Label ageLabel ;
    @FXML private Label sexLabel ;
    @FXML private Label priceLabel ;
    @FXML private Label errorLabel ;
    @FXML private TextField hoursTextField ;

    private Datasource<MyManList> datasource;
    private MyManList myManList;
    private MyMan myMan;

    @FXML
    public void initialize() {
        datasource = new MyManListFileDatasource("data","myMan-list.csv");
        myManList = datasource.readData();

        String myManName = (String) FXRouter.getData();
        myMan = myManList.findMyMansByName(myManName);

        showMyMan(myMan);
        errorLabel.setText("");
    }

    private void showMyMan(MyMan myMan) {
        nameLabel.setText(myMan.getName());
        ageLabel.setText(myMan.getAge2());
        sexLabel.setText(myMan.getSex());
        priceLabel.setText("" + myMan.getPrice());
    }

    @FXML
    public void handleGivePriceButton(){
        String priceString = hoursTextField.getText().trim();
        if (priceString.equals("")){
            errorLabel.setText("price is required");
            return;
        }

        try {
            double price = Double.parseDouble(priceString);
            if (price < 0) {
                errorLabel.setText("price must be positive number");
                return;
            }
            errorLabel.setText("");
            myManList.givePriceToName(myMan.getName(), price);
            hoursTextField.clear();
            datasource.writeData(myManList);
            showMyMan(myMan);
        } catch (NumberFormatException e) {
            errorLabel.setText("price must be number");
        }
    }
    @FXML
    public void BackToMyManTableButton(){
        try {
            FXRouter.goTo("myMan-table");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

