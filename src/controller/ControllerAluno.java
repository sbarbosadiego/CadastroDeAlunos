/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoAluno;
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
    
}
