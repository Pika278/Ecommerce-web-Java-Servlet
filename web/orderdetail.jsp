<%@page import="model.OrderedProduct"%>
<%@page import="java.util.List"%>
<%@page import="dao.OrderedProductDAO"%>
<%@page import="model.Account"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!--Favicon-->
        <title>Order Detail</title>
        <!--<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Fredoka:wght@300&display=swap">-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.1/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/style.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
              integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    </head>
    <body>
        <c:if test="${sessionScope.acc == null}">
            <% response.sendRedirect("home"); %>
        </c:if>
        <c:if test="${sessionScope.acc != null}">
                 <jsp:include page="menu.jsp"></jsp:include>

              <section class="cart_area section_padding">
                <div class="container">
                  <div class="cart_inner">
                    <div class="table-responsive">
                      <table class="table">
                        <thead>
                          <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Product</th>
                            <th scope="col">Price</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Total</th>
                          </tr>
                        </thead>
                        <tbody>
                        <%int i = 1;
                            Account a = (Account) session.getAttribute("acc");
                            int uid = a.getId();
                            int oid = Integer.parseInt(request.getParameter("oid"));
                            OrderedProductDAO orderedDAO = new OrderedProductDAO();
                            List<OrderedProduct> orderedproducts = orderedDAO.getOrderedProductByUser(oid, uid);
                        
                        %>
                          <% for(OrderedProduct od: orderedproducts) { %>
                          <tr>
                              <td>
                                  <h5><%=i++%></h5>
                              </td>
                             <td>
                                 <div class="media">
                                    <div class="d-flex">
                                      <img src="<%=od.getProductImage()%>" alt="#" class="img-fluid">
                                    </div>
                                    <div class="media-body">
                                      <p><%=od.getProductName()%></p>
                                    </div>
                                 </div>
                            </td>
                            <td>
                              <h5>$<%=od.getProductPrice()%></h5>
                            </td>
                            <td>
                              <h5><%=od.getQuantity()%></h5>
                            </td>
                            <td>
                              <h5>$<%=od.getQuantity() * od.getProductPrice()%></h5>
                            </td>
                          </tr>
                          <% } %>
                        </tbody>
                      </table>
                    </div>
                  </div>
              </section>
                          
<jsp:include page="footer.jsp"></jsp:include>

                <!-- jquery plugins here-->
                <script src="js/jquery-1.12.1.min.js"></script>
                <!-- popper js -->
                <script src="js/popper.min.js"></script>
                <!-- bootstrap js -->
                <script src="js/bootstrap.min.js"></script>
                <!-- easing js -->
                <script src="js/jquery.magnific-popup.js"></script>
                <!-- swiper js -->
                <script src="js/swiper.min.js"></script>
                <!-- swiper js -->
                <script src="js/mixitup.min.js"></script>
                <!-- particles js -->
                <script src="js/owl.carousel.min.js"></script>
                <script src="js/jquery.nice-select.min.js"></script>
                <!-- slick js -->
                <script src="js/slick.min.js"></script>
                <script src="js/jquery.counterup.min.js"></script>
                <script src="js/waypoints.min.js"></script>
                <script src="js/contact.js"></script>
                <script src="js/jquery.ajaxchimp.min.js"></script>
                <script src="js/jquery.form.js"></script>
                <script src="js/jquery.validate.min.js"></script>
                <script src="js/mail-script.js"></script>
                <!-- custom js -->
                <script src="js/custom.js"></script>
        </c:if>
    </body>    
</html>