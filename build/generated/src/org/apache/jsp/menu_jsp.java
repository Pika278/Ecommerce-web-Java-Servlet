package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<header class=\"main_menu home_menu\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row align-items-center justify-content-center\">\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <nav class=\"navbar navbar-expand-lg navbar-light\">\n");
      out.write("                        <a class=\"navbar-brand\" href=\"index.html\"> <img src=\"img/logo.png\" alt=\"logo\"> </a>\n");
      out.write("                        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\"\n");
      out.write("                            data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\"\n");
      out.write("                            aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                            <span class=\"menu_icon\"><i class=\"fas fa-bars\"></i></span>\n");
      out.write("                        </button>\n");
      out.write("\n");
      out.write("                        <div class=\"collapse navbar-collapse main-menu-item\" id=\"navbarSupportedContent\">\n");
      out.write("                            <ul class=\"navbar-nav\">\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"index\">Home</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"about\">about</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"product_list\">Product</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"nav-item dropdown\">\n");
      out.write("                                    <a class=\"nav-link dropdown-toggle\" href=\"blog.html\" id=\"navbarDropdown_3\"\n");
      out.write("                                        role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                        pages\n");
      out.write("                                    </a>\n");
      out.write("                                    <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown_2\">\n");
      out.write("                                        <a class=\"dropdown-item\" href=\"login\"> login</a>\n");
      out.write("                                        <a class=\"dropdown-item\" href=\"checkout\">product checkout</a>\n");
      out.write("                                        <a class=\"dropdown-item\" href=\"cart\">shopping cart</a>\n");
      out.write("                                    </div>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"contact\">Contact</a>\n");
      out.write("                                </li>\n");
      out.write("                                                <!--Nếu acc khác null -> login rồi -> hiển thị cả 3 menu dưới-->\n");
      out.write("                                <c:if test = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc != null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                    <!--Kiểm tra xem có phải admin ko: isAdmin == 1-->\n");
      out.write("                                    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc.isAdmin == 1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                        <li class=\"nav-item\">\n");
      out.write("                                            <a class=\"nav-link\" href=\"managerProduct\">Manager Product</a>\n");
      out.write("                                        </li> \n");
      out.write("                                        <li class=\"nav-item\">\n");
      out.write("                                            <a class=\"nav-link\" href=\"managerAccount\">Manager Account</a>\n");
      out.write("                                        </li>\n");
      out.write("                                    </c:if>\n");
      out.write("                                </c:if>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"hearer_icon d-flex align-items-center\">\n");
      out.write("                            <a id=\"search_1\" href=\"javascript:void(0)\"><i class=\"ti-search\"></i></a>\n");
      out.write("                            <a href=\"cart.html\">\n");
      out.write("                                <i class=\"flaticon-shopping-cart-black-shape\"></i>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"search_input\" id=\"search_input_box\">\n");
      out.write("            <div class=\"container \">\n");
      out.write("                <form class=\"d-flex justify-content-between search-inner\">\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"search_input\" placeholder=\"Search Here\">\n");
      out.write("                    <button type=\"submit\" class=\"btn\"></button>\n");
      out.write("                    <span class=\"ti-close\" id=\"close_search\" title=\"Close Search\"></span>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </header>");
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
