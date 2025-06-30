package com.pokedex.service;

import com.pokedex.model.Pokemon;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Serviço para integração com a PokéAPI
 */
public class PokemonService {

    private static final Logger logger = Logger.getLogger(PokemonService.class.getName());
    private static final String POKEAPI_BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

    public PokemonService() {
    }

    /**
     * Busca um Pokémon pelo nome na PokéAPI
     * @param name Nome do Pokémon
     * @return Pokemon com nome, imagem e ID
     * @throws PokemonNotFoundException Se o Pokémon não for encontrado
     * @throws PokemonServiceException Se houver erro na comunicação com a API
     */
    public Pokemon getPokemonByName(String name) throws PokemonNotFoundException, PokemonServiceException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do Pokémon não pode ser nulo ou vazio");
        }

        String urlString = POKEAPI_BASE_URL + name.toLowerCase().trim();
        logger.info("Buscando Pokémon: " + name + " na URL: " + urlString);

        try {
            URI uri = URI.create(urlString);
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000); // 10 segundos
            connection.setReadTimeout(15000); // 15 segundos
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            
            if (responseCode == 200) {
                String jsonResponse = readResponse(connection);
                return parsePokemonResponse(jsonResponse);
            } else if (responseCode == 404) {
                throw new PokemonNotFoundException("Pokémon '" + name + "' não encontrado");
            } else {
                throw new PokemonServiceException("Erro ao buscar Pokémon. Status: " + responseCode);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao fazer requisição para PokéAPI", e);
            throw new PokemonServiceException("Erro de comunicação com a PokéAPI: " + e.getMessage());
        }
    }

    /**
     * Lê a resposta da conexão HTTP
     */
    private String readResponse(HttpURLConnection connection) throws IOException {
        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }
        return response.toString();
    }

 private Pokemon parsePokemonResponse(String jsonResponse) throws PokemonServiceException {
    try {
        JSONObject json = new JSONObject(jsonResponse);

        int id = json.getInt("id");
        String name = json.getString("name");
        String image = "";

        // Pega o campo sprites/front_default
        if (!json.isNull("sprites")) {
            JSONObject sprites = json.getJSONObject("sprites");
            if (!sprites.isNull("front_default")) {
                image = sprites.getString("front_default");
            } else if (!sprites.isNull("front_shiny")) {
                image = sprites.getString("front_shiny");
            }
        }

        Pokemon pokemon = new Pokemon(name, image, id);
        logger.info("Pokémon processado com sucesso: " + pokemon);

        return pokemon;
    } catch (Exception e) {
        logger.log(Level.SEVERE, "Erro ao processar resposta JSON da PokéAPI", e);
        throw new PokemonServiceException("Erro ao processar dados do Pokémon: " + e.getMessage());
    }
}
    /**
     * Busca um Pokémon pelo ID
     */
    public Pokemon getPokemonById(Integer id) throws PokemonNotFoundException, PokemonServiceException {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID do Pokémon deve ser um número positivo");
        }
        
        return getPokemonByName(id.toString());
    }
}
