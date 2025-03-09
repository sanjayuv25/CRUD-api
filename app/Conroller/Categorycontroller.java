package com.ecommerse.app.Conroller;


import com.ecommerse.app.applayer.Category;
import com.ecommerse.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")// we can use this to avoid passing /api in each method
public class Categorycontroller
{
    @Autowired // used to avoid constructor ; it is field injuction
    public CategoryService service;

//    public Categorycontroller(CategoryService service) {
//        this.service = service;
//    }

   // @RequestMapping(value = "/public/category",method = RequestMethod.GET)|| it also for get mapping
    @GetMapping("/public/category")
     public ResponseEntity<List<Category>> getCategory()
     {
         List<Category> categories= service.getAllCategory();
         return new ResponseEntity<>(categories,HttpStatus.OK);
     }
     //@RequestMapping(value = "/public/category",method = RequestMethod.POST)|| for post mapping
     @PostMapping("/private/category")
     public ResponseEntity<String> addCategory(@RequestBody Category category)
     {
          service.createCategory(category);
         return new ResponseEntity<>("Category added successfully",HttpStatus.CREATED);
     }
     @DeleteMapping("/private/category/{id}")
     public ResponseEntity<String> deleteCategory(@PathVariable Long id)
     {
         try {
             String status = service.deleteCategory(id);
             return new ResponseEntity<>(status,HttpStatus.OK);
             //return ResponseEntity.ok(status);   //this is also fine
         }
         catch(ResponseStatusException e)
         {
             return new ResponseEntity<>(e.getReason(),e.getStatusCode());
         }
     }
     @PutMapping("/private/category/{id}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category,@PathVariable Long id)
     {
         try
         {
             Category uodate=service.updateCategory(category,id);
             return new ResponseEntity<>("Category with id modified :"+id,HttpStatus.OK);
         }
         catch (ResponseStatusException e)
         {
             return new ResponseEntity<>(e.getReason(),e.getStatusCode());
         }
     }
}
