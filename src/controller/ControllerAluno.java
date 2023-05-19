/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoAluno;
import java.util.ArrayList;
import model.ModelAluno;

/**
 * @author Diego Barbosa da Silva
 */
public class ControllerAluno {
    
    private DaoAluno daoAluno = new DaoAluno();
    
    /**
     * Passa os parâmetros para salvar um novo registro na base de dados.
     * @param nome
     * @return int
     */
    public int salvarAlunoController(ModelAluno nome) {
        return this.daoAluno.salvarAlunoDAO(nome);
    }
    
    /**
     * Passa os parâmetros de código de um aluno para a exclusão de um registro na base de dados.
     * @param codigoAluno
     * @return boolean
     */
    public boolean excluirAlunoController(int codigoAluno) {
        return this.daoAluno.excluirAlunoDAO(codigoAluno);
    }
    
    /**
     * Passa os parâmetros para atualizar um registro na base de dados. 
     * @param pModelAluno
     * @return boolean
     */
    public boolean editarAlunoController(ModelAluno pModelAluno) {
        return this.daoAluno.editarAlunoDAO(pModelAluno);
    }
    
    /**
     * Retorna a consulta dos dados de um aluno no banco de dados.
     * @param pIdAluno
     * @return ModelAluno
     */
    public ModelAluno retornarAlunoController(int pIdAluno) {
        return this.daoAluno.retornarAlunoDAO(pIdAluno);
    }
    
    /**
     * Retorna o nome de um registro na base de dados.
     * @param nome
     * @return ModelAluno
     */
    public ModelAluno retornarAlunoNomeController(String nome) {
        return this.daoAluno.retornarAlunoNomeDAO(nome);
    }
    
    /**
     * Retorna lista de alunos pelo código.
     * @return ArrayList
     */
    public ArrayList<ModelAluno> retornarListarAlunosController() {
        return this.daoAluno.listarAlunos();
    }
    
    /**
     * Retorna lista alunos pelo nome.
     * @param nome
     * @return ArrayList
     */
    public ArrayList<ModelAluno> retornarListarPesquisaAlunosController(String nome) {
        return this.daoAluno.listarPesquisaAluno(nome);
    }
    
}
