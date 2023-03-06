/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Barbosa
 */
public class ConexaoMySql {
    
    private Connection conexao = null;
    private String enderecoServidor = "localhost";
    private String nomeDoBanco = "dbalunoscurso";
    private String porta = "3306";
    private String user = "root";
    private String password = "";
    
    
    public ConexaoMySql() {
    }
    
    /**
     * Costrutor com os dados para conexão
     * @param enderecoServidor
     * @param nomeDoBanco
     * @param user
     * @param password 
     */
    public ConexaoMySql(String enderecoServidor, String nomeDoBanco, String porta, String user, String password) {
        this.setEnderecoServidor(enderecoServidor);
        this.setNomeDoBanco(nomeDoBanco);
        this.setPorta(porta);
        this.setUser(user);
        this.setPassword(password);
    }
    
    /**
     * Método responsável pela conexão no banco de dados
     * @return conexao
     */
    public Connection conectar() {
        try {
            String url = "jdbc:mysql://localhot:3306/"+this.getNomeDoBanco()+"?serverTimezone=UTC";
            conexao = DriverManager.getConnection(
                    url, //URL do banco de dados
                    this.getUser(), //Usuário de acesso ao banco de dados
                    this.getPassword()); //Senha de acesso ao banco de dados
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        System.out.println("Conectado");
        return conexao;
    }
    
    private String getEnderecoServidor() {
        return enderecoServidor;
    }

    private void setEnderecoServidor(String enderecoServidor) {
        this.enderecoServidor = enderecoServidor;
    }

    private String getNomeDoBanco() {
        return nomeDoBanco;
    }

    private void setNomeDoBanco(String nomeDoBanco) {
        this.nomeDoBanco = nomeDoBanco;
    }

    private String getUser() {
        return user;
    }

    private void setUser(String user) {
        this.user = user;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }
    
    
}
