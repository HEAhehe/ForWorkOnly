package ku.cs.assign2javafx;

import ku.cs.services.FXRouter;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXRouter.bind(this, stage, "Hello World: Welcome to MyMansList");
        configRoute();
        FXRouter.goTo("MyMan-list");
    }

    public static void configRoute()
    {
        String viewPath = "ku/cs/views/";
        FXRouter.when("hello", viewPath + "hello-view.fxml");
        FXRouter.when("MyMan", viewPath + "MyMan.fxml");
        FXRouter.when("MyMan-list", viewPath + "MyMan-list.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}