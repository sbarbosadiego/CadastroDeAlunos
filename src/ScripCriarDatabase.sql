/* Altera o delimitador para ser executado o script */
DELIMITER $

/* Cria a base de dados */
CREATE DATABASE escola;

/* Seleciona a base de dados */
USE escola;

/* Cria as tabelas e configura as fks */
CREATE TABLE IF NOT EXISTS curso (
pk_codigo_curso SERIAL NOT NULL PRIMARY KEY,
curso_descricao VARCHAR(50) NOT NULL,
curso_ementa TEXT
);

CREATE TABLE IF NOT EXISTS aluno (
pk_codigo_aluno SERIAL NOT NULL PRIMARY KEY,
aluno_nome VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS curso_aluno (
pk_codigo SERIAL NOT NULL PRIMARY KEY,
fk_aluno BIGINT UNSIGNED,
fk_curso BIGINT UNSIGNED,
FOREIGN KEY (fk_aluno) REFERENCES aluno(pk_codigo_aluno),
FOREIGN KEY (fk_curso) REFERENCES curso(pk_codigo_curso)
);

$
