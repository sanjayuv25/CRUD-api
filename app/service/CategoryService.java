package com.ecommerse.app.service;

import com.ecommerse.app.applayer.Category;
import com.ecommerse.app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service //service annotation is for managing bean
public class CategoryService implements CategoryLooseCuppling {

    //public List<Category> categories=new ArrayList<>();
    public Long nextId=1L;
    @Autowired
    public CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        //category.setId(nextId++);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long id) {
        Category category=categoryRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));
//        Category category= categories.stream()
//                .filter(c -> id.equals(c.getId()))
//                .findFirst()
//                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));
//               categoryRepository.delete(category);
             categoryRepository.delete(category);
        return "category with id "+id+" deleted successfully !!";
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        Category savedCategory=categoryRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));
        savedCategory.setName(category.getName());
        savedCategory.setFrom(category.getFrom());
        savedCategory.setTo(category.getTo());
        savedCategory.setNumber(category.getNumber());
        return categoryRepository.save(savedCategory);

//       if(optionalCategory.isPresent()) {
//           Category existingcategory = optionalCategory.get();
//           existingcategory.setName(category.getName());
//           Category savedcategory=categoryRepository.save(existingcategory);
//           return savedcategory;
//       }
//        else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found");
//       }
    }

}
