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
     * @param nome
     * @return int
     */
    public int salvarAlunoDAO(ModelAluno nome) {
        try {
            String sql = "INSERT INTO aluno (aluno_nome) VALUES (?);";
            PreparedStatement stmt = this.conectar().prepareStatement(sql);
            stmt.setString(1, nome.getNomeAluno());
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
