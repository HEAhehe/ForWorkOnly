package ku.cs;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product("P1", 100.0),
                new Product("P2", 54.0),
                new Product("P3", 28.0)
        };

        Car[] cars = {
                new Car("C1", 14200.0),
                new Car("C2", 93742.0),
                new Car("C3", 5432.0) };

        Data.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println("--------------");
        System.out.println("sort products by name");
        System.out.println("--------------");

        for (Product product : products) {
            System.out.println(product);
        }

        Data.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() < o2.getPrice()) {
                    return -1;
                } else if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println("--------------");
        System.out.println("sort products by price");
        System.out.println("--------------");

        for (Product product : products) {
            System.out.println(product);
        }

        Data.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getLicense().compareTo(o2.getLicense());
            }
        });

        System.out.println("--------------");
        System.out.println("sort cars by license");
        System.out.println("--------------");

        for (Car car : cars) {
            System.out.println(car);
        }

        Data.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                if (o1.getKiloDriven() < o2.getKiloDriven()) {
                    return -1;
                }
                if (o1.getKiloDriven() > o2.getKiloDriven()) {
                    return 1;
                }
                return 0;
            }
        });

        System.out.println("--------------");
        System.out.println("sort cars by kiloDriven");
        System.out.println("--------------");

        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
