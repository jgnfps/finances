# 📊 Finances API

API REST para controle financeiro pessoal, desenvolvida com **Java 21 + Spring Boot 3**.

## 📌 Funcionalidades

- Cadastro e autenticação de usuários
- Cadastro de categorias de transação (ex: Alimentação, Transporte)
- Registro de receitas e despesas
- Filtro de transações por usuário, tipo e período
- Validações e tratamento de erros
- Validações de entrada via Bean Validation
- Password hashing com BCrypt
- Estrutura de camadas: Controller → Service → Repository

## 📦 Tecnologias

- Java 21
- Spring Boot 3
- Spring Data JPA
- H2 Database (dev)
- Spring Validation
- BCrypt Password Encoder
- Lombok

## 📑 Como rodar

1️⃣ Clone o projeto:
```bash
git clone https://github.com/seuusuario/finances-api.git

## 📦 Exemplos de uso

Criar Usuário

{
  "nome": "João Guilherme",
  "email": "joao@gmail.com",
  "senha": "123456"
}

Criar Transação

{
  "descricao": "Academia",
  "valor": 90.00,
  "data": "2025-07-03",
  "tipo": "DESPESA",
  "categoriaId": 1,
  "usuarioId": 1
}

## 📈 Melhorias futuras
Paginação e ordenação

Atualização de dados (PUT)

Validação de e-mail único

JWT para autenticação segura

Relatórios de saldo mensal
