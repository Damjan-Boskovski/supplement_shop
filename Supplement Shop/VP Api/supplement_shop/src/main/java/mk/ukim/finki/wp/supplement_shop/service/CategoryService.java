package mk.ukim.finki.wp.supplement_shop.service;


import mk.ukim.finki.wp.supplement_shop.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();

    Optional<Category> findById(long id);

    Optional<Category> save(Category category);

    Optional<Category> edit(long id, Category categoryDetails);

    void deleteById(long id);

}

