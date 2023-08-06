package ku.cs.models;

public class MyMan {
    private String sex;
    private String name;
    private int age;

    public MyMan(String sex, String name) {
        this.sex = sex;
        this.name = name;
        this.age = 38;
    }

    public String getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int sumAge(){
        return age + 20 ;
    }
}