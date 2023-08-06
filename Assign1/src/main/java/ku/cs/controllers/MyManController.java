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
    public void initialize(){
        myMan = new MyMan("male","Tom Hughes");
        nameLabel.setText(myMan.getName());
        sexLabel.setText(myMan.getSex());
        ageLabel.setText(String.format("%d",myMan.getAge()));
    }

        @FXML
        public void Button3(ActionEvent actionEvent) {
            try {
                FXRouter.goTo("hello");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    @FXML
    public void Button2(ActionEvent actionEvent) {
        ageLabel.setText(String.format("%d",myMan.sumAge()));
    }

}

