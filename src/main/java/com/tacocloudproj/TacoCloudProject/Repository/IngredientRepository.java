package com.tacocloudproj.TacoCloudProject.Repository;

import com.tacocloudproj.TacoCloudProject.model.Ingredient;

import java.util.Optional;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
