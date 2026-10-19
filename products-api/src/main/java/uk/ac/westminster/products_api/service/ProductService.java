package uk.ac.westminster.products_api.service;

import org.springframework.stereotype.Service;
import uk.ac.westminster.products_api.product.DigitalProduct;
import uk.ac.westminster.products_api.product.PhysicalProduct;
import uk.ac.westminster.products_api.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public ProductService() {
        Product DigitalProduct = new DigitalProduct(
                nextId++,
                "Clean Code (E-Book)",
                100.00,
                "downloads/cleancode.pdf",
                12.00
        );

        Product PhysicalProduct = new PhysicalProduct(
                nextId++,
                "Macbook",
                1500.00,
                3.5,
                "100.00 x 120 x 50"
        );

        products.add(DigitalProduct);
        products.add(PhysicalProduct);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        product.setId(nextId++); // use the value, then add one
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }
    
}
