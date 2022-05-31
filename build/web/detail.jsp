<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zxx">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Product Details</title>
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
    <jsp:include page="menu.jsp"></jsp:include>
      <!-- breadcrumb part start-->
    <section class="breadcrumb_part single_product_breadcrumb">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb_iner">
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- breadcrumb part end-->

  <!--================Single Product Area =================-->
  <div class="product_image_area">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-12">
          <div class="product_img_slide owl-carousel">
            <div class="single_product_img">
              <img src="${detail.image}" alt="#" class="img-fluid">
            </div>
<!--            <div class="single_product_img">
              <img src="img/product/single_product.png" alt="#" class="img-fluid">
            </div>
            <div class="single_product_img">
              <img src="img/product/single_product.png" alt="#" class="img-fluid">
            </div>-->
          </div>
        </div>
        <div class="col-lg-8">
          <div class="single_product_text text-center">
            <h3>${detail.productName}</h3>
            <p>${detail.description}</p>
            <div class="card_area">
                <div class="product_count_area">
                    <p>Quantity</p>
                    <div class="product_count d-inline-block">
                        <span class="product_count_item inumber-decrement"> <i class="ti-minus"></i></span>
                        <input id = "amount" class="product_count_item input-number" type="text" value="1" min="0" max="10">
                        <span class="product_count_item number-increment"> <i class="ti-plus"></i></span>
                    </div>
                    <p>${detail.sellingPrice}$</p>
                </div>
              <div class="add_to_cart">
                  <a onclick="addCart2(${detail.productID})" class="btn_3">add to cart</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--================End Single Product Area =================-->
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
     <script>
        function addCart2(ProductID) {
                <c:if test="${sessionScope.acc != null}">
                    var select_value = document.getElementById("amount").value;
                    //Sử dụng Ajax
                    $.ajax({
                        url: "/web/addmanytocart",
                        type: "get", //send it through get method
                        data: {
                            ProductID: ProductID,
                            Quantity: select_value
                        },
                        success: function (message) {
                            alert(message);
                        }
                    });
                </c:if>
                <c:if test="${sessionScope.acc == null}">
                    location.href = "login";
                </c:if>
            }

//            function buy(ProductID) {
//                var select_value = document.getElementById("select_id").value;
//                location.href = "buyNow?ProductID=" + ProductID + "&Quantity=" + select_value;
//            }
            </script>  
</body>

</html>