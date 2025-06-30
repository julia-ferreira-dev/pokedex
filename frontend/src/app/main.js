const API_BASE_URL = 'http://localhost:8080/api';

async function buscarPokemon() {
    const name = document.getElementById('pokemonName').value.trim();
    if (!name) {
        alert('Por favor, digite o nome de um Pokémon');
        return;
    }

    const loadingEl = document.getElementById('loading');
    const displayEl = document.getElementById('pokemonDisplay');
    
    loadingEl.style.display = 'block';
    displayEl.style.display = 'none';

    try {
        const response = await fetch(`${API_BASE_URL}/pokemon?name=${encodeURIComponent(name)}`);
        const data = await response.json();

        if (response.ok) {
            exibirPokemon(data);
        } else {
            exibirErro(data.message || 'Pokémon não encontrado');
        }
    } catch (error) {
        console.error('Erro ao buscar Pokémon:', error);
        exibirErro('Erro de conexão com a API');
    } finally {
        loadingEl.style.display = 'none';
        displayEl.style.display = 'block';
    }
}

function exibirPokemon(pokemon) {
    const displayEl = document.getElementById('pokemonDisplay');
    displayEl.innerHTML = `
        <div class="pokemon-info">
            <h3>${pokemon.name}</h3>
            <div class="pokemon-image-container">
                <img src="${pokemon.image}" alt="${pokemon.name}" class="pokemon-image" 
                     onerror="this.src='../assets/images/icon.png'">
            </div>
            <p class="pokemon-id">#${pokemon.id.toString().padStart(3, '0')}</p>
        </div>
    `;
}

function exibirErro(mensagem) {
    const displayEl = document.getElementById('pokemonDisplay');
    displayEl.innerHTML = `
        <div class="error-message">
            <h3>❌ Erro</h3>
            <p>${mensagem}</p>
            <p class="error-tip">Tente outro nome</p>
        </div>
    `;
}

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('pokemonName').addEventListener('keypress', function(e) {
        if (e.key === 'Enter') {
            buscarPokemon();
        }
    });

    checkApiHealth();
});

async function checkApiHealth() {
    try {
        const response = await fetch(`${API_BASE_URL}/health`);
        if (!response.ok) {
            console.warn('API pode estar indisponível');
        }
    } catch (error) {
        console.warn('Não foi possível conectar com a API:', error);
    }
}