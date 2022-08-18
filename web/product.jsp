<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zxx">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>List Product</title>
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
</head>

<body>
        <c:if test="${sessionScope.acc.isAdmin == 1}">
            <% response.sendRedirect("home"); %>
        </c:if>
        <c:if test="${sessionScope.acc == null or sessionScope.acc.isAdmin != 1}">
                <jsp:include page="menu.jsp"></jsp:include>
                <!-- product list part start-->
                <section class="product_list section_padding">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="product_sidebar">
                                    <div class="single_sedebar">
                                        <form action="search" method = "post">
                                            <input value="${txtSearch}" type="text" name="txtSearch" placeholder="Search keyword">
                                            <i class="ti-search"></i>
                                        </form>
                                    </div>
                                    <div class="single_sedebar">
                                        <div class="select_option">
                                            <div class="select_option_list">Category <i class="right fas fa-caret-down"></i> </div>
                                            <div class="select_option_dropdown">
                                            <c:forEach items = "${listC}" var = "c">
                                                <p><a href="category?cid=${c.id}">${c.name}</a></p>
                                            </c:forEach> 
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>  
                            <div class="col-md-8">
                                <div class="product_list">
                                    <div class="row">
                                        <c:forEach items="${listP}" var="o">
                                            <div class="col-lg-6 col-sm-6">
                                                 <div class="single_product_item">
                                                    <img src="${o.image1}" alt="#" class="img-fluid" class = "productlist-img">
                                                    <h3> <a href="detail?pid=${o.productID}">${o.productName}</a> </h3>
                                                    <p>$${o.getPriceWithDot()}</p>
                                                </div>
                                                <div class="single_product_item">
                                                    <a onclick="addCart(${o.productID})" class="btn btn-outline-dark btn-block">Add to cart<i class="fas fa-shopping-cart"></i></a>
                                                </div>

                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    </div>
                </section>
                <!-- product list part end-->

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
                <script>
                        function addCart(ProductID) {
                            <c:if test="${sessionScope.acc != null}">
                            //Sử dụng Ajax
                            $.ajax({
                                url: "/web/addtocart",
                                type: "get", //send it through get method
                                data: {
                                    ProductID: ProductID
                                },
                                success: function (message) {
                                    alert(message);
                                },
                                error: function () {
                                }
                            });
                            </c:if>
                            <c:if test="${sessionScope.acc == null}">
                                location.href = "login";
                            </c:if>
                                                                }
                </script>

        </c:if>                
</body>

</html>