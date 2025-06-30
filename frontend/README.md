# 🎮 Pokédex Frontend

Uma interface moderna e responsiva para buscar informações de Pokémon, desenvolvida com HTML5, CSS3 e JavaScript vanilla.

## ✨ Features

- 🔍 **Busca inteligente** - Digite o nome do Pokémon e encontre instantaneamente
- 📱 **Design responsivo** - Funciona perfeitamente em desktop, tablet e mobile
- 🎨 **Visual moderno** - Interface com glassmorphism e tema Charizard
- ⚡ **Performance otimizada** - Carregamento rápido e animações suaves
- 🎯 **UX intuitiva** - Busca por Enter, feedback visual e estados de loading

## 🚀 Tecnologias

- **HTML5** - Estrutura semântica e acessível
- **CSS3** - Glassmorphism, animações e responsividade
- **JavaScript ES6+** - Fetch API, async/await e manipulação do DOM
- **Google Fonts** - Tipografia Poppins para modernidade

## 📱 Responsividade

| Dispositivo | Largura | Layout |
|-------------|---------|--------|
| Desktop | > 768px | Layout completo com todas as features |
| Tablet | 481px - 768px | Interface adaptada para touch |
| Mobile | ≤ 480px | Design otimizado para telas pequenas |

## 🎨 Design System

### Cores
- **Background**: Imagem de floresta com overlay
- **Container**: Glassmorphism com `backdrop-filter: blur(12px)`
- **Input**: `#f8f9fa` normal, `#ffffff` em foco
- **Botão**: Gradiente laranja `#ff6b35` → `#ff4757`

### Tipografia
- **Fonte principal**: Poppins (300, 400, 500, 600)
- **Fonte alternativa**: Roboto
- **Fonte display**: Courier New (elementos da Pokédex)

## 🏗️ Estrutura do Projeto

```
frontend/src/
├── app/
│   └── index.html          # Página principal
├── assets/
│   ├── scripts/
│   │   └── main.js         # Lógica da aplicação
│   ├── styles/
│   │   └── global.css      # Estilos globais
│   └── images/             # Assets visuais
│       ├── pokedex.png     # Imagem principal da Pokédex
│       ├── icon.png        # Favicon
│       └── floresta.png    # Background
```

## 🔧 Como usar

### Pré-requisitos
- Navegador moderno com suporte a ES6+
- Servidor backend rodando na porta 8080

### Instalação
1. Clone o repositório
```bash
git clone <seu-repositorio>
cd pokedex/frontend
```

2. Sirva os arquivos estáticos
```bash
# Com Python
python -m http.server 3000

# Com Node.js (http-server)
npx http-server -p 3000

# Ou abra diretamente no navegador
open src/app/index.html
```

3. Acesse no navegador
```
http://localhost:3000/src/app/
```

## 🔌 API Integration

O frontend consome uma API REST local:

```javascript
const API_BASE_URL = 'http://localhost:8080/api';

// Endpoints utilizados
GET /api/pokemon?name={nome}  // Buscar Pokémon
GET /api/health              // Status da API
```

### Exemplo de Response
```json
{
  "id": 39,
  "name": "JIGGLYPUFF",
  "image": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/39.png"
}
```

## 🎯 Funcionalidades

### Busca de Pokémon
- Input com placeholder inteligente
- Validação de campos vazios
- Loading state durante requisições
- Tratamento de erros com mensagens amigáveis

### Interface Interativa
- Botão de busca com efeitos hover/active
- Animações suaves de transição
- Feedback visual em todos os estados
- Design que simula uma Pokédex real

### Estados da Aplicação
1. **Inicial**: Mensagem de boas-vindas
2. **Loading**: Spinner com animação
3. **Sucesso**: Exibição do Pokémon encontrado
4. **Erro**: Mensagem de erro com dica

## 🌟 Highlights Técnicos

- **Glassmorphism**: Efeito de vidro moderno
- **CSS Grid/Flexbox**: Layout responsivo
- **Fetch API**: Requisições assíncronas
- **Error Handling**: Tratamento robusto de erros
- **Performance**: Otimizações de carregamento

## 🔮 Roadmap

- [ ] Cache local de Pokémon buscados
- [ ] Modo dark/light
- [ ] Busca por ID do Pokémon
- [ ] Histórico de buscas
- [ ] Favoritos
- [ ] Informações adicionais (tipos, stats)

## 🤝 Contribuindo

1. Fork o projeto
2. Crie uma branch (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request



## 👨‍💻 Autor

Desenvolvido com ❤️ por Julia Ferreira

---

⭐ **Gostou do projeto? Deixe uma estrela!**
