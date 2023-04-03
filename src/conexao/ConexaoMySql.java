package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author Diego Barbosa
 */
public class ConexaoMySql {

    private boolean status = false;
    private Connection connection = null;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private Statement states;
    private String servidor = "localhost";
    private String database = "";
    private String porta = "3306";
    private String usuario = "root";
    private String senha = "privada3";

    public ConexaoMySql() {

    }

    public ConexaoMySql(String servidor, String database, String porta, String usuario, String senha) {
        this.servidor = servidor;
        this.database = database;
        this.porta = porta;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    /**
     * Formata a URL de conexão ao banco de dados
     * @return String
     */
    private String url() {
        String url = "jdbc:mysql://" + this.servidor + ":" + this.porta + "/" + this.database + "?serverTimezone=UTC";
        return url;
    }

    /**
     * Método que realiza a conexão ao banco de dados
     * @return connection
     */
    public Connection conectar() {
        try {
            // Carrega o driver do JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conecta no banco de dados
            this.setConnection((Connection) DriverManager.getConnection(
                    this.url(),
                    this.usuario,
                    this.senha));
            
            // Chama o método que configura o banco de dados
            this.configurarBanco(connection);
            this.status = true;
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return connection;
    }

    /**
     * Método que encerra a conexão com o banco de dados
     * @return boolean
     */
    public boolean desconectar() {
        try {
            if ((this.getResultSet() != null) && (this.statement != null)) {
                this.getResultSet().close();
                this.statement.close();
            }
            this.getConnection().close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    /**
     * Método responsável pela criação do banco de dados e tabelas do mesmo
     * @param connection
     */
    private void configurarBanco(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            // Cria a base de dados
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS teste;");
            // Seleciona base de dados
            stmt.executeUpdate("USE teste;");
            // Cria tabela curso
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS curso ("
                    + "pk_codigo_curso SERIAL NOT NULL PRIMARY KEY,"
                    + "curso_descricao VARCHAR(50) NOT NULL,"
                    + "curso_ementa TEXT"
                    + ");");
            // Cria tabela aluno
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS aluno ("
                    + "pk_codigo_aluno SERIAL NOT NULL PRIMARY KEY,"
                    + "aluno_nome VARCHAR(50) NOT NULL"
                    + ");");
            // Cria tabela que relaciona curso e aluno
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS curso_aluno ("
                    + "pk_codigo SERIAL NOT NULL PRIMARY KEY,"
                    + "fk_aluno BIGINT UNSIGNED,"
                    + "fk_curso BIGINT UNSIGNED,"
                    + "FOREIGN KEY (fk_aluno) REFERENCES aluno(pk_codigo_aluno),"
                    + "FOREIGN KEY (fk_curso) REFERENCES curso(pk_codigo_curso)"
                    + ");");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    protected ResultSet getResultSet() {
        return resultSet;
    }

    protected void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    protected boolean getStatus() {
        return status;
    }

    protected void setStatus(boolean status) {
        this.status = status;
    }

    protected Connection getConnection() {
        return connection;
    }

    protected void setConnection(Connection connection) {
        this.connection = connection;
    }

    protected PreparedStatement getPreparedStatement() {
        return statement;
    }

    protected void setPreparedStatement(PreparedStatement statement) {
        this.states = statement;
    }

}
