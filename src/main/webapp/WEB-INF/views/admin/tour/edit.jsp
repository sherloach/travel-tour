<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="tourURL" value="/admin/tour/list"/>
<c:url var="tourAPI" value="/api/tour"/>

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
                        Tours
                    </h4>
                </div>
            </div>
            <div class="row">
                <ul class="nav responsive-tab nav-material nav-material-white">
                    <li><a class="nav-link"
							href="<c:url value='/admin/tour/list?page=1&limit=2'/>">
							<i class="icon icon-list"></i>All Tours</a>
					</li>
					<li><a class="nav-link active"
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
			<form:form id="formSubmit" role="form" modelAttribute="model">
				<div class="row">
					<div class="col-md-8 ">
						<div class="row">
							<div class="col-md-6 mb-3">
								<label>Tour Name</label>
								<form:input cssClass="form-control" path="name" required="required"/>
								<div class="invalid-feedback">
									Please provide a name.
								</div>
							</div>
							<div class="col-md-6 mb-3">
								<label>Location</label>
								<form:input cssClass="form-control" path="location" required="required"/>
								<div class="invalid-feedback">
									Please provide a location.
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 mb-3">
								<label>Start Date</label>
								<form:input cssClass="date-time-picker form-control" path="startDate"
									  autocomplete="off" required="required"/>
								<div class="invalid-feedback">
									Please choose a date.
								</div>
							</div>
							<div class="col-md-3 mb-3">
								<label>Price</label>
								<form:input cssClass="form-control" path="price" required="required"/>
								<div class="invalid-feedback">
									Please provide a valid price.
								</div>
							</div>
							<div class="col-md-3 mb-3">
								<label>Max Group Size</label>
								<form:input cssClass="form-control" path="maxGroupSize" required="required"/>
								<div class="invalid-feedback">
									Please provide a valid number.
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-9 mb-3">
								<label>Summary</label>
								<form:input cssClass="form-control" path="summary" required="required"/>
								<div class="invalid-feedback">
									Please provide a summary.
								</div>
							</div>
							<div class="col-md-3 mb-3">
								<label for="category">Duration</label>
								<form:input cssClass="form-control" path="duration" required="required"/>
								<!--<input type="text" class="form-control"  placeholder="Mobile Phones" required>-->
<!-- 								<select id="duration" name="duration" class="custom-select form-control" required>
									<option value="">Select Product Category</option>
									<option value="1">Mobile Phone</option>
									<option value="2">Laptop & Computers</option>
									<option value="3">Accessories</option>
								</select> -->
								<div class="invalid-feedback">
									Please provide a valid duration.
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="description">Description</label>
							<form:textarea cssClass="form-control p-t-40"  path="description"
									  placeholder="Write Something..." rows="10" required="required"></form:textarea>
							<div class="invalid-feedback">
								Please provide a tour details.
							</div>
						</div>
						<!-- <div class="row">
							<div class="col-md-3 offset-md-1">
								<input hidden id="imageCover" name="imageCover"/>
								<div class="dropzone dropzone-file-area" id="fileUpload">
									<div class="dz-default dz-message">
										<span>Drop A passport size image of user</span>
										<div>You can also click to open file browser</div>
									</div>
								</div>
							</div>
						</div> -->
					</div>

					<!-- Cần phải có ID để xử lý thêm, sửa -->
					<form:hidden path="id" id="tourID"/>

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
								<button class="btn btn-primary" type="button" id="btnAddOrUpdateTour">Publish</button>
							</div>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	</div>

	<script>
		// Example starter JavaScript for disabling form submissions if there are invalid fields
		(function () {
			"use strict";
			window.addEventListener("load", function () {
				var form = document.getElementById("formSubmit");
				var btnPublish = document.getElementById("btnAddOrUpdateTour");
				btnPublish.addEventListener("click", function (event) {
					event.preventDefault(); // Huỷ bỏ event nếu nó có thể huỷ mà không dừng sự lan rộng (propagation) của event tới phần khác.

					form.classList.add("was-validated");
					var editorElement = document.getElementById("description");
					if (editorElement.value == '') {
						editorElement.parentNode.classList.add("is-invalid");
						editorElement.parentNode.classList.remove("is-valid");
					} else {
						editorElement.parentNode.classList.remove("is-invalid");
						editorElement.parentNode.classList.add("is-valid");
					}
					
					if (form.checkValidity() == true) { // Returns true if an input element contains valid data.
						event.stopPropagation(); // Ngăn chặn sự lan rộng của sự kiện hiện tại tới thằng khác.

						// TODO: fix validation
						// THÊM / SỬA
						event.preventDefault();
						var data = {};
						var formData = $('#formSubmit').serializeArray();
						$.each(formData, function (i, v) {
							data[""+v.name+""] = v.value;
			            });

						var id = $('#tourID').val();
						
						if (id == "") {
							addTour(data);
						} else {
							updateTour(data);
						}
					}
				}, false);

				function addTour(data) {
					$.ajax({
						url: '${tourAPI}',
			            type: 'POST',
			            contentType: 'application/json',
			            data: JSON.stringify(data),
			            dataType: 'json',
			            success: function (result) {
			            	window.location.href = "${tourURL}?page=1&limit=2";
			            },
			            error: function (error) {
			            	window.location.href = "${tourURL}?page=1&limit=2";
			            }
			        });
				}

				function updateTour(data) {
					$.ajax({
			            url: '${tourAPI}',
			            type: 'PUT',
			            contentType: 'application/json',
			            data: JSON.stringify(data),
			            dataType: 'json',
			            success: function (result) {
			                window.location.href = "${tourURL}?page=1&limit=2";
			            },
			            error: function (error) {
							window.location.href = "${tourURL}?page=1&limit=2";
			            }
			        });
				}
			}, false);
		}());
		
		/* $('#btnAddOrUpdateTour').click(function (e) {
			event.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function (i, v) {
				data[""+v.name+""] = v.value;
            });
			var id = $('#tourID').val();
			
			if (id == "") {
				addTour(data);
			} else {
				updateTour(data);
			}

			function addTour(data) {
				$.ajax({
					url: '${tourAPI}',
		            type: 'POST',
		            contentType: 'application/json',
		            data: JSON.stringify(data),
		            dataType: 'json',
		            success: function (result) {
		            	window.location.href = "${tourURL}?page=1&limit=2";
		            },
		            error: function (error) {
		            	window.location.href = "${tourURL}?page=1&limit=2";
		            }
		        });
			}
		});
		

		function updateTour(data) {
			$.ajax({
	            url: '${tourAPI}',
	            type: 'PUT',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	                window.location.href = "${tourURL}?page=1&limit=2";
	            },
	            error: function (error) {
					window.location.href = "${tourURL}?page=1&limit=2";
	            }
	        });
		} */
	</script>
</body>
</html>