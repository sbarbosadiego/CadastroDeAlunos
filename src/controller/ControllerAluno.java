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
    
    public int salvarAlunoController(ModelAluno nome) {
        return this.daoAluno.salvarAlunoDAO(nome);
    }
    
    public boolean excluirAlunoController(int codigoAluno) {
        return this.daoAluno.excluirAlunoDAO(codigoAluno);
    }
    
    public boolean editarAlunoController(ModelAluno pModelAluno) {
        return this.daoAluno.editarAlunoDAO(pModelAluno);
    }
    
    public ModelAluno retornarAlunoController(int pIdAluno) {
        return this.daoAluno.retornarAlunoDAO(pIdAluno);
    }
    
    public ArrayList<ModelAluno> retornarListarAlunosController() {
        return this.daoAluno.listarAlunos();
    }
}
