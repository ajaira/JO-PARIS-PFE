package com.jo.paris.service.admin.category;

import com.jo.paris.dto.CategoryDto;
import com.jo.paris.entity.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategories();
}
