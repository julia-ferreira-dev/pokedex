package com.pokedex.service;

/**
 * Exceção lançada quando um Pokémon não é encontrado na PokéAPI
 */
public class PokemonNotFoundException extends Exception {

    public PokemonNotFoundException(String message) {
        super(message);
    }

    public PokemonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
