package ku.cs;

public class Main {
    public static void main(String[] args) {
        Product[] products = { new Product ("P1",100.0),
                new Product("P2", 54.0),
                new Product("P3", 28.0) };

        Car[] cars = {new Car("C1", 14200.0),
        new Car("C2", 93742.0),
                new Car("C3", 5432.0) };

        double minProduct = Data.min(products);
        double minCar = Data.min(cars);

        System.out.println("Min price of Product is : " + minProduct);
        System.out.println("Min kiloDriven of Car is : " + minCar);

    }
}

