package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBC {
    public Connection Conectar() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");//Setar o driver do Mysql na sua aplicação.
            return DriverManager.getConnection("jdbc:mysql://localhost/crud_cliente","root","");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}