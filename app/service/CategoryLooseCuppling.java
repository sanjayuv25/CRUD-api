package com.ecommerse.app.service;

import com.ecommerse.app.applayer.Category;

import java.util.List;

public interface CategoryLooseCuppling
{
   List<Category> getAllCategory();
   void createCategory(Category category);
   String deleteCategory(Long id);
   Category updateCategory(Category  category,Long id);
}
