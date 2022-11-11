package com.tacocloudproj.TacoCloudProject.Repository;

import com.tacocloudproj.TacoCloudProject.model.Ingredient;
import com.tacocloudproj.TacoCloudProject.model.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcIngredietnRepository implements IngredientRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcIngredietnRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query(
                "select id, name, type from ingredient",
                this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> result = jdbcTemplate.query(
                "select id, name, type from ingredient where id=?",
                this::mapRowToIngredient,
                id);
        return result.size() == 0 ?
                Optional.empty() :
                Optional.of(result.get(0)
                );
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {
        return new Ingredient(
                row.getString("id"),
                row.getString("name"),
                Type.valueOf(row.getString("type")));
    }
}
