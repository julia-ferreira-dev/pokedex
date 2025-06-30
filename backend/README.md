# 🚀 Pokédex Backend

Backend Java EE para integração com a [PokéAPI](https://pokeapi.co/), fornecendo uma API simples para buscar informações de Pokémon.

## 📋 Funcionalidades

- ✅ Busca de Pokémon por nome
- ✅ Integração com PokéAPI
- ✅ Suporte a CORS para frontend
- ✅ Tratamento de erros robusto
- ✅ Logging detalhado
- ✅ Interface web de teste

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Jakarta EE / Java EE**
- **Maven** para gerenciamento de dependências
- **Servlets** para endpoints REST
- **HttpURLConnection** para requisições HTTP
- **Regex** para parsing JSON simples

## 📁 Estrutura do Projeto

```
backend/
├── src/main/java/com/pokedex/
│   ├── api/                    # Classes de configuração JAX-RS
│   ├── filter/                 # Filtros (CORS)
│   ├── model/                  # Modelos de dados
│   ├── service/                # Lógica de negócio
│   │   ├── PokemonService.java
│   │   ├── PokemonNotFoundException.java
│   │   └── PokemonServiceException.java
│   └── servlet/                # Servlets REST
│       ├── PokemonServlet.java
│       └── HealthServlet.java
├── src/main/webapp/
│   ├── WEB-INF/web.xml        # Configuração dos servlets
│   └── index.html             # Interface de teste
├── pom.xml                    # Configuração Maven
└── README.md
```

## 🚀 Como Executar

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6 ou superior
- Servidor de aplicação (Tomcat, WildFly, etc.) ou IDE com servidor embutido

### Compilação e Execução

1. **Compilar o projeto:**
   ```bash
   mvn clean compile
   ```

2. **Gerar o WAR:**
   ```bash
   mvn clean package
   ```

3. **Executar com Maven (usando OpenLiberty):**
   ```bash
   mvn liberty:run
   ```

4. **Deploy manual:**
   - Copie o arquivo `target/pokedx-backend.war` para a pasta de deploy do seu servidor
   - Acesse `http://localhost:8080/pokedx-backend`

## 📡 API Endpoints

### 1. Health Check
```http
GET /api/health
```

**Resposta:**
```json
{
  "status": "OK",
  "message": "Pokédex API está funcionando!"
}
```

### 2. Buscar Pokémon
```http
GET /api/pokemon?name={nome}
```

**Parâmetros:**
- `name` (string): Nome do Pokémon a ser buscado

**Exemplo de requisição:**
```http
GET /api/pokemon?name=pikachu
```

**Resposta de sucesso (200):**
```json
{
  "name": "pikachu",
  "image": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
  "id": 25
}
```

**Resposta de erro (404):**
```json
{
  "error": "NOT_FOUND",
  "message": "Pokémon 'nome_inexistente' não encontrado",
  "status": 404
}
```

**Resposta de erro (400):**
```json
{
  "error": "BAD_REQUEST",
  "message": "Nome do Pokémon é obrigatório",
  "status": 400
}
```

## 🧪 Como Testar

### 1. Interface Web
Acesse `http://localhost:8080/pokedx-backend` para usar a interface de teste integrada.

### 2. cURL
```bash
# Health check
curl http://localhost:8080/pokedx-backend/api/health

# Buscar Pokémon
curl "http://localhost:8080/pokedx-backend/api/pokemon?name=bulbasaur"
```

### 3. Postman/Insomnia
Importe as seguintes requisições:
- GET `http://localhost:8080/pokedx-backend/api/health`
- GET `http://localhost:8080/pokedx-backend/api/pokemon?name=pikachu`

## 🔧 Configuração

### CORS
O projeto inclui configuração automática de CORS para permitir requisições de diferentes origens. Isso é configurado através do `CorsFilter`.

### Timeouts
- **Conexão:** 10 segundos
- **Leitura:** 15 segundos

### Logging
O projeto usa `java.util.logging` para logs. Os logs incluem:
- Requisições recebidas
- Pokémon encontrados/não encontrados
- Erros de comunicação com a PokéAPI
- Erros internos

## 🐛 Tratamento de Erros

A API trata os seguintes tipos de erro:

1. **400 (Bad Request):** Parâmetro `name` ausente ou vazio
2. **404 (Not Found):** Pokémon não encontrado na PokéAPI
3. **500 (Internal Server Error):** Erros de comunicação com PokéAPI ou erros internos

## 🔄 Integração com Frontend

Para integrar com o frontend, faça requisições para:
```javascript
// Exemplo em JavaScript
fetch('http://localhost:8080/pokedx-backend/api/pokemon?name=pikachu')
  .then(response => response.json())
  .then(data => {
    if (data.error) {
      console.error('Erro:', data.message);
    } else {
      console.log('Pokémon:', data);
      // data.name, data.image, data.id
    }
  })
  .catch(error => console.error('Erro na requisição:', error));
```

## 📝 Próximos Passos

Possíveis melhorias futuras:
- [ ] Cache de requisições para a PokéAPI
- [ ] Busca por ID do Pokémon
- [ ] Informações adicionais (tipos, habilidades, etc.)
- [ ] Paginação para listas de Pokémon
- [ ] Autenticação e rate limiting
- [ ] Testes automatizados
- [ ] Documentação OpenAPI/Swagger

## 🤝 Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.
