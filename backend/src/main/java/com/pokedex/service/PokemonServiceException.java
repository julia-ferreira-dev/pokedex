package com.pokedex.service;

/**
 * Exceção lançada quando há problemas na comunicação com a PokéAPI
 */
public class PokemonServiceException extends Exception {

    public PokemonServiceException(String message) {
        super(message);
    }

    public PokemonServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
