package ku.cs;

public class Car implements Measurable, Comparable {
    private String license;
    private double kiloDriven;

    public Car (String license, double kiloDriven) {
        this.license = license;
        this.kiloDriven = kiloDriven;
    }

    public String getLicense() {
        return license;
    }

    public double getKiloDriven() {
        return kiloDriven;
    }

    public double getMeasure() {
        return kiloDriven;
    }

    @Override
    public int compareTo(Object c) {
        Car car = (Car) c;
        if (this.kiloDriven < car.kiloDriven) {
            return - 1 ;
        }
        if (this.kiloDriven > car.kiloDriven) {
            return 1 ;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Car{" +
                "license=" + license + '\'' +
                ",kiloDriven=" + kiloDriven +
                '}';
    }

}