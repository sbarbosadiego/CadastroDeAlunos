/* Cria o banco de dados */
CREATE SCHEMA dbalunoscurso
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;

/* OPCIONAL conferir se a base de dados foi realmente criada */
SHOW DATABASES;

/* Conecta na base de dados que será utilizada */
USE dbalunoscurso;

/* Cria as tabelas */
CREATE TABLE IF NOT EXISTS curso (
pk_codigo_curso SERIAL NOT NULL AUTO_INCREMENT PRIMARY KEY,
curso_descricao VARCHAR(50) NOT NULL,
curso_ementa TEXT
);

CREATE TABLE IF NOT EXISTS aluno (
pk_codigo_aluno SERIAL NOT NULL AUTO_INCREMENT PRIMARY KEY,
aluno_nome VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS curso_aluno (
pk_codigo SERIAL NOT NULL AUTO_INCREMENT PRIMARY KEY,
fk_aluno BIGINT UNSIGNED,
fk_curso BIGINT UNSIGNED
);

/* OPCIONAL conferir se as tabelas realmente foram criadas */
SHOW TABLES;

/* OPCIONAL conferir as informações das tabelas criadas */
DESCRIBE aluno;
DESCRIBE curso;
DESCRIBE curso_aluno;

/* Cria a chave estrangeira na tabela curso_aluno */
ALTER TABLE curso_aluno
ADD FOREIGN KEY (fk_aluno)
REFERENCES aluno(pk_codigo_aluno);

ALTER TABLE curso_aluno
ADD FOREIGN KEY (fk_curso)
REFERENCES curso(pk_codigo_curso);

/* OPCIONAL conferir as informações da tabela curso_aluno */
DESCRIBE curso_aluno;


