package ku.cs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import ku.cs.models.MyMan;
import ku.cs.models.MyManList;
import ku.cs.services.FXRouter;
import ku.cs.services.MyManHardCodeDatasource;

import java.io.IOException;

public class MyManListController {
    @FXML private ListView<MyMan> MyManListView;
    @FXML private Label nameLabel;
    @FXML private Label sexLabel;
    @FXML private Label ageLabel;
    @FXML private Label errorLabel;
    @FXML private TextField giveAgeTextField;
    private MyManList myManList;
    private MyMan selectedMyMan;
    @FXML
    public void initialize(){
        errorLabel.setText("");
        ClearMyManInfo();
        MyManHardCodeDatasource datasource = new MyManHardCodeDatasource();
        myManList = datasource.readData();
        showList(myManList);
        MyManListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MyMan>() {
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
        MyManListView.getItems().clear();
        MyManListView.getItems().addAll(myManList.getMyMans());
    }
    private void showMyManInfo(MyMan myMan){
        sexLabel.setText(myMan.getSex());
        nameLabel.setText(myMan.getName());
        ageLabel.setText(String.format("%d", myMan.getAge()));
    }
    private void ClearMyManInfo(){
        sexLabel.setText("");
        nameLabel.setText("");
        ageLabel.setText("");
    }
    @FXML
    public void onBackButtonClick() {
        try {
            FXRouter.goTo("hello");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void onNextButtonClick() {
        try {
            FXRouter.goTo("myMan");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void onGiveScoreButtonClick() {
        if (selectedMyMan != null) {
            String scoreText = giveAgeTextField.getText();
            String errorMessage = "";
            try {
                double score = Double.parseDouble(scoreText);
                int age = 0;
                myManList.giveAgeToName(selectedMyMan.getName(), age);
                showMyManInfo(selectedMyMan);
            } catch (NumberFormatException e) {
                errorMessage = "Please insert number value";
                errorLabel.setText(errorMessage);
            } finally {
                if (errorMessage.equals("")) {
                    giveAgeTextField.setText("");
                }
            }
        } else {
            giveAgeTextField.setText("");
            errorLabel.setText("");
        }
    }
}
