package ku.cs.services;

import ku.cs.models.MyManList;
public class MyManHardCodeDatasource {
    public MyManList readData(){
        MyManList list = new MyManList();
        list.addNewMyMan("male","Tom Hughes");
        list.addNewMyMan("male","Christian Coulson");
        list.addNewMyMan("male","Hero Fiennes Tiffin");
        list.addNewMyMan("male","Maxence Danet-Fauvel");
        list.addNewMyMan("male","Tom Riddle");
        return list;
    }
}
