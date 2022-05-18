package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Fredoka\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link href=\"css/signupin.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\" id=\"container\">\n");
      out.write("            <div class=\"form-container sign-up-container\">\n");
      out.write("                <h1 style=\"position: relative; text-align: center; top: 80px;\">Create Account</h1>\n");
      out.write("                <form action=\"signup\" mothod=\"post\">\n");
      out.write("                    \n");
      out.write("                    <input class=\"inp\" type=\"text\" placeholder=\"UserName\" />\n");
      out.write("                    <input class=\"inp\" type=\"password\" placeholder=\"Password\" />\n");
      out.write("                    <input class=\"inp\" type=\"password\" placeholder=\"Repeat Password\" />\n");
      out.write("                    <button style=\"cursor: pointer;\" type=\"submit\">Sign Up</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-container sign-in-container\">\n");
      out.write("                <form action=\"login\" method=\"POST\">\n");
      out.write("                    <h1 style=\"position: relative; bottom: 10px\">Sign In</h1>\n");
      out.write("                    <p class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                    <input type=\"text\" name=\"user\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" id=\"inputEmail\" placeholder=\"UserName\" required=\"\" autofocus=\"\"/>\n");
      out.write("                    <input type=\"password\" name=\"pass\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" id=\"inputPassword\" placeholder=\"Password\" required=\"\"/>\n");
      out.write("                    <div class=\"form-group form-check\">\n");
      out.write("                    <input name=\"remember\" value=\"1\" type=\"checkbox\" class=\"form-check-input\" id=\"exampleCheck1\">\n");
      out.write("                    <label class=\"form-check-label\" for=\"exampleCheck1\">Remember me</label>\n");
      out.write("                </div>\n");
      out.write("                    <a href=\"#\">Forgot your password?</a>\n");
      out.write("                    <button style=\"cursor: pointer;\" type=\"submit\">Sign In</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"overlay-container\">\n");
      out.write("                <div class=\"overlay\">\n");
      out.write("                    <div class=\"overlay-panel overlay-left\">\n");
      out.write("                        <h1>Welcome Back!</h1>\n");
      out.write("                        <p>To keep connected with us please login with your personal info</p>\n");
      out.write("                        <button style=\"cursor: pointer;\" class=\"ghost\" id=\"signIn\">Sign In</button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"overlay-panel overlay-right\">\n");
      out.write("                        <h1>Hello, Friend!</h1>\n");
      out.write("                        <p>Enter your personal details and start journey with us</p>\n");
      out.write("                        <button style=\"cursor: pointer;\" class=\"ghost\" id=\"signUp\">Sign Up</button>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/signupin.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
