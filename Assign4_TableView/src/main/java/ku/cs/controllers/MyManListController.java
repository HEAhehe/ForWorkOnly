package ku.cs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import ku.cs.models.MyMan;
import ku.cs.models.MyManList;
import ku.cs.services.Datasource;
import ku.cs.services.FXRouter;
import ku.cs.services.MyManListFileDatasource;
import java.io.IOException;

public class MyManListController {
    @FXML private ListView<MyMan> myManListView;
    @FXML private Label nameLabel;
    @FXML private Label sexLabel;
    @FXML private Label ageLabel;
    @FXML private Label sumPriceLabel;
    @FXML private Label errorLabel;
    @FXML private TextField giveHourTextField;
    private MyManList myManList;
    private MyMan selectedMyMan;
    private Datasource<MyManList> datasource;

    @FXML
    public void initialize(){
        errorLabel.setText("");
        ClearMyManInfo();
        datasource = new MyManListFileDatasource("data", "myMan-list.csv");
        myManList = datasource.readData();
        showList(myManList);
        myManListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MyMan>() {
            @Override
            public void changed(ObservableValue<? extends MyMan> observableValue, MyMan oldValue, MyMan newValue) {
                if (newValue == null) {
                    ClearMyManInfo();
                    selectedMyMan = null;
                } else {
                    showMyManInfo(newValue);
                    selectedMyMan = newValue;
                }
            }
        });
    }
    private void showList(MyManList myManList){
        myManListView.getItems().clear();
        myManListView.getItems().addAll(myManList.getMyMans());
    }
    private void showMyManInfo(MyMan myMan){
        sexLabel.setText(myMan.getSex());
        nameLabel.setText(myMan.getName());
        ageLabel.setText(myMan.getAge2());
        sumPriceLabel.setText(String.format("%.2f", myMan.getSumPrice()));
    }
    private void ClearMyManInfo(){
        sexLabel.setText("");
        nameLabel.setText("");
        ageLabel.setText("");
        sumPriceLabel.setText("");
    }
    @FXML
    public void onBackButtonClick() {
        try {
            FXRouter.goTo("myMan");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void onNextButtonClick() {
        try {
            FXRouter.goTo("myMan-table");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void onGiveHourButtonClick() {
        if (selectedMyMan != null) {
            String hourText = giveHourTextField.getText();
            String errorMessage = "";
            try {
                double hour = Double.parseDouble(hourText);
                myManList.giveHourToName(selectedMyMan.getName(), hour);
                showMyManInfo(selectedMyMan);
                datasource.writeData(myManList);
                showList(myManList);
            }

            catch (NumberFormatException e) {
                errorMessage = "Please insert number value";
                errorLabel.setText(errorMessage);
            } finally {
                if (errorMessage.equals("")) {
                    giveHourTextField.setText("");
                }
            }
        } else {
            giveHourTextField.setText("");
            errorLabel.setText("");
        }
    }
}
