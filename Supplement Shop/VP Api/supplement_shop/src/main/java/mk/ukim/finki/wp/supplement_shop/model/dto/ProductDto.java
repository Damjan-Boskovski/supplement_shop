package mk.ukim.finki.wp.supplement_shop.model.dto;

import lombok.Data;

@Data
public class ProductDto {

    private String name;

    private String imageUrl;

    private double price;

    private String description;

    private int quantity;

    private long categoryId;

    private long manufacturerId;

    public ProductDto() {
    }

    public ProductDto(String name, String imageUrl, double price, String description, int quantity, long categoryId, long manufacturerId) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.manufacturerId = manufacturerId;
    }
}
