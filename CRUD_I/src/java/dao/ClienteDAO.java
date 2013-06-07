package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;

public class ClienteDAO {
    private Connection conexao;//Cria uma variável do tipo Connection para receber a conexão.

    public ClienteDAO() throws ClassNotFoundException{//Construtor com argumeto.
        this.conexao = new ConexaoJDBC().Conectar();//Ao criar um novo ClienteDAO ele cria uma conexão.
    }
    
    public void adicionar(Cliente cliente){
        String sql = "INSERT INTO tb_cliente (nome, email, telefone, datanascimento)VALUES(?,?,?,?)";
        try {
            PreparedStatement pstmt = this.conexao.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setLong(3, cliente.getTelefone());
            pstmt.setDate(4, cliente.getDtnasc());
            pstmt.execute();
            pstmt.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterar(Cliente cliente){
        try {
            String sql = "UPDATE tb_cliente SET nome=?, email=?, telefone=?, datanascimento=?"
                    + "WHERE id_cliente=?";
            PreparedStatement pstmt = this.conexao.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setLong(3, cliente.getTelefone());
            pstmt.setDate(4,cliente.getDtnasc());
            pstmt.setInt(5, cliente.getId());
            pstmt.execute();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletar(Integer id){
        try {
            PreparedStatement pstmt = this.conexao.prepareStatement("DELETE FROM tb_cliente "
                    + "WHERE id_cliente=?");
            pstmt.setInt(1, id);
            pstmt.execute();
            pstmt.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> listar(){
        try {
            List<Cliente> clientes = new ArrayList<Cliente>();
            PreparedStatement pstmt = this.conexao.prepareStatement("SELECT * FROM tb_cliente");
            ResultSet rstst = pstmt.executeQuery();
            while(rstst.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rstst.getInt("id_cliente"));
                cliente.setNome(rstst.getString("nome"));
                cliente.setEmail(rstst.getString("email"));
                cliente.setTelefone(rstst.getLong("telefone"));
                cliente.setDtnasc(rstst.getDate("datanascimento"));
                clientes.add(cliente);               
            }
            rstst.close();
            pstmt.close();
            conexao.close();
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}