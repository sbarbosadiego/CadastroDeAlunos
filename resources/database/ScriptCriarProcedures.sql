/* 
	Antes de executar os comandos alterar o delimiter para $
	Após isso pode ser retornado para o ;
*/

DELIMITER $

CREATE PROCEDURE Consulta_Aluno_Curso()
BEGIN
	SELECT
	E.pk_codigo AS 'Código',
	A.aluno_nome AS 'Nome do Aluno',
	C.curso_descricao AS 'Curso'
	FROM curso_aluno E
	INNER JOIN aluno A
	ON E.fk_aluno = A.pk_codigo_aluno
	INNER JOIN curso C
	ON E.fk_curso = C.pk_codigo_curso;
END
$

CREATE PROCEDURE Consulta_Curso()
BEGIN
	SELECT
	pk_codigo_curso AS 'Código',
	curso_descricao AS 'Descrição',
	curso_ementa AS 'Ementa'
	FROM curso;
END
$

CREATE PROCEDURE Consulta_Aluno()
BEGIN
	SELECT
	pk_codigo_aluno AS 'Código',
	aluno_nome AS 'Aluno'
	FROM aluno;
END
$

DELIMITER ;

CALL Consulta_Aluno_Curso();
CALL Consulta_Curso();
CALL Consulta_Aluno();
