# 🎮 Pokédex - Aplicação Full Stack

Uma aplicação completa para buscar e visualizar informações de Pokémon, desenvolvida com Java (backend) e HTML/CSS/JavaScript (frontend).

![Pokédx Preview](frontend/src/assets/images/pokedex.png)

## 🚀 Sobre o Projeto

Este projeto consiste em uma **Pokédx interativa** que permite aos usuários buscar informações de Pokémon através de uma interface moderna e responsiva. A aplicação simula uma Pokédx real com design glassmorphism e tema inspirado no Charizard.

### ✨ Features Principais

- 🔍 **Busca inteligente** - Digite o nome do Pokémon e veja as informações instantaneamente
- 📱 **Design responsivo** - Funciona perfeitamente em desktop, tablet e mobile  
- 🎨 **Interface moderna** - Visual com glassmorphism e animações suaves
- ⚡ **API REST robusta** - Backend escalável com Java e servlets
- 🌐 **Frontend vanilla** - Performance otimizada com tecnologias nativas
- 🔄 **UX intuitiva** - Estados visuais claros para loading, erro e sucesso

## 🏗️ Arquitetura

```
pokedx/
├── 🔧 backend/              # API REST em Java
│   ├── src/main/java/       # Servlets, models, services
│   ├── pom.xml             # Dependências Maven
│   └── 📖 README.md        # Documentação completa do backend
├── 🎨 frontend/            # Interface do usuário  
│   ├── src/app/           # HTML da aplicação
│   ├── src/assets/        # CSS, JS e imagens
│   └── 📖 README.md       # Documentação completa do frontend
└── 📋 README.md           # Este arquivo (visão geral)
```

## 🛠️ Stack Tecnológica

### Backend
- **Java 11+** + **Jakarta Servlets** - API REST robusta
- **Maven** - Gerenciamento de dependências
- **Jackson** - Serialização JSON eficiente

### Frontend  
- **HTML5 + CSS3 + JavaScript ES6+** - Tecnologias nativas
- **Fetch API** - Comunicação assíncrona
- **Google Fonts (Poppins)** - Tipografia moderna

## 🚀 Quick Start

### 1. Clone e execute o Backend
```bash
git clone https://github.com/seu-usuario/pokedex.git
cd pokedx/backend
mvn clean compile exec:java
```
🌐 **Backend rodando em:** `http://localhost:8080`

### 2. Execute o Frontend
```bash
cd ../frontend
python -m http.server 3000
```
🎮 **Aplicação disponível em:** `http://localhost:3000/src/app/`

## � Documentação Detalhada

Para informações técnicas completas, consulte a documentação específica de cada módulo:

| Módulo | Documentação | Descrição |
|--------|--------------|-----------|
| 🔧 **Backend** | [`backend/README.md`](backend/README.md) | API REST, endpoints, arquitetura e deploy |
| 🎨 **Frontend** | [`frontend/README.md`](frontend/README.md) | Interface, componentes, estilos e responsividade |

## 🎯 Demo

**Funcionalidades em ação:**
1. **Digite** o nome de um Pokémon (ex: "pikachu")
2. **Visualize** a imagem e informações na tela da Pokédx
3. **Teste** a responsividade redimensionando a janela
4. **Experimente** diferentes Pokémon e veja os estados de erro

## 🤝 Contribuindo

Contribuições são bem-vindas! Para contribuir:

1. **Fork** o repositório
2. **Crie** uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. **Commit** suas mudanças (`git commit -m 'Adiciona nova feature'`)  
4. **Abra** um Pull Request

## 👨‍💻 Autor

Desenvolvido com ❤️ por **Julia Alves Ferreira**

---

⭐ **Gostou do projeto? Deixe uma estrela!**
