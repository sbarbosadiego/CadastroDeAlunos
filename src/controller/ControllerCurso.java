/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoCurso;
import java.util.ArrayList;
import model.ModelCurso;

/**
 * @author Diego Barbosa da Silva
 */
public class ControllerCurso {
    
    private DaoCurso daoCurso = new DaoCurso();
    
    /**
     * Passa os parâmetros para salvar um novo registro na base de dados.
     * @param descricao
     * @return int
     */
    public int salvarCursoController(ModelCurso descricao) {
        return this.daoCurso.salvarCursoDAO(descricao);
    }
    
    /**
     * Passa os parâmetros de código de um curso para a exclusão de um registro na base de dados.
     * @param codigoCurso
     * @return boolean
     */
    public boolean excluirCursoController(int codigoCurso) {
        return this.daoCurso.excluirCursoDAO(codigoCurso);
    }
    
    /**
     * Passa os parâmetros para atualizar um registro na base de dados.
     * @param pModelCurso
     * @return boolean
     */
    public boolean editarCursoController(ModelCurso pModelCurso) {
        return this.daoCurso.editarCursoDAO(pModelCurso);
    }
    
    /**
     * Retorna a consulta dos dados de um curso no banco de dados.
     * @param pIdCurso
     * @return ModelCurso
     */
    public ModelCurso retornarCursoController(int pIdCurso) {
        return this.daoCurso.retornarCursoDAO(pIdCurso);
    }
    
    /**
     * Retorna o nome de um registro na base de dados.
     * @param nome
     * @return ModelCurso
     */
    public ModelCurso retornarCursoNomeController(String nome) {
        return this.daoCurso.retornarCursoNomeDAO(nome);
    }
    
    /**
     * Retorna lista de Cursos
     * @return ArrayList
     */
    public ArrayList<ModelCurso> retornarListarCursosController() {
        return this.daoCurso.listarCursos();
    }
    
    /**
     * Retorna lista cursos pelo nome.
     * @param curso ArrayList
     * @return 
     */
    public ArrayList<ModelCurso> retornarListarPesquisaCursosController(String curso) {
        return this.daoCurso.listarPesquisaCurso(curso);
    }
    
}
