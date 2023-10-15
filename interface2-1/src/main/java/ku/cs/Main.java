package ku.cs;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product ("P1",100.0),
                new Product("P2", 54.0),
                new Product("P3", 28.0) };

        Car[] cars = {
                new Car("C1", 14200.0),
                new Car("C2", 93742.0),
                new Car("C3", 5432.0) };

        double minProduct = Data.min(products, new Measurer() {
            @Override
            public double measure(Object obj) {
                Product product = (Product) obj;
                return product.getPrice();
            }
        });

        double minCar = Data.min(cars, new Measurer() {
            @Override
            public double measure(Object obj) {
                Car car = (Car) obj;
                return car.getKiloDriven();
            }
        });

        System.out.println("min price of Product = " + minProduct);
        System.out.println("min kiloDriven of Car = " + minCar);
    }
}

