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

/**
 *
 * @author Diego Barbosa
 */
public class DaoAluno extends ConexaoMySql {
    
    /**
     * Faz o insert do aluno no banco de dados
     * @param pModelAluno
     * @return int
     */
    public int salvarAlunoDAO(ModelAluno pModelAluno) {
        try {
            String sql = "INSERT INTO aluno (aluno_nome) VALUES (?);";
            PreparedStatement stmt = this.conectar().prepareStatement(sql);
            stmt.setString(1, pModelAluno.getNomeAluno());
            stmt.executeUpdate();

            return 1;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        } finally {
            this.desconectar();
        }
    }
    
    // Ainda fazendo
    public boolean editarAlunoDAO(ModelAluno pModelAluno) {
        try {
            String sql = "UPDATE aluno SET "
                    + "aluno_nome = ? "
                    + "WHERE pk_codigo_aluno = ?;";
            PreparedStatement stmt = this.conectar().prepareStatement(sql);
            stmt.setString(1, pModelAluno.getNomeAluno());
            stmt.setInt(2, pModelAluno.getCodigoAluno());
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally {
            this.desconectar();
        }
    }
    
    /**
     * Faz a exclusão de um aluno no banco de dados
     * @param codigoAluno
     * @return boolean
     */
    public boolean excluirAlunoDAO(int codigoAluno) {
        try {
            String sql = "DELETE FROM aluno WHERE pk_codigo_aluno = ?;";
            PreparedStatement stmt = this.conectar().prepareStatement(sql);
            stmt.setInt(1, codigoAluno);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally {
            this.desconectar();
        }
    }
    
    public ModelAluno retornarAlunoDAO(int pIdAluno) {
        ModelAluno modelAluno = new ModelAluno();
        try {
            String sql = "SELECT "
                    + "pk_codigo_aluno, "
                    + "aluno_nome "
                    + "FROM aluno WHERE pk_codigo_aluno = '"+pIdAluno+"'";
            Statement stmt = this.conectar().createStatement();
            stmt.executeQuery(sql);
            ResultSet retorno = stmt.executeQuery(sql);
            while (retorno.next()) {
                modelAluno.setCodigoAluno(this.getResultSet().getInt(1));
                modelAluno.setNomeAluno(this.getResultSet().getString(2));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.desconectar();
        }
        return modelAluno;
    }
    
    /**
     * Retorna lista de alunos
     * @return ArrayList
     */
    public ArrayList<ModelAluno> listarAlunos() {
        ArrayList<ModelAluno> listaModelAlunos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM aluno;";
            Statement consulta = this.conectar().createStatement();
            ResultSet retorno = consulta.executeQuery(sql);
            
            while (retorno.next()) {
                ModelAluno modelAlunos = new ModelAluno();
                modelAlunos.setCodigoAluno(retorno.getInt(1));
                modelAlunos.setNomeAluno(retorno.getString(2));
                listaModelAlunos.add(modelAlunos);
            }
            retorno.close();
            consulta.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.desconectar();
        }
        return listaModelAlunos;
    }

}
