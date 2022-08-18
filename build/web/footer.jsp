<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Footer</title>
    </head>
    <body>
        <footer class="footer_part">
                    <div class="footer_iner">
                        <div class="container">
                            <div class="row justify-content-between align-items-center">
                                <div class="col-lg-9">
                                    <div class="footer_menu">
                                        <div class="footer_logo">
                                            <a href="home"><img src="img/logo1.png" alt="#"></a>
                                        </div>
                                        <div class="footer_menu_item">
                                            <a href="home">Home</a>
                                            <a href="about">About</a>
                                            <a href="contact">Contact</a>      
                                            <c:if test="${sessionScope.acc == null}">
                                                <a href="product">Product</a>
                                                <a href="login">Login</a>
                                            </c:if>
                                        <c:if test = "${sessionScope.acc != null}">
                                            <c:if test="${sessionScope.acc.isAdmin == 1}">
                                                <a href="login">Manage</a>
                                                <a href="login">Logout</a>
                                            </c:if>
                                            <c:if test="${sessionScope.acc.isAdmin != 1}">
                                                <a href="product">Product</a>
                                                <a href="product">My Order</a>
                                                <a href="product">Logout</a>
                                            </c:if>
                                        </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3">
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
    </body>
</html>
