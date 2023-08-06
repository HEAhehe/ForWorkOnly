package ku.cs.assign2javafx;

import ku.cs.services.FXRouter;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXRouter.bind(this,stage, "Hello World");
        FXRouter.bind(this, stage, "", 800, 600);
        configRoute();
        FXRouter.goTo("myMan-table");
    }

    public static void configRoute()
    {
        String viewPath = "ku/cs/views/";
        FXRouter.when("hello", viewPath + "hello-view.fxml");
        FXRouter.when("myMan", viewPath + "MyMan.fxml");
        FXRouter.when("myMan-list", viewPath + "MyMan-list.fxml");
        FXRouter.when("myMan-table", viewPath + "myMan-table.fxml");
        FXRouter.when("myMan-price", viewPath + "myMan-price.fxml");

    }

    public static void main(String[] args) {
        launch();
    }
}