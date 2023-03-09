/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Diego Barbosa
 */
public class ModelAluno {
    
    private int codigoAluno;
    private String nomeAluno;
    

    public int getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(int codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        if (this.getNomeAluno() == null) {
            String vazio = "Nome do aluno em branco!!";
            throw new IllegalArgumentException(vazio);
        }
        if (this.getNomeAluno().length() > 50) {
            throw new IllegalArgumentException("O nome do aluno deve ter até 50 caracteres!!");
        }
        this.nomeAluno = nomeAluno;
    }
    
}
