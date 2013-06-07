package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Cliente;
import dao.ClienteDAO;
import java.util.List;
import java.text.SimpleDateFormat;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=ISO-8859-9");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-9\">\n");
      out.write("        <title>Pagina principal CRUD I</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h4>Formulário de cadastro de clientes<br/>\n");
      out.write("            Deve-se preencher todos os campos.</h4>\n");
      out.write("        <form method=\"post\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${act1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("action=\"controle.jsp?action=adicionar\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${act2}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${show_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            Nome: <input type=\"text\" name=\"nome\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" /> <br/>\n");
      out.write("            Email: <input type=\"text\" name=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" /> <br/>\n");
      out.write("            Telefone: <input type=\"text\" name=\"telefone\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${telefone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />(Apenas numeros)<br/>\n");
      out.write("            Data de nascimento: <input type=\"text\" name=\"data\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${data}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />dd/mm/yyyy (Formado da data)<br/>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sub1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("value=\"Cadastrar Cliente\"/>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sub2}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        </form>\n");
      out.write("        <form action=\"index.jsp\" >\n");
      out.write("             <input type=\"submit\" value=\"Limpar campos\"/>\n");
      out.write("        </form>\n");
      out.write("        <br />\n");
      out.write("        <font color=\"#FF0000\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</font> ");
      out.write("        \n");
      out.write("        <br/>\n");
      out.write("        <br/>        \n");
      out.write("        <h1>Lista de clientes</h1>\n");
      out.write("        <table width=\"100%\" border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <td>Código cliente</td>\n");
      out.write("                <td>Nome</td>\n");
      out.write("                <td>Email</td>\n");
      out.write("                <td>Fone</td>\n");
      out.write("                <td>Data</td>\n");
      out.write("                <td>Atualizar</td>\n");
      out.write("                <td>Excluir</td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                try{
                    String dtString = null;
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    ClienteDAO dao = new ClienteDAO();
                    List<Cliente>lista = dao.listar();
                    for(Cliente cliente : lista){
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( cliente.getId() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( cliente.getNome() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( cliente.getEmail() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( cliente.getTelefone() );
      out.write("</td>\n");
      out.write("                <td>");

                       try{
                           dtString = null;
                           dtString = sdf.format(cliente.getDtnasc());
                           out.println(dtString);
                       }catch(NullPointerException e){
                           out.print("Value " + e.getMessage());
                       }

                        
      out.write("</td>\n");
      out.write("                <td>");
 out.print("<a href=controle.jsp?action=pegarDados&id_cliente="+cliente.getId()
                                                                         +"&email="+cliente.getEmail()
                                                                         +"&telefone="+cliente.getTelefone()
                                                                         +"&data="+dtString
                                                                         +">Atualizar?</a>"); 
      out.write("</td>\n");
      out.write("                <td>");
 out.print("<a href=controle.jsp?action=excluir&id_cliente="+cliente.getId()
                                                                         +">Excluir?</a>"); 
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                    }
                }catch(Exception e){
                    out.print("Erro "+e);
                }
            
      out.write("\n");
      out.write("        </table>        \n");
      out.write("    </body>    \n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
