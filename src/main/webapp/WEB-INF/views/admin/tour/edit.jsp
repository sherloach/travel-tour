<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Admin</title>
</head>
<body>
 	<div class="page has-sidebar-left">
    <header class="blue accent-3 relative">
        <div class="container-fluid text-white">
            <div class="row p-t-b-10 ">
                <div class="col">
                    <h4>
                        <i class="icon-package"></i>
                        Products
                    </h4>
                </div>
            </div>
            <div class="row">
                <ul class="nav responsive-tab nav-material nav-material-white">
                    <li><a class="nav-link active"
							href="<c:url value='/admin/tour/list?page=1&limit=2'/>">
							<i class="icon icon-list"></i>All Tours</a>
					</li>
					<li><a class="nav-link"
							href="<c:url value='/admin/tour/edit'/>">
							<i class="icon icon-plus-circle"></i> Add New Tours</a>
					</li>
                    <li>
                        <a class="nav-link" href="#"><i class="icon icon-trash-can"></i>Trash</a>
                    </li>
                </ul>
            </div>
        </div>
    </header>
    <div class="container-fluid animatedParent animateOnce my-3">
        <div class="animated fadeInUpShort">
            <form id="formSubmit" role="form" novalidate>
                <div class="row">
                    <div class="col-md-8 ">
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="validationCustom01">Tour Name</label>
                                <input type="text" class="form-control" id="validationCustom01"
                                       placeholder="Product Name" required>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="validationCustom02">Location</label>
                                <input type="text" class="form-control" id="validationCustom02" placeholder="Last name"
                                       required>
                            </div>
                        </div>
                        <div class="row">
							<div class="col-md-6 mb-3">
								<label for="validationCustom01">Start Date</label>
								<input type="text" class="date-time-picker form-control" id="validationCustom01"
									   autocomplete="off" required>
							</div>
                            <div class="col-md-3 mb-3">
                                <label for="validationCustom04">Price</label>
                                <input type="text" class="form-control" id="validationCustom04" placeholder="$ 250"
                                       required>
                                <div class="invalid-feedback">
                                    Please provide a valid price.
                                </div>
                            </div>
                            <div class="col-md-3 mb-3">
                                <label for="sku">Max Group Size</label>
                                <input type="text" class="form-control" id="sku" required>
                                <div class="invalid-feedback">
                                    Please provide a valid sku.
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-9 mb-3">
                                <label for="validationCustom01">Summary</label>
                                <input type="text" class="form-control" id="validationCustom01"
                                       placeholder="Summary" required>
                            </div>
                            <div class="col-md-3 mb-3">
                            <label for="category">Duration</label>
                                <!--<input type="text" class="form-control"  placeholder="Mobile Phones" required>-->
                                <select id="category" class="custom-select form-control" required>
                                    <option value="">Select Product Category</option>
                                    <option value="1">Mobile Phone</option>
                                    <option value="2">Laptop & Computers</option>
                                    <option value="3">Accessories</option>
                                </select>
                                <div class="invalid-feedback">
                                    Please provide a valid category.
                                </div>
							</div>
                        </div>
                        <div class="form-group">
                            <label for="productDetails">Description</label>
                            <textarea class="form-control p-t-40" id="description"
                                      placeholder="Write Something..." rows="10" required></textarea>
                            <div class="invalid-feedback">
                                Please provide a product details.
                            </div>
                        </div>
                        <script>
                            // Example starter JavaScript for disabling form submissions if there are invalid fields
                            (function () {
                                "use strict";
                                window.addEventListener("load", function () {
                                    var form = document.getElementById("needs-validation");
                                    form.addEventListener("submit", function (event) {
                                        if (form.checkValidity() == false) {
                                            event.preventDefault();
                                            event.stopPropagation();
                                        }
                                        form.classList.add("was-validated");
                                        var editorElement = document.getElementById("productDetails");
                                        if (editorElement.value == '') {
                                            editorElement.parentNode.classList.add("is-invalid");
                                            editorElement.parentNode.classList.remove("is-valid");
                                        } else {
                                            editorElement.parentNode.classList.remove("is-invalid");
                                            editorElement.parentNode.classList.add("is-valid");
                                        }

                                    }, false);
                                }, false);
                            }());
                        </script>
                    </div>
                    <div class="col-md-3">
                        <div class="card mt-4">
                            <h6 class="card-header white">Publish</h6>
                            <div class="card-body text-success">

                                <div class="custom-control custom-checkbox mb-3">
                                    <input type="checkbox" class="custom-control-input" id="customControlValidation1" required>
                                    <label class="custom-control-label" for="customControlValidation1">Check this checkbox</label>
                                    <div class="invalid-feedback">Are you sure?</div>
                                </div>
                            </div>
                            <div class="card-footer bg-transparent">
                                <button class="btn btn-primary" type="submit">Publish</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>