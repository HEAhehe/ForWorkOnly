package ku.cs.controllers;

import javafx.fxml.FXML;
import ku.cs.services.FXRouter;
import java.io.IOException;

public class HelloController {
    @FXML
    protected void onHelloButtonClick() {
        try {
            FXRouter.goTo("myMan-table");
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
}