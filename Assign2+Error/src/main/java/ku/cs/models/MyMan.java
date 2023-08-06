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

    public void addAge(double age){
        if(age > 0){
            this.age += age;
        }
    }
    public boolean isName(String name){
        return  this.name.equals(name);
    }
    @Override
    public String toString(){
        return "{" +
                "name: '" + name + '\'' +
                ", sex: '" + sex + '\'' + '\'' +
                ", age: " + age +
                '}';
    }
}