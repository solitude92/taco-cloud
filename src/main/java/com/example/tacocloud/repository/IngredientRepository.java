package com.example.tacocloud.repository;

import com.example.tacocloud.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient , String> {

}
