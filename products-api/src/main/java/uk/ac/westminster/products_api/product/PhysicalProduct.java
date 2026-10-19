package uk.ac.westminster.products_api.product;

//PhysicalProduct is a product that has to be picked, packed and shipped.
public class PhysicalProduct extends Product{
    private double weightKg;
    private String dimensions;

    public PhysicalProduct() {}

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getweightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}

