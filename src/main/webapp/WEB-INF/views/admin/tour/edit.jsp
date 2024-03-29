<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="listTourURL" value="/admin/tour/list"/>
<c:url var="tourAPI" value="/api/tour"/>
<c:url var="editTourURL" value="/admin/tour/edit"/>

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
							href="<c:url value='/admin/tour/list?page=1&limit=6'/>">
							<i class="icon icon-list"></i>All Tours</a>
					</li>
					<li><a class="nav-link active"
							href="<c:url value='/admin/tour/edit'/>">
							<i class="icon icon-plus-circle"></i> Add New Tours</a>
					</li>
					<li><a class="nav-link"
						   href="<c:url value='/admin/route/list/tour/instour?tour=${model.id}'/>">
						<i class="icon icon-plus-circle"></i> Open Dates</a>
					</li>
                </ul>
            </div>
        </div>
    </header>
    <c:if test="${not empty message}">
		<div role="alert" class="alert alert-${alert}">
			  <strong>${message}</strong>
		</div>
	</c:if>
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
								<label>Route</label>
								<form:select cssClass="form-control" path="routeId" required="required">
									<form:option value="" label="Choose..."/>
									<c:forEach var="item" items="${route}">
										<form:option value="${item.id}" label="${item.startLocation} - ${item.destination}"/>
									</c:forEach>
								</form:select>
								<div class="invalid-feedback">
									Please choose a route.
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3 mb-3">
								<label>Adult Price</label>
								<form:input cssClass="form-control" path="adultPrice" required="required"/>
								<div class="invalid-feedback">
									Please provide a valid price.
								</div>
							</div>
							<div class="col-md-3 mb-3">
								<label>Children Price</label>
								<form:input cssClass="form-control" path="childrenPrice" required="required"/>
								<div class="invalid-feedback">
									Please provide a valid price.
								</div>
							</div>
							<div class="col-md-3 mb-3">
								<label>Max Group Size</label>
								<form:input cssClass="form-control" path="maxGroupSize" required="required" autocomplete="false"/>
								<div class="invalid-feedback">
									Please provide a valid number.
								</div>
							</div>
							<div class="col-md-3 mb-3">
								<label for="duration">Duration</label>
								<form:input cssClass="form-control" path="duration" required="required" autocomplete="off"/>
								<div class="invalid-feedback">
									Please provide a valid duration.
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 mb-3">
								<label>Summary</label>
								<form:input cssClass="form-control" path="summary" required="required"/>
								<div class="invalid-feedback">
									Please provide a summary.
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-5 mb-3">
								<label>Image</label>
								<input id="uploadImage" name="file" type="file" accept="image/*"/>
							</div>
						</div>

						<c:if test="${model.id != null}">
							<a href='/admin/tour/edit/location/edit?id=${model.id}' class="btn-show-more">Show more →</a>
							<div class="animated fadeInUpShort">
								<div class="row">
									<div class="col-md-12">
										<div class="card no-b shadow">
											<div class="card-body p-0">
												<div class="table-responsive">
													<table class="table table-hover">
														<thead>
															<tr class="no-b my-user-list">
																<th>LOCATION</th>
																<th>COORDINATES</th>
																<th>DAY</th>
																<th>DESCRIPTION</th>
															</tr>
														</thead>
														<tbody class="stepLocations">
															<c:forEach var="item" items="${model.tourLocations}" varStatus="loop">
																<tr class="no-b">
																	<td style="text-align: center"><div style="white-space: nowrap;overflow: hidden;width: 234px;text-overflow: ellipsis;">${item.location.address}</div></td>
																	<td style="text-align: center"><span class="badge badge-success">${item.location.longitude} - ${item.location.latitude}</span></td>
																	<td style="text-align: center">${item.day}</td>
																	<td style="text-align: center"><div style="white-space: nowrap;overflow: hidden;width: 234px;text-overflow: ellipsis;">${item.description}</div></td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:if>
						<div class="form-group">
							<label for="description">Description</label>
							<form:textarea cssClass="form-control p-t-40"  path="description"
									  placeholder="Write Something..." rows="10" required="required"></form:textarea>
							<div class="invalid-feedback">
								Please provide a tour details.
							</div>
						</div>
					</div>

					<!-- Cần phải có ID để xử lý thêm, sửa -->
					<form:hidden path="id" id="tourID"/>
					<form:hidden path="currentGroupSize" id="currentGroupSize"/>

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
			    const price_max = 50000000;
			    const price_min = 100000;

				$("#adultPrice").attr({
				    "type" : "number",
                    "max" : price_max,
                    "min" : price_min
                });
				$("#childrenPrice").attr({
					"type" : "number",
                    "max" : price_max,
                    "min" : price_min
				});
				$("#maxGroupSize").attr({
				    "type" : "number",
                    "max" : 50,
                    "min" : 1
				});
				$("#duration").attr({
				    "type" : "number",
                    "max" : 30,
                    "min" : 1
				});

                $("#adultPrice").focusout(function() {
                    if ($("#adultPrice").val() > price_max) {
                        $("#adultPrice").val(price_max);
                    } else if ($("#adultPrice").val() < price_min) {
                        $("#adultPrice").val(price_min);
                    }
                });

                $("#childrenPrice").focusout(function() {
                    if ($("#childrenPrice").val() > price_max) {
                        $("#childrenPrice").val($("#adultPrice").val() * 0.7);
                    } else if ($("#childrenPrice").val() > $("#adultPrice").val()) {
                        $("#childrenPrice").val($("#adultPrice").val() * 0.7);
                    } else if ($("#childrenPrice").val() < price_min) {
                        $("#childrenPrice").val(price_min);
                    }
                });

                $("#childrenPrice").focusin(function() {
                    $("#childrenPrice").val($("#adultPrice").val() * 0.7);
                });

                $("#maxGroupSize").focusout(function() {
                    if ($("#maxGroupSize").val() > 50) {
                        $("#maxGroupSize").val(50);
                    } else if ($("#maxGroupSize").val() < 1) {
                        $("#maxGroupSize").val(1);
                    }
                });

                $("#duration").focusout(function() {
                    if ($("#duration").val() > 30) {
                        $("#duration").val(30);
                    } else if ($("#duration").val() < 1) {
                        $("#duration").val(1);
                    }
                });

				var form = document.getElementById("formSubmit");
				var btnPublish = document.getElementById("btnAddOrUpdateTour");

				var data = {};
				var fileInput = document.getElementById('uploadImage');
				$('#uploadImage').change(function() {
					var files = fileInput.files[0];
					console.log(files);
					if (files) {
						var reader = new FileReader();
						reader.onload = function(e) {
							data[""+"base64"+""] = e.target.result;
							data[""+"image"+""] = files.name;
						};
						reader.readAsDataURL(files);
					}
				});

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
			            	window.location.href = "${editTourURL}?id=" + result.id + "&message=insert_success";
			            },
			            error: function (error) {
			            	window.location.href = "${listTourURL}?page=1&limit=6&message=error_system";
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
			                window.location.href = "${editTourURL}?id=" + result.id + "&message=update_success";
			            },
			            error: function (error) {
							window.location.href = "${listTourURL}?page=1&limit=6&message=error_system";
			            }
			        });
				}
			}, false);
		}());
	</script>
</body>
</html>