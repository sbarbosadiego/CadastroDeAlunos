/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.ConexaoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModelAluno;

/**
 * @author Diego Barbosa da Silva
 */
public class DaoAluno extends ConexaoMySql {

    /**
     * Realiza a inserção de dados na tabela aluno.
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

    /**
     * Atualiza os dados de um registro na tabela aluno.
     * @param pModelAluno
     * @return boolean
     */
    public boolean editarAlunoDAO(ModelAluno pModelAluno) {
        try {
            String sql = "UPDATE aluno SET "
                    + "aluno_nome = ? "
                    + "WHERE pk_codigo_aluno = ?";
            PreparedStatement stmt = this.conectar().prepareStatement(sql);
            stmt.setString(1, pModelAluno.getNomeAluno());
            stmt.setInt(2, pModelAluno.getCodigoAluno());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally {
            this.desconectar();
        }
    }

    /**
     * Realiza a exclusão de um registro na tabela aluno.
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
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Aluno possuí matrícula ativa");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally {
            this.desconectar();
        }
    }

    /**
     * Retorna a consulta de dados de um aluno no banco de dados.
     * @param pIdAluno
     * @return modelAluno
     */
    public ModelAluno retornarAlunoDAO(int pIdAluno) {
        ModelAluno modelAluno = new ModelAluno();
        try {
            String sql = "SELECT "
                    + "pk_codigo_aluno, "
                    + "aluno_nome "
                    + "FROM aluno WHERE pk_codigo_aluno = '" + pIdAluno + "'";
            Statement stmt = this.conectar().createStatement();
            stmt.executeQuery(sql);
            ResultSet retorno = stmt.executeQuery(sql);
            while (retorno.next()) {
                modelAluno.setCodigoAluno(retorno.getInt(1));
                modelAluno.setNomeAluno(retorno.getString(2));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.desconectar();
        }
        return modelAluno;
    }
    
    /**
     * Retorna aluno da pesquisa por caracteres.
     * @param nome
     * @return modelAluno
     */
    public ModelAluno retornarAlunoNomeDAO(String nome) {
        ModelAluno modelAluno = new ModelAluno();
        try {
            String sql = "SELECT * FROM aluno WHERE aluno_nome like '" + nome + "%' LIMIT 1;";
            Statement stmt = this.conectar().createStatement();
            stmt.executeQuery(sql);
            ResultSet retorno = stmt.executeQuery(sql);
            while (retorno.next()) {
                modelAluno.setCodigoAluno(retorno.getInt(1));
                modelAluno.setNomeAluno(retorno.getString(2));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.desconectar();
        }
        return modelAluno;
    }

    /**
     * Retorna lista de alunos.
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
    
    /**
     * Retorna lista de alunos pelo nome.
     * @param nome
     * @return ArrayList
     */
    public ArrayList<ModelAluno> listarPesquisaAluno(String nome) {
        ArrayList<ModelAluno> listaModelAlunos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM aluno WHERE aluno_nome LIKE '%" + nome + "%' ORDER BY aluno_nome;";
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
