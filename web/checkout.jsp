<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Checkout</title>
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

  <!--================Checkout Area =================-->
  <section class="checkout_area section_padding">
    <div class="container">
      <div class="billing_details">
        <div class="row">
          <div class="col-lg-8">
            <h3>Billing Details</h3>
            <form action="checkout" method="post" >
              <div class="col-md-12 form-group ">
                  <input required type="text" class="form-control" name="name" placeholder = "Full name">
              </div>
              <div class="col-md-12 form-group p_star">
                <input required type="text" class="form-control"  name="number" placeholder = "Phone Number">
              </div>
              <div class="col-md-12 form-group p_star">
                  <input required type="text" class="form-control"  name="add" placeholder = "Address">
              </div>
                 <input type="submit" class="btn_3" value="Checkout" >

            </form>
          </div>

          <div class="col-lg-4">
            <div class="order_box">
              <h2>Your Order</h2>
              <ul class="list">
                <li>
                  <a href="#">Product
                    <span> Quantity</span>
                    <span>Pricex</span>
                  </a>
                </li>
                <c:forEach items = "${list}" var = "o">
                    <li>
                      <a href="#">${o.productName}
                        
                        <span>x${o.quantity}</span>
                        <span>$${o.getPriceWithDot()}</span>

                      </a>
                    </li>
                </c:forEach>
              </ul>
           
              <ul class="list list_2">
                <li>
                  <a href="#">Total
                    <span>$${total}</span>
                  </a>
                </li>
                <li>
                  <a href="#">Shipping
                    <span>Flat rate: $1</span>
                  </a>
                </li>
                <li>
                  <a href="#">Subtotal
                    <span>$${subtotal}</span>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--================End Checkout Area =================-->

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
</body>

</html>