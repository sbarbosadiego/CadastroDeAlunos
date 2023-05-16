/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoCurso;
import java.util.ArrayList;
import model.ModelCurso;

/**
 *
 * @author Diego Barbosa
 */
public class ControllerCurso {
    
    private DaoCurso daoCurso = new DaoCurso();
    
    /**
     * Salvar curso controller
     * @param descricao
     * @return int
     */
    public int salvarCursoController(ModelCurso descricao) {
        return this.daoCurso.salvarCursoDAO(descricao);
    }
    
    /**
     * Excluir curso por código de cadastro
     * @param codigoCurso
     * @return boolean
     */
    public boolean excluirCursoController(int codigoCurso) {
        return this.daoCurso.excluirCursoDAO(codigoCurso);
    }
    
    /**
     * Edita o cadastro de um curso
     * @param pModelCurso
     * @return boolean
     */
    public boolean editarCursoController(ModelCurso pModelCurso) {
        return this.daoCurso.editarCursoDAO(pModelCurso);
    }
    
    /**
     * Retorna a consulta dos dados de um Curso no banco de dados
     * @param pIdCurso
     * @return ModelCurso
     */
    public ModelCurso retornarCursoController(int pIdCurso) {
        return this.daoCurso.retornarCursoDAO(pIdCurso);
    }
    
    public ModelCurso retornarCursoController(String nome) {
        return this.daoCurso.retornarCursoNomeDAO(nome);
    }
    
    /**
     * Retorna lista de Cursos
     * @return  ArrayList
     */
    public ArrayList<ModelCurso> retornarListarCursosController() {
        return this.daoCurso.listarCursos();
    }
    
    /**
     * Retorna lista cursos pelo nome.
     * @param curso
     * @return 
     */
    public ArrayList<ModelCurso> retornarListarPesquisaCursosController(String curso) {
        return this.daoCurso.listarPesquisaCurso(curso);
    }
    
}
