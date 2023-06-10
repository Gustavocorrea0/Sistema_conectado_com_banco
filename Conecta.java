/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardatabase;
import java.sql.*;
/**
 *
 * @author facec.lab02
 */
public class Conecta {
    //Criar atributos da classe de conexão
    public Connection conn;
    //Criar constantes com valores de Conexão //Letra maiuscula por ser constante

    private final String DRIVER = "org.postgresql.Driver";
    private final String NOMEDB = "base";
    private final String URL = "jdbc:postgresql://localhost:5432/" + NOMEDB; // Protocolo de conexão local | host
    private final String USUARIO = "postgres";
    private final String SENHA = "postgres";

    //Tentar fazer conexão
    //Retorna true caso a conexão seja estabelecida com sucesso
    public boolean getConexao() {
        try {
            Class.forName(DRIVER); //Estabelecer conexão com driver
            conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão Realizada Com Sucesso");
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Problema com o Driver de Conexão! \n" + ex.toString());
            return false;
        } catch (SQLException ex) {
            System.out.println("Problema na conexão com o banco!\n" + ex.toString());
            return false;
        }
    }

    //Encerrar conexão 
    public void close() {
        try {
            conn.close();
            System.out.println("Conexão encerrada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Problema ao encerrar a conexão");
        }
    }
}
