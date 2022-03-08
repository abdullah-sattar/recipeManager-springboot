package com.example.recipemanager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String time;
    private String ingredients;

    public Recipe() {
    }

    public Recipe(int id, String name, String time, String ingredients) {
        this.name = name;
        this.time = time;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getIngredients() {
        return ingredients;
    }
}
