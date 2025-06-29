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
  * **Opção 1 (Recomendado - Via Git):** Se o projeto estiver em um repositório Git (GitHub, GitLab, etc.), clone-o para sua máquina:
      ```bash
      git clone https://github.com/Glaudencio12/API-sistema-escolar-simples
      ```
2.  **Abra o Terminal no Diretório Correto:**
  * Navegue até a pasta raiz do projeto no seu terminal (ou abra o terminal diretamente dentro dessa pasta, dependendo do seu sistema operacional). 
  * **Importante:** Certifique-se de que os arquivos `docker-compose.yml` e o `Dockerfile` da aplicação estejam no diretório atual quando você abrir o terminal.

3.  **Inicie os Serviços com Docker Compose:**
  * No terminal, execute o seguinte comando:
      ```bash
      docker compose up -d
      ```
    * Este comando irá baixar as imagens necessárias do Docker Hub (sua aplicação e MySQL), criar os contêineres e iniciá-los em segundo plano.

4.  **Verifique a Execução dos Contêineres:**
  * Você pode confirmar que os contêineres estão rodando de duas maneiras:
    * **Via Terminal:** Execute `docker ps` para ver uma lista dos contêineres ativos.
    * **Via Docker Desktop:** Abra o aplicativo Docker Desktop. Na seção "Containers" (ou "Contêineres"), você deverá ver `sistema_escolar_app` e `mysql_sistema_escolar` com status "Running" (Em execução).

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
