/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardatabase;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author facec.lab02
 */
public class CarroDAO {
    public Conecta conexao; // Objeto que faz conexão com o Banco de Dados
    public Carro carro; // Objeto da classe a ser manipulada com o CRUD
    public PreparedStatement ps; // Realiza as queries no banco
    public ResultSet resultados; // Armazena o resultado das queries
    public String msg; // Armazena mensagem de retorno
    public String sql; // Armazena Query
    
    public static final byte INCLUSAO = 1;
    public static final byte ALTERACAO = 2;
    public static final byte EXCLUSAO = 3;
    
    public CarroDAO(){
        conexao = new Conecta();
        carro = new Carro();
    }

        public boolean localizar() {
        try {
            //Definir a query com a busca
            sql = "SELECT * FROM carro WHERE id = ?";// <-- Essa Interrogação
            ps = conexao.conn.prepareStatement(sql); // PS prepara a query
            ps.setInt(1, carro.getId()); // Pegar a interrogação e trocar pelo valor setInt
            resultados = ps.executeQuery(); // Executa a query (é mesmo ;)) e armazena retorno
            // Coloca resultados no Banco nos atributos da Classe filme 
            resultados.next(); // Move para a proxima linha de resultados (Dica: Utilizar for para varios Registros)
            carro.setId(Integer.parseInt(resultados.getString(1))); // Integer.parseInt passa o valor pra inteiro
            carro.setNome(resultados.getString(2));
            carro.setAno(resultados.getString(3));
            carro.setModelo(resultados.getString(4));
            carro.setMarca(resultados.getString(5));
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Registro não encontrado!");
            return false;
        }
    }
        
    public String atualizar(byte operacao) {
        msg = "OPeração Realizada com sucesso";
        try {
            if (operacao == INCLUSAO) {
                sql = "INSERT INTO carro (id, nome, ano, modelo, marca) VALUES(?,?,?,?,?)";
                ps = conexao.conn.prepareStatement(sql);
                //Substituimos os pontos de Interrogacao
                ps.setInt(1, carro.getId());
                ps.setString(2, carro.getNome());             
                ps.setString(3, carro.getAno());   
                ps.setString(5, carro.getModelo());
                ps.setString(4, carro.getMarca());  
                
            } else if (operacao == ALTERACAO) {
                sql = "UPDATE carro SET nome = ?, ano = ?, modelo = ?, marca = ? WHERE id = ?"; // comando sql
                ps = conexao.conn.prepareStatement(sql);
                ps.setString(1, carro.getNome());
                ps.setString(2, carro.getAno());
                ps.setString(3, carro.getModelo());
                ps.setString(4, carro.getMarca());
                ps.setInt(5, carro.getId());
            } else if (operacao == EXCLUSAO) {
                sql = "DELETE FROM carro WHERE id = ?";
                ps = conexao.conn.prepareStatement(sql);
                ps.setInt(1, carro.getId());
            }
            
            if(ps.executeUpdate() == 0){
                msg = "Erro na atualização do banco de dados!";
            }
            
            
        } catch (SQLException ex) {
            msg = "Falha na operação atualizar";
        }
        return msg;
    }
}
