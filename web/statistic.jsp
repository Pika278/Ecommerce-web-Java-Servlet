<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!--Favicon-->
        <title>Statistic</title>
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
                 <div class="container">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="product_sidebar">
                                <div class="single_sedebar">
                                    <form action="statisticfilter" method = "post">
                                            <div class="col-md-12 form-group ">
                                            <input value="${year}" type="text" class="form-control" name="year" placeholder = "Enter Year" >
                                            </div>
                                            <div class="col-md-12 form-group p_star">
                                              <input value="${month}" type="text" class="form-control"  name="month" placeholder = "Enter Month">                                        <i class="ti-search"></i>
                                            </div>
                                            <div class="col-md-12 form-group p_star">
                                              <input value="${day}" type="text" class="form-control"  name="day" placeholder = "Enter Day">                                        <i class="ti-search"></i>
                                            </div>
                                            <div class="col-md-12 form-group p_star">
                                                <button class = "btn_1" type="submit">Submit</button>
                                            </div>
                                    </form>
                                </div>
                            </div>
                        </div> 
                    </div>
                 </div>
                                        
            <!--<div class="container">-->
                 <section class="feature_part section_padding">
                    <div class="container" style="padding-top: 200px; "> 
                        <div class="row justify-content-center">
                            <div class="col-lg-3 col-sm-6">
                                <div class="single_feature_part">
                                    <h4>Total Order</h4>
                                    <h3>${totalOrder}</h3>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6">
                                <div class="single_feature_part">
                                    <h4>Total Product Sold</h4>
                                    <h3>${totalQuantityProduct}</h3>
                                </div>
                            </div>

                            <div class="col-lg-3 col-sm-6">
                                <div class="single_feature_part">
                                    <h4>Total Profit</h4>
                                    <h3>$${profit}</h3>
                                </div>
                            </div>
                                
                            <div class="col-lg-3 col-sm-6">
                                <div class="single_feature_part">
                                    <h4>Total Income</h4>
                                    <h3>$${total}</h3>
                                </div>
                            </div>
                        </div>
                    </div>
                 </section>
            <!--</div>-->
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
