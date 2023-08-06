package ku.cs.models;

import java.util.ArrayList;

public class MyManList {
    public ArrayList<MyMan> myMans;

    public MyManList(){
        myMans = new ArrayList<>();
    }
    public void addNewMyMan(String sex, String name, int age, Double price) {
        sex = sex.trim();
        name = name.trim();
        if (!sex.equals("") && !name.equals("")) {
            MyMan exist = findMyMansByName(name);
            if (exist == null) {
                myMans.add(new MyMan(sex, name, age));
            }
        }
    }
    public void addNewMyMan(String sex, String name, String age, Double price) {
        sex = sex.trim();
        name = name.trim();
        if (!sex.equals("") && !name.equals("")) {
            MyMan exist = findMyMansByName(name);
            if (exist == null) {
                myMans.add(new MyMan(sex, name, age, price));
            }
        }
    }
    public void addNewMyMan(String sex, String name, String age2) {
        sex = sex.trim();
        name = name.trim();
        age2 = age2.trim();
        if (!sex.equals("") && !name.equals("") && !age2.equals("")) {
            MyMan exist = findMyMansByName(name);
            if (exist == null) {
                myMans.add(new MyMan(sex.trim(), name.trim(), age2.trim()));
            }
        }
    }
    public MyMan findMyMansByName(String name){
        for(MyMan myMan : myMans){
            if(myMan.isName(name)){
                return myMan;
            }
        }
        return null;
    }
    public void giveHourToName(String name,double hour){
        MyMan exist = findMyMansByName(name);
        if (exist != null) {
            exist.addHour(hour);
        }
    }
    public void givePriceToName(String name,double price){
        MyMan exist = findMyMansByName(name);
        if (exist != null) {
            exist.addPrice(price);
        }
    }
    public ArrayList<MyMan> getMyMans() {
        return myMans;
    }

}