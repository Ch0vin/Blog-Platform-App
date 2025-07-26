package com.chovin.blog.service.impl;

import com.chovin.blog.domain.entities.Category;
import com.chovin.blog.repository.CategoryRepository;
import com.chovin.blog.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepositoryl;


    @Override
    public List<Category> listCategories() {
        return categoryRepositoryl.findAllWithPostCount() ;
    }
}
