# GameStore

## 1. Sobre o Projeto

O GameStore é uma aplicação desktop desenvolvida em Java utilizando JavaFX, PostgreSQL e Docker.

O principal objetivo deste projeto foi praticar e consolidar conhecimentos relacionados a:

- Programação Orientada a Objetos (POO)
- Arquitetura MVC
- Persistência de dados com JDBC
- Integração com PostgreSQL
- Utilização de Docker
- Desenvolvimento de interfaces gráficas com JavaFX
- Estruturação de projetos utilizando Maven

---

## 1.1 Tecnologias Utilizadas

| Tecnologia | Versão |
|------------|---------|
| Java | 21 |
| JavaFX | 21 |
| Maven | 3+ |
| PostgreSQL | 15 |
| Docker | Latest |
| IntelliJ IDEA | 2025+ |

---

## 2. Funcionalidades

### 2.1 Gerenciamento de Jogos

- Cadastrar jogos
- Atualizar jogos
- Excluir jogos
- Visualizar jogos cadastrados

### 2.2 Gerenciamento de Usuários

- Cadastrar usuários
- Atualizar usuários
- Excluir usuários
- Visualizar usuários cadastrados

### 2.3 Market

- Registrar compras
- Atualizar compras
- Excluir compras
- Visualizar compras registradas

---

## 3. Estrutura do Projeto

```text
src
├── Controller
├── DAO
├── Model
├── Util
└── view
```

### 3.1 Controller

Responsável por controlar a interação entre interface e sistema.

### 3.2 DAO

Responsável pelas operações de banco de dados.

### 3.3 Model

Representa as entidades da aplicação.

### 3.4 View

Arquivos FXML responsáveis pelas telas.

### 3.5 Util

Classes auxiliares, como a conexão com o banco de dados.

---

## 4. Instalação do IntelliJ IDEA

### 4.1 Download

Acesse:

https://www.jetbrains.com/idea/download

Baixe a versão Community Edition.

### 4.2 Instalação

Execute o instalador e siga os passos padrão.

### 4.3 Configuração do JDK

Após abrir o IntelliJ:

1. File
2. Project Structure
3. SDK
4. Adicione o Java 21

---

## 5. Instalação do Docker

### 5.1 Download

Acesse:

https://www.docker.com/products/docker-desktop/

Baixe o Docker Desktop para Windows.

### 5.2 Instalação

Execute o instalador e mantenha as opções padrão.

### 5.3 Verificação

Abra o terminal e execute:

```bash
docker --version
```

Exemplo:

```bash
Docker version 28.x.x
```

---

## 6. Configuração do Banco de Dados

### 6.1 Iniciar o Container

Na raiz do projeto execute:

```bash
docker compose up -d
```

### 6.2 Verificar Containers

```bash
docker ps
```

### 6.3 Parar Container

```bash
docker compose down
```

---

## 7. Estrutura do Banco

```sql
CREATE TABLE games (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    price NUMERIC(10,2)
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE market (
    id SERIAL PRIMARY KEY,
    user_id INTEGER,
    game_id INTEGER
);
```

---

## 8. Executando o Projeto

### 8.1 Clonar o Repositório

```bash
git clone URL_DO_REPOSITORIO
```

### 8.2 Abrir no IntelliJ

Abra a pasta do projeto pelo IntelliJ IDEA.

### 8.3 Executar Banco de Dados

```bash
docker compose up -d
```

### 8.4 Executar Aplicação

```bash
mvn javafx:run
```

---

## 9. Conceitos Aplicados

Durante o desenvolvimento foram utilizados conceitos de:

### 9.1 Programação Orientada a Objetos

- Encapsulamento
- Abstração
- Organização em classes

### 9.2 Arquitetura MVC

- Model
- View
- Controller

### 9.3 Persistência de Dados

- JDBC
- PostgreSQL
- DAO Pattern

### 9.4 Containerização

- Docker
- Docker Compose

---

## 10. Autor

Marcos Henrique Barbosa Pessoa

Projeto acadêmico desenvolvido para praticar conceitos de Programação Orientada a Objetos, persistência de dados, arquitetura MVC e integração com banco de dados PostgreSQL utilizando Docker.
