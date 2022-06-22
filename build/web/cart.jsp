<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zxx">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Cart</title>
    <link rel="icon" href="img/favicon.png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- animate CSS -->
    <link rel="stylesheet" href="css/animate.css">
    <!-- owl carousel CSS -->
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <!-- font awesome CSS -->
    <link rel="stylesheet" href="css/all.css">
    <!-- flaticon CSS -->
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <!-- font awesome CSS -->
    <link rel="stylesheet" href="css/magnific-popup.css">
    <!-- swiper CSS -->
    <link rel="stylesheet" href="css/slick.css">
    <!-- style CSS -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

     <jsp:useBean id="c" class="dao.CartDAO"></jsp:useBean>
</head>
<body>
    <c:if test="${sessionScope.acc == null}">
            <% response.sendRedirect("home"); %>
        </c:if>
        <c:if test="${sessionScope.acc != null}">
            <c:if test="${sessionScope.acc.isAdmin != 1}">
                <jsp:include page="menu.jsp"></jsp:include>
    <!-- breadcrumb part start-->
<!--    <section class="breadcrumb_part">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb_iner">
                        <h2>cart list</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>-->
    <!-- breadcrumb part end-->

  <!--================Cart Area =================-->
                <section class="cart_area section_padding">
                  <div class="container">
                    <div class="cart_inner">
                      <div class="table-responsive">
                        <table class="table">
                          <thead>
                            <tr>
                              <th scope="col">Product</th>
                              <th scope="col">Price</th>
                              <th scope="col">Quantity</th>
                              <th>Delete</th>
                            </tr>
                          </thead>
                          <tbody>
                            <!--<tr>-->
                            <c:forEach items = "${list}" var = "o">
                            <tr>
                               <td>
                                <div class="media">
                                  <div class="d-flex">
                                    <img src="${o.image}" alt="#" class="img-fluid">
                                  </div>
                                  <div class="media-body">
                                    <p>${o.productName}</p>
                                  </div>
                                </div>
                              </td>
                              <td>
                                <h5>$${o.getPriceWithDot()}</h5>
                              </td>
                              <td>
                                <div class="product_count">
                                  <a href="minusquantity?minusId=${o.productID}"><span class="ti-minus"></span></a>
                                  <input class="input-number" type="text" value="${o.quantity}" readonly/>
                                  <a href="addquantity?plusId=${o.productID}"><span class="ti-plus"></span></a>
                                </div>
                              </td>
                              <td>
                                  <a href="deleteproductcart?pid=${o.productID}" class="delete"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xe92b;</i></a>
                              </td>

                            </tr>
                            </c:forEach>
                            <!--</tr>-->
                            <tr>
                              <td>
                                <h5>Subtotal</h5>
                              </td>
                              <td>
                                <h5>$${subtotal}</h5>
                              </td>
                            </tr>
                          </tbody>
                        </table>
                        <div class="checkout_btn_inner float-right">
                          <a class="btn_1" href="productlist">Continue Shopping</a>
                          <a class="btn_1 checkout_btn_1" href="loadcheckhout">Proceed to checkout</a>
                        </div>
                      </div>
                    </div>
                </section>
                <!--================End Cart Area =================-->
                   <!--::footer_part start::-->
                  <footer class="footer_part">
                      <div class="footer_iner">
                          <div class="container">
                              <div class="row justify-content-between align-items-center">
                                  <div class="col-lg-8">
                                      <div class="footer_menu">
                                          <div class="footer_logo">
                                              <a href="home"><img src="img/logo1.png" alt="#"></a>
                                          </div>
                                          <div class="footer_menu_item">
                                              <a href="home">Home</a>
                                              <a href="about">About</a>
                                              <a href="product">Products</a>
                                              <a href="contact">Contact</a>
                                              <a href="login">Login</a>
                                          </div>
                                      </div>
                                  </div>
                                  <div class="col-lg-4">
                                      <div class="social_icon">
                                          <a href="#"><i class="fab fa-facebook-f"></i></a>
                                          <a href="#"><i class="fab fa-instagram"></i></a>
                                          <a href="#"><i class="fab fa-google-plus-g"></i></a>
                                          <a href="#"><i class="fab fa-linkedin-in"></i></a>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </footer>
                  <!--::footer_part end::-->

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
            <c:if test="${sessionScope.acc.isAdmin == 1}">
                <% response.sendRedirect("home"); %>
            </c:if>
        </c:if>
</body>

</html>