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

* Java 21 instalado
* Maven instalado
* MySQL (ou banco de sua escolha)
* IDE (IntelliJ, Eclipse, etc.)

### Clone do repositório
Faça um clone do repositório com o seguinte comando via terminal git bash dentro da pasta que deseja:
* `git clone https://github.com/Glaudencio12/API-sistema-escolar-simples.git`

Pronto, agora só abra o projeto no intellij, execute e teste.

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
