package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class HelloController {
    @FXML
    protected void onHelloButtonClick() {
        try {
            FXRouter.goTo("MyMan");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void onNextButtonClick() {
        try {
            FXRouter.goTo("MyMan-list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}