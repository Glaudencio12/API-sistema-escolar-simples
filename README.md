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

## Endpoints
### Turmas (`/class`)

* `GET /class` — Listar todas as turmas
* `GET /class/{id}` — Obter turma por ID
* `POST /class` — Criar nova turma
* `PUT /class/update` — Atualizar turma via body
* `DELETE /class/delete/{id}` — Deletar turma
* `GET /class/{id}/students` — Listar alunos da turma

### Alunos (`/students`)

* `GET /students` — Listar todos os alunos
* `GET /students/{id}` — Obter aluno por ID
* `POST /students/class/{idClass}` — Criar novo aluno
* `PUT /students/update` — Atualizar aluno
* `PUT /students/update/class/{idClass}` — Atualizar turma do aluno
* `DELETE /students/delete/{id}` — Deletar aluno
* `GET /students/by-class/{id}` — Listar alunos de uma turma específica
