
package br.univali.rbcprinter.controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conexao {
    private final String JDBC     = "postgresql";
    private final String HOST     = "";
    private final String PORT     = "5432";
    private final String DATABASE = "";
    private final String USER     = "";
    private final String PASSWORD = "";
    private final String DRIVER   = "org.postgresql.Driver";
    private String url;
    private Connection conexao;
    private PreparedStatement pStatement;
    private Statement statement;

    public Conexao() {
        try {
            url = "jdbc:" + JDBC + "://" + HOST + ":" + PORT + "/" + DATABASE;
            Properties prop = new Properties();
            prop.setProperty("user", USER);
            prop.setProperty("password", PASSWORD);
            prop.setProperty("ssl", "true");
            prop.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
            conexao = DriverManager.getConnection(url, prop);
            statement = conexao.createStatement();
            System.out.println("Conexao estabelecida;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void encerrarConexao() {
        try {
            conexao.close();
            System.out.println("Conexão encerrada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet consultaCaso() {
        String sql = "SELECT id, tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao FROM caso";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        return rs;
    }
    
    public ResultSet consultaCasoOrdenado() {
        String sql = "SELECT id, tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao, ROUND(AVG(similaridade)::numeric,2) FROM caso GROUP BY id ORDER BY similaridade DESC";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public void inserirCaso(String tipo, String cabo, String fonte, String ledPower, String ledProcess, String iluminador, String imprimindo, String escaneando, String alimentador, String estufa, String tonner, String solucao) {
        String sql = "INSERT INTO caso (tipo_impressora, cabeamento, fonte, led_power, led_processamento, iluminador_scanner, imprimindo, scanner, alimentador, estufa, tonner, solucao) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pStatement = conexao.prepareStatement(sql);
            pStatement.setString(1, tipo);
            pStatement.setString(2, cabo);
            pStatement.setString(3, fonte);
            pStatement.setString(4, ledPower);
            pStatement.setString(5, ledProcess);
            pStatement.setString(6, iluminador);
            pStatement.setString(7, imprimindo);
            pStatement.setString(8, escaneando);
            pStatement.setString(9, alimentador);
            pStatement.setString(10, estufa);
            pStatement.setString(11, tonner);
            pStatement.setString(12, solucao);
            pStatement.executeUpdate();
            System.out.println("Caso inserido;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void alterarSimilaridade(int id, double similaridade) {
        String sql = "UPDATE caso SET similaridade = ? WHERE id = ?";
        try {
            pStatement = conexao.prepareStatement(sql);
            pStatement.setDouble(1, similaridade);
            pStatement.setInt(2, id);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
