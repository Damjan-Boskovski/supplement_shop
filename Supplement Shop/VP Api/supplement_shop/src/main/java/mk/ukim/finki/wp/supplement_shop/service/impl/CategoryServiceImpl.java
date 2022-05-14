package mk.ukim.finki.wp.supplement_shop.service.impl;

import mk.ukim.finki.wp.supplement_shop.exception.CategoryNotFoundException;
import mk.ukim.finki.wp.supplement_shop.model.Category;
import mk.ukim.finki.wp.supplement_shop.repository.CategoryRepository;
import mk.ukim.finki.wp.supplement_shop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<Category> save(Category category) {
        return Optional.of(categoryRepository.save(category));
    }

    @Override
    public Optional<Category> edit(long id, Category categoryDetails) {
        Category categoryToEdit = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

        categoryToEdit.setName(categoryDetails.getName());
        return Optional.of(categoryRepository.save(categoryToEdit));
    }

    @Override
    public void deleteById(long id) {
        categoryRepository.deleteById(id);
    }
}
