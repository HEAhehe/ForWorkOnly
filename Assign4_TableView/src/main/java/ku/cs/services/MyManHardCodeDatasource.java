package ku.cs.services;

import ku.cs.models.MyManList;

public class MyManHardCodeDatasource implements Datasource<MyManList> {
    @Override
    public MyManList readData(){
        MyManList list = new MyManList();
        list.addNewMyMan("male","Tom Hughes","38");
        list.addNewMyMan("male","Christian Coulson","44");
        list.addNewMyMan("male","Hero Fiennes Tiffin","25");
        list.addNewMyMan("male","Maxence Danet-Fauvel","30");
        list.addNewMyMan("male","Tom Riddle","97");
        return list;
    }
    

    public void writeData(MyManList data) {

    }
}
