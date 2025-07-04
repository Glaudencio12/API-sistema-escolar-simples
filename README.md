# API Sistema Escolar Simples
## Tecnologias Utilizadas
* **Java 21**
* **Spring Boot**
* **MySQL**
* **Maven**

## Funcionalidades
* **Turmas**
  * Criar, listar, atualizar, deletar turmas
  * Listar alunos por turma - A ser implementado
* **Alunos**
  * Criar, listar, atualizar, deletar alunos
  * Consultar alunos por turma  - A ser implementado
    
## Configuração do Ambiente

### Pré-requisitos

* Antes de começar, certifique-se de ter o [Docker Desktop](https://www.docker.com/products/docker-desktop/) e **em execução** em sua máquina.
* [Postman](https://www.postman.com/downloads/) instalado para a realização de testes na aplicação
## Passos para Iniciar o Projeto

1.  **Obtenha os Arquivos do Projeto:**
  * **Opção 1 (Recomendado - Via Git):** clone-o para sua máquina:
      ```bash
      git clone https://github.com/Glaudencio12/API-sistema-escolar-simples
      ```
2. **Configure as Variáveis de Ambiente**
* Edite o arquivo `.env.example` com as credenciais desejadas.

* Exemplo de .env.example:
  ```env
    MYSQL_USER=usuario_exemplo
    MYSQL_PASSWORD=senha_forte
    MYSQL_ROOT_PASSWORD=admin_root
    
    SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/sistema_escolar?useTimezone=true&serverTimezone=UTC
    SPRING_DATASOURCE_USERNAME=usuario_exemplo
    SPRING_DATASOURCE_PASSWORD=senha_forte

  ```
3. **Inicie os Serviços com Docker Compose**
* Navegue até a pasta raiz do projeto no seu terminal e execute o comando abaixo.
    * **Importante:** Certifique-se de que os arquivos `docker-compose.yml` e o `Dockerfile` da aplicação estejam no diretório atual quando você abrir o terminal
   ```bash
   docker compose up -d
   ```
   Esse comando irá:
   * Baixar a imagem da aplicação do Docker Hub (caso ainda não esteja localmente)
   * Subir o banco MySQL e a aplicação conectados em rede


4.  **Verifique a Execução dos Contêineres:**
  * Você pode confirmar que os contêineres estão rodando de duas maneiras:
    * **Via Terminal:** Execute `docker ps` para ver uma lista dos contêineres ativos.

5.  **Acesse a Aplicação:**
  * Com os serviços em funcionamento, você pode testar a aplicação usando o Postaman

### Gerenciamento dos Contêineres

* **Para parar os serviços da aplicação execute:**
    ```bash
    docker compose stop
    ```
  
## Endpoints
### Turmas (`/class`)

* `GET /class` — Listar todas as turmas
* `GET /class/{id}` — Obter turma por ID
* `POST /class` — Criar nova turma
* `PUT /class/{id}` — Atualizar turma via id e body
* `DELETE /class/{id}` — Deletar turma

### Alunos (`/students`)

* `GET /students` — Listar todos os alunos
* `GET /students/{id}` — Obter aluno por ID
* `POST /students/class/{idClass}` — Criar novo aluno 
* `PUT /students/{id}` — Atualizar aluno via id e body
* `PUT /students/class/{id}` — Atualizar turma do aluno
* `DELETE /students/{id}` — Deletar aluno

## Exemplos de testes
