package com.example.tacocloud.configuration;

import com.example.tacocloud.domain.Ingredient;
import com.example.tacocloud.repository.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.tacocloud.domain.Ingredient.Type;


@Configuration
public class SpringJdbcConfig {

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository ingredientRepository) {
        return args -> {
            ingredientRepository.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
            ingredientRepository.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
            ingredientRepository.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
            ingredientRepository.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
            ingredientRepository.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
            ingredientRepository.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
            ingredientRepository.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
            ingredientRepository.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
            ingredientRepository.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
            ingredientRepository.save(new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));

        };
    }


//    @Bean
//    public DataSource datasource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .setName("tacoCLoud")
//                .generateUniqueName(false)
//                .build();
//    }

//    @Bean
//    public JdbcTemplate jdbcTemplateDS(){
//        return new JdbcTemplate(datasource());
//    }
}
