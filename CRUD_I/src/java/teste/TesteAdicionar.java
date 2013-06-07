package teste;

import dao.ClienteDAO;
import modelo.Cliente;

public class TesteAdicionar {
    public static void main(String[] args) throws Exception {
        //  SIMULANDO PEGADA DE PARAMETROS 'REQUESTE' DO FORMULARIO  ///////////
        String nome = ("Wesley Praxedes");
        String email = ("wesleyprofile@gmail.com");
        long telefone = Long.parseLong("6196657468");
        String data = ("01/01/2012");

        //  FORMATANDO DATA  ///////////////////////////////////////////////////
        String auxDt = data;
        int ano=Integer.parseInt(auxDt.substring(6,10)) - 1900;
        int mes=Integer.parseInt(auxDt.substring(3,5)) - 1 ;
        int dia=Integer.parseInt(auxDt.substring(0,2));
        java.sql.Date dtSQL = new java.sql.Date(ano, mes, dia);
        
        //  MONTANDO OBJETO CLIENTE  ///////////////////////////////////////////
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setDtnasc(dtSQL);

        //  PASSANDO OBJETO PARA O DAO  /////////////////////////////////////////
        ClienteDAO dao = new ClienteDAO();
        dao.adicionar(cliente);
        
        System.out.println("Gravado!");
    }    
}
