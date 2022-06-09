<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!--Favicon-->
        <title>Quin Store</title>
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
        <style>
            body {
                color: #566787;
                background: #f5f5f5;
                font-family: 'Rubik', sans-serif;
                font-size: 16px;
            }
            .table-responsive {
                margin: 30px auto;
            }
            .table-wrapper {
                background: #fff;
                padding: 20px 25px;
                border-radius: 3px;
                min-width: 1000px;
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
            }

            table.table td a.edit {
                color: #FFC107;
            }
            table.table td a.delete {
                color: #F44336;
            }
            .modal .form-control {
                border-radius: 2px;
                box-shadow: none;
                border-color: #dddddd;
            }
            .modal textarea.form-control {
                resize: vertical;
            }
            .modal .btn {
                border-radius: 2px;
                min-width: 100px;
            }	
            .modal form label {
                font-weight: normal;
            }	
        </style>

    </head>
    <body>
            <%--<jsp:include page="menu.jsp"></jsp:include>--%>
        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div>
                       <a href = "home" class="btn btn-primary">Back to home</a>
                       <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons"></i> <span>Add Product</span></a>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Image</th>
                                <th>Name</th>
                                <th>Buying Price</th>
                                <th>Selling Price</th>
                                <th>Quantity</th>
                                <th>Description</th>
                                <th>Manager</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${listP}" var="o">
                                <tr>
                                    <td>${o.productID}</td>
                                    <td><img src="${o.image1}" style="height: 100px"></td>
                                    <td><a href="detail?pid=${o.productID}">${o.productName}</a></td>
                                    <td>$${o.buyingPrice}</td>
                                    <td>$${o.sellingPrice}</td>
                                    <td>${o.quantity}</td>
                                    <td>${o.description}</td>
                                    <td>
                                        <!--Link to GET in EditControl-->
                                        <a href="loadedit?pid=${o.productID}" class="edit"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xf044;</i></a>
                                        <a href="delete?pid=${o.productID}" class="delete"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xe92b;</i></a>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                    <div class="clearfix">
                        <div class="hint-text">Total has ${count} product</div>
                    </div>
                    
                </div>
            </div>     
        </div>
        <!-- Add Product -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="addproduct" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Name</label>
                                <input name="name" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <textarea name="description" rows="4" cols="50" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Buying Price</label>
                                <input type="text" class="form-control" required name="buyingprice">
                            </div>
                            <div class="form-group">
                                <label>Selling Price</label>
                                <input type="text" class="form-control" required name="sellingprice">
                            </div>
                            <div class="form-group">
                                <label>Image 1 </label>
                                <input name="image1" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image2 </label>
                                <input name="image2" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image3 </label>
                                <input name="image3" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image4 </label>
                                <input name="image4" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image5 </label>
                                <input name="image5" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Category</label>
                                <select name="cateID" class="form-control" required>
                                    <c:forEach var="o" items="${listC}">
                                        <option value="${o.id}">${o.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Quantity</label>
                                <input type="text" class="form-control" required name="quantity">
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
        
</html>