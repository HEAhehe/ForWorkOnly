package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class HelloController {
    @FXML
    public void Button1(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("MyMan");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}