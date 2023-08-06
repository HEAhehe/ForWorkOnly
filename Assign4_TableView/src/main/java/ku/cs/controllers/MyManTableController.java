package ku.cs.controllers;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ku.cs.models.MyMan;
import ku.cs.models.MyManList;
import ku.cs.services.Datasource;
import ku.cs.services.FXRouter;
import ku.cs.services.MyManListFileDatasource;

import java.io.IOException;

public class MyManTableController {
    @FXML
    private TableView myManTableView;
    private MyManList myManList ;
    private Datasource<MyManList> datasource;
    @FXML
    public void initialize(){
        datasource = new MyManListFileDatasource("data","myMan-list.csv");
        myManList = datasource.readData();
        showTable(myManList);

        myManTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MyMan>() {
            @Override
            public void changed(ObservableValue observable, MyMan oldValue, MyMan newValue) {
                if (newValue != null) {
                    try {
                        // FXRouter.goTo สามารถส่งข้อมูลไปยังหน้าที่ต้องการได้ โดยกำหนดเป็น parameter ที่สอง
                        FXRouter.goTo("myMan-price", newValue.getName());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    private void showTable(MyManList myManList){
        TableColumn<MyMan,String> sexColumn = new TableColumn<>("His sex");
        sexColumn.setCellValueFactory(new PropertyValueFactory<>("Sex"));

        TableColumn<MyMan,String> nameColumn = new TableColumn<>("His name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<MyMan,String> ageColumn = new TableColumn<>("His age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("Age2"));

        TableColumn<MyMan,Double> priceColumn = new TableColumn<>("His price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));

        myManTableView.getColumns().clear();
        myManTableView.getColumns().add(sexColumn);
        myManTableView.getColumns().add(nameColumn);
        myManTableView.getColumns().add(ageColumn);
        myManTableView.getColumns().add(priceColumn);

        myManTableView.getItems().clear();

        for (MyMan myMan: myManList.getMyMans()) {
            myManTableView.getItems().add(myMan);
        }
    }
    @FXML
    public void onBackToHelloButtonClick(){
        try{
            FXRouter.goTo("myMan-list");
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onNextToHelloButtonClick(){
        try{
            FXRouter.goTo("hello");
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
