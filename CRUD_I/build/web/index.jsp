
<%@page contentType="text/html" pageEncoding="ISO-8859-9"%>
<%@page import = "modelo.Cliente" %>
<%@page import = "dao.ClienteDAO"%>
<%@page import="java.util.List"%>
<%@page import = "java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-9">
        <title>Pagina principal CRUD I</title>
    </head>
    <body>
        <h4>Formulário de cadastro de clientes<br/>
            Deve-se preencher todos os campos.</h4>
        <form method="post" ${act1}action="controle.jsp?action=adicionar" >${act2}
            ${show_id}
            Nome: <input type="text" name="nome" value="${nome}" /> <br/>
            Email: <input type="text" name="email" value="${email}" /> <br/>
            Telefone: <input type="text" name="telefone" value="${telefone}" />(Apenas numeros)<br/>
            Data de nascimento: <input type="text" name="data" value="${data}" />dd/mm/yyyy (Formado da data)<br/>

            <input type="submit" ${sub1}value="Cadastrar Cliente"/>${sub2}
        </form>
        <form action="index.jsp" >
             <input type="submit" value="Limpar campos"/>
        </form>
        <br />
        <font color="#FF0000">${msg}</font> <%--Variavel ell (expression linguage)--%>        
        <br/>
        <br/>        
        <h1>Lista de clientes</h1>
        <table width="100%" border="1">
            <tr>
                <td>Código cliente</td>
                <td>Nome</td>
                <td>Email</td>
                <td>Fone</td>
                <td>Data</td>
                <td>Atualizar</td>
                <td>Excluir</td>
            </tr>
            <%
                try{
                    String dtString = null;
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    ClienteDAO dao = new ClienteDAO();
                    List<Cliente>lista = dao.listar();
                    for(Cliente cliente : lista){
            %>
            <tr>
                <td><%= cliente.getId() %></td>
                <td><%= cliente.getNome() %></td>
                <td><%= cliente.getEmail() %></td>
                <td><%= cliente.getTelefone() %></td>
                <td><%
                       try{
                           dtString = null;
                           dtString = sdf.format(cliente.getDtnasc());
                           out.println(dtString);
                       }catch(NullPointerException e){
                           out.print("Value " + e.getMessage());
                       }

                        %></td>
                <td><% out.print("<a href=controle.jsp?action=pegarDados&id_cliente="+cliente.getId()
                                                                         +"&email="+cliente.getEmail()
                                                                         +"&telefone="+cliente.getTelefone()
                                                                         +"&data="+dtString
                                                                         +">Atualizar?</a>"); %></td>
                <td><% out.print("<a href=controle.jsp?action=excluir&id_cliente="+cliente.getId()
                                                                         +">Excluir?</a>"); %></td>
            </tr>
            <%
                    }
                }catch(Exception e){
                    out.print("Erro "+e);
                }
            %>
        </table>        
    </body>    
</html>