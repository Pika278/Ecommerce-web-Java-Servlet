package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\n");
      out.write("<html lang=\"zxx\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <!-- Required meta tags -->\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <title>Quin Store</title>\n");
      out.write("    <link rel=\"icon\" href=\"img/favicon.png\">\n");
      out.write("    <!-- Bootstrap CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("    <!-- animate CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/animate.css\">\n");
      out.write("    <!-- owl carousel CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\">\n");
      out.write("    <!-- font awesome CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/all.css\">\n");
      out.write("    <!-- flaticon CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/flaticon.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/themify-icons.css\">\n");
      out.write("    <!-- font awesome CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\n");
      out.write("    <!-- swiper CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/slick.css\">\n");
      out.write("    <!-- style CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("    <!-- banner part start-->\n");
      out.write("    <section class=\"banner_part\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row align-items-center\">\n");
      out.write("                <div class=\"col-md-5\">\n");
      out.write("                    <div class=\"banner_text\">\n");
      out.write("                        <div class=\"banner_text_iner\">\n");
      out.write("                            <h1>Best quality\n");
      out.write("                                pillow</h1>\n");
      out.write("                            <p>Seamlessly empower fully researched \n");
      out.write("                                growth strategies and interoperable internal</p>\n");
      out.write("                            <a href=\"product_list.html\" class=\"btn_1\">shop now</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"banner_img\">\n");
      out.write("            <img src=\"img/banner.png\" alt=\"#\" class=\"img-fluid\">\n");
      out.write("            <img src=\"img/banner_pattern.png \" alt=\"#\" class=\"pattern_img img-fluid\">\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("    <!-- banner part start-->\n");
      out.write("\n");
      out.write("    <!-- product list start-->\n");
      out.write("    <section class=\"single_product_list\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <div class=\"single_product_iner\">\n");
      out.write("                        <div class=\"row align-items-center justify-content-between\">\n");
      out.write("                            <div class=\"col-lg-6 col-sm-6\">\n");
      out.write("                                <div class=\"single_product_img\">\n");
      out.write("                                    <img src=\"img/single_product_1.png\" class=\"img-fluid\" alt=\"#\">\n");
      out.write("                                    <img src=\"img/product_overlay.png\" alt=\"#\" class=\"product_overlay img-fluid\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-5 col-sm-6\">\n");
      out.write("                                <div class=\"single_product_content\">\n");
      out.write("                                    <h5>Started from $10</h5>\n");
      out.write("                                    <h2> <a href=\"single-product.html\">Printed memory foam \n");
      out.write("                                        brief modern throw \n");
      out.write("                                        pillow case</a> </h2>\n");
      out.write("                                    <a href=\"product_list.html\" class=\"btn_3\">Explore Now</a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"single_product_iner\">\n");
      out.write("                        <div class=\"row align-items-center justify-content-between\">\n");
      out.write("                            <div class=\"col-lg-6 col-sm-6\">\n");
      out.write("                                <div class=\"single_product_img\">\n");
      out.write("                                    <img src=\"img/single_product_2.png\" class=\"img-fluid\" alt=\"#\">\n");
      out.write("                                    <img src=\"img/product_overlay.png\" alt=\"#\" class=\"product_overlay img-fluid\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-5 col-sm-6\">\n");
      out.write("                                <div class=\"single_product_content\">\n");
      out.write("                                    <h5>Started from $10</h5>\n");
      out.write("                                    <h2> <a href=\"single-product.html\">Printed memory foam \n");
      out.write("                                        brief modern throw \n");
      out.write("                                        pillow case</a> </h2>\n");
      out.write("                                    <a href=\"product_list.html\" class=\"btn_3\">Explore Now</a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"single_product_iner\">\n");
      out.write("                        <div class=\"row align-items-center justify-content-between\">\n");
      out.write("                            <div class=\"col-lg-6 col-sm-6\">\n");
      out.write("                                <div class=\"single_product_img\">\n");
      out.write("                                    <img src=\"img/single_product_3.png\" class=\"img-fluid\" alt=\"#\">\n");
      out.write("                                    <img src=\"img/product_overlay.png\" alt=\"#\" class=\"product_overlay img-fluid\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-5 col-sm-6\">\n");
      out.write("                                <div class=\"single_product_content\">\n");
      out.write("                                    <h5>Started from $10</h5>\n");
      out.write("                                    <h2> <a href=\"single-product.html\">Printed memory foam \n");
      out.write("                                            brief modern throw \n");
      out.write("                                            pillow case</a> </h2>\n");
      out.write("                                    <a href=\"product_list.html\" class=\"btn_3\">Explore Now</a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("    <!-- product list end-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!--::footer_part start::-->\n");
      out.write("    <footer class=\"footer_part\">\n");
      out.write("        <div class=\"footer_iner\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row justify-content-between align-items-center\">\n");
      out.write("                    <div class=\"col-lg-8\">\n");
      out.write("                        <div class=\"footer_menu\">\n");
      out.write("                            <div class=\"footer_logo\">\n");
      out.write("                                <a href=\"home\"><img src=\"img/logo.png\" alt=\"#\"></a>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"footer_menu_item\">\n");
      out.write("                                <a href=\"home\">Home</a>\n");
      out.write("                                <a href=\"about\">About</a>\n");
      out.write("                                <a href=\"product\">Products</a>\n");
      out.write("                                <a href=\"contact\">Contact</a>\n");
      out.write("                                <a href=\"login\">Login</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-4\">\n");
      out.write("                        <div class=\"social_icon\">\n");
      out.write("                            <a href=\"#\"><i class=\"fab fa-facebook-f\"></i></a>\n");
      out.write("                            <a href=\"#\"><i class=\"fab fa-instagram\"></i></a>\n");
      out.write("                            <a href=\"#\"><i class=\"fab fa-google-plus-g\"></i></a>\n");
      out.write("                            <a href=\"#\"><i class=\"fab fa-linkedin-in\"></i></a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </footer>\n");
      out.write("    <!--::footer_part end::-->\n");
      out.write("\n");
      out.write("    <!-- jquery plugins here-->\n");
      out.write("    <script src=\"js/jquery-1.12.1.min.js\"></script>\n");
      out.write("    <!-- popper js -->\n");
      out.write("    <script src=\"js/popper.min.js\"></script>\n");
      out.write("    <!-- bootstrap js -->\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <!-- magnific popup js -->\n");
      out.write("    <script src=\"js/jquery.magnific-popup.js\"></script>\n");
      out.write("    <!-- carousel js -->\n");
      out.write("    <script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.nice-select.min.js\"></script>\n");
      out.write("    <!-- slick js -->\n");
      out.write("    <script src=\"js/slick.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.counterup.min.js\"></script>\n");
      out.write("    <script src=\"js/waypoints.min.js\"></script>\n");
      out.write("    <script src=\"js/contact.js\"></script>\n");
      out.write("    <script src=\"js/jquery.ajaxchimp.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.form.js\"></script>\n");
      out.write("    <script src=\"js/jquery.validate.min.js\"></script>\n");
      out.write("    <script src=\"js/mail-script.js\"></script>\n");
      out.write("    <!-- custom js -->\n");
      out.write("    <script src=\"js/custom.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
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
