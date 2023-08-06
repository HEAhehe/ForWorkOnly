package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.models.MyMan;
import ku.cs.services.FXRouter;

import java.io.IOException;


public class MyManController {
    @FXML
    private Label nameLabel;
    @FXML
    private Label sexLabel;
    @FXML
    private Label ageLabel;

    @FXML
    public void initialize() {
        MyMan MyMan = new MyMan("male", "Tom Hughes");
        MyMan.addAge(38);
        showMyMan(MyMan);
    }
    private void showMyMan(MyMan MyMan) {
        nameLabel.setText(MyMan.getName());
        ageLabel.setText(MyMan.getAge());
        sexLabel.setText(MyMan.getSex());
    }
    @FXML
    public void onHandleBackButton(){
        try{
            FXRouter.goTo("MyMan-list");
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void onNextButtonClick() {
        try {
            FXRouter.goTo("hello");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}