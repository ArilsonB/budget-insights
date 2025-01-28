package io.github.arilsondev.BudgetInsights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import io.github.arilsondev.BudgetInsights.model.Category;
import io.github.arilsondev.BudgetInsights.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> findByCategoryType(String categoryType) {
        return categoryRepository.findByCategoryType(categoryType);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}