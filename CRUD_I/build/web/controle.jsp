
<%@page import="java.util.List"%>
<%@page import = "modelo.Cliente" %>
<%@page import = "dao.ClienteDAO"%>

<%
    String action = request.getParameter("action");
    // CADASTRAR  //////////////////////////////////////////////////////////////
    if (action.equalsIgnoreCase("adicionar")) {
        Cliente cliente = new Cliente();
        cliente.setNome(request.getParameter("nome"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setTelefone(Long.parseLong(request.getParameter("telefone")));
        
        // Covertendo a data de String para SQLdate.
        String auxDt = request.getParameter("data");
        int ano=Integer.parseInt(auxDt.substring(6,10)) - 1900;
        int mes=Integer.parseInt(auxDt.substring(3,5)) - 1 ;
        int dia=Integer.parseInt(auxDt.substring(0,2));
        java.sql.Date dtSQL = new java.sql.Date(ano, mes, dia);
        cliente.setDtnasc(dtSQL);
        
        ClienteDAO dao = new ClienteDAO();
        try {
            dao.adicionar(cliente);
            request.setAttribute("msg","Cliente cadastrado com Sucesso!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            out.print("Erro" + e.getMessage());
        }
    }
    // ATUALIZAR - PEGANDO DADOS PRO FORMULARIO  ///////////////////////////////
    else if (action.equalsIgnoreCase("pegarDados")){
        try {
            int id = (Integer.parseInt(request.getParameter("id_cliente")));
            String nome = null;// = (request.getParameter("nome"));
            ClienteDAO dao = new ClienteDAO();
            List<Cliente>lista=dao.listar();
            for(Cliente cliente : lista){
                if(cliente.getId()==id)
                    nome = cliente.getNome();
            }
            
            request.setAttribute("act1", "action=\"controle.jsp?action=update\" > <!--");
            request.setAttribute("act2", "-->" );
            request.setAttribute("show_id", "Cod. Cliente: <input type=\"text\" name=\"id_cliente\""
                                               + "value=\""+id+"\" readonly=\"readonly\" /> <br/>");
            request.setAttribute("nome", nome );
            request.setAttribute("email",request.getParameter("email"));
            request.setAttribute("telefone",request.getParameter("telefone"));
            request.setAttribute("data",request.getParameter("data"));
            request.setAttribute("sub1", "value=\"Atualizar Cliente\"/> <!--");
            request.setAttribute("sub2", "-->");

            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            out.print("Erro" + e.getMessage());
        }
    }
    //  ATUALIZAR - ENVIANDO PRO DAO ///////////////////////////////////////////
    else if (action.equalsIgnoreCase("update")){
        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(request.getParameter("id_cliente")));
        cliente.setNome(request.getParameter("nome"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setTelefone(Long.parseLong(request.getParameter("telefone")));
        
        // Convertendo a data de String para SQLdate.
        String auxDt = request.getParameter("data");
        int ano=Integer.parseInt(auxDt.substring(6,10)) - 1900;
        int mes=Integer.parseInt(auxDt.substring(3,5)) - 1 ;
        int dia=Integer.parseInt(auxDt.substring(0,2));
        java.sql.Date dtSQL = new java.sql.Date(ano, mes, dia);

        cliente.setDtnasc(dtSQL);

        ClienteDAO dao = new ClienteDAO();
        try {
            dao.alterar(cliente);
            request.setAttribute("msg","Cliente atualizado com Sucesso!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            out.print("Erro" + e.getMessage());
        }
    }
    // EXCLUIR  ////////////////////////////////////////////////////////////////
    else if (action.equalsIgnoreCase("excluir")){
        try {
            Integer cod_cliente = Integer.parseInt(request.getParameter("id_cliente"));
            ClienteDAO dao = new ClienteDAO();
            dao.deletar(cod_cliente);
            request.setAttribute("msg","Cliente Deletado com Sucesso!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            out.print("Erro" + e.getMessage());
        }
    }
%>