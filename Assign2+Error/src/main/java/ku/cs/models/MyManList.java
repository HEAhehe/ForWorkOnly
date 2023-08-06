package ku.cs.models;

import java.util.ArrayList;

public class MyManList {
    public ArrayList<MyMan> myMans;
    public MyManList(){
        myMans = new ArrayList<>();
    }
    public void addNewMyMan(String sex, String name) {
        sex = sex.trim();
        name = name.trim();
        if (!sex.equals("") && !name.equals("")) {
            MyMan exist = findMyMansByName(name);
            if (exist == null) {
                myMans.add(new MyMan(sex.trim(), name.trim()));
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
    public void giveAgeToName(String name,int age){
        MyMan exist = findMyMansByName(name);
        if (exist != null) {
            exist.addAge(age);
        }
    }
    public ArrayList<MyMan> getMyMans() {
        return myMans;
    }

}
