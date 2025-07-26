package com.chovin.blog.controller;

import com.chovin.blog.domain.dto.CategoryDto;
import com.chovin.blog.domain.entities.Category;
import com.chovin.blog.mapper.CategoryMapper;
import com.chovin.blog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private CategoryService categoryService;
    private CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories(){
        List<Category> listCategory= categoryService.listCategories();
        return ResponseEntity.ok(listCategory.stream().map(categoryMapper::toDto).toList());
    }
}
