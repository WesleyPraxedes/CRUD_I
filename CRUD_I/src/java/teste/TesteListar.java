package teste;

import dao.ClienteDAO;
import java.util.List;
import modelo.Cliente;

public class TesteListar {
    public static void main(String[] args) throws Exception {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> clientes = dao.listar();
        for(Cliente cliente : clientes){
            System.out.println("Cod: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("DN: "+ cliente.getDtnasc());
            System.out.println("");
        }
        System.out.println("Fim!");
    }    
}
