package mk.ukim.finki.wp.supplement_shop.service.impl;

import mk.ukim.finki.wp.supplement_shop.model.dto.ProductDto;
import mk.ukim.finki.wp.supplement_shop.exception.CategoryNotFoundException;
import mk.ukim.finki.wp.supplement_shop.exception.ManufacturerNotFoundException;
import mk.ukim.finki.wp.supplement_shop.exception.ProductNotFoundException;
import mk.ukim.finki.wp.supplement_shop.model.Category;
import mk.ukim.finki.wp.supplement_shop.model.Manufacturer;
import mk.ukim.finki.wp.supplement_shop.model.Product;
import mk.ukim.finki.wp.supplement_shop.repository.CategoryRepository;
import mk.ukim.finki.wp.supplement_shop.repository.ManufacturerRepository;
import mk.ukim.finki.wp.supplement_shop.repository.ProductRepository;
import mk.ukim.finki.wp.supplement_shop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ManufacturerRepository manufacturerRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Optional<Product> save(ProductDto product) {
        Category category = categoryRepository.findById(product.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(product.getCategoryId()));
        Manufacturer manufacturer = manufacturerRepository.findById(product.getManufacturerId())
                .orElseThrow(() -> new ManufacturerNotFoundException(product.getManufacturerId()));

        Product productToSave = new Product(product.getName(), product.getImageUrl(),
                product.getPrice(), product.getDescription(),
                product.getQuantity(), category, manufacturer);

        return Optional.of(productRepository.save(productToSave));
    }

    @Override
    public Optional<Product> edit(long id, ProductDto productDetails) {
        Product productToEdit = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        productToEdit.setName(productDetails.getName());
        productToEdit.setImageUrl(productDetails.getImageUrl());
        productToEdit.setPrice(productDetails.getPrice());
        productToEdit.setDescription(productDetails.getDescription());
        productToEdit.setQuantity(productDetails.getQuantity());

        Category category = categoryRepository.findById(productDetails.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(productDetails.getCategoryId()));
        Manufacturer manufacturer = manufacturerRepository.findById(productDetails.getManufacturerId())
                .orElseThrow(() -> new ManufacturerNotFoundException(productDetails.getManufacturerId()));

        productToEdit.setCategory(category);
        productToEdit.setManufacturer(manufacturer);

        return Optional.of(productRepository.save(productToEdit));
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
}
