package com.example.recipemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RecipeController {

    @Autowired
    RecipeRepository repository;
    ArrayList<Recipe> recipes = new ArrayList<>();

    @GetMapping("/recipes")
    public ResponseEntity<List<Recipe>> getRecipes() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

//    @GetMapping("/courses/{id}")
//    public ResponseEntity<Course> getCourseById(@PathVariable String id) {
//        return ResponseEntity.status(HttpStatus.OK).body(repository.findCourseByid(Integer.parseInt(id)));
//    }

    @PostMapping("/recipe")
    public ResponseEntity<String> createRecipe(@RequestBody Recipe recipe) {
        repository.save(recipe);
        return ResponseEntity.status(HttpStatus.OK).body("Recipe added");
    }

    @DeleteMapping("/course/{id}")
    @Transactional
    public ResponseEntity<String> deleteRecipe(@PathVariable String id) {
        repository.deleteRecipeByid(Integer.parseInt(id));
        return ResponseEntity.status(HttpStatus.OK).body("Recipe with ID " + id + " has been deleted");
    }
}
