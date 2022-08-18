<%@page import="model.Orders"%>
<%@page import="java.util.List"%>
<%@page import="dao.OrdersDAO"%>
<%@page import="dao.AccountDAO"%>
<%@page import="model.Account"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!--Favicon-->
        <title>Manage Order</title>
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
            <c:if test="${sessionScope.acc.isAdmin == 1}">
                 <jsp:include page="menu.jsp"></jsp:include>
              <section class="cart_area section_padding">
                <div class="container">
                  <div class="cart_inner">
                    <div class="table-responsive">
                      <table class="table">
                        <thead>
                          <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Username</th>
                            <th scope="col">Name</th>
                            <th scope="col">Phone</th>
                            <th scope="col">Address</th>
                            <th scope="col">Total</th>
                            <th scope="col">Date</th>
                            <th scope="col">Status</th>
                            <th scope="col">Detail</th>
                            <th scope="col">Cancel</th>
                          </tr>
                        </thead>
                        <tbody>
                        <%int i = 1;
                        OrdersDAO orderDAO = new OrdersDAO();
                        List<Orders> orders = orderDAO.getAllOrders();
                        %>
                          <%--<c:forEach items = "${orders}" var = "o">--%>
                          <% for(Orders o : orders) { %>
                          <tr>
                            <td>
                                <h5><%=i++%></h5>
                            </td>
                            <td>
                                <%
                                    AccountDAO accountDAO = new AccountDAO();
                                    Account a = accountDAO.getAccountByID(o.getAccountID());
                                    String username = a.getUsername();
                                %>
                                <h5><%=username%></h5>
                            </td>
                            <td>
                                <h5><%=o.getName()%></h5>
                            </td>
                            <td>
                                <h5><%=o.getPhone()%></h5>
                            </td>
                            <td>
                                <h5><%=o.getAddress()%></h5>
                            </td>
                            <td>
                                <h5>$<%=o.getTotal()%></h5>
                            </td>
                            <td>
                                <h5><%=o.getDate()%></h5>
                            </td>
                            <td>
                                <%if(o.getStatus().equalsIgnoreCase("Canceled")) { %>
                                    <button class = "btn" disabled style = "color:#B08EAD">CANCELED</button>
                                <%} else if(o.getStatus().equalsIgnoreCase("Waiting")) { %>
                                        <a href = "updateDelivering?oid=<%=o.getOrderID()%>" class="btn_3">Waiting</a>
                                    <% } else if(o.getStatus().equalsIgnoreCase("Delivering")) {%>
                                        <a href = "updateDelivered?oid=<%=o.getOrderID()%>" class="btn_3">Delivering</a>
                                    <% } else { %>
                                    <button class = "btn" disabled style = "color:#B08EAD">DELIVERED</button>
                                <% } %>
                            </td>
                            <td>
                                <a href = "manageorderdetail?oid=<%=o.getOrderID()%>" class="btn_3">Detail</a>
                            </td>                            <td>
                                <a href="cancelorder?oid=<%=o.getOrderID()%>" class="delete"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xe92b;</i></a>
                            </td>
                            
                          </tr>
                          <%--</c:forEach>--%>
                          <% } %>
                        </tbody>
                      </table>
                    </div>
                  </div>
              </section>
              <!--================End Cart Area =================-->

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
            <c:if test="${sessionScope.acc.isAdmin != 1}">
                <% response.sendRedirect("home"); %>
            </c:if>
        </c:if>
    </body>    
</html>