/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoAluno;
import java.util.ArrayList;
import model.ModelAluno;

/**
 *
 * @author Diego Barbosa
 */
public class ControllerAluno {
    
    private DaoAluno daoAluno = new DaoAluno();
    
    /**
     * Salvar aluno controller
     * @param nome
     * @return int
     */
    public int salvarAlunoController(ModelAluno nome) {
        return this.daoAluno.salvarAlunoDAO(nome);
    }
    
    /**
     * Excluir aluno por código de cadastro
     * @param codigoAluno
     * @return boolean
     */
    public boolean excluirAlunoController(int codigoAluno) {
        return this.daoAluno.excluirAlunoDAO(codigoAluno);
    }
    
    /**
     * Edita o cadastro de um aluno
     * @param pModelAluno
     * @return boolean
     */
    public boolean editarAlunoController(ModelAluno pModelAluno) {
        return this.daoAluno.editarAlunoDAO(pModelAluno);
    }
    
    /**
     * Retorna a consulta dos dados de um aluno no banco de dados
     * @param pIdAluno
     * @return ModelAluno
     */
    public ModelAluno retornarAlunoController(int pIdAluno) {
        return this.daoAluno.retornarAlunoDAO(pIdAluno);
    }
    
    /**
     * Retorna lista de alunos
     * @return  ArrayList
     */
    public ArrayList<ModelAluno> retornarListarAlunosController() {
        return this.daoAluno.listarAlunos();
    }
}
