package com.pokedex.model;

/**
 * Modelo de dados para representar um Pokémon
 */
public class Pokemon {
    private String name;
    private String image;
    private Integer id;

    public Pokemon() {
    }

    public Pokemon(String name, String image, Integer id) {
        this.name = name;
        this.image = image;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", id=" + id +
                '}';
    }
}
