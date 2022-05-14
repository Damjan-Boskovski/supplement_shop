package mk.ukim.finki.wp.supplement_shop.service;

import mk.ukim.finki.wp.supplement_shop.model.dto.ProductDto;
import mk.ukim.finki.wp.supplement_shop.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(long id);

    Optional<Product> findByName(String name);

    Optional<Product> save(ProductDto product);

    Optional<Product> edit(long id, ProductDto productDetails);

    void deleteById(long id);
}
