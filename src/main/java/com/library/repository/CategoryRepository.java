package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{


}