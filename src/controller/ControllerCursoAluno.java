/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoCursoAluno;
import java.util.ArrayList;
import model.ModelAluno;
import model.ModelCurso;
import model.ModelCursoAluno;

/**
 * @author Diego Barbosa da Silva
 */
public class ControllerCursoAluno {
    
    private DaoCursoAluno daoCursoAluno = new DaoCursoAluno();
    
    /**
     * Salvar vinculo de aluno a um curso.
     * @param nome
     * @param descricao
     * @return int
     */
    public int salvarCursoAlunoController(ModelAluno nome, ModelCurso descricao) {
        return this.daoCursoAluno.salvarCursoAlunoDAO(nome, descricao);
    }
    
    /**
     * Excluir registro de um aluno vinculado a um curso.
     * @param codigoCursoAluno
     * @return boolean
     */
    public boolean excluirCursoAlunoController(int codigoCursoAluno) {
        return this.daoCursoAluno.excluirCursoAlunoDAO(codigoCursoAluno);
    }
    
    /**
     * Retorna lista de alunos pelo código.
     * @return  ArrayList
     */
    public ArrayList<ModelCursoAluno> retornarListarCursoAlunosController() {
        return this.daoCursoAluno.listarCursoAluno();
    }
    
}
