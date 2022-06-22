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
                <!-- breadcrumb part start-->
<!--                <section class="breadcrumb_part">
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
              <section class="cart_area section_padding">
                  <div class=" checkout_btn_inner float-right" style=" margin-right: 100px;">
                        <a href="#addEmployeeModal" class="btn_1 btn-success" data-toggle="modal"><span>Add Product</span></a>
                    </div>
                <div class="container">
                  <div class="cart_inner">
                    <div class="table-responsive">
                      <table class="table">
                        <thead>
                          <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Buying Price</th>
                            <th scope="col">Selling Price</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Description</th>
                            <th scope="col">Manager</th>
                          </tr>
                        </thead>
                        <tbody>
                        <%int i = 1;%>
                          <c:forEach items = "${listP}" var = "o">
                          <tr>
                            <td>
                                <h5>${o.productID}</h5>
                            </td>
                            <td>
                                <div class="media">
                                    <div class="d-flex">
                                        <a href="detail?pid=${o.productID}"><img src="${o.image1}" alt="#" class="img-fluid"></a>
                                    </div>
                                    <div class="media-body">
                                      <p>${o.productName}</p>
                                    </div>
                                  </div>
                            </td>
                            <td>
                                <h5>$${o.buyingPrice}</h5>
                            </td>
                            <td>
                                <h5>$${o.sellingPrice}</h5>
                            </td>
                            <td>
                                <h5>${o.quantity}</h5>
                            </td>
                            <td>
                                <p>${o.description}</p>
                            </td>
                            <td>
                                <a href="loadedit?pid=${o.productID}" class="edit"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xf044;</i></a>
                                <a href="delete?pid=${o.productID}" class="delete"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xe92b;</i></a>
                            </td>
                          </tr>
                          </c:forEach>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </section>
                          <!-- Add Product -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="add" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" class="form-control" required name="name">
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <textarea name="description" rows="4" cols="58" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input type="text" class="form-control" required name="price">
                            </div>
                            <div class="form-group">
                                <label>Image Link</label>
                                <input type="text" class="form-control" required name="imageLink">
                            </div>
                            <div class="form-group">
                                <label>Category</label>
<!--                                <select name="CategoryID" class="form-control" required>
                                    <%--<c:forEach var="o" items="${listC}">--%>
                                        <option value="Smart Phone">Smart Phone</option>
                                        <option value="Laptop">Laptop</option>
                                        <option value="Smart Watch">Smart Watch</option>
                                        <option value="Speaker">Speaker</option>
                                  <%--</c:forEach>--%>
                                </select>-->
                                  <div class="select_option">
                                        <div class="select_option_list">Category <i class="right fas fa-caret-down"></i> </div>
                                        <div class="select_option_dropdown">
                                        <c:forEach items = "${listC}" var = "c">
                                            <p><a href="category?cid=${c.id}">${c.name}</a></p>
                                        </c:forEach> 
                                        </div>
                                   </div>
                            </div>
                            <div class="form-group">
                                <label>Amount</label>
                                <input type="text" class="form-control" required name="amount">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
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
            <c:if test="${sessionScope.acc.isAdmin != 1}">
                <% response.sendRedirect("home"); %>
            </c:if>
        </c:if>
    </body>    
</html>