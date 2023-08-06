module ku.cs.assign2javafx {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens ku.cs.assign2javafx to javafx.fxml;
    exports ku.cs.assign2javafx;
    exports ku.cs.controllers;
    opens ku.cs.controllers to javafx.fxml;
}