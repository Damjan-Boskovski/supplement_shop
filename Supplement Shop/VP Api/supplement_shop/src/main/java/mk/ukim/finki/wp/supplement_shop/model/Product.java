package mk.ukim.finki.wp.supplement_shop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String imageUrl;

    private double price;

    @Column(length = 4000)
    private String description;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    public Product() {
    }

    public Product(String name, String imageUrl, double price, String description, int quantity, Category category, Manufacturer manufacturer) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.category = category;
        this.manufacturer = manufacturer;
    }
}
