module cs.projectmarket {
    requires javafx.controls;
    requires javafx.fxml;


    opens cs.projectmarket to javafx.fxml;
    exports cs.projectmarket;
}