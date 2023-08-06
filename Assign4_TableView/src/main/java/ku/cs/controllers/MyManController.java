package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.models.MyMan;
import ku.cs.services.FXRouter;

import java.io.IOException;


public class MyManController {
    private MyMan myMan ;
    @FXML
    private Label nameLabel ;
    @FXML
    private Label sexLabel ;
    @FXML
    private Label ageLabel ;
    @FXML
    private Label priceLabel;

    @FXML
    public void initialize(){
        MyMan myMan = new MyMan("male","Tom Hughes","38");
        showMyMan(myMan);
    }

    private void showMyMan(MyMan myMan){
        nameLabel.setText(myMan.getName());
        sexLabel.setText(myMan.getSex());
        ageLabel.setText(String.format("%d",myMan.getAge()));
        priceLabel.setText(String.format("%f",myMan.getPrice()));
    }

    @FXML
    public void onHandleBackButton() {
        try {
            FXRouter.goTo("hello");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void onNextButtonClick() {
        try {
            FXRouter.goTo("myMan-list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

