package ku.cs;

public class Main {
    public static void main(String[] args) {
        Product[] products = {  new Product("P1",100.0),
                                new Product("P2", 54.0),
                                new Product("P3", 28.0) };

        Car[] cars = {  new Car("C1", 14200.0),
                        new Car("C2", 93742.0),
                        new Car("C3", 5432.0) };

        Data.sort(products);
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("---------");
        Data.sort(cars);
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}

