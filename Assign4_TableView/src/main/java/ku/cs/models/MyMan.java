package ku.cs.models;

public class MyMan {
    private String sex;
    private String name;
    private int age;
    private String age2;
    private double price;
    private double hour;

    public MyMan(String sex, String name, int age) {
        this.sex = sex;
        this.name = name;
        this.age = age;
    }
    public MyMan(String sex, String name) {
        this.sex = sex;
        this.name = name;
        this.age = 38;
        this.price = 2000;
    }
    public MyMan(String sex, String name, String age2) {
        this.sex = sex;
        this.name = name;
        this.age2 = age2;
        this.hour = 0;
        this.price = 2000;
    }

    public MyMan(String sex, String name, String age2, double price){
        this.sex = sex;
        this.name = name;
        this.age2 = age2;
        this.price = price ;
    }

    public boolean isName(String name) {
        return this.name.equals(name);
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
    public String getAge2() {
        return age2;
    }
    public double getSumPrice(){
        return price * hour;
    }
    public double addHour(double hour){
        this.hour += hour;
        return hour;
    }
    public double addPrice(double price){
        this.price += price ;
        return price;
    }
    public int sumAge(){
        return age;
    }

    public double getPrice() {return price;}

    @Override
    public String toString(){
        return "{" +
                "name: '" + name + '\'' +
                ", sex: '" + sex + '\'' + '\'' +
                ", age: " + age +
                ", price: " + price +
                '}';
    }

}