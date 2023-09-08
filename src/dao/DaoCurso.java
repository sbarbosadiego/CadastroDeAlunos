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
import model.ModelCurso;

/**
 * @author Diego Barbosa da Silva
 */
public class DaoCurso extends ConexaoMySql {
    
    /**
     * Realiza a inserção de dados na tabela curso.
     * @param pModelCurso
     * @return int
     */
    public int salvarCursoDAO(ModelCurso pModelCurso) {
        try {
            String sql = "INSERT INTO curso (curso_descricao, curso_ementa) VALUES (?,?);";
            PreparedStatement stmt = this.conectar().prepareStatement(sql);
            stmt.setString(1, pModelCurso.getDescricaoCurso());
            stmt.setString(2, pModelCurso.getEmentaCurso());
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
     * Atualiza o cadastro de um registro na tabela curso.
     * @param pModelCurso
     * @return boolean
     */
    public boolean editarCursoDAO(ModelCurso pModelCurso) {
        try {
            String sql = "UPDATE curso SET "
                    + "curso_descricao = ?, "
                    + "curso_ementa = ? "
                    + "WHERE pk_codigo_curso = ?";
            PreparedStatement stmt = this.conectar().prepareStatement(sql);
            stmt.setString(1, pModelCurso.getDescricaoCurso());
            stmt.setString(2, pModelCurso.getEmentaCurso());
            stmt.setInt(3, pModelCurso.getCodigoCurso());
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
     * Realiza a exclusão de um registro na tabela curso.
     * @param codigoCurso
     * @return boolean
     */
    public boolean excluirCursoDAO(int codigoCurso) {
        try {
            String sql = "DELETE FROM curso WHERE pk_codigo_curso = ?;";
            PreparedStatement stmt = this.conectar().prepareStatement(sql);
            stmt.setInt(1, codigoCurso);
            stmt.executeUpdate();
            return true;
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Curso referenciado em aluno");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally {
            this.desconectar();
        }
    }

    /**
     * Retorna a consulta de dados de um curso no banco de dados.
     * @param pIdCurso
     * @return modelCurso
     */
    public ModelCurso retornarCursoDAO(int pIdCurso) {
        ModelCurso modelCurso = new ModelCurso();
        try {
            String sql = "SELECT "
                    + "pk_codigo_curso, "
                    + "curso_descricao, "
                    + "curso_ementa "
                    + "FROM curso WHERE pk_codigo_curso = '" + pIdCurso + "'";
            Statement stmt = this.conectar().createStatement();
            stmt.executeQuery(sql);
            ResultSet retorno = stmt.executeQuery(sql);
            while (retorno.next()) {
                modelCurso.setCodigoCurso(retorno.getInt(1));
                modelCurso.setDescricaoCurso(retorno.getString(2));
                modelCurso.setEmentaCurso(retorno.getString(3));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.desconectar();
        }
        return modelCurso;
    }
    
    /**
     * Retorna a consulta de um curso por caracteres.
     * @param curso
     * @return modelCurso
     */
    public ModelCurso retornarCursoNomeDAO(String curso) {
        ModelCurso modelCurso = new ModelCurso();
        try {
            String sql = "SELECT * FROM curso WHERE curso_descricao LIKE '" + curso + "%' LIMIT 1;";
            Statement stmt = this.conectar().createStatement();
            stmt.executeQuery(sql);
            ResultSet retorno = stmt.executeQuery(sql);
            while (retorno.next()) {
                modelCurso.setCodigoCurso(retorno.getInt(1));
                modelCurso.setDescricaoCurso(retorno.getString(2));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.desconectar();
        }
        return modelCurso;
    }

    /**
     * Retorna lista de cursos
     * @return ArrayList
     */
    public ArrayList<ModelCurso> listarCursos() {
        ArrayList<ModelCurso> listaModelCursos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM curso;";
            Statement consulta = this.conectar().createStatement();
            ResultSet retorno = consulta.executeQuery(sql);

            while (retorno.next()) {
                ModelCurso modelCursos = new ModelCurso();
                modelCursos.setCodigoCurso(retorno.getInt(1));
                modelCursos.setDescricaoCurso(retorno.getString(2));
                modelCursos.setEmentaCurso(retorno.getString(3));
                listaModelCursos.add(modelCursos);
            }
            retorno.close();
            consulta.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.desconectar();
        }
        return listaModelCursos;
    }
    
    /**
     * Retorna lista de cursos pelo nome.
     * @param nome
     * @return ArrayList
     */
    public ArrayList<ModelCurso> listarPesquisaCurso(String curso) {
        ArrayList<ModelCurso> listaModelCursos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM curso WHERE curso_descricao LIKE '%" + curso + "%' ORDER BY curso_descricao;";
            Statement consulta = this.conectar().createStatement();
            ResultSet retorno = consulta.executeQuery(sql);

            while (retorno.next()) {
                ModelCurso modelCursos = new ModelCurso();
                modelCursos.setCodigoCurso(retorno.getInt(1));
                modelCursos.setDescricaoCurso(retorno.getString(2));
                listaModelCursos.add(modelCursos);
            }
            retorno.close();
            consulta.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.desconectar();
        }
        return listaModelCursos;
    }
    
}
