package com.ecommerse.app.repository;

import com.ecommerse.app.applayer.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
