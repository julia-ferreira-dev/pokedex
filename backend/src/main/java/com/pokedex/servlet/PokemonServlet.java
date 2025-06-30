package com.pokedex.servlet;

import com.pokedex.model.Pokemon;
import com.pokedex.service.PokemonNotFoundException;
import com.pokedex.service.PokemonService;
import com.pokedex.service.PokemonServiceException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet para buscar informações de Pokémon
 */
@WebServlet(name = "PokemonServlet", urlPatterns = {"/api/pokemon"})
public class PokemonServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(PokemonServlet.class.getName());
    private PokemonService pokemonService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.pokemonService = new PokemonService();
        logger.info("PokemonServlet inicializado");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Configurar CORS para permitir requisições do frontend
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pokemonName = request.getParameter("name");
        
        PrintWriter out = response.getWriter();

        try {
            // Validação do parâmetro
            if (pokemonName == null || pokemonName.trim().isEmpty()) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.println("{\"error\":\"BAD_REQUEST\",\"message\":\"Nome do Pokémon é obrigatório\",\"status\":400}");
                return;
            }

            logger.info("Buscando Pokémon: " + pokemonName);

            Pokemon pokemon = pokemonService.getPokemonByName(pokemonName.trim());
            
            // Retorna o JSON do Pokémon
            String jsonResponse = String.format(
                "{\"name\":\"%s\",\"image\":\"%s\",\"id\":%d}",
                pokemon.getName(),
                pokemon.getImage() != null ? pokemon.getImage() : "",
                pokemon.getId()
            );
            
            response.setStatus(HttpServletResponse.SC_OK);
            out.println(jsonResponse);
            logger.info("Pokémon encontrado: " + pokemon.getName());

        } catch (PokemonNotFoundException e) {
            logger.warning("Pokémon não encontrado: " + pokemonName);
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            out.println("{\"error\":\"NOT_FOUND\",\"message\":\"" + e.getMessage() + "\",\"status\":404}");

        } catch (PokemonServiceException e) {
            logger.log(Level.SEVERE, "Erro no serviço ao buscar Pokémon: " + pokemonName, e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("{\"error\":\"SERVICE_ERROR\",\"message\":\"Erro interno do servidor\",\"status\":500}");

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro inesperado ao buscar Pokémon: " + pokemonName, e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("{\"error\":\"INTERNAL_ERROR\",\"message\":\"Erro interno inesperado\",\"status\":500}");

        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Configurar CORS para preflight requests
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
