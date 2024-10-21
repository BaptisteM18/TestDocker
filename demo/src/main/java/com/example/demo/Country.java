package com.example.demo;

public class Country {
    private static int counter = 0;
    private int id;
    private String name;
    private int population;

    public Country(String name, int population) {
        this.id = ++counter;
        this.name = name;
        this.population = population;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

}
