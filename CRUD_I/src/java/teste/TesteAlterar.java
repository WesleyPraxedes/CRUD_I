package teste;

import dao.ClienteDAO;
import modelo.Cliente;

public class TesteAlterar {public static void main(String[] args) throws Exception{
        String nome = ("Wesley Pro");
        String email = ("wesley_profile@hotmail.com");
        long telefone = Long.parseLong("6196657468");
        String data = ("01/01/2008");
        
        String auxDt = data;
        int ano=Integer.parseInt(auxDt.substring(6,10)) - 1900;
        int mes=Integer.parseInt(auxDt.substring(3,5)) - 1 ;
        int dia=Integer.parseInt(auxDt.substring(0,2));
        java.sql.Date dtSQL = new java.sql.Date(ano, mes, dia);
        
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setDtnasc(dtSQL);
        cliente.setId(14);

        ClienteDAO dao = new ClienteDAO();
        dao.alterar(cliente);
        
        System.out.println("Alterado!");
    }
}
