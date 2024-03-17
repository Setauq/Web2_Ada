# Projeto Gestão de Livros

Ser + Tech Programa 50+
Projeto Final do modulo  - Programação Web II

## Objetivo
Desenvolver um sistema de biblioteca que simule uma gestão de livros. 
Livros:
Criar
Visualizar
Atualizar
Deletar

Membros da biblioteca:
Criar
Visualizar
Atualizar
Deletar

Gestão de Empréstimos:
Registrar empréstimos de livros aos membros.
Definir prazo para devolução e gerenciar multas por atraso.


## Desenvolvimento
Este projeto foi criado como parte do Desafio do Curso de Java da AdaTech, patrocinado 
pela Núclea e ministrado pelo professor Alex Facincani.

## Funcionalidade

Foram criadas as tabelas de membro, endereço,  livro e empréstimo.

Tabela de membros possui informações das pessoas que podem fazer empréstimos de livros.
Tabela de endereço dos membros.
Tabela de livros contém as informações para empréstimo.
Tabela de empréstimo é responsável por registrar os empréstimo, data de devolução, atrasos e multas.

## Como utilizar

Para utilizá-lo, será necessário ferramentas como Postman, Insomnia, Thunder Client ou similar.

Exemplos:
Post
http://localhost:8080/livro

Patch
http://localhost:8080/livro/{id}

Delete
http://localhost:8080/livro/delete/{id}

Get
http://localhost:8080/livro/all

Put
http://localhost:8080/livro/{id}

