package teste;

import dao.ClienteDAO;

public class TesteDeletar {
    public static void main(String[] args) throws Exception{
        ClienteDAO dao = new ClienteDAO();
        dao.deletar(21);  //Numero do 'id_cliente' do cliente a ser deletado.
        
        System.out.println("Deletado!");
    }
}