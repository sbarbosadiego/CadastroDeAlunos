/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * @author Diego Barbosa da Silva
 */
public class ModelCursoAluno {
    
    private int codigoCursoAluno;
    private int codigoAluno;
    private int codigoCurso;
    private String aluno;
    private String curso;

    public ModelCursoAluno() {
    }

    public int getCodigoCursoAluno() {
        return codigoCursoAluno;
    }

    public void setCodigoCursoAluno(int codigoCursoAluno) {
        this.codigoCursoAluno = codigoCursoAluno;
    }

    public int getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(int codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
}
