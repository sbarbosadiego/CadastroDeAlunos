/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.ConexaoMySql;
import java.sql.SQLException;
import model.ModelAluno;

/**
 *
 * @author Diego Barbosa
 */
public class DaoAluno extends ConexaoMySql {

    public int salvarAlunoDAO(ModelAluno nome) {
        try {
            this.conectar();
            return this.insertSql("INSERT INTO aluno (aluno_nome) VALUES ("
                    + "'" + nome.getNomeAluno() + "');");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.desconectar();
        }
    }

}
