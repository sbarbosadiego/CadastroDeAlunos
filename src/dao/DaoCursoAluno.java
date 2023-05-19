/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.ConexaoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModelAluno;
import model.ModelCurso;
import model.ModelCursoAluno;

/**
 * @author Diego Barbosa da Silva
 */
public class DaoCursoAluno extends ConexaoMySql {
    
    /**
     * Faz a inserção na tabela curso_aluno associando um registro de aluno com um curso.
     * @param pModelAluno
     * @param pModelCurso
     * @return int
     */
    public int salvarCursoAlunoDAO(ModelAluno pModelAluno, ModelCurso pModelCurso) {
        try {
            String sql = "INSERT INTO curso_aluno (fk_aluno, fk_curso) VALUES (?, ?);";
            PreparedStatement stmt = this.conectar().prepareStatement(sql);
            stmt.setInt(1, pModelAluno.getCodigoAluno());
            stmt.setInt(2, pModelCurso.getCodigoCurso());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        } finally {
            this.desconectar();
        }
    }
    
    /**
     * Exclui o registro de um aluno vinculado a um curso.
     * @param codigoCursoAluno
     * @return boolean
     */
    public boolean excluirCursoAlunoDAO(int codigoCursoAluno) {
        try {
            String sql = "DELETE FROM curso_aluno WHERE pk_codigo = ?;";
            PreparedStatement stmt = this.conectar().prepareStatement(sql);
            stmt.setInt(1, codigoCursoAluno);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally {
            this.desconectar();
        }
    }
    
    /**
     * Retorna lista de alunos vinculados a cursos.
     * @return ArrayList
     */
    public ArrayList<ModelCursoAluno> listarCursoAluno() {
        ArrayList<ModelCursoAluno> listaModelCursoAluno = new ArrayList<>();
        try {
            String sql = "SELECT E.pk_codigo, "
                    + "A.pk_codigo_aluno, "
                    + "A.aluno_nome, "
                    + "C.curso_descricao "
                    + "FROM curso_aluno E "
                    + "INNER JOIN aluno A "
                    + "ON E.fk_aluno = A.pk_codigo_aluno "
                    + "INNER JOIN curso C "
                    + "ON E.fk_curso = C.pk_codigo_curso;";
            Statement consulta = this.conectar().createStatement();
            ResultSet retorno = consulta.executeQuery(sql);

            while (retorno.next()) {
                ModelCursoAluno modelCursoAluno = new ModelCursoAluno();
                modelCursoAluno.setCodigoCursoAluno(retorno.getInt(1));
                modelCursoAluno.setCodigoAluno(retorno.getInt(2));
                modelCursoAluno.setAluno(retorno.getString(3));
                modelCursoAluno.setCurso(retorno.getString(4));
                listaModelCursoAluno.add(modelCursoAluno);
            }
            retorno.close();
            consulta.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.desconectar();
        }
        return listaModelCursoAluno;
    }
    
}
