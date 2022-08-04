<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zxx">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Quin Store</title>
<!--    <link rel="icon" href="img/favicon.png">
     Bootstrap CSS 
    <link rel="stylesheet" href="css/bootstrap.min.css">
     animate CSS 
    <link rel="stylesheet" href="css/animate.css">
     owl carousel CSS 
    <link rel="stylesheet" href="css/owl.carousel.min.css">
     font awesome CSS 
    <link rel="stylesheet" href="css/all.css">
     flaticon CSS 
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/themify-icons.css">
     font awesome CSS 
    <link rel="stylesheet" href="css/magnific-popup.css">
     swiper CSS 
    <link rel="stylesheet" href="css/slick.css">-->
    <!-- style CSS -->
    <link rel="stylesheet" href="css/style.css">
     <jsp:useBean id="c" class="dao.CartDAO"></jsp:useBean>
</head>

<body>
<header class="main_menu home_menu">
        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-lg-12">
                    <nav class="navbar navbar-expand-lg navbar-light">
                        <a class="navbar-brand" href="home"> <img src="img/logo1.png" alt="logo"> </a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span class="menu_icon"><i class="fas fa-bars"></i></span>
                        </button>

                        <div class="collapse navbar-collapse main-menu-item" id="navbarSupportedContent">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link" href="home">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="about">about</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="contact">Contact</a>
                                </li>
                                <c:if test="${sessionScope.acc == null}">
                                    <li class="nav-item">
                                        <a class="nav-link" href="productlist">Product</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="login">Login</a>
                                    </li>
                                </c:if>
                                <c:if test = "${sessionScope.acc != null}">
                                    <c:if test="${sessionScope.acc.isAdmin == 1}">
                                        <li class="nav-item">
                                            <a class="nav-link" href="manage">Manage</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="logout">LogOut</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${sessionScope.acc.isAdmin != 1}">
                                        <li class="nav-item">
                                            <a class="nav-link" href="productlist">Product</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="myorder">My Order</a>
                                        </li>
                                        <li class="nav-item">
                                        <a class="nav-link" href="logout">LogOut</a>
                                        </li>
                                        <div class="hearer_icon d-flex align-items-center">
                                            <a href="cart">
                                              <i class="flaticon-shopping-cart-black-shape"></i>
                                            </a>
                                        </div>
                                    </c:if>
                                </c:if>

                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
<!--    <script src="js/jquery-1.12.1.min.js"></script>
     popper js 
    <script src="js/popper.min.js"></script>
     bootstrap js 
    <script src="js/bootstrap.min.js"></script>
     magnific popup js 
    <script src="js/jquery.magnific-popup.js"></script>
     carousel js 
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
     slick js 
    <script src="js/slick.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/contact.js"></script>
    <script src="js/jquery.ajaxchimp.min.js"></script>
    <script src="js/jquery.form.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/mail-script.js"></script>
     custom js 
    <script src="js/custom.js"></script>-->
</body>

</html>