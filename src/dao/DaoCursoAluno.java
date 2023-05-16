/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.ConexaoMySql;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelAluno;
import model.ModelCurso;

/**
 *
 * @author Diego Barbosa da Silva
 */
public class DaoCursoAluno extends ConexaoMySql {
    
    /**
     * Vincula um aluno a um curso no banco de dados.
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
    

    
}
