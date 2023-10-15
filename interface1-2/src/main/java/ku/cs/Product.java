package ku.cs;

public class Product implements Measurable, Comparable {
    private String name ;
    private double price ;

    public Product (String name, double price) {
        this.name = name ;
        this.price = price ;
    }

    public String getName() {
        return name ;
    }

    public double getPrice() {
        return price ;
    }

    public double getMeasure() {
        return price ;
    }

    @Override
    public int compareTo(Object p) {
        Product product = (Product) p;
        if (this.price < product.price) {
            return -1 ;
        }
        if (this.price > product.price) {
            return 1 ;
        }
        return 0 ;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name=" + name + '\'' +
        ",price=" + price +
                '}';
    }
}
